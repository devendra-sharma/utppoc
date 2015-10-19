package net.atos.transport.test;

import net.atos.transport.entity.Route;

public class RouteFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Route newRoute() {

		Integer rouId = mockValues.nextInteger();

		Route route = new Route();
		route.setRouId(rouId);
		return route;
	}
	
}
