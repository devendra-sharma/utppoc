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
import net.atos.transport.entity.TicketStatusLink;
import net.atos.transport.entity.jpa.TicketStatusLinkEntity;
import net.atos.transport.entity.jpa.TicketStatusEntity;
import net.atos.transport.entity.jpa.TicketStatusEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class TicketStatusLinkServiceMapperTest
{

    private TicketStatusLinkServiceMapper ticketStatusLinkServiceMapper;

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
        ticketStatusLinkServiceMapper = new TicketStatusLinkServiceMapper();
        ticketStatusLinkServiceMapper.setModelMapper(modelMapper);
    }

    /**
     * Mapping from 'TicketStatusLinkEntity' to 'TicketStatusLink'
     * 
     * @param ticketStatusLinkEntity
     */
    @Test
    public void testMapTicketStatusLinkEntityToTicketStatusLink()
    {
        // Given
        TicketStatusLinkEntity ticketStatusLinkEntity = new TicketStatusLinkEntity();
        ticketStatusLinkEntity.setExpired(mockValues.nextString(1));
        ticketStatusLinkEntity.setEffectiveFrom(mockValues.nextDate());
        ticketStatusLinkEntity.setEffectiveTo(mockValues.nextDate());
        ticketStatusLinkEntity.setTicketStatus2(new TicketStatusEntity());
        ticketStatusLinkEntity.getTicketStatus2().setTisId(mockValues.nextInteger());
        ticketStatusLinkEntity.setTicketStatus(new TicketStatusEntity());
        ticketStatusLinkEntity.getTicketStatus().setTisId(mockValues.nextInteger());

        // When
        TicketStatusLink ticketStatusLink = ticketStatusLinkServiceMapper
                .mapTicketStatusLinkEntityToTicketStatusLink(ticketStatusLinkEntity);

        // Then
        assertEquals(ticketStatusLinkEntity.getExpired(), ticketStatusLink.getExpired());
        assertEquals(ticketStatusLinkEntity.getEffectiveFrom(), ticketStatusLink.getEffectiveFrom());
        assertEquals(ticketStatusLinkEntity.getEffectiveTo(), ticketStatusLink.getEffectiveTo());
        assertEquals(ticketStatusLinkEntity.getTicketStatus2().getTisId(), ticketStatusLink.getTisIdLinkedBy());
        assertEquals(ticketStatusLinkEntity.getTicketStatus().getTisId(), ticketStatusLink.getTisIdLinks());
    }

    /**
     * Test : Mapping from 'TicketStatusLink' to 'TicketStatusLinkEntity'
     */
    @Test
    public void testMapTicketStatusLinkToTicketStatusLinkEntity()
    {
        // Given
        TicketStatusLink ticketStatusLink = new TicketStatusLink();
        ticketStatusLink.setExpired(mockValues.nextString(1));
        ticketStatusLink.setEffectiveFrom(mockValues.nextDate());
        ticketStatusLink.setEffectiveTo(mockValues.nextDate());
        ticketStatusLink.setTisIdLinkedBy(mockValues.nextInteger());
        ticketStatusLink.setTisIdLinks(mockValues.nextInteger());

        TicketStatusLinkEntity ticketStatusLinkEntity = new TicketStatusLinkEntity();

        // When
        ticketStatusLinkServiceMapper.mapTicketStatusLinkToTicketStatusLinkEntity(ticketStatusLink,
                ticketStatusLinkEntity);

        // Then
        assertEquals(ticketStatusLink.getExpired(), ticketStatusLinkEntity.getExpired());
        assertEquals(ticketStatusLink.getEffectiveFrom(), ticketStatusLinkEntity.getEffectiveFrom());
        assertEquals(ticketStatusLink.getEffectiveTo(), ticketStatusLinkEntity.getEffectiveTo());
        assertEquals(ticketStatusLink.getTisIdLinkedBy(), ticketStatusLinkEntity.getTicketStatus2().getTisId());
        assertEquals(ticketStatusLink.getTisIdLinks(), ticketStatusLinkEntity.getTicketStatus().getTisId());
    }

}
