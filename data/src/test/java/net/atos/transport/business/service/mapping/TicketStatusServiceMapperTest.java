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
import net.atos.transport.entity.TicketStatus;
import net.atos.transport.entity.jpa.TicketStatusEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class TicketStatusServiceMapperTest {

	private TicketStatusServiceMapper ticketStatusServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		ticketStatusServiceMapper = new TicketStatusServiceMapper();
		ticketStatusServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'TicketStatusEntity' to 'TicketStatus'
	 * @param ticketStatusEntity
	 */
	@Test
	public void testMapTicketStatusEntityToTicketStatus() {
		// Given
		TicketStatusEntity ticketStatusEntity = new TicketStatusEntity();
		ticketStatusEntity.setExpired(mockValues.nextString(1));
		ticketStatusEntity.setEffectiveFrom(mockValues.nextDate());
		ticketStatusEntity.setEffectiveTo(mockValues.nextDate());
		ticketStatusEntity.setTicketStatusCode(mockValues.nextString(3));
		ticketStatusEntity.setTicketStatusDescription(mockValues.nextString(32));
		ticketStatusEntity.setPercentDiscount(mockValues.nextBigDecimal());
		ticketStatusEntity.setRatRailcardTypeDesc(mockValues.nextString(32));
		ticketStatusEntity.setTicketStatusTypeDesc(mockValues.nextString(32));
		
		// When
		TicketStatus ticketStatus = ticketStatusServiceMapper.mapTicketStatusEntityToTicketStatus(ticketStatusEntity);
		
		// Then
		assertEquals(ticketStatusEntity.getExpired(), ticketStatus.getExpired());
		assertEquals(ticketStatusEntity.getEffectiveFrom(), ticketStatus.getEffectiveFrom());
		assertEquals(ticketStatusEntity.getEffectiveTo(), ticketStatus.getEffectiveTo());
		assertEquals(ticketStatusEntity.getTicketStatusCode(), ticketStatus.getTicketStatusCode());
		assertEquals(ticketStatusEntity.getTicketStatusDescription(), ticketStatus.getTicketStatusDescription());
		assertEquals(ticketStatusEntity.getPercentDiscount(), ticketStatus.getPercentDiscount());
		assertEquals(ticketStatusEntity.getRatRailcardTypeDesc(), ticketStatus.getRatRailcardTypeDesc());
		assertEquals(ticketStatusEntity.getTicketStatusTypeDesc(), ticketStatus.getTicketStatusTypeDesc());
	}
	
	/**
	 * Test : Mapping from 'TicketStatus' to 'TicketStatusEntity'
	 */
	@Test
	public void testMapTicketStatusToTicketStatusEntity() {
		// Given
		TicketStatus ticketStatus = new TicketStatus();
		ticketStatus.setExpired(mockValues.nextString(1));
		ticketStatus.setEffectiveFrom(mockValues.nextDate());
		ticketStatus.setEffectiveTo(mockValues.nextDate());
		ticketStatus.setTicketStatusCode(mockValues.nextString(3));
		ticketStatus.setTicketStatusDescription(mockValues.nextString(32));
		ticketStatus.setPercentDiscount(mockValues.nextBigDecimal());
		ticketStatus.setRatRailcardTypeDesc(mockValues.nextString(32));
		ticketStatus.setTicketStatusTypeDesc(mockValues.nextString(32));

		TicketStatusEntity ticketStatusEntity = new TicketStatusEntity();
		
		// When
		ticketStatusServiceMapper.mapTicketStatusToTicketStatusEntity(ticketStatus, ticketStatusEntity);
		
		// Then
		assertEquals(ticketStatus.getExpired(), ticketStatusEntity.getExpired());
		assertEquals(ticketStatus.getEffectiveFrom(), ticketStatusEntity.getEffectiveFrom());
		assertEquals(ticketStatus.getEffectiveTo(), ticketStatusEntity.getEffectiveTo());
		assertEquals(ticketStatus.getTicketStatusCode(), ticketStatusEntity.getTicketStatusCode());
		assertEquals(ticketStatus.getTicketStatusDescription(), ticketStatusEntity.getTicketStatusDescription());
		assertEquals(ticketStatus.getPercentDiscount(), ticketStatusEntity.getPercentDiscount());
		assertEquals(ticketStatus.getRatRailcardTypeDesc(), ticketStatusEntity.getRatRailcardTypeDesc());
		assertEquals(ticketStatus.getTicketStatusTypeDesc(), ticketStatusEntity.getTicketStatusTypeDesc());
	}

}