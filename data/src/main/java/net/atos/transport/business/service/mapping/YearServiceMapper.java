/*


 */
package net.atos.transport.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.Year;
import net.atos.transport.entity.jpa.YearEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class YearServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public YearServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'YearEntity' to 'Year'
	 * @param yearEntity
	 */
	public Year mapYearEntityToYear(YearEntity yearEntity) {
		if(yearEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Year year = map(yearEntity, Year.class);

		return year;
	}
	
	/**
	 * Mapping from 'Year' to 'YearEntity'
	 * @param year
	 * @param yearEntity
	 */
	public void mapYearToYearEntity(Year year, YearEntity yearEntity) {
		if(year == null) {
			return;
		}

		//--- Generic mapping 
		map(year, yearEntity);

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