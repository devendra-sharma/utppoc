package net.atos.transport.test;

import net.atos.transport.entity.jpa.TypeEntity;

public class TypeEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public TypeEntity newTypeEntity()
    {

        Integer typId = mockValues.nextInteger();

        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setTypId(typId);
        return typeEntity;
    }

}
