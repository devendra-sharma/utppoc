package net.atos.transport.test;

import net.atos.transport.entity.jpa.LocationTypeEntity;

public class LocationTypeEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public LocationTypeEntity newLocationTypeEntity()
    {

        Integer lotId = mockValues.nextInteger();

        LocationTypeEntity locationTypeEntity = new LocationTypeEntity();
        locationTypeEntity.setLotId(lotId);
        return locationTypeEntity;
    }

}
