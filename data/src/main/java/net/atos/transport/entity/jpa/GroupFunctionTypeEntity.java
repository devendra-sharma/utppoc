package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "group_function_type"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="group_function_type", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="GroupFunctionTypeEntity.countAll", query="SELECT COUNT(x) FROM GroupFunctionTypeEntity x" )
} )
public class GroupFunctionTypeEntity extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="gft_id", nullable=false)
    private Integer    gftId        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="group_function_type_desc", length=32)
    private String     groupFunctionTypeDesc ;

   
    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="groupFunctionType", targetEntity=LocationLinkEntity.class)
    private transient List<LocationLinkEntity> listOfLocationLink;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public GroupFunctionTypeEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setGftId( Integer gftId ) {
        this.gftId = gftId ;
    }
    public Integer getGftId() {
        return this.gftId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : group_function_type_desc ( VARCHAR ) 
    public void setGroupFunctionTypeDesc( String groupFunctionTypeDesc ) {
        this.groupFunctionTypeDesc = groupFunctionTypeDesc;
    }
    public String getGroupFunctionTypeDesc() {
        return this.groupFunctionTypeDesc;
    }

    


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfLocationLink( List<LocationLinkEntity> listOfLocationLink ) {
        this.listOfLocationLink = listOfLocationLink;
    }
    public List<LocationLinkEntity> getListOfLocationLink() {
        return this.listOfLocationLink;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(gftId);
        sb.append("]:"); 
        sb.append(groupFunctionTypeDesc);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 

}
