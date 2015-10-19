/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.LocationType;
import net.atos.transport.entity.jpa.LocationTypeEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class LocationTypeServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public LocationTypeServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'LocationTypeEntity' to 'LocationType'
     * @param locationTypeEntity
     */
    public LocationType mapLocationTypeEntityToLocationType(LocationTypeEntity locationTypeEntity) {
        if(locationTypeEntity == null) {
            return null;
        }

        //--- Generic mapping 
        return map(locationTypeEntity, LocationType.class);

    }
    
    /**
     * Mapping from 'LocationType' to 'LocationTypeEntity'
     * @param locationType
     * @param locationTypeEntity
     */
    public void mapLocationTypeToLocationTypeEntity(LocationType locationType, LocationTypeEntity locationTypeEntity) {
        if(locationType == null) {
            return;
        }

        //--- Generic mapping 
        map(locationType, locationTypeEntity);

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