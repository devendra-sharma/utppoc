package net.atos.transport.business;

import java.math.BigDecimal;

import net.atos.htts.transport.common.constants.AppConstants;
import net.atos.htts.transport.common.domain.CodeBookDTO;
import net.atos.htts.transport.common.domain.PassengerCharterDTO;
import net.atos.transport.business.service.CodeBookMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassengerCharterServiceImpl implements PassengerCharterService
{

    @Autowired
    private CodeBookMap codeBookMap;

    /**
     * This method will calculate the passenger charter full fare.
     */
    @Override
    public BigDecimal calculatePassengerCharterFullFare(PassengerCharterDTO passengerCharterDTO, CodeBookDTO codeBookDTO)
    {
        BigDecimal fare = null;
        boolean childTicketFlag = false;

        fare = this.calculateBaseValueFare(passengerCharterDTO);
        childTicketFlag = this.establishChildTicketType(codeBookDTO);

        if (childTicketFlag)
        {
            fare = BigDecimal.valueOf(fare.doubleValue() / 2);
            return fare;
        }
        else
        {
            return fare;
        }
    }

    /**
     * This method will calculate the base fare value.
     * 
     * @param passengerCharterDTO
     * @return
     */
    private BigDecimal calculateBaseValueFare(PassengerCharterDTO passengerCharterDTO)
    {
        // Full fare = ((Actual transaction value)/ (100-discount percent)) * 100
        BigDecimal fullFare = null;

        fullFare = BigDecimal
                .valueOf((passengerCharterDTO.getTransactionValue().doubleValue() / (100 - passengerCharterDTO
                        .getDiscountPercent().doubleValue())) * 100);
        return fullFare;
    }

    /**
     * This method will establish the ticket type.
     * 
     * @param passengerCharterDTO
     * @param codeBookDTO
     * @return
     */
    private boolean establishChildTicketType(CodeBookDTO codeBookDTO)
    {

        String ticketTypeCodeBook = codeBookMap.getCodeBookByTypeAndCobId(AppConstants.TICKET_TYPE_GROUP,
                codeBookDTO.getCobId());
        return ticketTypeCodeBook != null ? ticketTypeCodeBook.equals(AppConstants.CHILD_TICKET_TYPE) : false;

    }
}
