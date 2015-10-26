package net.atos.transport.test;

import net.atos.transport.entity.jpa.YearEntity;

public class YearEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public YearEntity newYearEntity()
    {

        Integer year = mockValues.nextInteger();

        YearEntity yearEntity = new YearEntity();
        yearEntity.setYear(year);
        return yearEntity;
    }

}
