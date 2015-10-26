/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.TicketAllocationCode;
import net.atos.transport.entity.jpa.TicketAllocationCodeEntity;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.TicketAllocationCodeServiceMapper;
import net.atos.transport.data.repository.jpa.TicketAllocationCodeJpaRepository;
import net.atos.transport.test.TicketAllocationCodeFactoryForTest;
import net.atos.transport.test.TicketAllocationCodeEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of TicketAllocationCodeService
 */
@RunWith(MockitoJUnitRunner.class)
public class TicketAllocationCodeServiceImplTest
{

    @InjectMocks
    private TicketAllocationCodeServiceImpl ticketAllocationCodeService;

    @Mock
    private TicketAllocationCodeJpaRepository ticketAllocationCodeJpaRepository;

    @Mock
    private TicketAllocationCodeServiceMapper ticketAllocationCodeServiceMapper;

    private TicketAllocationCodeFactoryForTest ticketAllocationCodeFactoryForTest = new TicketAllocationCodeFactoryForTest();

    private TicketAllocationCodeEntityFactoryForTest ticketAllocationCodeEntityFactoryForTest = new TicketAllocationCodeEntityFactoryForTest();

    private MockValues mockValues = new MockValues();

    @Test
    public void findById()
    {
        // Given
        Integer tacId = mockValues.nextInteger();

        TicketAllocationCodeEntity ticketAllocationCodeEntity = ticketAllocationCodeJpaRepository.findOne(tacId);

        TicketAllocationCode ticketAllocationCode = ticketAllocationCodeFactoryForTest.newTicketAllocationCode();
        when(
                ticketAllocationCodeServiceMapper
                        .mapTicketAllocationCodeEntityToTicketAllocationCode(ticketAllocationCodeEntity)).thenReturn(
                ticketAllocationCode);

        // When
        TicketAllocationCode ticketAllocationCodeFound = ticketAllocationCodeService.findById(tacId);

        // Then
        assertEquals(ticketAllocationCode.getTacId(), ticketAllocationCodeFound.getTacId());
    }

    @Test
    public void findAll()
    {
        // Given
        List<TicketAllocationCodeEntity> ticketAllocationCodeEntitys = new ArrayList<TicketAllocationCodeEntity>();
        TicketAllocationCodeEntity ticketAllocationCodeEntity1 = ticketAllocationCodeEntityFactoryForTest
                .newTicketAllocationCodeEntity();
        ticketAllocationCodeEntitys.add(ticketAllocationCodeEntity1);
        TicketAllocationCodeEntity ticketAllocationCodeEntity2 = ticketAllocationCodeEntityFactoryForTest
                .newTicketAllocationCodeEntity();
        ticketAllocationCodeEntitys.add(ticketAllocationCodeEntity2);
        when(ticketAllocationCodeJpaRepository.findAll()).thenReturn(ticketAllocationCodeEntitys);

        TicketAllocationCode ticketAllocationCode1 = ticketAllocationCodeFactoryForTest.newTicketAllocationCode();
        when(
                ticketAllocationCodeServiceMapper
                        .mapTicketAllocationCodeEntityToTicketAllocationCode(ticketAllocationCodeEntity1)).thenReturn(
                ticketAllocationCode1);
        TicketAllocationCode ticketAllocationCode2 = ticketAllocationCodeFactoryForTest.newTicketAllocationCode();
        when(
                ticketAllocationCodeServiceMapper
                        .mapTicketAllocationCodeEntityToTicketAllocationCode(ticketAllocationCodeEntity2)).thenReturn(
                ticketAllocationCode2);

        // When
        List<TicketAllocationCode> ticketAllocationCodesFounds = ticketAllocationCodeService.findAll();

        // Then
        assertTrue(ticketAllocationCode1 == ticketAllocationCodesFounds.get(0));
        assertTrue(ticketAllocationCode2 == ticketAllocationCodesFounds.get(1));
    }

    @Test
    public void create()
    {
        // Given
        TicketAllocationCode ticketAllocationCode = ticketAllocationCodeFactoryForTest.newTicketAllocationCode();

        TicketAllocationCodeEntity ticketAllocationCodeEntity = ticketAllocationCodeEntityFactoryForTest
                .newTicketAllocationCodeEntity();
        when(ticketAllocationCodeJpaRepository.findOne(ticketAllocationCode.getTacId())).thenReturn(null);

        ticketAllocationCodeEntity = new TicketAllocationCodeEntity();
        ticketAllocationCodeServiceMapper.mapTicketAllocationCodeToTicketAllocationCodeEntity(ticketAllocationCode,
                ticketAllocationCodeEntity);
        TicketAllocationCodeEntity ticketAllocationCodeEntitySaved = ticketAllocationCodeJpaRepository
                .save(ticketAllocationCodeEntity);

        TicketAllocationCode ticketAllocationCodeSaved = ticketAllocationCodeFactoryForTest.newTicketAllocationCode();
        when(
                ticketAllocationCodeServiceMapper
                        .mapTicketAllocationCodeEntityToTicketAllocationCode(ticketAllocationCodeEntitySaved))
                .thenReturn(ticketAllocationCodeSaved);

        // When
        TicketAllocationCode ticketAllocationCodeResult = ticketAllocationCodeService.create(ticketAllocationCode);

        // Then
        assertTrue(ticketAllocationCodeResult == ticketAllocationCodeSaved);
    }

    @Test
    public void createKOExists()
    {
        // Given
        TicketAllocationCode ticketAllocationCode = ticketAllocationCodeFactoryForTest.newTicketAllocationCode();

        TicketAllocationCodeEntity ticketAllocationCodeEntity = ticketAllocationCodeEntityFactoryForTest
                .newTicketAllocationCodeEntity();
        when(ticketAllocationCodeJpaRepository.findOne(ticketAllocationCode.getTacId())).thenReturn(
                ticketAllocationCodeEntity);

        // When
        Exception exception = null;
        try
        {
            ticketAllocationCodeService.create(ticketAllocationCode);
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
        TicketAllocationCode ticketAllocationCode = ticketAllocationCodeFactoryForTest.newTicketAllocationCode();

        TicketAllocationCodeEntity ticketAllocationCodeEntity = ticketAllocationCodeEntityFactoryForTest
                .newTicketAllocationCodeEntity();
        when(ticketAllocationCodeJpaRepository.findOne(ticketAllocationCode.getTacId())).thenReturn(
                ticketAllocationCodeEntity);

        TicketAllocationCodeEntity ticketAllocationCodeEntitySaved = ticketAllocationCodeEntityFactoryForTest
                .newTicketAllocationCodeEntity();
        when(ticketAllocationCodeJpaRepository.save(ticketAllocationCodeEntity)).thenReturn(
                ticketAllocationCodeEntitySaved);

        TicketAllocationCode ticketAllocationCodeSaved = ticketAllocationCodeFactoryForTest.newTicketAllocationCode();
        when(
                ticketAllocationCodeServiceMapper
                        .mapTicketAllocationCodeEntityToTicketAllocationCode(ticketAllocationCodeEntitySaved))
                .thenReturn(ticketAllocationCodeSaved);

        // When
        TicketAllocationCode ticketAllocationCodeResult = ticketAllocationCodeService.update(ticketAllocationCode);

        // Then
        verify(ticketAllocationCodeServiceMapper).mapTicketAllocationCodeToTicketAllocationCodeEntity(
                ticketAllocationCode, ticketAllocationCodeEntity);
        assertTrue(ticketAllocationCodeResult == ticketAllocationCodeSaved);
    }

    @Test
    public void delete()
    {
        // Given
        Integer tacId = mockValues.nextInteger();

        // When
        ticketAllocationCodeService.delete(tacId);

        // Then
        verify(ticketAllocationCodeJpaRepository).delete(tacId);

    }

}
