/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.TicketStatusLink;
import net.atos.transport.entity.jpa.TicketStatusLinkEntity;
import java.util.Date;
import net.atos.transport.business.service.mapping.TicketStatusLinkServiceMapper;
import net.atos.transport.data.repository.jpa.TicketStatusLinkJpaRepository;
import net.atos.transport.test.TicketStatusLinkFactoryForTest;
import net.atos.transport.test.TicketStatusLinkEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of TicketStatusLinkService
 */
@RunWith(MockitoJUnitRunner.class)
public class TicketStatusLinkServiceImplTest
{

    @InjectMocks
    private TicketStatusLinkServiceImpl ticketStatusLinkService;

    @Mock
    private TicketStatusLinkJpaRepository ticketStatusLinkJpaRepository;

    @Mock
    private TicketStatusLinkServiceMapper ticketStatusLinkServiceMapper;

    private TicketStatusLinkFactoryForTest ticketStatusLinkFactoryForTest = new TicketStatusLinkFactoryForTest();

    private TicketStatusLinkEntityFactoryForTest ticketStatusLinkEntityFactoryForTest = new TicketStatusLinkEntityFactoryForTest();

    private MockValues mockValues = new MockValues();

    @Test
    public void findById()
    {
        // Given
        Integer tslId = mockValues.nextInteger();

        TicketStatusLinkEntity ticketStatusLinkEntity = ticketStatusLinkJpaRepository.findOne(tslId);

        TicketStatusLink ticketStatusLink = ticketStatusLinkFactoryForTest.newTicketStatusLink();
        when(ticketStatusLinkServiceMapper.mapTicketStatusLinkEntityToTicketStatusLink(ticketStatusLinkEntity))
                .thenReturn(ticketStatusLink);

        // When
        TicketStatusLink ticketStatusLinkFound = ticketStatusLinkService.findById(tslId);

        // Then
        assertEquals(ticketStatusLink.getTslId(), ticketStatusLinkFound.getTslId());
    }

    @Test
    public void findAll()
    {
        // Given
        List<TicketStatusLinkEntity> ticketStatusLinkEntitys = new ArrayList<TicketStatusLinkEntity>();
        TicketStatusLinkEntity ticketStatusLinkEntity1 = ticketStatusLinkEntityFactoryForTest
                .newTicketStatusLinkEntity();
        ticketStatusLinkEntitys.add(ticketStatusLinkEntity1);
        TicketStatusLinkEntity ticketStatusLinkEntity2 = ticketStatusLinkEntityFactoryForTest
                .newTicketStatusLinkEntity();
        ticketStatusLinkEntitys.add(ticketStatusLinkEntity2);
        when(ticketStatusLinkJpaRepository.findAll()).thenReturn(ticketStatusLinkEntitys);

        TicketStatusLink ticketStatusLink1 = ticketStatusLinkFactoryForTest.newTicketStatusLink();
        when(ticketStatusLinkServiceMapper.mapTicketStatusLinkEntityToTicketStatusLink(ticketStatusLinkEntity1))
                .thenReturn(ticketStatusLink1);
        TicketStatusLink ticketStatusLink2 = ticketStatusLinkFactoryForTest.newTicketStatusLink();
        when(ticketStatusLinkServiceMapper.mapTicketStatusLinkEntityToTicketStatusLink(ticketStatusLinkEntity2))
                .thenReturn(ticketStatusLink2);

        // When
        List<TicketStatusLink> ticketStatusLinksFounds = ticketStatusLinkService.findAll();

        // Then
        assertTrue(ticketStatusLink1 == ticketStatusLinksFounds.get(0));
        assertTrue(ticketStatusLink2 == ticketStatusLinksFounds.get(1));
    }

    @Test
    public void create()
    {
        // Given
        TicketStatusLink ticketStatusLink = ticketStatusLinkFactoryForTest.newTicketStatusLink();

        TicketStatusLinkEntity ticketStatusLinkEntity = ticketStatusLinkEntityFactoryForTest
                .newTicketStatusLinkEntity();
        when(ticketStatusLinkJpaRepository.findOne(ticketStatusLink.getTslId())).thenReturn(null);

        ticketStatusLinkEntity = new TicketStatusLinkEntity();
        ticketStatusLinkServiceMapper.mapTicketStatusLinkToTicketStatusLinkEntity(ticketStatusLink,
                ticketStatusLinkEntity);
        TicketStatusLinkEntity ticketStatusLinkEntitySaved = ticketStatusLinkJpaRepository.save(ticketStatusLinkEntity);

        TicketStatusLink ticketStatusLinkSaved = ticketStatusLinkFactoryForTest.newTicketStatusLink();
        when(ticketStatusLinkServiceMapper.mapTicketStatusLinkEntityToTicketStatusLink(ticketStatusLinkEntitySaved))
                .thenReturn(ticketStatusLinkSaved);

        // When
        TicketStatusLink ticketStatusLinkResult = ticketStatusLinkService.create(ticketStatusLink);

        // Then
        assertTrue(ticketStatusLinkResult == ticketStatusLinkSaved);
    }

    @Test
    public void createKOExists()
    {
        // Given
        TicketStatusLink ticketStatusLink = ticketStatusLinkFactoryForTest.newTicketStatusLink();

        TicketStatusLinkEntity ticketStatusLinkEntity = ticketStatusLinkEntityFactoryForTest
                .newTicketStatusLinkEntity();
        when(ticketStatusLinkJpaRepository.findOne(ticketStatusLink.getTslId())).thenReturn(ticketStatusLinkEntity);

        // When
        Exception exception = null;
        try
        {
            ticketStatusLinkService.create(ticketStatusLink);
        }
        catch (Exception e)
        {
            exception = e;
        }

        // Then
        assertTrue(exception instanceof IllegalStateException);
        assertEquals("already.exists", exception.getMessage());
    }

    @Test
    public void update()
    {
        // Given
        TicketStatusLink ticketStatusLink = ticketStatusLinkFactoryForTest.newTicketStatusLink();

        TicketStatusLinkEntity ticketStatusLinkEntity = ticketStatusLinkEntityFactoryForTest
                .newTicketStatusLinkEntity();
        when(ticketStatusLinkJpaRepository.findOne(ticketStatusLink.getTslId())).thenReturn(ticketStatusLinkEntity);

        TicketStatusLinkEntity ticketStatusLinkEntitySaved = ticketStatusLinkEntityFactoryForTest
                .newTicketStatusLinkEntity();
        when(ticketStatusLinkJpaRepository.save(ticketStatusLinkEntity)).thenReturn(ticketStatusLinkEntitySaved);

        TicketStatusLink ticketStatusLinkSaved = ticketStatusLinkFactoryForTest.newTicketStatusLink();
        when(ticketStatusLinkServiceMapper.mapTicketStatusLinkEntityToTicketStatusLink(ticketStatusLinkEntitySaved))
                .thenReturn(ticketStatusLinkSaved);

        // When
        TicketStatusLink ticketStatusLinkResult = ticketStatusLinkService.update(ticketStatusLink);

        // Then
        verify(ticketStatusLinkServiceMapper).mapTicketStatusLinkToTicketStatusLinkEntity(ticketStatusLink,
                ticketStatusLinkEntity);
        assertTrue(ticketStatusLinkResult == ticketStatusLinkSaved);
    }

    @Test
    public void delete()
    {
        // Given
        Integer tslId = mockValues.nextInteger();

        // When
        ticketStatusLinkService.delete(tslId);

        // Then
        verify(ticketStatusLinkJpaRepository).delete(tslId);

    }

}
