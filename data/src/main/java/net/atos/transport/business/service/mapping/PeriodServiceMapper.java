/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.Period;
import net.atos.transport.entity.jpa.PeriodEntity;
import net.atos.transport.entity.jpa.YearEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class PeriodServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public PeriodServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'PeriodEntity' to 'Period'
     * @param periodEntity
     */
    public Period mapPeriodEntityToPeriod(PeriodEntity periodEntity) {
        if(periodEntity == null) {
            return null;
        }

        //--- Generic mapping 
        Period period = map(periodEntity, Period.class);

        //--- Link mapping ( link to Year )
        if(periodEntity.getYear2() != null) {
            period.setYear(periodEntity.getYear2().getYear());
        }
        return period;
    }
    
    /**
     * Mapping from 'Period' to 'PeriodEntity'
     * @param period
     * @param periodEntity
     */
    public void mapPeriodToPeriodEntity(Period period, PeriodEntity periodEntity) {
        if(period == null) {
            return;
        }

        //--- Generic mapping 
        map(period, periodEntity);

        //--- Link mapping ( link : period )
        if( hasLinkToYear(period) ) {
            YearEntity year1 = new YearEntity();
            year1.setYear( period.getYear() );
            periodEntity.setYear2( year1 );
        } else {
            periodEntity.setYear2( null );
        }

    }
    
    /**
     * Verify that Year id is valid.
     * @param Year Year
     * @return boolean
     */
    private boolean hasLinkToYear(Period period) {
        if(period.getYear() != null) {
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