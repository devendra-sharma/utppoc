package net.atos.transport.test;

import net.atos.transport.entity.ProcessControl;

public class ProcessControlFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ProcessControl newProcessControl() {

		Integer processId = mockValues.nextInteger();

		ProcessControl processControl = new ProcessControl();
		processControl.setProcessId(processId);
		return processControl;
	}
	
}
