package net.atos.transport.test;

import net.atos.transport.entity.jpa.PeriodEntity;

public class PeriodEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public PeriodEntity newPeriodEntity() {

		Integer perId = mockValues.nextInteger();

		PeriodEntity periodEntity = new PeriodEntity();
		periodEntity.setPerId(perId);
		return periodEntity;
	}
	
}
