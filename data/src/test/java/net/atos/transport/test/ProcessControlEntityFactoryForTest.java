package net.atos.transport.test;

import net.atos.transport.entity.jpa.ProcessControlEntity;

public class ProcessControlEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ProcessControlEntity newProcessControlEntity() {

		Integer processId = mockValues.nextInteger();

		ProcessControlEntity processControlEntity = new ProcessControlEntity();
		processControlEntity.setProcessId(processId);
		return processControlEntity;
	}
	
}
