package net.atos.transport.test;

import net.atos.transport.entity.jpa.TicketStatusLinkEntity;

public class TicketStatusLinkEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public TicketStatusLinkEntity newTicketStatusLinkEntity()
    {

        Integer tslId = mockValues.nextInteger();

        TicketStatusLinkEntity ticketStatusLinkEntity = new TicketStatusLinkEntity();
        ticketStatusLinkEntity.setTslId(tslId);
        return ticketStatusLinkEntity;
    }

}
