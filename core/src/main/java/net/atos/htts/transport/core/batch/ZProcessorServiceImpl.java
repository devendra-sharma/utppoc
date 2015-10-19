package net.atos.htts.transport.core.batch;


import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.atos.htts.transport.common.constants.AppConstants;
import net.atos.htts.transport.common.constants.UTPConstants;
import net.atos.htts.transport.common.domain.CheckFaresDTO;
import net.atos.htts.transport.common.domain.CodeBookDTO;
import net.atos.htts.transport.common.domain.CodeBookDetailsDTO;
import net.atos.htts.transport.common.domain.ConvertCurrency;
import net.atos.htts.transport.common.domain.PassengerCharterDTO;
import net.atos.htts.transport.common.domain.RetailItemDTO;
import net.atos.htts.transport.common.exceptions.UTPException;
import net.atos.htts.transport.common.util.CommonUtil;
import net.atos.transport.business.CheckFaresService;
import net.atos.transport.business.CurrencyConversionService;
import net.atos.transport.business.CurrencyService;
import net.atos.transport.business.PassengerCharterService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ZProcessorServiceImpl implements ZProcessorService{

	
	private static final transient org.slf4j.Logger logger = LoggerFactory.getLogger(ZProcessorServiceImpl.class);

	
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private CurrencyConversionService currencyConversionService;
	
	@Autowired
	private PassengerCharterService passengerCharterService;
	
	@Autowired
	private CheckFaresService checkFaresService;
	
	/**
	 * 
	 * @param fieldSet
	 * @return
	 * @throws ParseException 
	 */
	private ConvertCurrency populateConvertCurrency(FieldSet fieldSet) {
		ConvertCurrency convertCurrency = new ConvertCurrency();
		convertCurrency.setAmountInOrgCurr(new BigDecimal(fieldSet.readString("transactionValue")));		
		convertCurrency.setTargetCurrency(fieldSet.readString("currency"));
		convertCurrency.setSaleDate(fieldSet.readDate("dateOfSale",AppConstants.DATE_FORMAT));
		
		return convertCurrency;
	}
	
	/**
	 * This method will put all logic together for invoking
	 * different services and returning the output.
	 */
	@Override
	public String ProcessZRecord(FieldSet fieldSet) throws UTPException{
		
		logger.info("Inside ProcessZRecord");
		BigDecimal covertedAmount = null;
		
				
		//Call the CurrencyService to see if conversion required or not.
		String inputCurrency = fieldSet.readString("currency");
		String StrTargetCurrency = currencyService.ifConvertCurrency(inputCurrency);
		
		//Call the CurrencyConversionService to convert the actual transactionValue
		if(!StrTargetCurrency.equals(AppConstants.NO_CONVERSION)){
			ConvertCurrency convertCurrency = populateConvertCurrency(fieldSet);
			covertedAmount = currencyConversionService.convertCurrency(convertCurrency);
		}
		//The convertedAmount is replaced in transactionValue & Refund value,correct fare
		
		//Call the PassengerCharter to calculate the value.
		List<Object> DTOList = populatePassengerCharter(fieldSet,covertedAmount);
		BigDecimal fullfare = passengerCharterService.calculatePassengerCharterFullFare((PassengerCharterDTO)DTOList.get(0), (CodeBookDTO)DTOList.get(1));
		//The output of Passenger charter will be replaced in Correct Fare
		
		
		//Call CheckFares.		
		CheckFaresDTO checkFaresDTO = populateCheckFares(fieldSet,fullfare);
		CodeBookDetailsDTO codeBookDetailsDTO = checkFaresService.checkFares(checkFaresDTO);
		
		checkFareInclusionRequired(codeBookDetailsDTO);
		
		//Populating the values in output FieldSet.
		String[] fieldValuesArray = populateFinalValues(fieldSet, covertedAmount, fullfare,codeBookDetailsDTO);
		String stringarray = Arrays.toString(fieldValuesArray);
		return stringarray;	
	}

	/**
	 * This method will just log message if checkfare is
	 * required or not.
	 * @param codeBookDetailsDTO
	 */
	private void checkFareInclusionRequired(
			CodeBookDetailsDTO codeBookDetailsDTO) {
		
		if(codeBookDetailsDTO.getCobId().equals(new Long(0))){
			logger.info("checkFareInclusion is Required");
		} else{
			logger.info("checkFareInclusion is not Required");
		}		
	}

	/**
	 * This method will populate the check fares
	 * DTO.
	 * @param fieldSet
	 * @return
	 */
	private CheckFaresDTO populateCheckFares(FieldSet fieldSet,
			BigDecimal fare) {
		CheckFaresDTO checkFaresDTO=new CheckFaresDTO();
		RetailItemDTO retailItemDTO = new RetailItemDTO();
		
		retailItemDTO.setTransactionValue(Long.valueOf(fare.longValue()));
		retailItemDTO.setDeferredIssueTypeCobId(Long.valueOf(fieldSet.readString("deferredIssueType")));		
		retailItemDTO.setDateOfSale(fieldSet.readDate("dateOfSale", AppConstants.DATE_FORMAT));
		retailItemDTO.setDateOfIssue(CommonUtil.getDateForFormat(fieldSet.readString("dateAndTime"), AppConstants.DATE_TIME_FORMAT));		
		retailItemDTO.setOriginLocId(Long.valueOf(fieldSet.readLong("issuingLocation")));
		retailItemDTO.setDestinationLocId(Long.valueOf(fieldSet.readLong("destination")));
		retailItemDTO.setSellingLocationLocId(Long.valueOf(fieldSet.readLong("sellingLocation")));
		retailItemDTO.setRouteRouId(Long.valueOf(fieldSet.readLong("route")));
		retailItemDTO.setTicketStatusTisId(Long.valueOf(fieldSet.readLong("ticketStatus")));	
		retailItemDTO.setProductProId(Long.valueOf(fieldSet.readLong("product")));	
		
		checkFaresDTO.setRetailItem(retailItemDTO);
		return checkFaresDTO;
	}
	
	

	/**
	 * This method will populate the final values.
	 */
	private String[] populateFinalValues(FieldSet fieldSet,BigDecimal transactionValue,
				BigDecimal correctFare,CodeBookDetailsDTO codeBookDetailsDTO) {
		String[] fieldValues = fieldSet.getValues();
		String transactionValueString =null;
		
		if(transactionValue!=null){
			transactionValueString = StringUtils.leftPad(transactionValue.toString(), 14,"0");
		}
		else{
			transactionValueString = StringUtils.leftPad(correctFare.toString(), 14,"0");
		}
				
		fieldValues[UTPConstants.TRANSACTION_VALUE] = transactionValueString;
		fieldValues[UTPConstants.REFUND_VALUE] = transactionValueString;
		fieldValues[UTPConstants.CORRECT_FARE] = StringUtils.leftPad(correctFare.toString(),14,"0");
		fieldValues[UTPConstants.FARES_CHECKING_RESULT] = StringUtils.leftPad(codeBookDetailsDTO.getFaresCheckingResult(),6," ");
		fieldValues[UTPConstants.GENERATE_RETAIL_ITEM] = StringUtils.leftPad(codeBookDetailsDTO.getGeneratingRetailItem(),10,"0");
		
		return fieldValues;
	}
	
	/**
	 * This method will populate the passenger charter.
	 */
	private List<Object> populatePassengerCharter(FieldSet fieldSet,BigDecimal covertedAmount) {
		List<Object> list=new ArrayList<Object>();
		PassengerCharterDTO passengerCharterDTO=new PassengerCharterDTO();
		CodeBookDTO codeBookDTO=new CodeBookDTO();
		
		passengerCharterDTO.setDiscountPercent(Integer.valueOf(fieldSet.readString("discountPercentage")));
		//Set the converted amount as input here.
		if(covertedAmount!=null){
			passengerCharterDTO.setTransactionValue(covertedAmount);
		}
		else{
			passengerCharterDTO.setTransactionValue(new BigDecimal(fieldSet.readString("transactionValue")));
		}		
		codeBookDTO.setCobId(Integer.valueOf(fieldSet.readString("originRecordType")));
		
		list.add(passengerCharterDTO);
		list.add(codeBookDTO);
		
		return list;
	}
}
