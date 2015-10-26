package net.atos.transport.test;

import net.atos.transport.entity.jpa.WeekEntity;

public class WeekEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public WeekEntity newWeekEntity()
    {

        Integer weekId = mockValues.nextInteger();

        WeekEntity weekEntity = new WeekEntity();
        weekEntity.setWeekId(weekId);
        return weekEntity;
    }

}
