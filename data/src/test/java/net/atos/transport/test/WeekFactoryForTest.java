package net.atos.transport.test;

import net.atos.transport.entity.Week;

public class WeekFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Week newWeek() {

		Integer weekId = mockValues.nextInteger();

		Week week = new Week();
		week.setWeekId(weekId);
		return week;
	}
	
}
