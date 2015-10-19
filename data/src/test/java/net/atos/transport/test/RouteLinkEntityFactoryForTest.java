package net.atos.transport.test;

import net.atos.transport.entity.jpa.RouteLinkEntity;

public class RouteLinkEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public RouteLinkEntity newRouteLinkEntity() {

		Integer rolId = mockValues.nextInteger();

		RouteLinkEntity routeLinkEntity = new RouteLinkEntity();
		routeLinkEntity.setRolId(rolId);
		return routeLinkEntity;
	}
	
}
