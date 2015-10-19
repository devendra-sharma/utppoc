/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.LocationLink;
import net.atos.transport.entity.jpa.LocationLinkEntity;
import java.util.Date;
import net.atos.transport.business.service.mapping.LocationLinkServiceMapper;
import net.atos.transport.data.repository.jpa.LocationLinkJpaRepository;
import net.atos.transport.test.LocationLinkFactoryForTest;
import net.atos.transport.test.LocationLinkEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of LocationLinkService
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationLinkServiceImplTest {

	@InjectMocks
	private LocationLinkServiceImpl locationLinkService;
	@Mock
	private LocationLinkJpaRepository locationLinkJpaRepository;
	@Mock
	private LocationLinkServiceMapper locationLinkServiceMapper;
	
	private LocationLinkFactoryForTest locationLinkFactoryForTest = new LocationLinkFactoryForTest();

	private LocationLinkEntityFactoryForTest locationLinkEntityFactoryForTest = new LocationLinkEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer lolId = mockValues.nextInteger();
		
		LocationLinkEntity locationLinkEntity = locationLinkJpaRepository.findOne(lolId);
		
		LocationLink locationLink = locationLinkFactoryForTest.newLocationLink();
		when(locationLinkServiceMapper.mapLocationLinkEntityToLocationLink(locationLinkEntity)).thenReturn(locationLink);

		// When
		LocationLink locationLinkFound = locationLinkService.findById(lolId);

		// Then
		assertEquals(locationLink.getLolId(),locationLinkFound.getLolId());
	}

	@Test
	public void findAll() {
		// Given
		List<LocationLinkEntity> locationLinkEntitys = new ArrayList<LocationLinkEntity>();
		LocationLinkEntity locationLinkEntity1 = locationLinkEntityFactoryForTest.newLocationLinkEntity();
		locationLinkEntitys.add(locationLinkEntity1);
		LocationLinkEntity locationLinkEntity2 = locationLinkEntityFactoryForTest.newLocationLinkEntity();
		locationLinkEntitys.add(locationLinkEntity2);
		when(locationLinkJpaRepository.findAll()).thenReturn(locationLinkEntitys);
		
		LocationLink locationLink1 = locationLinkFactoryForTest.newLocationLink();
		when(locationLinkServiceMapper.mapLocationLinkEntityToLocationLink(locationLinkEntity1)).thenReturn(locationLink1);
		LocationLink locationLink2 = locationLinkFactoryForTest.newLocationLink();
		when(locationLinkServiceMapper.mapLocationLinkEntityToLocationLink(locationLinkEntity2)).thenReturn(locationLink2);

		// When
		List<LocationLink> locationLinksFounds = locationLinkService.findAll();

		// Then
		assertTrue(locationLink1 == locationLinksFounds.get(0));
		assertTrue(locationLink2 == locationLinksFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		LocationLink locationLink = locationLinkFactoryForTest.newLocationLink();

		LocationLinkEntity locationLinkEntity = locationLinkEntityFactoryForTest.newLocationLinkEntity();
		when(locationLinkJpaRepository.findOne(locationLink.getLolId())).thenReturn(null);
		
		locationLinkEntity = new LocationLinkEntity();
		locationLinkServiceMapper.mapLocationLinkToLocationLinkEntity(locationLink, locationLinkEntity);
		LocationLinkEntity locationLinkEntitySaved = locationLinkJpaRepository.save(locationLinkEntity);
		
		LocationLink locationLinkSaved = locationLinkFactoryForTest.newLocationLink();
		when(locationLinkServiceMapper.mapLocationLinkEntityToLocationLink(locationLinkEntitySaved)).thenReturn(locationLinkSaved);

		// When
		LocationLink locationLinkResult = locationLinkService.create(locationLink);

		// Then
		assertTrue(locationLinkResult == locationLinkSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		LocationLink locationLink = locationLinkFactoryForTest.newLocationLink();

		LocationLinkEntity locationLinkEntity = locationLinkEntityFactoryForTest.newLocationLinkEntity();
		when(locationLinkJpaRepository.findOne(locationLink.getLolId())).thenReturn(locationLinkEntity);

		// When
		Exception exception = null;
		try {
			locationLinkService.create(locationLink);
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
		LocationLink locationLink = locationLinkFactoryForTest.newLocationLink();

		LocationLinkEntity locationLinkEntity = locationLinkEntityFactoryForTest.newLocationLinkEntity();
		when(locationLinkJpaRepository.findOne(locationLink.getLolId())).thenReturn(locationLinkEntity);
		
		LocationLinkEntity locationLinkEntitySaved = locationLinkEntityFactoryForTest.newLocationLinkEntity();
		when(locationLinkJpaRepository.save(locationLinkEntity)).thenReturn(locationLinkEntitySaved);
		
		LocationLink locationLinkSaved = locationLinkFactoryForTest.newLocationLink();
		when(locationLinkServiceMapper.mapLocationLinkEntityToLocationLink(locationLinkEntitySaved)).thenReturn(locationLinkSaved);

		// When
		LocationLink locationLinkResult = locationLinkService.update(locationLink);

		// Then
		verify(locationLinkServiceMapper).mapLocationLinkToLocationLinkEntity(locationLink, locationLinkEntity);
		assertTrue(locationLinkResult == locationLinkSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer lolId = mockValues.nextInteger();

		// When
		locationLinkService.delete(lolId);

		// Then
		verify(locationLinkJpaRepository).delete(lolId);
		
	}

}
