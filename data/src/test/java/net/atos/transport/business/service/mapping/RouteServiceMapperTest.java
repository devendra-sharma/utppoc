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
import net.atos.transport.entity.Route;
import net.atos.transport.entity.jpa.RouteEntity;
import net.atos.transport.entity.jpa.TicketAllocationCodeEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class RouteServiceMapperTest
{

    private RouteServiceMapper routeServiceMapper;

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
        routeServiceMapper = new RouteServiceMapper();
        routeServiceMapper.setModelMapper(modelMapper);
    }

    /**
     * Mapping from 'RouteEntity' to 'Route'
     * 
     * @param routeEntity
     */
    @Test
    public void testMapRouteEntityToRoute()
    {
        // Given
        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setExpired(mockValues.nextString(1));
        routeEntity.setEffectiveFrom(mockValues.nextDate());
        routeEntity.setEffectiveTo(mockValues.nextDate());
        routeEntity.setRouteCode(mockValues.nextString(5));
        routeEntity.setRouteDescription(mockValues.nextString(35));
        routeEntity.setCobIdRouteType(mockValues.nextInteger());
        routeEntity.setTicketAllocationCode(new TicketAllocationCodeEntity());
        routeEntity.getTicketAllocationCode().setTacId(mockValues.nextInteger());

        // When
        Route route = routeServiceMapper.mapRouteEntityToRoute(routeEntity);

        // Then
        assertEquals(routeEntity.getExpired(), route.getExpired());
        assertEquals(routeEntity.getEffectiveFrom(), route.getEffectiveFrom());
        assertEquals(routeEntity.getEffectiveTo(), route.getEffectiveTo());
        assertEquals(routeEntity.getRouteCode(), route.getRouteCode());
        assertEquals(routeEntity.getRouteDescription(), route.getRouteDescription());
        assertEquals(routeEntity.getCobIdRouteType(), route.getCobIdRouteType());
        assertEquals(routeEntity.getTicketAllocationCode().getTacId(), route.getTacId());
    }

    /**
     * Test : Mapping from 'Route' to 'RouteEntity'
     */
    @Test
    public void testMapRouteToRouteEntity()
    {
        // Given
        Route route = new Route();
        route.setExpired(mockValues.nextString(1));
        route.setEffectiveFrom(mockValues.nextDate());
        route.setEffectiveTo(mockValues.nextDate());
        route.setRouteCode(mockValues.nextString(5));
        route.setRouteDescription(mockValues.nextString(35));
        route.setCobIdRouteType(mockValues.nextInteger());
        route.setTacId(mockValues.nextInteger());

        RouteEntity routeEntity = new RouteEntity();

        // When
        routeServiceMapper.mapRouteToRouteEntity(route, routeEntity);

        // Then
        assertEquals(route.getExpired(), routeEntity.getExpired());
        assertEquals(route.getEffectiveFrom(), routeEntity.getEffectiveFrom());
        assertEquals(route.getEffectiveTo(), routeEntity.getEffectiveTo());
        assertEquals(route.getRouteCode(), routeEntity.getRouteCode());
        assertEquals(route.getRouteDescription(), routeEntity.getRouteDescription());
        assertEquals(route.getCobIdRouteType(), routeEntity.getCobIdRouteType());
        assertEquals(route.getTacId(), routeEntity.getTicketAllocationCode().getTacId());
    }

}
