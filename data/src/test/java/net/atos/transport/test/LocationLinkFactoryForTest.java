package net.atos.transport.test;

import net.atos.transport.entity.LocationLink;

public class LocationLinkFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public LocationLink newLocationLink() {

		Integer lolId = mockValues.nextInteger();

		LocationLink locationLink = new LocationLink();
		locationLink.setLolId(lolId);
		return locationLink;
	}
	
}
