/*


 */
package net.atos.transport.entity;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Calendar implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer calId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    private Date calendarDate;

    @Size( max = 32 )
    private String dayOfWeek;

    @NotNull
    private Integer period;

    @NotNull
    private Integer year;

    @NotNull
    private Integer week;

    private Integer currencyRate;
    
	private Integer conversionPower;


    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setCalId( Integer calId ) {
        this.calId = calId ;
    }

    public Integer getCalId() {
        return this.calId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setCalendarDate( Date calendarDate ) {
        this.calendarDate = calendarDate;
    }
    public Date getCalendarDate() {
        return this.calendarDate;
    }

    public void setDayOfWeek( String dayOfWeek ) {
        this.dayOfWeek = dayOfWeek;
    }
    public String getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setPeriod( Integer period ) {
        this.period = period;
    }
    public Integer getPeriod() {
        return this.period;
    }

    public void setYear( Integer year ) {
        this.year = year;
    }
    public Integer getYear() {
        return this.year;
    }

    public void setWeek( Integer week ) {
        this.week = week;
    }
    public Integer getWeek() {
        return this.week;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public Integer getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(Integer currencyRate) {
		this.currencyRate = currencyRate;
	}

	public Integer getConversionPower() {
		return conversionPower;
	}

	public void setConversionPower(Integer conversionPower) {
		this.conversionPower = conversionPower;
	}
	
		@Override
		public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(calId);
        sb.append("|");
        sb.append(calendarDate);
        sb.append("|");
        sb.append(dayOfWeek);
        sb.append("|");
        sb.append(period);
        sb.append("|");
        sb.append(year);
        sb.append("|");
        sb.append(week);
        return sb.toString(); 
    }

		


}
