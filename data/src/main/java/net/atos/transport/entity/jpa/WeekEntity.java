package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "week"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="week", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="WeekEntity.countAll", query="SELECT COUNT(x) FROM WeekEntity x" )
} )
public class WeekEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="week_id", nullable=false)
    private Integer    weekId       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="week")
    private Integer    week         ;

    @Temporal(TemporalType.DATE)
    @Column(name="start_date")
    private Date       startDate    ;

    @Temporal(TemporalType.DATE)
    @Column(name="end_date")
    private Date       endDate      ;

    @Column(name="week_mask", length=8)
    private String     weekMask     ;

    // "year" (column "year") is not defined by itself because used as FK in a link 
    // "period" (column "period") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="year", referencedColumnName="year")
    private YearEntity year2       ;

    @ManyToOne
    @JoinColumn(name="period", referencedColumnName="per_id")
    private PeriodEntity period2     ;

    @OneToMany(mappedBy="week2", targetEntity=CalendarEntity.class)
    private transient List<CalendarEntity> listOfCalendar;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public WeekEntity() {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setWeekId( Integer weekId ) {
        this.weekId = weekId ;
    }
    public Integer getWeekId() {
        return this.weekId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : week ( INT ) 
    public void setWeek( Integer week ) {
        this.week = week;
    }
    public Integer getWeek() {
        return this.week;
    }

    //--- DATABASE MAPPING : start_date ( DATE ) 
    public void setStartDate( Date startDate ) {
        this.startDate = startDate;
    }
    public Date getStartDate() {
        return this.startDate;
    }

    //--- DATABASE MAPPING : end_date ( DATE ) 
    public void setEndDate( Date endDate ) {
        this.endDate = endDate;
    }
    public Date getEndDate() {
        return this.endDate;
    }

    //--- DATABASE MAPPING : week_mask ( VARCHAR ) 
    public void setWeekMask( String weekMask ) {
        this.weekMask = weekMask;
    }
    public String getWeekMask() {
        return this.weekMask;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setYear2( YearEntity year2 ) {
        this.year2 = year2;
    }
    public YearEntity getYear2() {
        return this.year2;
    }

    public void setPeriod2( PeriodEntity period2 ) {
        this.period2 = period2;
    }
    public PeriodEntity getPeriod2() {
        return this.period2;
    }

    public void setListOfCalendar( List<CalendarEntity> listOfCalendar ) {
        this.listOfCalendar = listOfCalendar;
    }
    public List<CalendarEntity> getListOfCalendar() {
        return this.listOfCalendar;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(weekId);
        sb.append("]:"); 
        sb.append(week);
        sb.append("|");
        sb.append(startDate);
        sb.append("|");
        sb.append(endDate);
        sb.append("|");
        sb.append(weekMask);
        return sb.toString(); 
    } 

}
