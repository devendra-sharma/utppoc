package net.atos.transport.entity.jpa;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "instance_control_log"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="instance_control_log", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="InstanceControlLogEntity.countAll", query="SELECT COUNT(x) FROM InstanceControlLogEntity x" )
} )
public class InstanceControlLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="icl_id", nullable=false)
    private Integer    iclId        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="value", length=45)
    private String     value        ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public InstanceControlLogEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIclId( Integer iclId ) {
        this.iclId = iclId ;
    }
    public Integer getIclId() {
        return this.iclId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : value ( VARCHAR ) 
    public void setValue( String value ) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(iclId);
        sb.append("]:"); 
        sb.append(value);
        return sb.toString(); 
    } 

}
