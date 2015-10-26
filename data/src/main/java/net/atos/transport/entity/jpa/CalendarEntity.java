package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persistent class for entity stored in table "calendar"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "calendar", catalog = "mydb")
// Define named queries here
@NamedQueries(
{@NamedQuery(name = "CalendarEntity.countAll", query = "SELECT COUNT(x) FROM CalendarEntity x") })
public class CalendarEntity implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cal_id", nullable = false)
    private Integer calId;

    // ----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    // ----------------------------------------------------------------------
    @Temporal(TemporalType.DATE)
    @Column(name = "calendar_date")
    private Date calendarDate;

    @Column(name = "day_of_week", length = 32)
    private String dayOfWeek;

    @Column(name = "currency_rate", length = 5)
    private Integer currencyRate;

    @Column(name = "conversion_power", length = 8)
    private Integer conversionPower;

    // "period" (column "period") is not defined by itself because used as FK in a link
    // "year" (column "year") is not defined by itself because used as FK in a link
    // "week" (column "week") is not defined by itself because used as FK in a link

    // ----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    // ----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "week", referencedColumnName = "week_id")
    private WeekEntity week2;

    @ManyToOne
    @JoinColumn(name = "year", referencedColumnName = "year")
    private YearEntity year2;

    @ManyToOne
    @JoinColumn(name = "period", referencedColumnName = "per_id")
    private PeriodEntity period2;

    // ----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    // ----------------------------------------------------------------------
    public CalendarEntity()
    {
        super();
    }

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------
    public void setCalId(Integer calId)
    {
        this.calId = calId;
    }

    public Integer getCalId()
    {
        return this.calId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    // ----------------------------------------------------------------------
    // --- DATABASE MAPPING : calendar_date ( DATE )
    public void setCalendarDate(Date calendarDate)
    {
        this.calendarDate = calendarDate;
    }

    public Date getCalendarDate()
    {
        return this.calendarDate;
    }

    // --- DATABASE MAPPING : day_of_week ( VARCHAR )
    public void setDayOfWeek(String dayOfWeek)
    {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDayOfWeek()
    {
        return this.dayOfWeek;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    // ----------------------------------------------------------------------
    public void setWeek2(WeekEntity week2)
    {
        this.week2 = week2;
    }

    public WeekEntity getWeek2()
    {
        return this.week2;
    }

    public void setYear2(YearEntity year2)
    {
        this.year2 = year2;
    }

    public YearEntity getYear2()
    {
        return this.year2;
    }

    public void setPeriod2(PeriodEntity period2)
    {
        this.period2 = period2;
    }

    public PeriodEntity getPeriod2()
    {
        return this.period2;
    }

    public Integer getCurrencyRate()
    {
        return currencyRate;
    }

    public void setCurrencyRate(Integer currencyRate)
    {
        this.currencyRate = currencyRate;
    }

    public Integer getConversionPower()
    {
        return conversionPower;
    }

    public void setConversionPower(Integer conversionPower)
    {
        this.conversionPower = conversionPower;
    }

    // ----------------------------------------------------------------------
    // toString METHOD
    // ----------------------------------------------------------------------
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(calId);
        sb.append("]:");
        sb.append(calendarDate);
        sb.append("|");
        sb.append(dayOfWeek);
        return sb.toString();
    }

}
