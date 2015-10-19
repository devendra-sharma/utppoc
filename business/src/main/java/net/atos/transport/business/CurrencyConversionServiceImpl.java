package net.atos.transport.business;

import java.math.BigDecimal;
import java.util.List;

import net.atos.htts.transport.common.constants.AppConstants;
import net.atos.htts.transport.common.domain.ConvertCurrency;
import net.atos.htts.transport.common.exceptions.UTPException;
import net.atos.transport.business.service.CalendarService;
import net.atos.transport.entity.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CurrencyConversionServiceImpl implements CurrencyConversionService{


    @Autowired
    private CalendarService calendarService;
    
    @Override
    public BigDecimal convertCurrency(net.atos.htts.transport.common.domain.ConvertCurrency convCurr) throws UTPException{
        
        List<Calendar> retCalendars = calendarService.findAll();
        
        Calendar calendar  = this.retrieveCalenderObject(convCurr,retCalendars);
        
        if(convCurr.getAmountInOrgCurr().doubleValue() < 0){
            convCurr.setAmountInOrgCurr(BigDecimal.valueOf(convCurr.getAmountInOrgCurr().doubleValue() * -1));
        }        
        
        if(convCurr.getTargetCurrency().equals(AppConstants.EUROS)){
            return BigDecimal.valueOf(convCurr.getAmountInOrgCurr().doubleValue()*(calendar.getCurrencyRate()*10/calendar.getConversionPower()));
        }else{
            return BigDecimal.valueOf(convCurr.getAmountInOrgCurr().doubleValue()/(calendar.getCurrencyRate()*10/calendar.getConversionPower()));
        }

        
    }

    /**
     * populate details for convert currency.
     * @param convCurr
     * @param retCalendars
     * @throws Exception 
     */
    private Calendar retrieveCalenderObject(ConvertCurrency convCurr,
            List<Calendar> retCalendars) throws UTPException {
        
        for (Calendar calendar : retCalendars) {
            if(convCurr.getSaleDate().equals(calendar.getCalendarDate())){
                return calendar;
            }
        }    
        throw new UTPException("Could not find the related Calender object");
        
    }
}
