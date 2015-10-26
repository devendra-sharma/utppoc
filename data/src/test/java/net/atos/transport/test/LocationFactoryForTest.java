package net.atos.transport.test;

import net.atos.transport.entity.Location;

public class LocationFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public Location newLocation()
    {

        Integer locId = mockValues.nextInteger();

        Location location = new Location();
        location.setLocId(locId);
        return location;
    }

}
