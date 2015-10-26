package net.atos.transport.test;

import net.atos.transport.entity.Calendar;

public class CalendarFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public Calendar newCalendar()
    {

        Integer calId = mockValues.nextInteger();

        Calendar calendar = new Calendar();
        calendar.setCalId(calId);
        return calendar;
    }

}
