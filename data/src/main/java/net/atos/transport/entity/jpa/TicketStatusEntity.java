package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "ticket_status"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="ticket_status", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TicketStatusEntity.countAll", query="SELECT COUNT(x) FROM TicketStatusEntity x" )
} )
public class TicketStatusEntity extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tis_id", nullable=false)
    private Integer    tisId        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
  

    @Column(name="ticket_status_code", length=3)
    private String     ticketStatusCode ;

    @Column(name="ticket_status_description", length=32)
    private String     ticketStatusDescription ;

    @Column(name="percent_discount")
    private BigDecimal percentDiscount ;

    @Column(name="rat_railcard_type_desc", length=32)
    private String     ratRailcardTypeDesc ;

    @Column(name="ticket_status_type_desc", length=32)
    private String     ticketStatusTypeDesc ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="ticketStatus2", targetEntity=TicketStatusLinkEntity.class)
    private transient List<TicketStatusLinkEntity> listOfTicketStatusLink2;

    @OneToMany(mappedBy="ticketStatus", targetEntity=TicketStatusLinkEntity.class)
    private transient List<TicketStatusLinkEntity> listOfTicketStatusLink;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TicketStatusEntity() {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setTisId( Integer tisId ) {
        this.tisId = tisId ;
    }
    public Integer getTisId() {
        return this.tisId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    

    //--- DATABASE MAPPING : ticket_status_code ( VARCHAR ) 
    public void setTicketStatusCode( String ticketStatusCode ) {
        this.ticketStatusCode = ticketStatusCode;
    }
    public String getTicketStatusCode() {
        return this.ticketStatusCode;
    }

    //--- DATABASE MAPPING : ticket_status_description ( VARCHAR ) 
    public void setTicketStatusDescription( String ticketStatusDescription ) {
        this.ticketStatusDescription = ticketStatusDescription;
    }
    public String getTicketStatusDescription() {
        return this.ticketStatusDescription;
    }

    //--- DATABASE MAPPING : percent_discount ( DECIMAL ) 
    public void setPercentDiscount( BigDecimal percentDiscount ) {
        this.percentDiscount = percentDiscount;
    }
    public BigDecimal getPercentDiscount() {
        return this.percentDiscount;
    }

    //--- DATABASE MAPPING : rat_railcard_type_desc ( VARCHAR ) 
    public void setRatRailcardTypeDesc( String ratRailcardTypeDesc ) {
        this.ratRailcardTypeDesc = ratRailcardTypeDesc;
    }
    public String getRatRailcardTypeDesc() {
        return this.ratRailcardTypeDesc;
    }

    //--- DATABASE MAPPING : ticket_status_type_desc ( VARCHAR ) 
    public void setTicketStatusTypeDesc( String ticketStatusTypeDesc ) {
        this.ticketStatusTypeDesc = ticketStatusTypeDesc;
    }
    public String getTicketStatusTypeDesc() {
        return this.ticketStatusTypeDesc;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfTicketStatusLink2( List<TicketStatusLinkEntity> listOfTicketStatusLink2 ) {
        this.listOfTicketStatusLink2 = listOfTicketStatusLink2;
    }
    public List<TicketStatusLinkEntity> getListOfTicketStatusLink2() {
        return this.listOfTicketStatusLink2;
    }

    public void setListOfTicketStatusLink( List<TicketStatusLinkEntity> listOfTicketStatusLink ) {
        this.listOfTicketStatusLink = listOfTicketStatusLink;
    }
    public List<TicketStatusLinkEntity> getListOfTicketStatusLink() {
        return this.listOfTicketStatusLink;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(tisId);
        sb.append("]:"); 
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        sb.append("|");
        sb.append(ticketStatusCode);
        sb.append("|");
        sb.append(ticketStatusDescription);
        sb.append("|");
        sb.append(percentDiscount);
        sb.append("|");
        sb.append(ratRailcardTypeDesc);
        sb.append("|");
        sb.append(ticketStatusTypeDesc);
        return sb.toString(); 
    } 

}
