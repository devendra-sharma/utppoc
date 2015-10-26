package net.atos.transport.test;

import net.atos.transport.entity.jpa.TicketAllocationCodeEntity;

public class TicketAllocationCodeEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public TicketAllocationCodeEntity newTicketAllocationCodeEntity()
    {

        Integer tacId = mockValues.nextInteger();

        TicketAllocationCodeEntity ticketAllocationCodeEntity = new TicketAllocationCodeEntity();
        ticketAllocationCodeEntity.setTacId(tacId);
        return ticketAllocationCodeEntity;
    }

}
