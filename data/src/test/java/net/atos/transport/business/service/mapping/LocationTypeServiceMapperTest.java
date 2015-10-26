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
import net.atos.transport.entity.LocationType;
import net.atos.transport.entity.jpa.LocationTypeEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class LocationTypeServiceMapperTest
{

    private LocationTypeServiceMapper locationTypeServiceMapper;

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
        locationTypeServiceMapper = new LocationTypeServiceMapper();
        locationTypeServiceMapper.setModelMapper(modelMapper);
    }

    /**
     * Mapping from 'LocationTypeEntity' to 'LocationType'
     * 
     * @param locationTypeEntity
     */
    @Test
    public void testMapLocationTypeEntityToLocationType()
    {
        // Given
        LocationTypeEntity locationTypeEntity = new LocationTypeEntity();
        locationTypeEntity.setLocationTypeDesc(mockValues.nextString(32));
        locationTypeEntity.setExpired(mockValues.nextString(1));
        locationTypeEntity.setEffectiveFrom(mockValues.nextDate());
        locationTypeEntity.setEffectiveTo(mockValues.nextDate());

        // When
        LocationType locationType = locationTypeServiceMapper.mapLocationTypeEntityToLocationType(locationTypeEntity);

        // Then
        assertEquals(locationTypeEntity.getLocationTypeDesc(), locationType.getLocationTypeDesc());
        assertEquals(locationTypeEntity.getExpired(), locationType.getExpired());
        assertEquals(locationTypeEntity.getEffectiveFrom(), locationType.getEffectiveFrom());
        assertEquals(locationTypeEntity.getEffectiveTo(), locationType.getEffectiveTo());
    }

    /**
     * Test : Mapping from 'LocationType' to 'LocationTypeEntity'
     */
    @Test
    public void testMapLocationTypeToLocationTypeEntity()
    {
        // Given
        LocationType locationType = new LocationType();
        locationType.setLocationTypeDesc(mockValues.nextString(32));
        locationType.setExpired(mockValues.nextString(1));
        locationType.setEffectiveFrom(mockValues.nextDate());
        locationType.setEffectiveTo(mockValues.nextDate());

        LocationTypeEntity locationTypeEntity = new LocationTypeEntity();

        // When
        locationTypeServiceMapper.mapLocationTypeToLocationTypeEntity(locationType, locationTypeEntity);

        // Then
        assertEquals(locationType.getLocationTypeDesc(), locationTypeEntity.getLocationTypeDesc());
        assertEquals(locationType.getExpired(), locationTypeEntity.getExpired());
        assertEquals(locationType.getEffectiveFrom(), locationTypeEntity.getEffectiveFrom());
        assertEquals(locationType.getEffectiveTo(), locationTypeEntity.getEffectiveTo());
    }

}
