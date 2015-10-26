package net.atos.htts.transport.common.domain;

import java.math.BigDecimal;

public class PassengerCharterDTO
{

    private Integer discountPercent;

    private String ticketStatus;

    private BigDecimal transactionValue;

    public Integer getDiscountPercent()
    {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent)
    {
        this.discountPercent = discountPercent;
    }

    public String getTicketStatus()
    {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus)
    {
        this.ticketStatus = ticketStatus;
    }

    public BigDecimal getTransactionValue()
    {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue)
    {
        this.transactionValue = transactionValue;
    }

}
