package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persistent class for entity stored in table "year"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "year", catalog = "mydb")
// Define named queries here
@NamedQueries(
{@NamedQuery(name = "YearEntity.countAll", query = "SELECT COUNT(x) FROM YearEntity x") })
public class YearEntity implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "year", nullable = false)
    private Integer year;

    // ----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    // ----------------------------------------------------------------------
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    // ----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    // ----------------------------------------------------------------------
    @OneToMany(mappedBy = "year2", targetEntity = CalendarEntity.class)
    private transient List<CalendarEntity> listOfCalendar;

    @OneToMany(mappedBy = "year2", targetEntity = PeriodEntity.class)
    private transient List<PeriodEntity> listOfPeriod;

    @OneToMany(mappedBy = "year2", targetEntity = WeekEntity.class)
    private transient List<WeekEntity> listOfWeek;

    // ----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    // ----------------------------------------------------------------------
    public YearEntity()
    {
        super();
    }

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------
    public void setYear(Integer year)
    {
        this.year = year;
    }

    public Integer getYear()
    {
        return this.year;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    // ----------------------------------------------------------------------
    // --- DATABASE MAPPING : start_date ( DATE )
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getStartDate()
    {
        return this.startDate;
    }

    // --- DATABASE MAPPING : end_date ( DATE )
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public Date getEndDate()
    {
        return this.endDate;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    // ----------------------------------------------------------------------
    public void setListOfCalendar(List<CalendarEntity> listOfCalendar)
    {
        this.listOfCalendar = listOfCalendar;
    }

    public List<CalendarEntity> getListOfCalendar()
    {
        return this.listOfCalendar;
    }

    public void setListOfPeriod(List<PeriodEntity> listOfPeriod)
    {
        this.listOfPeriod = listOfPeriod;
    }

    public List<PeriodEntity> getListOfPeriod()
    {
        return this.listOfPeriod;
    }

    public void setListOfWeek(List<WeekEntity> listOfWeek)
    {
        this.listOfWeek = listOfWeek;
    }

    public List<WeekEntity> getListOfWeek()
    {
        return this.listOfWeek;
    }

    // ----------------------------------------------------------------------
    // toString METHOD
    // ----------------------------------------------------------------------
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(year);
        sb.append("]:");
        sb.append(startDate);
        sb.append("|");
        sb.append(endDate);
        return sb.toString();
    }

}
