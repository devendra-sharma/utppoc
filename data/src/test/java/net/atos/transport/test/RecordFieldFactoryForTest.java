package net.atos.transport.test;

import net.atos.transport.entity.RecordField;

public class RecordFieldFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public RecordField newRecordField()
    {

        Integer refId = mockValues.nextInteger();

        RecordField recordField = new RecordField();
        recordField.setRefId(refId);
        return recordField;
    }

}
