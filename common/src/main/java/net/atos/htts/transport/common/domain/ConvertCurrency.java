package net.atos.htts.transport.common.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ConvertCurrency
{

    private Date dateOfConversion;

    private List<CalendarDTO> calendar;

    private BigDecimal amountInOrgCurr;

    private String targetCurrency;

    private Date saleDate;

    public Date getDateOfConversion()
    {
        return dateOfConversion;
    }

    public void setDateOfConversion(Date dateOfConversion)
    {
        this.dateOfConversion = dateOfConversion;
    }

    public BigDecimal getAmountInOrgCurr()
    {
        return amountInOrgCurr;
    }

    public void setAmountInOrgCurr(BigDecimal amountInOrgCurr)
    {
        this.amountInOrgCurr = amountInOrgCurr;
    }

    public String getTargetCurrency()
    {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency)
    {
        this.targetCurrency = targetCurrency;
    }

    public List<CalendarDTO> getCalendar()
    {
        return calendar;
    }

    public void setCalendar(List<CalendarDTO> calendar)
    {
        this.calendar = calendar;
    }

    public Date getSaleDate()
    {
        return saleDate;
    }

    public void setSaleDate(Date saleDate)
    {
        this.saleDate = saleDate;
    }
}
