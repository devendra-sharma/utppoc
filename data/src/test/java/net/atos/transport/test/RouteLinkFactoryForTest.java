package net.atos.transport.test;

import net.atos.transport.entity.RouteLink;

public class RouteLinkFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public RouteLink newRouteLink()
    {

        Integer rolId = mockValues.nextInteger();

        RouteLink routeLink = new RouteLink();
        routeLink.setRolId(rolId);
        return routeLink;
    }

}
