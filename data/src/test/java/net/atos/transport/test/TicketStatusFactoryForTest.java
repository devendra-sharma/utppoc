package net.atos.transport.test;

import net.atos.transport.entity.TicketStatus;

public class TicketStatusFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public TicketStatus newTicketStatus()
    {

        Integer tisId = mockValues.nextInteger();

        TicketStatus ticketStatus = new TicketStatus();
        ticketStatus.setTisId(tisId);
        return ticketStatus;
    }

}
