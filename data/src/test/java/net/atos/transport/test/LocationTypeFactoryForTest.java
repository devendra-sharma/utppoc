package net.atos.transport.test;

import net.atos.transport.entity.LocationType;

public class LocationTypeFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public LocationType newLocationType()
    {

        Integer lotId = mockValues.nextInteger();

        LocationType locationType = new LocationType();
        locationType.setLotId(lotId);
        return locationType;
    }

}
