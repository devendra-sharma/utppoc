/*


 */
package net.atos.transport.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.Week;
import net.atos.transport.entity.jpa.WeekEntity;
import net.atos.transport.entity.jpa.YearEntity;
import net.atos.transport.entity.jpa.PeriodEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class WeekServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public WeekServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'WeekEntity' to 'Week'
	 * @param weekEntity
	 */
	public Week mapWeekEntityToWeek(WeekEntity weekEntity) {
		if(weekEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Week week = map(weekEntity, Week.class);

		//--- Link mapping ( link to Year )
		if(weekEntity.getYear2() != null) {
			week.setYear(weekEntity.getYear2().getYear());
		}
		//--- Link mapping ( link to Period )
		if(weekEntity.getPeriod2() != null) {
			week.setPeriod(weekEntity.getPeriod2().getPerId());
		}
		return week;
	}
	
	/**
	 * Mapping from 'Week' to 'WeekEntity'
	 * @param week
	 * @param weekEntity
	 */
	public void mapWeekToWeekEntity(Week week, WeekEntity weekEntity) {
		if(week == null) {
			return;
		}

		//--- Generic mapping 
		map(week, weekEntity);

		//--- Link mapping ( link : week )
		if( hasLinkToYear(week) ) {
			YearEntity year1 = new YearEntity();
			year1.setYear( week.getYear() );
			weekEntity.setYear2( year1 );
		} else {
			weekEntity.setYear2( null );
		}

		//--- Link mapping ( link : week )
		if( hasLinkToPeriod(week) ) {
			PeriodEntity period2 = new PeriodEntity();
			period2.setPerId( week.getPeriod() );
			weekEntity.setPeriod2( period2 );
		} else {
			weekEntity.setPeriod2( null );
		}

	}
	
	/**
	 * Verify that Year id is valid.
	 * @param Year Year
	 * @return boolean
	 */
	private boolean hasLinkToYear(Week week) {
		if(week.getYear() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that Period id is valid.
	 * @param Period Period
	 * @return boolean
	 */
	private boolean hasLinkToPeriod(Week week) {
		if(week.getPeriod() != null) {
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