/*


 */
package net.atos.transport.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.Business;
import net.atos.transport.entity.jpa.BusinessEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class BusinessServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public BusinessServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'BusinessEntity' to 'Business'
	 * @param businessEntity
	 */
	public Business mapBusinessEntityToBusiness(BusinessEntity businessEntity) {
		if(businessEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Business business = map(businessEntity, Business.class);

		return business;
	}
	
	/**
	 * Mapping from 'Business' to 'BusinessEntity'
	 * @param business
	 * @param businessEntity
	 */
	public void mapBusinessToBusinessEntity(Business business, BusinessEntity businessEntity) {
		if(business == null) {
			return;
		}

		//--- Generic mapping 
		map(business, businessEntity);

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