/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.Calendar;
import net.atos.transport.entity.jpa.CalendarEntity;
import net.atos.transport.entity.jpa.PeriodEntity;
import net.atos.transport.entity.jpa.WeekEntity;
import net.atos.transport.entity.jpa.YearEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class CalendarServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public CalendarServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'CalendarEntity' to 'Calendar'
     * @param calendarEntity
     */
    public Calendar mapCalendarEntityToCalendar(CalendarEntity calendarEntity) {
        if(calendarEntity == null) {
            return null;
        }

        //--- Generic mapping 
        Calendar calendar = map(calendarEntity, Calendar.class);

        //--- Link mapping ( link to Week )
        if(calendarEntity.getWeek2() != null) {
            calendar.setWeek(calendarEntity.getWeek2().getWeekId());
        }
        //--- Link mapping ( link to Year )
        if(calendarEntity.getYear2() != null) {
            calendar.setYear(calendarEntity.getYear2().getYear());
        }
        //--- Link mapping ( link to Period )
        if(calendarEntity.getPeriod2() != null) {
            calendar.setPeriod(calendarEntity.getPeriod2().getPerId());
        }
        
        if(calendarEntity.getConversionPower() != null) {
            calendar.setConversionPower(calendarEntity.getConversionPower());
        }
        
        if(calendarEntity.getCurrencyRate() != null) {
            calendar.setCurrencyRate(calendarEntity.getCurrencyRate());
        }
        return calendar;
    }
    
    /**
     * Mapping from 'Calendar' to 'CalendarEntity'
     * @param calendar
     * @param calendarEntity
     */
    public void mapCalendarToCalendarEntity(Calendar calendar, CalendarEntity calendarEntity) {
        if(calendar == null) {
            return;
        }

        //--- Generic mapping 
        map(calendar, calendarEntity);

        //--- Link mapping ( link : calendar )
        if( hasLinkToWeek(calendar) ) {
            WeekEntity week1 = new WeekEntity();
            week1.setWeekId( calendar.getWeek() );
            calendarEntity.setWeek2( week1 );
        } else {
            calendarEntity.setWeek2( null );
        }

        //--- Link mapping ( link : calendar )
        if( hasLinkToYear(calendar) ) {
            YearEntity year2 = new YearEntity();
            year2.setYear( calendar.getYear() );
            calendarEntity.setYear2( year2 );
        } else {
            calendarEntity.setYear2( null );
        }

        //--- Link mapping ( link : calendar )
        if( hasLinkToPeriod(calendar) ) {
            PeriodEntity period3 = new PeriodEntity();
            period3.setPerId( calendar.getPeriod() );
            calendarEntity.setPeriod2( period3 );
        } else {
            calendarEntity.setPeriod2( null );
        }

    }
    
    /**
     * Verify that Week id is valid.
     * @param Week Week
     * @return boolean
     */
    private boolean hasLinkToWeek(Calendar calendar) {
        if(calendar.getWeek() != null) {
            return true;
        }
        return false;
    }

    /**
     * Verify that Year id is valid.
     * @param Year Year
     * @return boolean
     */
    private boolean hasLinkToYear(Calendar calendar) {
        if(calendar.getYear() != null) {
            return true;
        }
        return false;
    }

    /**
     * Verify that Period id is valid.
     * @param Period Period
     * @return boolean
     */
    private boolean hasLinkToPeriod(Calendar calendar) {
        if(calendar.getPeriod() != null) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    protected void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

}