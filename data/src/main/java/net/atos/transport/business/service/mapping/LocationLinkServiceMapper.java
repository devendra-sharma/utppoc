/*


 */
package net.atos.transport.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.LocationLink;
import net.atos.transport.entity.jpa.LocationLinkEntity;
import net.atos.transport.entity.jpa.LocationEntity;
import net.atos.transport.entity.jpa.GroupFunctionTypeEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class LocationLinkServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public LocationLinkServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'LocationLinkEntity' to 'LocationLink'
     * @param locationLinkEntity
     */
    public LocationLink mapLocationLinkEntityToLocationLink(LocationLinkEntity locationLinkEntity) {
        if(locationLinkEntity == null) {
            return null;
        }

        //--- Generic mapping 
        LocationLink locationLink = map(locationLinkEntity, LocationLink.class);

        //--- Link mapping ( link to Location )
        if(locationLinkEntity.getLocation2() != null) {
            locationLink.setLocIdParent(locationLinkEntity.getLocation2().getLocId());
        }
        //--- Link mapping ( link to Location )
        if(locationLinkEntity.getLocation() != null) {
            locationLink.setLocIdChild(locationLinkEntity.getLocation().getLocId());
        }
        //--- Link mapping ( link to GroupFunctionType )
        if(locationLinkEntity.getGroupFunctionType() != null) {
            locationLink.setGftId(locationLinkEntity.getGroupFunctionType().getGftId());
        }
        return locationLink;
    }
    
    /**
     * Mapping from 'LocationLink' to 'LocationLinkEntity'
     * @param locationLink
     * @param locationLinkEntity
     */
    public void mapLocationLinkToLocationLinkEntity(LocationLink locationLink, LocationLinkEntity locationLinkEntity) {
        if(locationLink == null) {
            return;
        }

        //--- Generic mapping 
        map(locationLink, locationLinkEntity);

        //--- Link mapping ( link : locationLink )
        if( hasLinkToLocation(locationLink) ) {
            LocationEntity location1 = new LocationEntity();
            location1.setLocId( locationLink.getLocIdParent() );
            locationLinkEntity.setLocation2( location1 );
        } else {
            locationLinkEntity.setLocation2( null );
        }

        //--- Link mapping ( link : locationLink )
        if( hasLinkToLocation(locationLink) ) {
            LocationEntity location2 = new LocationEntity();
            location2.setLocId( locationLink.getLocIdChild() );
            locationLinkEntity.setLocation( location2 );
        } else {
            locationLinkEntity.setLocation( null );
        }

        //--- Link mapping ( link : locationLink )
        if( hasLinkToGroupFunctionType(locationLink) ) {
            GroupFunctionTypeEntity groupFunctionType3 = new GroupFunctionTypeEntity();
            groupFunctionType3.setGftId( locationLink.getGftId() );
            locationLinkEntity.setGroupFunctionType( groupFunctionType3 );
        } else {
            locationLinkEntity.setGroupFunctionType( null );
        }

    }
    
    /**
     * Verify that Location id is valid.
     * @param Location Location
     * @return boolean
     */
    private boolean hasLinkToLocation(LocationLink locationLink) {
        if(locationLink.getLocIdParent() != null) {
            return true;
        }
        return false;
    }

    /**
     * Verify that GroupFunctionType id is valid.
     * @param GroupFunctionType GroupFunctionType
     * @return boolean
     */
    private boolean hasLinkToGroupFunctionType(LocationLink locationLink) {
        if(locationLink.getGftId() != null) {
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