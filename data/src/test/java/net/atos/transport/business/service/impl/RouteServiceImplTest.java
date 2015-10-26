/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.Route;
import net.atos.transport.entity.jpa.RouteEntity;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.RouteServiceMapper;
import net.atos.transport.data.repository.jpa.RouteJpaRepository;
import net.atos.transport.test.RouteFactoryForTest;
import net.atos.transport.test.RouteEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of RouteService
 */
@RunWith(MockitoJUnitRunner.class)
public class RouteServiceImplTest
{

    @InjectMocks
    private RouteServiceImpl routeService;

    @Mock
    private RouteJpaRepository routeJpaRepository;

    @Mock
    private RouteServiceMapper routeServiceMapper;

    private RouteFactoryForTest routeFactoryForTest = new RouteFactoryForTest();

    private RouteEntityFactoryForTest routeEntityFactoryForTest = new RouteEntityFactoryForTest();

    private MockValues mockValues = new MockValues();

    @Test
    public void findById()
    {
        // Given
        Integer rouId = mockValues.nextInteger();

        RouteEntity routeEntity = routeJpaRepository.findOne(rouId);

        Route route = routeFactoryForTest.newRoute();
        when(routeServiceMapper.mapRouteEntityToRoute(routeEntity)).thenReturn(route);

        // When
        Route routeFound = routeService.findById(rouId);

        // Then
        assertEquals(route.getRouId(), routeFound.getRouId());
    }

    @Test
    public void findAll()
    {
        // Given
        List<RouteEntity> routeEntitys = new ArrayList<RouteEntity>();
        RouteEntity routeEntity1 = routeEntityFactoryForTest.newRouteEntity();
        routeEntitys.add(routeEntity1);
        RouteEntity routeEntity2 = routeEntityFactoryForTest.newRouteEntity();
        routeEntitys.add(routeEntity2);
        when(routeJpaRepository.findAll()).thenReturn(routeEntitys);

        Route route1 = routeFactoryForTest.newRoute();
        when(routeServiceMapper.mapRouteEntityToRoute(routeEntity1)).thenReturn(route1);
        Route route2 = routeFactoryForTest.newRoute();
        when(routeServiceMapper.mapRouteEntityToRoute(routeEntity2)).thenReturn(route2);

        // When
        List<Route> routesFounds = routeService.findAll();

        // Then
        assertTrue(route1 == routesFounds.get(0));
        assertTrue(route2 == routesFounds.get(1));
    }

    @Test
    public void create()
    {
        // Given
        Route route = routeFactoryForTest.newRoute();

        RouteEntity routeEntity = routeEntityFactoryForTest.newRouteEntity();
        when(routeJpaRepository.findOne(route.getRouId())).thenReturn(null);

        routeEntity = new RouteEntity();
        routeServiceMapper.mapRouteToRouteEntity(route, routeEntity);
        RouteEntity routeEntitySaved = routeJpaRepository.save(routeEntity);

        Route routeSaved = routeFactoryForTest.newRoute();
        when(routeServiceMapper.mapRouteEntityToRoute(routeEntitySaved)).thenReturn(routeSaved);

        // When
        Route routeResult = routeService.create(route);

        // Then
        assertTrue(routeResult == routeSaved);
    }

    @Test
    public void createKOExists()
    {
        // Given
        Route route = routeFactoryForTest.newRoute();

        RouteEntity routeEntity = routeEntityFactoryForTest.newRouteEntity();
        when(routeJpaRepository.findOne(route.getRouId())).thenReturn(routeEntity);

        // When
        Exception exception = null;
        try
        {
            routeService.create(route);
        }
        catch (Exception e)
        {
            exception = e;
        }

        // Then
        assertTrue(exception instanceof IllegalStateException);
        assertEquals("already.exists", exception.getMessage());
    }

    @Test
    public void update()
    {
        // Given
        Route route = routeFactoryForTest.newRoute();

        RouteEntity routeEntity = routeEntityFactoryForTest.newRouteEntity();
        when(routeJpaRepository.findOne(route.getRouId())).thenReturn(routeEntity);

        RouteEntity routeEntitySaved = routeEntityFactoryForTest.newRouteEntity();
        when(routeJpaRepository.save(routeEntity)).thenReturn(routeEntitySaved);

        Route routeSaved = routeFactoryForTest.newRoute();
        when(routeServiceMapper.mapRouteEntityToRoute(routeEntitySaved)).thenReturn(routeSaved);

        // When
        Route routeResult = routeService.update(route);

        // Then
        verify(routeServiceMapper).mapRouteToRouteEntity(route, routeEntity);
        assertTrue(routeResult == routeSaved);
    }

    @Test
    public void delete()
    {
        // Given
        Integer rouId = mockValues.nextInteger();

        // When
        routeService.delete(rouId);

        // Then
        verify(routeJpaRepository).delete(rouId);

    }

}
