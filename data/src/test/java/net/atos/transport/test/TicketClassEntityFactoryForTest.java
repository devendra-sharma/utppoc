package net.atos.transport.test;

import net.atos.transport.entity.jpa.TicketClassEntity;

public class TicketClassEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public TicketClassEntity newTicketClassEntity()
    {

        Integer ticId = mockValues.nextInteger();

        TicketClassEntity ticketClassEntity = new TicketClassEntity();
        ticketClassEntity.setTicId(ticId);
        return ticketClassEntity;
    }

}
