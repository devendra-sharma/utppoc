/*


 */
package net.atos.transport.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Week implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------
    @NotNull
    private Integer weekId;

    // ----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    // ----------------------------------------------------------------------

    private Integer weeks;

    private Date startDate;

    private Date endDate;

    @Size(max = 8)
    private String weekMask;

    @NotNull
    private Integer year;

    @NotNull
    private Integer period;

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------
    public void setWeekId(Integer weekId)
    {
        this.weekId = weekId;
    }

    public Integer getWeekId()
    {
        return this.weekId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    // ----------------------------------------------------------------------
    public void setWeek(Integer week)
    {
        this.weeks = week;
    }

    public Integer getWeek()
    {
        return this.weeks;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getStartDate()
    {
        return this.startDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public Date getEndDate()
    {
        return this.endDate;
    }

    public void setWeekMask(String weekMask)
    {
        this.weekMask = weekMask;
    }

    public String getWeekMask()
    {
        return this.weekMask;
    }

    public void setYear(Integer year)
    {
        this.year = year;
    }

    public Integer getYear()
    {
        return this.year;
    }

    public void setPeriod(Integer period)
    {
        this.period = period;
    }

    public Integer getPeriod()
    {
        return this.period;
    }

    // ----------------------------------------------------------------------
    // toString METHOD
    // ----------------------------------------------------------------------
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(weekId);
        sb.append("|");
        sb.append(weeks);
        sb.append("|");
        sb.append(startDate);
        sb.append("|");
        sb.append(endDate);
        sb.append("|");
        sb.append(weekMask);
        sb.append("|");
        sb.append(year);
        sb.append("|");
        sb.append(period);
        return sb.toString();
    }

}
