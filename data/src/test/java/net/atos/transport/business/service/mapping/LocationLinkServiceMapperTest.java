/*


 */
package net.atos.transport.business.service.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.LocationLink;
import net.atos.transport.entity.jpa.LocationLinkEntity;
import net.atos.transport.entity.jpa.LocationEntity;
import net.atos.transport.entity.jpa.LocationEntity;
import net.atos.transport.entity.jpa.GroupFunctionTypeEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class LocationLinkServiceMapperTest
{

    private LocationLinkServiceMapper locationLinkServiceMapper;

    private static ModelMapper modelMapper = new ModelMapper();

    private MockValues mockValues = new MockValues();

    @BeforeClass
    public static void setUp()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Before
    public void before()
    {
        locationLinkServiceMapper = new LocationLinkServiceMapper();
        locationLinkServiceMapper.setModelMapper(modelMapper);
    }

    /**
     * Mapping from 'LocationLinkEntity' to 'LocationLink'
     * 
     * @param locationLinkEntity
     */
    @Test
    public void testMapLocationLinkEntityToLocationLink()
    {
        // Given
        LocationLinkEntity locationLinkEntity = new LocationLinkEntity();
        locationLinkEntity.setExpired(mockValues.nextString(1));
        locationLinkEntity.setEffectiveFrom(mockValues.nextDate());
        locationLinkEntity.setEffectiveTo(mockValues.nextDate());
        locationLinkEntity.setLocation2(new LocationEntity());
        locationLinkEntity.getLocation2().setLocId(mockValues.nextInteger());
        locationLinkEntity.setLocation(new LocationEntity());
        locationLinkEntity.getLocation().setLocId(mockValues.nextInteger());
        locationLinkEntity.setGroupFunctionType(new GroupFunctionTypeEntity());
        locationLinkEntity.getGroupFunctionType().setGftId(mockValues.nextInteger());

        // When
        LocationLink locationLink = locationLinkServiceMapper.mapLocationLinkEntityToLocationLink(locationLinkEntity);

        // Then
        assertEquals(locationLinkEntity.getExpired(), locationLink.getExpired());
        assertEquals(locationLinkEntity.getEffectiveFrom(), locationLink.getEffectiveFrom());
        assertEquals(locationLinkEntity.getEffectiveTo(), locationLink.getEffectiveTo());
        assertEquals(locationLinkEntity.getLocation2().getLocId(), locationLink.getLocIdParent());
        assertEquals(locationLinkEntity.getLocation().getLocId(), locationLink.getLocIdChild());
        assertEquals(locationLinkEntity.getGroupFunctionType().getGftId(), locationLink.getGftId());
    }

    /**
     * Test : Mapping from 'LocationLink' to 'LocationLinkEntity'
     */
    @Test
    public void testMapLocationLinkToLocationLinkEntity()
    {
        // Given
        LocationLink locationLink = new LocationLink();
        locationLink.setExpired(mockValues.nextString(1));
        locationLink.setEffectiveFrom(mockValues.nextDate());
        locationLink.setEffectiveTo(mockValues.nextDate());
        locationLink.setLocIdParent(mockValues.nextInteger());
        locationLink.setLocIdChild(mockValues.nextInteger());
        locationLink.setGftId(mockValues.nextInteger());

        LocationLinkEntity locationLinkEntity = new LocationLinkEntity();

        // When
        locationLinkServiceMapper.mapLocationLinkToLocationLinkEntity(locationLink, locationLinkEntity);

        // Then
        assertEquals(locationLink.getExpired(), locationLinkEntity.getExpired());
        assertEquals(locationLink.getEffectiveFrom(), locationLinkEntity.getEffectiveFrom());
        assertEquals(locationLink.getEffectiveTo(), locationLinkEntity.getEffectiveTo());
        assertEquals(locationLink.getLocIdParent(), locationLinkEntity.getLocation2().getLocId());
        assertEquals(locationLink.getLocIdChild(), locationLinkEntity.getLocation().getLocId());
        assertEquals(locationLink.getGftId(), locationLinkEntity.getGroupFunctionType().getGftId());
    }

}
