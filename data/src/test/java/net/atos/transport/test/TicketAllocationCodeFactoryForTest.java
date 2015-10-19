package net.atos.transport.test;

import net.atos.transport.entity.TicketAllocationCode;

public class TicketAllocationCodeFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TicketAllocationCode newTicketAllocationCode() {

		Integer tacId = mockValues.nextInteger();

		TicketAllocationCode ticketAllocationCode = new TicketAllocationCode();
		ticketAllocationCode.setTacId(tacId);
		return ticketAllocationCode;
	}
	
}
