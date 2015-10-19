package net.atos.transport.entity.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for entity stored in table "process_control"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="process_control", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ProcessControlEntity.countAll", query="SELECT COUNT(x) FROM ProcessControlEntity x" )
} )
public class ProcessControlEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="process_id", nullable=false)
    private Integer    processId    ;


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
    public ProcessControlEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setProcessId( Integer processId ) {
        this.processId = processId ;
    }
    public Integer getProcessId() {
        return this.processId;
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
        sb.append(processId);
        sb.append("]:"); 
        sb.append(value);
        return sb.toString(); 
    } 

}
