package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "location_link"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="location_link", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="LocationLinkEntity.countAll", query="SELECT COUNT(x) FROM LocationLinkEntity x" )
} )
public class LocationLinkEntity extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="lol_id", nullable=false)
    private Integer    lolId        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
   
    // "locIdChild" (column "loc_id_child") is not defined by itself because used as FK in a link 
    // "locIdParent" (column "loc_id_parent") is not defined by itself because used as FK in a link 
    // "gftId" (column "gft_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="loc_id_parent", referencedColumnName="loc_id")
    private LocationEntity location2   ;

    @ManyToOne
    @JoinColumn(name="loc_id_child", referencedColumnName="loc_id")
    private LocationEntity location    ;

    @ManyToOne
    @JoinColumn(name="gft_id", referencedColumnName="gft_id")
    private GroupFunctionTypeEntity groupFunctionType;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public LocationLinkEntity() {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setLolId( Integer lolId ) {
        this.lolId = lolId ;
    }
    public Integer getLolId() {
        return this.lolId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : expired ( CHAR ) 
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setLocation2( LocationEntity location2 ) {
        this.location2 = location2;
    }
    public LocationEntity getLocation2() {
        return this.location2;
    }

    public void setLocation( LocationEntity location ) {
        this.location = location;
    }
    public LocationEntity getLocation() {
        return this.location;
    }

    public void setGroupFunctionType( GroupFunctionTypeEntity groupFunctionType ) {
        this.groupFunctionType = groupFunctionType;
    }
    public GroupFunctionTypeEntity getGroupFunctionType() {
        return this.groupFunctionType;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(lolId);
        sb.append("]:"); 
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 

}
