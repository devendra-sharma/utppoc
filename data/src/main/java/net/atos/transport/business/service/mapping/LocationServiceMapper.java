/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.Location;
import net.atos.transport.entity.jpa.LocationEntity;
import net.atos.transport.entity.jpa.LocationTypeEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class LocationServiceMapper extends AbstractServiceMapper
{

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;

    /**
     * Constructor.
     */
    public LocationServiceMapper()
    {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'LocationEntity' to 'Location'
     * 
     * @param locationEntity
     */
    public Location mapLocationEntityToLocation(LocationEntity locationEntity)
    {
        if (locationEntity == null)
        {
            return null;
        }

        // --- Generic mapping
        Location location = map(locationEntity, Location.class);

        // --- Link mapping ( link to LocationType )
        if (locationEntity.getLocationType() != null)
        {
            location.setLotId(locationEntity.getLocationType().getLotId());
        }
        return location;
    }

    /**
     * Mapping from 'Location' to 'LocationEntity'
     * 
     * @param location
     * @param locationEntity
     */
    public void mapLocationToLocationEntity(Location location, LocationEntity locationEntity)
    {
        if (location == null)
        {
            return;
        }

        // --- Generic mapping
        map(location, locationEntity);

        // --- Link mapping ( link : location )
        if (hasLinkToLocationType(location))
        {
            LocationTypeEntity locationType1 = new LocationTypeEntity();
            locationType1.setLotId(location.getLotId());
            locationEntity.setLocationType(locationType1);
        }
        else
        {
            locationEntity.setLocationType(null);
        }

    }

    /**
     * Verify that LocationType id is valid.
     * 
     * @param LocationType
     *            LocationType
     * @return boolean
     */
    private boolean hasLinkToLocationType(Location location)
    {
        if (location.getLotId() != null)
        {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelMapper getModelMapper()
    {
        return modelMapper;
    }

    protected void setModelMapper(ModelMapper modelMapper)
    {
        this.modelMapper = modelMapper;
    }

}
