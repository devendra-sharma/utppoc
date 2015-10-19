package net.atos.transport.business;

import net.atos.htts.transport.common.constants.AppConstants;

import net.atos.transport.business.service.CodeBookMap;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyServiceImpl implements CurrencyService{
	
	private static final transient org.slf4j.Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);
	@Autowired
	CodeBookMap codeBookMap;
	
	public CurrencyServiceImpl(){}
	
	@Override
	public String ifConvertCurrency(String curr_code) throws NumberFormatException {
		try{			
		
			String LennonCurrency = codeBookMap.getCodeBookByTypeAndCobId(AppConstants.CURRENCY_GROUP, AppConstants.LENNON_CURR_COB_ID);			
			String InputCurrency = codeBookMap.getCodeBookByTypeAndCobId(AppConstants.CURRENCY_GROUP, Integer.valueOf(curr_code));
		
			if(InputCurrency.equals(LennonCurrency)){			
				return AppConstants.NO_CONVERSION;
			}
			else if(!InputCurrency.equals(LennonCurrency)){
				if(InputCurrency.equals(AppConstants.STERLING)){	
					return AppConstants.EUROS;
				}
				else {
					return AppConstants.STERLING;
				}
			}
			else{
				return AppConstants.NO_CONVERSION;
			}
			
			
		}
		catch(NumberFormatException nfe){
			logger.error("Inside method [ifConvertCurrency] : Error :"+nfe.getMessage());
			throw new NumberFormatException(nfe.getMessage());
		}
	}

}
