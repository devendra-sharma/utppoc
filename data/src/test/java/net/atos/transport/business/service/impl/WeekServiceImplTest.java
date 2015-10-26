/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.Week;
import net.atos.transport.entity.jpa.WeekEntity;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.WeekServiceMapper;
import net.atos.transport.data.repository.jpa.WeekJpaRepository;
import net.atos.transport.test.WeekFactoryForTest;
import net.atos.transport.test.WeekEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of WeekService
 */
@RunWith(MockitoJUnitRunner.class)
public class WeekServiceImplTest
{

    @InjectMocks
    private WeekServiceImpl weekService;

    @Mock
    private WeekJpaRepository weekJpaRepository;

    @Mock
    private WeekServiceMapper weekServiceMapper;

    private WeekFactoryForTest weekFactoryForTest = new WeekFactoryForTest();

    private WeekEntityFactoryForTest weekEntityFactoryForTest = new WeekEntityFactoryForTest();

    private MockValues mockValues = new MockValues();

    @Test
    public void findById()
    {
        // Given
        Integer weekId = mockValues.nextInteger();

        WeekEntity weekEntity = weekJpaRepository.findOne(weekId);

        Week week = weekFactoryForTest.newWeek();
        when(weekServiceMapper.mapWeekEntityToWeek(weekEntity)).thenReturn(week);

        // When
        Week weekFound = weekService.findById(weekId);

        // Then
        assertEquals(week.getWeekId(), weekFound.getWeekId());
    }

    @Test
    public void findAll()
    {
        // Given
        List<WeekEntity> weekEntitys = new ArrayList<WeekEntity>();
        WeekEntity weekEntity1 = weekEntityFactoryForTest.newWeekEntity();
        weekEntitys.add(weekEntity1);
        WeekEntity weekEntity2 = weekEntityFactoryForTest.newWeekEntity();
        weekEntitys.add(weekEntity2);
        when(weekJpaRepository.findAll()).thenReturn(weekEntitys);

        Week week1 = weekFactoryForTest.newWeek();
        when(weekServiceMapper.mapWeekEntityToWeek(weekEntity1)).thenReturn(week1);
        Week week2 = weekFactoryForTest.newWeek();
        when(weekServiceMapper.mapWeekEntityToWeek(weekEntity2)).thenReturn(week2);

        // When
        List<Week> weeksFounds = weekService.findAll();

        // Then
        assertTrue(week1 == weeksFounds.get(0));
        assertTrue(week2 == weeksFounds.get(1));
    }

    @Test
    public void create()
    {
        // Given
        Week week = weekFactoryForTest.newWeek();

        WeekEntity weekEntity = weekEntityFactoryForTest.newWeekEntity();
        when(weekJpaRepository.findOne(week.getWeekId())).thenReturn(null);

        weekEntity = new WeekEntity();
        weekServiceMapper.mapWeekToWeekEntity(week, weekEntity);
        WeekEntity weekEntitySaved = weekJpaRepository.save(weekEntity);

        Week weekSaved = weekFactoryForTest.newWeek();
        when(weekServiceMapper.mapWeekEntityToWeek(weekEntitySaved)).thenReturn(weekSaved);

        // When
        Week weekResult = weekService.create(week);

        // Then
        assertTrue(weekResult == weekSaved);
    }

    @Test
    public void createKOExists()
    {
        // Given
        Week week = weekFactoryForTest.newWeek();

        WeekEntity weekEntity = weekEntityFactoryForTest.newWeekEntity();
        when(weekJpaRepository.findOne(week.getWeekId())).thenReturn(weekEntity);

        // When
        Exception exception = null;
        try
        {
            weekService.create(week);
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
        Week week = weekFactoryForTest.newWeek();

        WeekEntity weekEntity = weekEntityFactoryForTest.newWeekEntity();
        when(weekJpaRepository.findOne(week.getWeekId())).thenReturn(weekEntity);

        WeekEntity weekEntitySaved = weekEntityFactoryForTest.newWeekEntity();
        when(weekJpaRepository.save(weekEntity)).thenReturn(weekEntitySaved);

        Week weekSaved = weekFactoryForTest.newWeek();
        when(weekServiceMapper.mapWeekEntityToWeek(weekEntitySaved)).thenReturn(weekSaved);

        // When
        Week weekResult = weekService.update(week);

        // Then
        verify(weekServiceMapper).mapWeekToWeekEntity(week, weekEntity);
        assertTrue(weekResult == weekSaved);
    }

    @Test
    public void delete()
    {
        // Given
        Integer weekId = mockValues.nextInteger();

        // When
        weekService.delete(weekId);

        // Then
        verify(weekJpaRepository).delete(weekId);

    }

}
