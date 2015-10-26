package net.atos.transport.test;

import net.atos.transport.entity.Period;

public class PeriodFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public Period newPeriod()
    {

        Integer perId = mockValues.nextInteger();

        Period period = new Period();
        period.setPerId(perId);
        return period;
    }

}
