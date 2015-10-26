package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persistent class for entity stored in table "period"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "period", catalog = "mydb")
// Define named queries here
@NamedQueries(
{@NamedQuery(name = "PeriodEntity.countAll", query = "SELECT COUNT(x) FROM PeriodEntity x") })
public class PeriodEntity implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "per_id", nullable = false)
    private Integer perId;

    // ----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    // ----------------------------------------------------------------------
    @Column(name = "period")
    private Integer period;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "status", length = 6)
    private String status;

    @Column(name = "period_mask", length = 8)
    private String periodMask;

    // "year" (column "year") is not defined by itself because used as FK in a link

    // ----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    // ----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "year", referencedColumnName = "year")
    private YearEntity year2;

    @OneToMany(mappedBy = "period2", targetEntity = WeekEntity.class)
    private transient List<WeekEntity> listOfWeek;

    @OneToMany(mappedBy = "period2", targetEntity = CalendarEntity.class)
    private transient List<CalendarEntity> listOfCalendar;

    // ----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    // ----------------------------------------------------------------------
    public PeriodEntity()
    {
        super();
    }

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------
    public void setPerId(Integer perId)
    {
        this.perId = perId;
    }

    public Integer getPerId()
    {
        return this.perId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    // ----------------------------------------------------------------------
    // --- DATABASE MAPPING : period ( INT )
    public void setPeriod(Integer period)
    {
        this.period = period;
    }

    public Integer getPeriod()
    {
        return this.period;
    }

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

    // --- DATABASE MAPPING : status ( VARCHAR )
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return this.status;
    }

    // --- DATABASE MAPPING : period_mask ( VARCHAR )
    public void setPeriodMask(String periodMask)
    {
        this.periodMask = periodMask;
    }

    public String getPeriodMask()
    {
        return this.periodMask;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    // ----------------------------------------------------------------------
    public void setYear2(YearEntity year2)
    {
        this.year2 = year2;
    }

    public YearEntity getYear2()
    {
        return this.year2;
    }

    public void setListOfWeek(List<WeekEntity> listOfWeek)
    {
        this.listOfWeek = listOfWeek;
    }

    public List<WeekEntity> getListOfWeek()
    {
        return this.listOfWeek;
    }

    public void setListOfCalendar(List<CalendarEntity> listOfCalendar)
    {
        this.listOfCalendar = listOfCalendar;
    }

    public List<CalendarEntity> getListOfCalendar()
    {
        return this.listOfCalendar;
    }

    // ----------------------------------------------------------------------
    // toString METHOD
    // ----------------------------------------------------------------------
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(perId);
        sb.append("]:");
        sb.append(period);
        sb.append("|");
        sb.append(startDate);
        sb.append("|");
        sb.append(endDate);
        sb.append("|");
        sb.append(status);
        sb.append("|");
        sb.append(periodMask);
        return sb.toString();
    }

}
