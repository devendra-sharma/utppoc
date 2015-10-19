package net.atos.transport.test;

import net.atos.transport.entity.ApplicationParameters;

public class ApplicationParametersFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ApplicationParameters newApplicationParameters() {

		Integer applicationParametersId = mockValues.nextInteger();

		ApplicationParameters applicationParameters = new ApplicationParameters();
		applicationParameters.setApplicationParametersId(applicationParametersId);
		return applicationParameters;
	}
	
}
