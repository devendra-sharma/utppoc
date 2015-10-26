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
import net.atos.transport.entity.TicketAllocationCode;
import net.atos.transport.entity.jpa.TicketAllocationCodeEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class TicketAllocationCodeServiceMapperTest
{

    private TicketAllocationCodeServiceMapper ticketAllocationCodeServiceMapper;

    private static ModelMapper modelMapper = new ModelMapper();

    private MockValues mockValues = new MockValues();

    @BeforeClass
    public static void setUp()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Before
    public void before()
    {
        ticketAllocationCodeServiceMapper = new TicketAllocationCodeServiceMapper();
        ticketAllocationCodeServiceMapper.setModelMapper(modelMapper);
    }

    /**
     * Mapping from 'TicketAllocationCodeEntity' to 'TicketAllocationCode'
     * 
     * @param ticketAllocationCodeEntity
     */
    @Test
    public void testMapTicketAllocationCodeEntityToTicketAllocationCode()
    {
        // Given
        TicketAllocationCodeEntity ticketAllocationCodeEntity = new TicketAllocationCodeEntity();
        ticketAllocationCodeEntity.setTacCode(mockValues.nextString(1));
        ticketAllocationCodeEntity.setTacDescription(mockValues.nextString(32));
        ticketAllocationCodeEntity.setEffectiveFrom(mockValues.nextDate());
        ticketAllocationCodeEntity.setEffectiveTo(mockValues.nextDate());
        ticketAllocationCodeEntity.setExpired(mockValues.nextString(1));

        // When
        TicketAllocationCode ticketAllocationCode = ticketAllocationCodeServiceMapper
                .mapTicketAllocationCodeEntityToTicketAllocationCode(ticketAllocationCodeEntity);

        // Then
        assertEquals(ticketAllocationCodeEntity.getTacCode(), ticketAllocationCode.getTacCode());
        assertEquals(ticketAllocationCodeEntity.getTacDescription(), ticketAllocationCode.getTacDescription());
        assertEquals(ticketAllocationCodeEntity.getEffectiveFrom(), ticketAllocationCode.getEffectiveFrom());
        assertEquals(ticketAllocationCodeEntity.getEffectiveTo(), ticketAllocationCode.getEffectiveTo());
        assertEquals(ticketAllocationCodeEntity.getExpired(), ticketAllocationCode.getExpired());
    }

    /**
     * Test : Mapping from 'TicketAllocationCode' to 'TicketAllocationCodeEntity'
     */
    @Test
    public void testMapTicketAllocationCodeToTicketAllocationCodeEntity()
    {
        // Given
        TicketAllocationCode ticketAllocationCode = new TicketAllocationCode();
        ticketAllocationCode.setTacCode(mockValues.nextString(1));
        ticketAllocationCode.setTacDescription(mockValues.nextString(32));
        ticketAllocationCode.setEffectiveFrom(mockValues.nextDate());
        ticketAllocationCode.setEffectiveTo(mockValues.nextDate());
        ticketAllocationCode.setExpired(mockValues.nextString(1));

        TicketAllocationCodeEntity ticketAllocationCodeEntity = new TicketAllocationCodeEntity();

        // When
        ticketAllocationCodeServiceMapper.mapTicketAllocationCodeToTicketAllocationCodeEntity(ticketAllocationCode,
                ticketAllocationCodeEntity);

        // Then
        assertEquals(ticketAllocationCode.getTacCode(), ticketAllocationCodeEntity.getTacCode());
        assertEquals(ticketAllocationCode.getTacDescription(), ticketAllocationCodeEntity.getTacDescription());
        assertEquals(ticketAllocationCode.getEffectiveFrom(), ticketAllocationCodeEntity.getEffectiveFrom());
        assertEquals(ticketAllocationCode.getEffectiveTo(), ticketAllocationCodeEntity.getEffectiveTo());
        assertEquals(ticketAllocationCode.getExpired(), ticketAllocationCodeEntity.getExpired());
    }

}
