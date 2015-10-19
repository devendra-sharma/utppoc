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
import net.atos.transport.entity.Calendar;
import net.atos.transport.entity.jpa.CalendarEntity;
import net.atos.transport.entity.jpa.WeekEntity;
import net.atos.transport.entity.jpa.YearEntity;
import net.atos.transport.entity.jpa.PeriodEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class CalendarServiceMapperTest {

	private CalendarServiceMapper calendarServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		calendarServiceMapper = new CalendarServiceMapper();
		calendarServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'CalendarEntity' to 'Calendar'
	 * @param calendarEntity
	 */
	@Test
	public void testMapCalendarEntityToCalendar() {
		// Given
		CalendarEntity calendarEntity = new CalendarEntity();
		calendarEntity.setCalendarDate(mockValues.nextDate());
		calendarEntity.setDayOfWeek(mockValues.nextString(32));
		calendarEntity.setWeek2(new WeekEntity());
		calendarEntity.getWeek2().setWeekId(mockValues.nextInteger());
		calendarEntity.setYear2(new YearEntity());
		calendarEntity.getYear2().setYear(mockValues.nextInteger());
		calendarEntity.setPeriod2(new PeriodEntity());
		calendarEntity.getPeriod2().setPerId(mockValues.nextInteger());
		
		// When
		Calendar calendar = calendarServiceMapper.mapCalendarEntityToCalendar(calendarEntity);
		
		// Then
		assertEquals(calendarEntity.getCalendarDate(), calendar.getCalendarDate());
		assertEquals(calendarEntity.getDayOfWeek(), calendar.getDayOfWeek());
		assertEquals(calendarEntity.getWeek2().getWeekId(), calendar.getWeek());
		assertEquals(calendarEntity.getYear2().getYear(), calendar.getYear());
		assertEquals(calendarEntity.getPeriod2().getPerId(), calendar.getPeriod());
	}
	
	/**
	 * Test : Mapping from 'Calendar' to 'CalendarEntity'
	 */
	@Test
	public void testMapCalendarToCalendarEntity() {
		// Given
		Calendar calendar = new Calendar();
		calendar.setCalendarDate(mockValues.nextDate());
		calendar.setDayOfWeek(mockValues.nextString(32));
		calendar.setWeek(mockValues.nextInteger());
		calendar.setYear(mockValues.nextInteger());
		calendar.setPeriod(mockValues.nextInteger());

		CalendarEntity calendarEntity = new CalendarEntity();
		
		// When
		calendarServiceMapper.mapCalendarToCalendarEntity(calendar, calendarEntity);
		
		// Then
		assertEquals(calendar.getCalendarDate(), calendarEntity.getCalendarDate());
		assertEquals(calendar.getDayOfWeek(), calendarEntity.getDayOfWeek());
		assertEquals(calendar.getWeek(), calendarEntity.getWeek2().getWeekId());
		assertEquals(calendar.getYear(), calendarEntity.getYear2().getYear());
		assertEquals(calendar.getPeriod(), calendarEntity.getPeriod2().getPerId());
	}

}