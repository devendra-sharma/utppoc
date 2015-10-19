package net.atos.transport.test;

import net.atos.transport.entity.Year;

public class YearFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Year newYear() {

		Integer curYear = mockValues.nextInteger();

		Year year = new Year();
		year.setYear(curYear);
		return year;
	}
	
}
