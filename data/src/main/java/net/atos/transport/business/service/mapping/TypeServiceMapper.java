/*


 */
package net.atos.transport.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.Type;
import net.atos.transport.entity.jpa.TypeEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class TypeServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public TypeServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'TypeEntity' to 'Type'
	 * @param typeEntity
	 */
	public Type mapTypeEntityToType(TypeEntity typeEntity) {
		if(typeEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Type type = map(typeEntity, Type.class);

		return type;
	}
	
	/**
	 * Mapping from 'Type' to 'TypeEntity'
	 * @param type
	 * @param typeEntity
	 */
	public void mapTypeToTypeEntity(Type type, TypeEntity typeEntity) {
		if(type == null) {
			return;
		}

		//--- Generic mapping 
		map(type, typeEntity);

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