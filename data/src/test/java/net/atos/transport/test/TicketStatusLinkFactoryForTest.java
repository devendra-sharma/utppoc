package net.atos.transport.test;

import net.atos.transport.entity.TicketStatusLink;

public class TicketStatusLinkFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public TicketStatusLink newTicketStatusLink()
    {

        Integer tslId = mockValues.nextInteger();

        TicketStatusLink ticketStatusLink = new TicketStatusLink();
        ticketStatusLink.setTslId(tslId);
        return ticketStatusLink;
    }

}
