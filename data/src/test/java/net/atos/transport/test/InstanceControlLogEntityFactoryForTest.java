package net.atos.transport.test;

import net.atos.transport.entity.jpa.InstanceControlLogEntity;

public class InstanceControlLogEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public InstanceControlLogEntity newInstanceControlLogEntity()
    {

        Integer iclId = mockValues.nextInteger();

        InstanceControlLogEntity instanceControlLogEntity = new InstanceControlLogEntity();
        instanceControlLogEntity.setIclId(iclId);
        return instanceControlLogEntity;
    }

}
