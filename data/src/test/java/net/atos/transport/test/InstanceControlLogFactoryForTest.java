package net.atos.transport.test;

import net.atos.transport.entity.InstanceControlLog;

public class InstanceControlLogFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public InstanceControlLog newInstanceControlLog() {

		Integer iclId = mockValues.nextInteger();

		InstanceControlLog instanceControlLog = new InstanceControlLog();
		instanceControlLog.setIclId(iclId);
		return instanceControlLog;
	}
	
}
