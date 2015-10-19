package net.atos.transport.test;

import net.atos.transport.entity.jpa.TicketStatusEntity;

public class TicketStatusEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public TicketStatusEntity newTicketStatusEntity() {

		Integer tisId = mockValues.nextInteger();

		TicketStatusEntity ticketStatusEntity = new TicketStatusEntity();
		ticketStatusEntity.setTisId(tisId);
		return ticketStatusEntity;
	}
	
}
