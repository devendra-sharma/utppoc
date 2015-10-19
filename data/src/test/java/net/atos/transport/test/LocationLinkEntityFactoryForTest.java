package net.atos.transport.test;

import net.atos.transport.entity.jpa.LocationLinkEntity;

public class LocationLinkEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public LocationLinkEntity newLocationLinkEntity() {

		Integer lolId = mockValues.nextInteger();

		LocationLinkEntity locationLinkEntity = new LocationLinkEntity();
		locationLinkEntity.setLolId(lolId);
		return locationLinkEntity;
	}
	
}
