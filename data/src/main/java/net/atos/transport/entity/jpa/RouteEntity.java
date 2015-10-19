package net.atos.transport.entity.jpa;

import java.io.Serializable;
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

/**
 * Persistent class for entity stored in table "route"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="route", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="RouteEntity.countAll", query="SELECT COUNT(x) FROM RouteEntity x" )
} )
public class RouteEntity extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="rou_id", nullable=false)
    private Integer    rouId        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    

    @Column(name="route_code", length=5)
    private String     routeCode    ;

    @Column(name="route_description", length=35)
    private String     routeDescription ;

    @Column(name="cob_id_route_type", nullable=false)
    private Integer    cobIdRouteType ;

    // "tacId" (column "tac_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="tac_id", referencedColumnName="tac_id")
    private TicketAllocationCodeEntity ticketAllocationCode;

    @OneToMany(mappedBy="route", targetEntity=RouteLinkEntity.class)
    private transient List<RouteLinkEntity> listOfRouteLink;

    @OneToMany(mappedBy="route2", targetEntity=RouteLinkEntity.class)
    private transient List<RouteLinkEntity> listOfRouteLink2;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public RouteEntity() {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setRouId( Integer rouId ) {
        this.rouId = rouId ;
    }
    public Integer getRouId() {
        return this.rouId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : expired ( CHAR ) 
  

    //--- DATABASE MAPPING : route_code ( VARCHAR ) 
    public void setRouteCode( String routeCode ) {
        this.routeCode = routeCode;
    }
    public String getRouteCode() {
        return this.routeCode;
    }

    //--- DATABASE MAPPING : route_description ( VARCHAR ) 
    public void setRouteDescription( String routeDescription ) {
        this.routeDescription = routeDescription;
    }
    public String getRouteDescription() {
        return this.routeDescription;
    }

    //--- DATABASE MAPPING : cob_id_route_type ( INT ) 
    public void setCobIdRouteType( Integer cobIdRouteType ) {
        this.cobIdRouteType = cobIdRouteType;
    }
    public Integer getCobIdRouteType() {
        return this.cobIdRouteType;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setTicketAllocationCode( TicketAllocationCodeEntity ticketAllocationCode ) {
        this.ticketAllocationCode = ticketAllocationCode;
    }
    public TicketAllocationCodeEntity getTicketAllocationCode() {
        return this.ticketAllocationCode;
    }

    public void setListOfRouteLink( List<RouteLinkEntity> listOfRouteLink ) {
        this.listOfRouteLink = listOfRouteLink;
    }
    public List<RouteLinkEntity> getListOfRouteLink() {
        return this.listOfRouteLink;
    }

    public void setListOfRouteLink2( List<RouteLinkEntity> listOfRouteLink2 ) {
        this.listOfRouteLink2 = listOfRouteLink2;
    }
    public List<RouteLinkEntity> getListOfRouteLink2() {
        return this.listOfRouteLink2;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(rouId);
        sb.append("]:"); 
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        sb.append("|");
        sb.append(routeCode);
        sb.append("|");
        sb.append(routeDescription);
        sb.append("|");
        sb.append(cobIdRouteType);
        return sb.toString(); 
    } 

}
