package net.atos.transport.test;

import net.atos.transport.entity.jpa.RouteEntity;

public class RouteEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public RouteEntity newRouteEntity()
    {

        Integer rouId = mockValues.nextInteger();

        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setRouId(rouId);
        return routeEntity;
    }

}
