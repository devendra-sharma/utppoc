package net.atos.transport.test;

import net.atos.transport.entity.GroupFunctionType;

public class GroupFunctionTypeFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public GroupFunctionType newGroupFunctionType()
    {

        Integer gftId = mockValues.nextInteger();

        GroupFunctionType groupFunctionType = new GroupFunctionType();
        groupFunctionType.setGftId(gftId);
        return groupFunctionType;
    }

}
