package net.atos.transport.test;

import net.atos.transport.entity.jpa.LocationEntity;

public class LocationEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public LocationEntity newLocationEntity() {

		Integer locId = mockValues.nextInteger();

		LocationEntity locationEntity = new LocationEntity();
		locationEntity.setLocId(locId);
		return locationEntity;
	}
	
}
