package net.atos.transport.test;

import net.atos.transport.entity.jpa.GroupFunctionTypeEntity;

public class GroupFunctionTypeEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public GroupFunctionTypeEntity newGroupFunctionTypeEntity()
    {

        Integer gftId = mockValues.nextInteger();

        GroupFunctionTypeEntity groupFunctionTypeEntity = new GroupFunctionTypeEntity();
        groupFunctionTypeEntity.setGftId(gftId);
        return groupFunctionTypeEntity;
    }

}
