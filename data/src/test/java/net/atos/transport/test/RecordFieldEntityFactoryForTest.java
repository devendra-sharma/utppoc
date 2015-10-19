package net.atos.transport.test;

import net.atos.transport.entity.jpa.RecordFieldEntity;

public class RecordFieldEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public RecordFieldEntity newRecordFieldEntity() {

		Integer refId = mockValues.nextInteger();

		RecordFieldEntity recordFieldEntity = new RecordFieldEntity();
		recordFieldEntity.setRefId(refId);
		return recordFieldEntity;
	}
	
}
