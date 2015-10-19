package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "ticket_allocation_code"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="ticket_allocation_code", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TicketAllocationCodeEntity.countAll", query="SELECT COUNT(x) FROM TicketAllocationCodeEntity x" )
} )
public class TicketAllocationCodeEntity extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tac_id", nullable=false)
    private Integer    tacId        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="tac_code", length=1)
    private String     tacCode      ;

    @Column(name="tac_description", length=32)
    private String     tacDescription ;

   


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="ticketAllocationCode", targetEntity=ProductEntity.class)
    private transient List<ProductEntity> listOfProduct;

    @OneToMany(mappedBy="ticketAllocationCode", targetEntity=RouteEntity.class)
    private transient List<RouteEntity> listOfRoute ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TicketAllocationCodeEntity() {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setTacId( Integer tacId ) {
        this.tacId = tacId ;
    }
    public Integer getTacId() {
        return this.tacId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : tac_code ( VARCHAR ) 
    public void setTacCode( String tacCode ) {
        this.tacCode = tacCode;
    }
    public String getTacCode() {
        return this.tacCode;
    }

    //--- DATABASE MAPPING : tac_description ( VARCHAR ) 
    public void setTacDescription( String tacDescription ) {
        this.tacDescription = tacDescription;
    }
    public String getTacDescription() {
        return this.tacDescription;
    }

    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfProduct( List<ProductEntity> listOfProduct ) {
        this.listOfProduct = listOfProduct;
    }
    public List<ProductEntity> getListOfProduct() {
        return this.listOfProduct;
    }

    public void setListOfRoute( List<RouteEntity> listOfRoute ) {
        this.listOfRoute = listOfRoute;
    }
    public List<RouteEntity> getListOfRoute() {
        return this.listOfRoute;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(tacId);
        sb.append("]:"); 
        sb.append(tacCode);
        sb.append("|");
        sb.append(tacDescription);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 

}
