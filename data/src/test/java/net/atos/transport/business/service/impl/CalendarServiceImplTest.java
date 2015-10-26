/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.Calendar;
import net.atos.transport.entity.jpa.CalendarEntity;
import java.util.Date;
import net.atos.transport.business.service.mapping.CalendarServiceMapper;
import net.atos.transport.data.repository.jpa.CalendarJpaRepository;
import net.atos.transport.test.CalendarFactoryForTest;
import net.atos.transport.test.CalendarEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of CalendarService
 */
@RunWith(MockitoJUnitRunner.class)
public class CalendarServiceImplTest
{

    @InjectMocks
    private CalendarServiceImpl calendarService;

    @Mock
    private CalendarJpaRepository calendarJpaRepository;

    @Mock
    private CalendarServiceMapper calendarServiceMapper;

    private CalendarFactoryForTest calendarFactoryForTest = new CalendarFactoryForTest();

    private CalendarEntityFactoryForTest calendarEntityFactoryForTest = new CalendarEntityFactoryForTest();

    private MockValues mockValues = new MockValues();

    @Test
    public void findById()
    {
        // Given
        Integer calId = mockValues.nextInteger();

        CalendarEntity calendarEntity = calendarJpaRepository.findOne(calId);

        Calendar calendar = calendarFactoryForTest.newCalendar();
        when(calendarServiceMapper.mapCalendarEntityToCalendar(calendarEntity)).thenReturn(calendar);

        // When
        Calendar calendarFound = calendarService.findById(calId);

        // Then
        assertEquals(calendar.getCalId(), calendarFound.getCalId());
    }

    @Test
    public void findAll()
    {
        // Given
        List<CalendarEntity> calendarEntitys = new ArrayList<CalendarEntity>();
        CalendarEntity calendarEntity1 = calendarEntityFactoryForTest.newCalendarEntity();
        calendarEntitys.add(calendarEntity1);
        CalendarEntity calendarEntity2 = calendarEntityFactoryForTest.newCalendarEntity();
        calendarEntitys.add(calendarEntity2);
        when(calendarJpaRepository.findAll()).thenReturn(calendarEntitys);

        Calendar calendar1 = calendarFactoryForTest.newCalendar();
        when(calendarServiceMapper.mapCalendarEntityToCalendar(calendarEntity1)).thenReturn(calendar1);
        Calendar calendar2 = calendarFactoryForTest.newCalendar();
        when(calendarServiceMapper.mapCalendarEntityToCalendar(calendarEntity2)).thenReturn(calendar2);

        // When
        List<Calendar> calendarsFounds = calendarService.findAll();

        // Then
        assertTrue(calendar1 == calendarsFounds.get(0));
        assertTrue(calendar2 == calendarsFounds.get(1));
    }

    @Test
    public void create()
    {
        // Given
        Calendar calendar = calendarFactoryForTest.newCalendar();

        CalendarEntity calendarEntity = calendarEntityFactoryForTest.newCalendarEntity();
        when(calendarJpaRepository.findOne(calendar.getCalId())).thenReturn(null);

        calendarEntity = new CalendarEntity();
        calendarServiceMapper.mapCalendarToCalendarEntity(calendar, calendarEntity);
        CalendarEntity calendarEntitySaved = calendarJpaRepository.save(calendarEntity);

        Calendar calendarSaved = calendarFactoryForTest.newCalendar();
        when(calendarServiceMapper.mapCalendarEntityToCalendar(calendarEntitySaved)).thenReturn(calendarSaved);

        // When
        Calendar calendarResult = calendarService.create(calendar);

        // Then
        assertTrue(calendarResult == calendarSaved);
    }

    @Test
    public void createKOExists()
    {
        // Given
        Calendar calendar = calendarFactoryForTest.newCalendar();

        CalendarEntity calendarEntity = calendarEntityFactoryForTest.newCalendarEntity();
        when(calendarJpaRepository.findOne(calendar.getCalId())).thenReturn(calendarEntity);

        // When
        Exception exception = null;
        try
        {
            calendarService.create(calendar);
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
        Calendar calendar = calendarFactoryForTest.newCalendar();

        CalendarEntity calendarEntity = calendarEntityFactoryForTest.newCalendarEntity();
        when(calendarJpaRepository.findOne(calendar.getCalId())).thenReturn(calendarEntity);

        CalendarEntity calendarEntitySaved = calendarEntityFactoryForTest.newCalendarEntity();
        when(calendarJpaRepository.save(calendarEntity)).thenReturn(calendarEntitySaved);

        Calendar calendarSaved = calendarFactoryForTest.newCalendar();
        when(calendarServiceMapper.mapCalendarEntityToCalendar(calendarEntitySaved)).thenReturn(calendarSaved);

        // When
        Calendar calendarResult = calendarService.update(calendar);

        // Then
        verify(calendarServiceMapper).mapCalendarToCalendarEntity(calendar, calendarEntity);
        assertTrue(calendarResult == calendarSaved);
    }

    @Test
    public void delete()
    {
        // Given
        Integer calId = mockValues.nextInteger();

        // When
        calendarService.delete(calId);

        // Then
        verify(calendarJpaRepository).delete(calId);

    }

}
