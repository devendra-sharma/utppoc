package net.atos.transport.entity.jpa;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "ticket_status_link"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="ticket_status_link", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TicketStatusLinkEntity.countAll", query="SELECT COUNT(x) FROM TicketStatusLinkEntity x" )
} )
public class TicketStatusLinkEntity extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tsl_id", nullable=false)
    private Integer    tslId        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
   

	// "tisIdLinks" (column "tis_id_links") is not defined by itself because used as FK in a link 
	// "tisIdLinkedBy" (column "tis_id_linked_by") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="tis_id_linked_by", referencedColumnName="tis_id")
    private TicketStatusEntity ticketStatus2;

    @ManyToOne
    @JoinColumn(name="tis_id_links", referencedColumnName="tis_id")
    private TicketStatusEntity ticketStatus;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TicketStatusLinkEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setTslId( Integer tslId ) {
        this.tslId = tslId ;
    }
    public Integer getTslId() {
        return this.tslId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : expired ( CHAR ) 
   

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setTicketStatus2( TicketStatusEntity ticketStatus2 ) {
        this.ticketStatus2 = ticketStatus2;
    }
    public TicketStatusEntity getTicketStatus2() {
        return this.ticketStatus2;
    }

    public void setTicketStatus( TicketStatusEntity ticketStatus ) {
        this.ticketStatus = ticketStatus;
    }
    public TicketStatusEntity getTicketStatus() {
        return this.ticketStatus;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(tslId);
        sb.append("]:"); 
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 

}
