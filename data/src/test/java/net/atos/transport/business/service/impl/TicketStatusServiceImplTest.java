/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.TicketStatus;
import net.atos.transport.entity.jpa.TicketStatusEntity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.TicketStatusServiceMapper;
import net.atos.transport.data.repository.jpa.TicketStatusJpaRepository;
import net.atos.transport.test.TicketStatusFactoryForTest;
import net.atos.transport.test.TicketStatusEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of TicketStatusService
 */
@RunWith(MockitoJUnitRunner.class)
public class TicketStatusServiceImplTest
{

    @InjectMocks
    private TicketStatusServiceImpl ticketStatusService;

    @Mock
    private TicketStatusJpaRepository ticketStatusJpaRepository;

    @Mock
    private TicketStatusServiceMapper ticketStatusServiceMapper;

    private TicketStatusFactoryForTest ticketStatusFactoryForTest = new TicketStatusFactoryForTest();

    private TicketStatusEntityFactoryForTest ticketStatusEntityFactoryForTest = new TicketStatusEntityFactoryForTest();

    private MockValues mockValues = new MockValues();

    @Test
    public void findById()
    {
        // Given
        Integer tisId = mockValues.nextInteger();

        TicketStatusEntity ticketStatusEntity = ticketStatusJpaRepository.findOne(tisId);

        TicketStatus ticketStatus = ticketStatusFactoryForTest.newTicketStatus();
        when(ticketStatusServiceMapper.mapTicketStatusEntityToTicketStatus(ticketStatusEntity))
                .thenReturn(ticketStatus);

        // When
        TicketStatus ticketStatusFound = ticketStatusService.findById(tisId);

        // Then
        assertEquals(ticketStatus.getTisId(), ticketStatusFound.getTisId());
    }

    @Test
    public void findAll()
    {
        // Given
        List<TicketStatusEntity> ticketStatusEntitys = new ArrayList<TicketStatusEntity>();
        TicketStatusEntity ticketStatusEntity1 = ticketStatusEntityFactoryForTest.newTicketStatusEntity();
        ticketStatusEntitys.add(ticketStatusEntity1);
        TicketStatusEntity ticketStatusEntity2 = ticketStatusEntityFactoryForTest.newTicketStatusEntity();
        ticketStatusEntitys.add(ticketStatusEntity2);
        when(ticketStatusJpaRepository.findAll()).thenReturn(ticketStatusEntitys);

        TicketStatus ticketStatus1 = ticketStatusFactoryForTest.newTicketStatus();
        when(ticketStatusServiceMapper.mapTicketStatusEntityToTicketStatus(ticketStatusEntity1)).thenReturn(
                ticketStatus1);
        TicketStatus ticketStatus2 = ticketStatusFactoryForTest.newTicketStatus();
        when(ticketStatusServiceMapper.mapTicketStatusEntityToTicketStatus(ticketStatusEntity2)).thenReturn(
                ticketStatus2);

        // When
        List<TicketStatus> ticketStatussFounds = ticketStatusService.findAll();

        // Then
        assertTrue(ticketStatus1 == ticketStatussFounds.get(0));
        assertTrue(ticketStatus2 == ticketStatussFounds.get(1));
    }

    @Test
    public void create()
    {
        // Given
        TicketStatus ticketStatus = ticketStatusFactoryForTest.newTicketStatus();

        TicketStatusEntity ticketStatusEntity = ticketStatusEntityFactoryForTest.newTicketStatusEntity();
        when(ticketStatusJpaRepository.findOne(ticketStatus.getTisId())).thenReturn(null);

        ticketStatusEntity = new TicketStatusEntity();
        ticketStatusServiceMapper.mapTicketStatusToTicketStatusEntity(ticketStatus, ticketStatusEntity);
        TicketStatusEntity ticketStatusEntitySaved = ticketStatusJpaRepository.save(ticketStatusEntity);

        TicketStatus ticketStatusSaved = ticketStatusFactoryForTest.newTicketStatus();
        when(ticketStatusServiceMapper.mapTicketStatusEntityToTicketStatus(ticketStatusEntitySaved)).thenReturn(
                ticketStatusSaved);

        // When
        TicketStatus ticketStatusResult = ticketStatusService.create(ticketStatus);

        // Then
        assertTrue(ticketStatusResult == ticketStatusSaved);
    }

    @Test
    public void createKOExists()
    {
        // Given
        TicketStatus ticketStatus = ticketStatusFactoryForTest.newTicketStatus();

        TicketStatusEntity ticketStatusEntity = ticketStatusEntityFactoryForTest.newTicketStatusEntity();
        when(ticketStatusJpaRepository.findOne(ticketStatus.getTisId())).thenReturn(ticketStatusEntity);

        // When
        Exception exception = null;
        try
        {
            ticketStatusService.create(ticketStatus);
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
        TicketStatus ticketStatus = ticketStatusFactoryForTest.newTicketStatus();

        TicketStatusEntity ticketStatusEntity = ticketStatusEntityFactoryForTest.newTicketStatusEntity();
        when(ticketStatusJpaRepository.findOne(ticketStatus.getTisId())).thenReturn(ticketStatusEntity);

        TicketStatusEntity ticketStatusEntitySaved = ticketStatusEntityFactoryForTest.newTicketStatusEntity();
        when(ticketStatusJpaRepository.save(ticketStatusEntity)).thenReturn(ticketStatusEntitySaved);

        TicketStatus ticketStatusSaved = ticketStatusFactoryForTest.newTicketStatus();
        when(ticketStatusServiceMapper.mapTicketStatusEntityToTicketStatus(ticketStatusEntitySaved)).thenReturn(
                ticketStatusSaved);

        // When
        TicketStatus ticketStatusResult = ticketStatusService.update(ticketStatus);

        // Then
        verify(ticketStatusServiceMapper).mapTicketStatusToTicketStatusEntity(ticketStatus, ticketStatusEntity);
        assertTrue(ticketStatusResult == ticketStatusSaved);
    }

    @Test
    public void delete()
    {
        // Given
        Integer tisId = mockValues.nextInteger();

        // When
        ticketStatusService.delete(tisId);

        // Then
        verify(ticketStatusJpaRepository).delete(tisId);

    }

}
