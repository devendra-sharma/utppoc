package net.atos.transport.test;

import net.atos.transport.entity.jpa.CalendarEntity;

public class CalendarEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public CalendarEntity newCalendarEntity() {

		Integer calId = mockValues.nextInteger();

		CalendarEntity calendarEntity = new CalendarEntity();
		calendarEntity.setCalId(calId);
		return calendarEntity;
	}
	
}
