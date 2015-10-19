package net.atos.transport.test;

import net.atos.transport.entity.jpa.FaresCheckingExclusionEntity;

public class FaresCheckingExclusionEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public FaresCheckingExclusionEntity newFaresCheckingExclusionEntity() {

		Long faresCheckingExclusionId = mockValues.nextLong();

		FaresCheckingExclusionEntity faresCheckingExclusionEntity = new FaresCheckingExclusionEntity();
		faresCheckingExclusionEntity.setFaresCheckingExclusionId(faresCheckingExclusionId);
		return faresCheckingExclusionEntity;
	}
	
}
