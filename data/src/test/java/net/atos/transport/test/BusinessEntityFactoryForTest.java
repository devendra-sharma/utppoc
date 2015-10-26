package net.atos.transport.test;

import net.atos.transport.entity.jpa.BusinessEntity;

public class BusinessEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public BusinessEntity newBusinessEntity()
    {

        Integer busId = mockValues.nextInteger();

        BusinessEntity businessEntity = new BusinessEntity();
        businessEntity.setBusId(busId);
        return businessEntity;
    }

}
