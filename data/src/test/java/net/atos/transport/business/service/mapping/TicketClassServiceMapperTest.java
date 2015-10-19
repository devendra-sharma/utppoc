/*


 */
package net.atos.transport.business.service.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.TicketClass;
import net.atos.transport.entity.jpa.TicketClassEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class TicketClassServiceMapperTest {

	private TicketClassServiceMapper ticketClassServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		ticketClassServiceMapper = new TicketClassServiceMapper();
		ticketClassServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'TicketClassEntity' to 'TicketClass'
	 * @param ticketClassEntity
	 */
	@Test
	public void testMapTicketClassEntityToTicketClass() {
		// Given
		TicketClassEntity ticketClassEntity = new TicketClassEntity();
		ticketClassEntity.setTicketClassDescription(mockValues.nextString(32));
		ticketClassEntity.setEffectiveFrom(mockValues.nextDate());
		ticketClassEntity.setEffectiveTo(mockValues.nextDate());
		ticketClassEntity.setExpired(mockValues.nextString(1));
		
		// When
		TicketClass ticketClass = ticketClassServiceMapper.mapTicketClassEntityToTicketClass(ticketClassEntity);
		
		// Then
		assertEquals(ticketClassEntity.getTicketClassDescription(), ticketClass.getTicketClassDescription());
		assertEquals(ticketClassEntity.getEffectiveFrom(), ticketClass.getEffectiveFrom());
		assertEquals(ticketClassEntity.getEffectiveTo(), ticketClass.getEffectiveTo());
		assertEquals(ticketClassEntity.getExpired(), ticketClass.getExpired());
	}
	
	/**
	 * Test : Mapping from 'TicketClass' to 'TicketClassEntity'
	 */
	@Test
	public void testMapTicketClassToTicketClassEntity() {
		// Given
		TicketClass ticketClass = new TicketClass();
		ticketClass.setTicketClassDescription(mockValues.nextString(32));
		ticketClass.setEffectiveFrom(mockValues.nextDate());
		ticketClass.setEffectiveTo(mockValues.nextDate());
		ticketClass.setExpired(mockValues.nextString(1));

		TicketClassEntity ticketClassEntity = new TicketClassEntity();
		
		// When
		ticketClassServiceMapper.mapTicketClassToTicketClassEntity(ticketClass, ticketClassEntity);
		
		// Then
		assertEquals(ticketClass.getTicketClassDescription(), ticketClassEntity.getTicketClassDescription());
		assertEquals(ticketClass.getEffectiveFrom(), ticketClassEntity.getEffectiveFrom());
		assertEquals(ticketClass.getEffectiveTo(), ticketClassEntity.getEffectiveTo());
		assertEquals(ticketClass.getExpired(), ticketClassEntity.getExpired());
	}

}