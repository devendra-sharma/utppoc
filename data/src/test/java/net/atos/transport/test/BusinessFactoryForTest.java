package net.atos.transport.test;

import net.atos.transport.entity.Business;

public class BusinessFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public Business newBusiness()
    {

        Integer busId = mockValues.nextInteger();

        Business business = new Business();
        business.setBusId(busId);
        return business;
    }

}
