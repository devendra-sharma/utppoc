/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.RouteLink;
import net.atos.transport.entity.jpa.RouteLinkEntity;
import java.util.Date;
import net.atos.transport.business.service.mapping.RouteLinkServiceMapper;
import net.atos.transport.data.repository.jpa.RouteLinkJpaRepository;
import net.atos.transport.test.RouteLinkFactoryForTest;
import net.atos.transport.test.RouteLinkEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of RouteLinkService
 */
@RunWith(MockitoJUnitRunner.class)
public class RouteLinkServiceImplTest {

	@InjectMocks
	private RouteLinkServiceImpl routeLinkService;
	@Mock
	private RouteLinkJpaRepository routeLinkJpaRepository;
	@Mock
	private RouteLinkServiceMapper routeLinkServiceMapper;
	
	private RouteLinkFactoryForTest routeLinkFactoryForTest = new RouteLinkFactoryForTest();

	private RouteLinkEntityFactoryForTest routeLinkEntityFactoryForTest = new RouteLinkEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer rolId = mockValues.nextInteger();
		
		RouteLinkEntity routeLinkEntity = routeLinkJpaRepository.findOne(rolId);
		
		RouteLink routeLink = routeLinkFactoryForTest.newRouteLink();
		when(routeLinkServiceMapper.mapRouteLinkEntityToRouteLink(routeLinkEntity)).thenReturn(routeLink);

		// When
		RouteLink routeLinkFound = routeLinkService.findById(rolId);

		// Then
		assertEquals(routeLink.getRolId(),routeLinkFound.getRolId());
	}

	@Test
	public void findAll() {
		// Given
		List<RouteLinkEntity> routeLinkEntitys = new ArrayList<RouteLinkEntity>();
		RouteLinkEntity routeLinkEntity1 = routeLinkEntityFactoryForTest.newRouteLinkEntity();
		routeLinkEntitys.add(routeLinkEntity1);
		RouteLinkEntity routeLinkEntity2 = routeLinkEntityFactoryForTest.newRouteLinkEntity();
		routeLinkEntitys.add(routeLinkEntity2);
		when(routeLinkJpaRepository.findAll()).thenReturn(routeLinkEntitys);
		
		RouteLink routeLink1 = routeLinkFactoryForTest.newRouteLink();
		when(routeLinkServiceMapper.mapRouteLinkEntityToRouteLink(routeLinkEntity1)).thenReturn(routeLink1);
		RouteLink routeLink2 = routeLinkFactoryForTest.newRouteLink();
		when(routeLinkServiceMapper.mapRouteLinkEntityToRouteLink(routeLinkEntity2)).thenReturn(routeLink2);

		// When
		List<RouteLink> routeLinksFounds = routeLinkService.findAll();

		// Then
		assertTrue(routeLink1 == routeLinksFounds.get(0));
		assertTrue(routeLink2 == routeLinksFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		RouteLink routeLink = routeLinkFactoryForTest.newRouteLink();

		RouteLinkEntity routeLinkEntity = routeLinkEntityFactoryForTest.newRouteLinkEntity();
		when(routeLinkJpaRepository.findOne(routeLink.getRolId())).thenReturn(null);
		
		routeLinkEntity = new RouteLinkEntity();
		routeLinkServiceMapper.mapRouteLinkToRouteLinkEntity(routeLink, routeLinkEntity);
		RouteLinkEntity routeLinkEntitySaved = routeLinkJpaRepository.save(routeLinkEntity);
		
		RouteLink routeLinkSaved = routeLinkFactoryForTest.newRouteLink();
		when(routeLinkServiceMapper.mapRouteLinkEntityToRouteLink(routeLinkEntitySaved)).thenReturn(routeLinkSaved);

		// When
		RouteLink routeLinkResult = routeLinkService.create(routeLink);

		// Then
		assertTrue(routeLinkResult == routeLinkSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		RouteLink routeLink = routeLinkFactoryForTest.newRouteLink();

		RouteLinkEntity routeLinkEntity = routeLinkEntityFactoryForTest.newRouteLinkEntity();
		when(routeLinkJpaRepository.findOne(routeLink.getRolId())).thenReturn(routeLinkEntity);

		// When
		Exception exception = null;
		try {
			routeLinkService.create(routeLink);
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
		RouteLink routeLink = routeLinkFactoryForTest.newRouteLink();

		RouteLinkEntity routeLinkEntity = routeLinkEntityFactoryForTest.newRouteLinkEntity();
		when(routeLinkJpaRepository.findOne(routeLink.getRolId())).thenReturn(routeLinkEntity);
		
		RouteLinkEntity routeLinkEntitySaved = routeLinkEntityFactoryForTest.newRouteLinkEntity();
		when(routeLinkJpaRepository.save(routeLinkEntity)).thenReturn(routeLinkEntitySaved);
		
		RouteLink routeLinkSaved = routeLinkFactoryForTest.newRouteLink();
		when(routeLinkServiceMapper.mapRouteLinkEntityToRouteLink(routeLinkEntitySaved)).thenReturn(routeLinkSaved);

		// When
		RouteLink routeLinkResult = routeLinkService.update(routeLink);

		// Then
		verify(routeLinkServiceMapper).mapRouteLinkToRouteLinkEntity(routeLink, routeLinkEntity);
		assertTrue(routeLinkResult == routeLinkSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer rolId = mockValues.nextInteger();

		// When
		routeLinkService.delete(rolId);

		// Then
		verify(routeLinkJpaRepository).delete(rolId);
		
	}

}
