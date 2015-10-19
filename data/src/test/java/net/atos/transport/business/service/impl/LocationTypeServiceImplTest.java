/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.LocationType;
import net.atos.transport.entity.jpa.LocationTypeEntity;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.LocationTypeServiceMapper;
import net.atos.transport.data.repository.jpa.LocationTypeJpaRepository;
import net.atos.transport.test.LocationTypeFactoryForTest;
import net.atos.transport.test.LocationTypeEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of LocationTypeService
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationTypeServiceImplTest {

	@InjectMocks
	private LocationTypeServiceImpl locationTypeService;
	@Mock
	private LocationTypeJpaRepository locationTypeJpaRepository;
	@Mock
	private LocationTypeServiceMapper locationTypeServiceMapper;
	
	private LocationTypeFactoryForTest locationTypeFactoryForTest = new LocationTypeFactoryForTest();

	private LocationTypeEntityFactoryForTest locationTypeEntityFactoryForTest = new LocationTypeEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer lotId = mockValues.nextInteger();
		
		LocationTypeEntity locationTypeEntity = locationTypeJpaRepository.findOne(lotId);
		
		LocationType locationType = locationTypeFactoryForTest.newLocationType();
		when(locationTypeServiceMapper.mapLocationTypeEntityToLocationType(locationTypeEntity)).thenReturn(locationType);

		// When
		LocationType locationTypeFound = locationTypeService.findById(lotId);

		// Then
		assertEquals(locationType.getLotId(),locationTypeFound.getLotId());
	}

	@Test
	public void findAll() {
		// Given
		List<LocationTypeEntity> locationTypeEntitys = new ArrayList<LocationTypeEntity>();
		LocationTypeEntity locationTypeEntity1 = locationTypeEntityFactoryForTest.newLocationTypeEntity();
		locationTypeEntitys.add(locationTypeEntity1);
		LocationTypeEntity locationTypeEntity2 = locationTypeEntityFactoryForTest.newLocationTypeEntity();
		locationTypeEntitys.add(locationTypeEntity2);
		when(locationTypeJpaRepository.findAll()).thenReturn(locationTypeEntitys);
		
		LocationType locationType1 = locationTypeFactoryForTest.newLocationType();
		when(locationTypeServiceMapper.mapLocationTypeEntityToLocationType(locationTypeEntity1)).thenReturn(locationType1);
		LocationType locationType2 = locationTypeFactoryForTest.newLocationType();
		when(locationTypeServiceMapper.mapLocationTypeEntityToLocationType(locationTypeEntity2)).thenReturn(locationType2);

		// When
		List<LocationType> locationTypesFounds = locationTypeService.findAll();

		// Then
		assertTrue(locationType1 == locationTypesFounds.get(0));
		assertTrue(locationType2 == locationTypesFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		LocationType locationType = locationTypeFactoryForTest.newLocationType();

		LocationTypeEntity locationTypeEntity = locationTypeEntityFactoryForTest.newLocationTypeEntity();
		when(locationTypeJpaRepository.findOne(locationType.getLotId())).thenReturn(null);
		
		locationTypeEntity = new LocationTypeEntity();
		locationTypeServiceMapper.mapLocationTypeToLocationTypeEntity(locationType, locationTypeEntity);
		LocationTypeEntity locationTypeEntitySaved = locationTypeJpaRepository.save(locationTypeEntity);
		
		LocationType locationTypeSaved = locationTypeFactoryForTest.newLocationType();
		when(locationTypeServiceMapper.mapLocationTypeEntityToLocationType(locationTypeEntitySaved)).thenReturn(locationTypeSaved);

		// When
		LocationType locationTypeResult = locationTypeService.create(locationType);

		// Then
		assertTrue(locationTypeResult == locationTypeSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		LocationType locationType = locationTypeFactoryForTest.newLocationType();

		LocationTypeEntity locationTypeEntity = locationTypeEntityFactoryForTest.newLocationTypeEntity();
		when(locationTypeJpaRepository.findOne(locationType.getLotId())).thenReturn(locationTypeEntity);

		// When
		Exception exception = null;
		try {
			locationTypeService.create(locationType);
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
		LocationType locationType = locationTypeFactoryForTest.newLocationType();

		LocationTypeEntity locationTypeEntity = locationTypeEntityFactoryForTest.newLocationTypeEntity();
		when(locationTypeJpaRepository.findOne(locationType.getLotId())).thenReturn(locationTypeEntity);
		
		LocationTypeEntity locationTypeEntitySaved = locationTypeEntityFactoryForTest.newLocationTypeEntity();
		when(locationTypeJpaRepository.save(locationTypeEntity)).thenReturn(locationTypeEntitySaved);
		
		LocationType locationTypeSaved = locationTypeFactoryForTest.newLocationType();
		when(locationTypeServiceMapper.mapLocationTypeEntityToLocationType(locationTypeEntitySaved)).thenReturn(locationTypeSaved);

		// When
		LocationType locationTypeResult = locationTypeService.update(locationType);

		// Then
		verify(locationTypeServiceMapper).mapLocationTypeToLocationTypeEntity(locationType, locationTypeEntity);
		assertTrue(locationTypeResult == locationTypeSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer lotId = mockValues.nextInteger();

		// When
		locationTypeService.delete(lotId);

		// Then
		verify(locationTypeJpaRepository).delete(lotId);
		
	}

}
