/*


 */
package net.atos.transport.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.ApplicationParameters;
import net.atos.transport.entity.jpa.ApplicationParametersEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class ApplicationParametersServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public ApplicationParametersServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'ApplicationParametersEntity' to 'ApplicationParameters'
	 * @param applicationParametersEntity
	 */
	public ApplicationParameters mapApplicationParametersEntityToApplicationParameters(ApplicationParametersEntity applicationParametersEntity) {
		if(applicationParametersEntity == null) {
			return null;
		}

		//--- Generic mapping 
		ApplicationParameters applicationParameters = map(applicationParametersEntity, ApplicationParameters.class);

		return applicationParameters;
	}
	
	/**
	 * Mapping from 'ApplicationParameters' to 'ApplicationParametersEntity'
	 * @param applicationParameters
	 * @param applicationParametersEntity
	 */
	public void mapApplicationParametersToApplicationParametersEntity(ApplicationParameters applicationParameters, ApplicationParametersEntity applicationParametersEntity) {
		if(applicationParameters == null) {
			return;
		}

		//--- Generic mapping 
		map(applicationParameters, applicationParametersEntity);

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