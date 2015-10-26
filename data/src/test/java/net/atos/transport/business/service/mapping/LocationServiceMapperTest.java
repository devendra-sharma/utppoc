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
import net.atos.transport.entity.Location;
import net.atos.transport.entity.jpa.LocationEntity;
import net.atos.transport.entity.jpa.LocationTypeEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class LocationServiceMapperTest
{

    private LocationServiceMapper locationServiceMapper;

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
        locationServiceMapper = new LocationServiceMapper();
        locationServiceMapper.setModelMapper(modelMapper);
    }

    /**
     * Mapping from 'LocationEntity' to 'Location'
     * 
     * @param locationEntity
     */
    @Test
    public void testMapLocationEntityToLocation()
    {
        // Given
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setLocation(mockValues.nextString(8));
        locationEntity.setLocationDescription(mockValues.nextString(32));
        locationEntity.setAddress(mockValues.nextString(220));
        locationEntity.setPostcode(mockValues.nextString(8));
        locationEntity.setTelephone(mockValues.nextString(15));
        locationEntity.setLocIdPrimaryZone(mockValues.nextInteger());
        locationEntity.setPrimaryZoneCode(mockValues.nextString(8));
        locationEntity.setPrimaryZoneDesc(mockValues.nextString(32));
        locationEntity.setLocIdSecondaryZone(mockValues.nextInteger());
        locationEntity.setSecondaryZoneCode(mockValues.nextString(8));
        locationEntity.setSecondaryZoneDesc(mockValues.nextString(32));
        locationEntity.setLocIdTertiaryZone(mockValues.nextInteger());
        locationEntity.setTertiaryZoneCode(mockValues.nextString(8));
        locationEntity.setTertiaryZoneDesc(mockValues.nextString(32));
        locationEntity.setLocIdTvStation(mockValues.nextInteger());
        locationEntity.setTvStationCode(mockValues.nextString(8));
        locationEntity.setTvStationName(mockValues.nextString(32));
        locationEntity.setLocIdLocalAuthority(mockValues.nextInteger());
        locationEntity.setLocalAuthorityCode(mockValues.nextString(8));
        locationEntity.setLocalAuthorityName(mockValues.nextString(32));
        locationEntity.setLocIdStationGroup(mockValues.nextInteger());
        locationEntity.setStationGroup(mockValues.nextString(8));
        locationEntity.setStationGroupDesc(mockValues.nextString(32));
        locationEntity.setLocIdLondonStationGrp(mockValues.nextInteger());
        locationEntity.setLondonStationGrpCode(mockValues.nextString(8));
        locationEntity.setLondonStationGrpDesc(mockValues.nextString(32));
        locationEntity.setOsGridReference(mockValues.nextString(8));
        locationEntity.setPostalRegion(mockValues.nextString(2));
        locationEntity.setNalco12charDescription(mockValues.nextString(12));
        locationEntity.setNalco16charDescription(mockValues.nextString(16));
        locationEntity.setNalco26charDescription(mockValues.nextString(26));
        locationEntity.setNalcoTiploc(mockValues.nextString(7));
        locationEntity.setNalco3charCode(mockValues.nextString(3));
        locationEntity.setEffectiveFrom(mockValues.nextDate());
        locationEntity.setEffectiveTo(mockValues.nextDate());
        locationEntity.setExpired(mockValues.nextString(1));
        locationEntity.setLocIdMasterAccount(mockValues.nextInteger());
        locationEntity.setMasterAccountCode(mockValues.nextString(8));
        locationEntity.setMasterAccountName(mockValues.nextString(32));
        locationEntity.setCobIdGroupType(mockValues.nextInteger());
        locationEntity.setLocationType(new LocationTypeEntity());
        locationEntity.getLocationType().setLotId(mockValues.nextInteger());

        // When
        Location location = locationServiceMapper.mapLocationEntityToLocation(locationEntity);

        // Then
        assertEquals(locationEntity.getLocation(), location.getLocation());
        assertEquals(locationEntity.getLocationDescription(), location.getLocationDescription());
        assertEquals(locationEntity.getAddress(), location.getAddress());
        assertEquals(locationEntity.getPostcode(), location.getPostcode());
        assertEquals(locationEntity.getTelephone(), location.getTelephone());
        assertEquals(locationEntity.getLocIdPrimaryZone(), location.getLocIdPrimaryZone());
        assertEquals(locationEntity.getPrimaryZoneCode(), location.getPrimaryZoneCode());
        assertEquals(locationEntity.getPrimaryZoneDesc(), location.getPrimaryZoneDesc());
        assertEquals(locationEntity.getLocIdSecondaryZone(), location.getLocIdSecondaryZone());
        assertEquals(locationEntity.getSecondaryZoneCode(), location.getSecondaryZoneCode());
        assertEquals(locationEntity.getSecondaryZoneDesc(), location.getSecondaryZoneDesc());
        assertEquals(locationEntity.getLocIdTertiaryZone(), location.getLocIdTertiaryZone());
        assertEquals(locationEntity.getTertiaryZoneCode(), location.getTertiaryZoneCode());
        assertEquals(locationEntity.getTertiaryZoneDesc(), location.getTertiaryZoneDesc());
        assertEquals(locationEntity.getLocIdTvStation(), location.getLocIdTvStation());
        assertEquals(locationEntity.getTvStationCode(), location.getTvStationCode());
        assertEquals(locationEntity.getTvStationName(), location.getTvStationName());
        assertEquals(locationEntity.getLocIdLocalAuthority(), location.getLocIdLocalAuthority());
        assertEquals(locationEntity.getLocalAuthorityCode(), location.getLocalAuthorityCode());
        assertEquals(locationEntity.getLocalAuthorityName(), location.getLocalAuthorityName());
        assertEquals(locationEntity.getLocIdStationGroup(), location.getLocIdStationGroup());
        assertEquals(locationEntity.getStationGroup(), location.getStationGroup());
        assertEquals(locationEntity.getStationGroupDesc(), location.getStationGroupDesc());
        assertEquals(locationEntity.getLocIdLondonStationGrp(), location.getLocIdLondonStationGrp());
        assertEquals(locationEntity.getLondonStationGrpCode(), location.getLondonStationGrpCode());
        assertEquals(locationEntity.getLondonStationGrpDesc(), location.getLondonStationGrpDesc());
        assertEquals(locationEntity.getOsGridReference(), location.getOsGridReference());
        assertEquals(locationEntity.getPostalRegion(), location.getPostalRegion());
        assertEquals(locationEntity.getNalco12charDescription(), location.getNalco12charDescription());
        assertEquals(locationEntity.getNalco16charDescription(), location.getNalco16charDescription());
        assertEquals(locationEntity.getNalco26charDescription(), location.getNalco26charDescription());
        assertEquals(locationEntity.getNalcoTiploc(), location.getNalcoTiploc());
        assertEquals(locationEntity.getNalco3charCode(), location.getNalco3charCode());
        assertEquals(locationEntity.getEffectiveFrom(), location.getEffectiveFrom());
        assertEquals(locationEntity.getEffectiveTo(), location.getEffectiveTo());
        assertEquals(locationEntity.getExpired(), location.getExpired());
        assertEquals(locationEntity.getLocIdMasterAccount(), location.getLocIdMasterAccount());
        assertEquals(locationEntity.getMasterAccountCode(), location.getMasterAccountCode());
        assertEquals(locationEntity.getMasterAccountName(), location.getMasterAccountName());
        assertEquals(locationEntity.getCobIdGroupType(), location.getCobIdGroupType());
        assertEquals(locationEntity.getLocationType().getLotId(), location.getLotId());
    }

    /**
     * Test : Mapping from 'Location' to 'LocationEntity'
     */
    @Test
    public void testMapLocationToLocationEntity()
    {
        // Given
        Location location = new Location();
        location.setLocation(mockValues.nextString(8));
        location.setLocationDescription(mockValues.nextString(32));
        location.setAddress(mockValues.nextString(220));
        location.setPostcode(mockValues.nextString(8));
        location.setTelephone(mockValues.nextString(15));
        location.setLocIdPrimaryZone(mockValues.nextInteger());
        location.setPrimaryZoneCode(mockValues.nextString(8));
        location.setPrimaryZoneDesc(mockValues.nextString(32));
        location.setLocIdSecondaryZone(mockValues.nextInteger());
        location.setSecondaryZoneCode(mockValues.nextString(8));
        location.setSecondaryZoneDesc(mockValues.nextString(32));
        location.setLocIdTertiaryZone(mockValues.nextInteger());
        location.setTertiaryZoneCode(mockValues.nextString(8));
        location.setTertiaryZoneDesc(mockValues.nextString(32));
        location.setLocIdTvStation(mockValues.nextInteger());
        location.setTvStationCode(mockValues.nextString(8));
        location.setTvStationName(mockValues.nextString(32));
        location.setLocIdLocalAuthority(mockValues.nextInteger());
        location.setLocalAuthorityCode(mockValues.nextString(8));
        location.setLocalAuthorityName(mockValues.nextString(32));
        location.setLocIdStationGroup(mockValues.nextInteger());
        location.setStationGroup(mockValues.nextString(8));
        location.setStationGroupDesc(mockValues.nextString(32));
        location.setLocIdLondonStationGrp(mockValues.nextInteger());
        location.setLondonStationGrpCode(mockValues.nextString(8));
        location.setLondonStationGrpDesc(mockValues.nextString(32));
        location.setOsGridReference(mockValues.nextString(8));
        location.setPostalRegion(mockValues.nextString(2));
        location.setNalco12charDescription(mockValues.nextString(12));
        location.setNalco16charDescription(mockValues.nextString(16));
        location.setNalco26charDescription(mockValues.nextString(26));
        location.setNalcoTiploc(mockValues.nextString(7));
        location.setNalco3charCode(mockValues.nextString(3));
        location.setEffectiveFrom(mockValues.nextDate());
        location.setEffectiveTo(mockValues.nextDate());
        location.setExpired(mockValues.nextString(1));
        location.setLocIdMasterAccount(mockValues.nextInteger());
        location.setMasterAccountCode(mockValues.nextString(8));
        location.setMasterAccountName(mockValues.nextString(32));
        location.setCobIdGroupType(mockValues.nextInteger());
        location.setLotId(mockValues.nextInteger());

        LocationEntity locationEntity = new LocationEntity();

        // When
        locationServiceMapper.mapLocationToLocationEntity(location, locationEntity);

        // Then
        assertEquals(location.getLocation(), locationEntity.getLocation());
        assertEquals(location.getLocationDescription(), locationEntity.getLocationDescription());
        assertEquals(location.getAddress(), locationEntity.getAddress());
        assertEquals(location.getPostcode(), locationEntity.getPostcode());
        assertEquals(location.getTelephone(), locationEntity.getTelephone());
        assertEquals(location.getLocIdPrimaryZone(), locationEntity.getLocIdPrimaryZone());
        assertEquals(location.getPrimaryZoneCode(), locationEntity.getPrimaryZoneCode());
        assertEquals(location.getPrimaryZoneDesc(), locationEntity.getPrimaryZoneDesc());
        assertEquals(location.getLocIdSecondaryZone(), locationEntity.getLocIdSecondaryZone());
        assertEquals(location.getSecondaryZoneCode(), locationEntity.getSecondaryZoneCode());
        assertEquals(location.getSecondaryZoneDesc(), locationEntity.getSecondaryZoneDesc());
        assertEquals(location.getLocIdTertiaryZone(), locationEntity.getLocIdTertiaryZone());
        assertEquals(location.getTertiaryZoneCode(), locationEntity.getTertiaryZoneCode());
        assertEquals(location.getTertiaryZoneDesc(), locationEntity.getTertiaryZoneDesc());
        assertEquals(location.getLocIdTvStation(), locationEntity.getLocIdTvStation());
        assertEquals(location.getTvStationCode(), locationEntity.getTvStationCode());
        assertEquals(location.getTvStationName(), locationEntity.getTvStationName());
        assertEquals(location.getLocIdLocalAuthority(), locationEntity.getLocIdLocalAuthority());
        assertEquals(location.getLocalAuthorityCode(), locationEntity.getLocalAuthorityCode());
        assertEquals(location.getLocalAuthorityName(), locationEntity.getLocalAuthorityName());
        assertEquals(location.getLocIdStationGroup(), locationEntity.getLocIdStationGroup());
        assertEquals(location.getStationGroup(), locationEntity.getStationGroup());
        assertEquals(location.getStationGroupDesc(), locationEntity.getStationGroupDesc());
        assertEquals(location.getLocIdLondonStationGrp(), locationEntity.getLocIdLondonStationGrp());
        assertEquals(location.getLondonStationGrpCode(), locationEntity.getLondonStationGrpCode());
        assertEquals(location.getLondonStationGrpDesc(), locationEntity.getLondonStationGrpDesc());
        assertEquals(location.getOsGridReference(), locationEntity.getOsGridReference());
        assertEquals(location.getPostalRegion(), locationEntity.getPostalRegion());
        assertEquals(location.getNalco12charDescription(), locationEntity.getNalco12charDescription());
        assertEquals(location.getNalco16charDescription(), locationEntity.getNalco16charDescription());
        assertEquals(location.getNalco26charDescription(), locationEntity.getNalco26charDescription());
        assertEquals(location.getNalcoTiploc(), locationEntity.getNalcoTiploc());
        assertEquals(location.getNalco3charCode(), locationEntity.getNalco3charCode());
        assertEquals(location.getEffectiveFrom(), locationEntity.getEffectiveFrom());
        assertEquals(location.getEffectiveTo(), locationEntity.getEffectiveTo());
        assertEquals(location.getExpired(), locationEntity.getExpired());
        assertEquals(location.getLocIdMasterAccount(), locationEntity.getLocIdMasterAccount());
        assertEquals(location.getMasterAccountCode(), locationEntity.getMasterAccountCode());
        assertEquals(location.getMasterAccountName(), locationEntity.getMasterAccountName());
        assertEquals(location.getCobIdGroupType(), locationEntity.getCobIdGroupType());
        assertEquals(location.getLotId(), locationEntity.getLocationType().getLotId());
    }

}
