package net.atos.transport.test;

import net.atos.transport.entity.jpa.ApplicationParametersEntity;

public class ApplicationParametersEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ApplicationParametersEntity newApplicationParametersEntity() {

		Integer applicationParametersId = mockValues.nextInteger();

		ApplicationParametersEntity applicationParametersEntity = new ApplicationParametersEntity();
		applicationParametersEntity.setApplicationParametersId(applicationParametersId);
		return applicationParametersEntity;
	}
	
}
