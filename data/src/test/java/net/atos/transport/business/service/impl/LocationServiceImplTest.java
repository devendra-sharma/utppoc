/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.Location;
import net.atos.transport.entity.jpa.LocationEntity;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.LocationServiceMapper;
import net.atos.transport.data.repository.jpa.LocationJpaRepository;
import net.atos.transport.test.LocationFactoryForTest;
import net.atos.transport.test.LocationEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of LocationService
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationServiceImplTest {

	@InjectMocks
	private LocationServiceImpl locationService;
	@Mock
	private LocationJpaRepository locationJpaRepository;
	@Mock
	private LocationServiceMapper locationServiceMapper;
	
	private LocationFactoryForTest locationFactoryForTest = new LocationFactoryForTest();

	private LocationEntityFactoryForTest locationEntityFactoryForTest = new LocationEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer locId = mockValues.nextInteger();
		
		LocationEntity locationEntity = locationJpaRepository.findOne(locId);
		
		Location location = locationFactoryForTest.newLocation();
		when(locationServiceMapper.mapLocationEntityToLocation(locationEntity)).thenReturn(location);

		// When
		Location locationFound = locationService.findById(locId);

		// Then
		assertEquals(location.getLocId(),locationFound.getLocId());
	}

	@Test
	public void findAll() {
		// Given
		List<LocationEntity> locationEntitys = new ArrayList<LocationEntity>();
		LocationEntity locationEntity1 = locationEntityFactoryForTest.newLocationEntity();
		locationEntitys.add(locationEntity1);
		LocationEntity locationEntity2 = locationEntityFactoryForTest.newLocationEntity();
		locationEntitys.add(locationEntity2);
		when(locationJpaRepository.findAll()).thenReturn(locationEntitys);
		
		Location location1 = locationFactoryForTest.newLocation();
		when(locationServiceMapper.mapLocationEntityToLocation(locationEntity1)).thenReturn(location1);
		Location location2 = locationFactoryForTest.newLocation();
		when(locationServiceMapper.mapLocationEntityToLocation(locationEntity2)).thenReturn(location2);

		// When
		List<Location> locationsFounds = locationService.findAll();

		// Then
		assertTrue(location1 == locationsFounds.get(0));
		assertTrue(location2 == locationsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Location location = locationFactoryForTest.newLocation();

		LocationEntity locationEntity = locationEntityFactoryForTest.newLocationEntity();
		when(locationJpaRepository.findOne(location.getLocId())).thenReturn(null);
		
		locationEntity = new LocationEntity();
		locationServiceMapper.mapLocationToLocationEntity(location, locationEntity);
		LocationEntity locationEntitySaved = locationJpaRepository.save(locationEntity);
		
		Location locationSaved = locationFactoryForTest.newLocation();
		when(locationServiceMapper.mapLocationEntityToLocation(locationEntitySaved)).thenReturn(locationSaved);

		// When
		Location locationResult = locationService.create(location);

		// Then
		assertTrue(locationResult == locationSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Location location = locationFactoryForTest.newLocation();

		LocationEntity locationEntity = locationEntityFactoryForTest.newLocationEntity();
		when(locationJpaRepository.findOne(location.getLocId())).thenReturn(locationEntity);

		// When
		Exception exception = null;
		try {
			locationService.create(location);
		} catch(Exception e) {
			exception = e;
		}

		// Then
		assertTrue(exception instanceof IllegalStateException);
		assertEquals("already.exists", exception.getMessage());
	}

	@Test
	public void update() {
		// Given
		Location location = locationFactoryForTest.newLocation();

		LocationEntity locationEntity = locationEntityFactoryForTest.newLocationEntity();
		when(locationJpaRepository.findOne(location.getLocId())).thenReturn(locationEntity);
		
		LocationEntity locationEntitySaved = locationEntityFactoryForTest.newLocationEntity();
		when(locationJpaRepository.save(locationEntity)).thenReturn(locationEntitySaved);
		
		Location locationSaved = locationFactoryForTest.newLocation();
		when(locationServiceMapper.mapLocationEntityToLocation(locationEntitySaved)).thenReturn(locationSaved);

		// When
		Location locationResult = locationService.update(location);

		// Then
		verify(locationServiceMapper).mapLocationToLocationEntity(location, locationEntity);
		assertTrue(locationResult == locationSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer locId = mockValues.nextInteger();

		// When
		locationService.delete(locId);

		// Then
		verify(locationJpaRepository).delete(locId);
		
	}

}
