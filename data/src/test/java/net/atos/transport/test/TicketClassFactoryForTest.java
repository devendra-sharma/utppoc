package net.atos.transport.test;

import net.atos.transport.entity.TicketClass;

public class TicketClassFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public TicketClass newTicketClass()
    {

        Integer ticId = mockValues.nextInteger();

        TicketClass ticketClass = new TicketClass();
        ticketClass.setTicId(ticId);
        return ticketClass;
    }

}
