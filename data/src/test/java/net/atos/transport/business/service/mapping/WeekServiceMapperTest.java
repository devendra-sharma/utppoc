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
import net.atos.transport.entity.Week;
import net.atos.transport.entity.jpa.WeekEntity;
import net.atos.transport.entity.jpa.YearEntity;
import net.atos.transport.entity.jpa.PeriodEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class WeekServiceMapperTest
{

    private WeekServiceMapper weekServiceMapper;

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
        weekServiceMapper = new WeekServiceMapper();
        weekServiceMapper.setModelMapper(modelMapper);
    }

    /**
     * Mapping from 'WeekEntity' to 'Week'
     * 
     * @param weekEntity
     */
    @Test
    public void testMapWeekEntityToWeek()
    {
        // Given
        WeekEntity weekEntity = new WeekEntity();
        weekEntity.setWeek(mockValues.nextInteger());
        weekEntity.setStartDate(mockValues.nextDate());
        weekEntity.setEndDate(mockValues.nextDate());
        weekEntity.setWeekMask(mockValues.nextString(8));
        weekEntity.setYear2(new YearEntity());
        weekEntity.getYear2().setYear(mockValues.nextInteger());
        weekEntity.setPeriod2(new PeriodEntity());
        weekEntity.getPeriod2().setPerId(mockValues.nextInteger());

        // When
        Week week = weekServiceMapper.mapWeekEntityToWeek(weekEntity);

        // Then
        assertEquals(weekEntity.getWeek(), week.getWeek());
        assertEquals(weekEntity.getStartDate(), week.getStartDate());
        assertEquals(weekEntity.getEndDate(), week.getEndDate());
        assertEquals(weekEntity.getWeekMask(), week.getWeekMask());
        assertEquals(weekEntity.getYear2().getYear(), week.getYear());
        assertEquals(weekEntity.getPeriod2().getPerId(), week.getPeriod());
    }

    /**
     * Test : Mapping from 'Week' to 'WeekEntity'
     */
    @Test
    public void testMapWeekToWeekEntity()
    {
        // Given
        Week week = new Week();
        week.setWeek(mockValues.nextInteger());
        week.setStartDate(mockValues.nextDate());
        week.setEndDate(mockValues.nextDate());
        week.setWeekMask(mockValues.nextString(8));
        week.setYear(mockValues.nextInteger());
        week.setPeriod(mockValues.nextInteger());

        WeekEntity weekEntity = new WeekEntity();

        // When
        weekServiceMapper.mapWeekToWeekEntity(week, weekEntity);

        // Then
        assertEquals(week.getWeek(), weekEntity.getWeek());
        assertEquals(week.getStartDate(), weekEntity.getStartDate());
        assertEquals(week.getEndDate(), weekEntity.getEndDate());
        assertEquals(week.getWeekMask(), weekEntity.getWeekMask());
        assertEquals(week.getYear(), weekEntity.getYear2().getYear());
        assertEquals(week.getPeriod(), weekEntity.getPeriod2().getPerId());
    }

}
