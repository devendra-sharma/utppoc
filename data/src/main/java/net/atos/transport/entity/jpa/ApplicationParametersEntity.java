/*


 */
// This Bean has a basic Primary Key (not composite) 

package net.atos.transport.entity.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Persistent class for entity stored in table "application_parameters"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="application_parameters", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ApplicationParametersEntity.countAll", query="SELECT COUNT(x) FROM ApplicationParametersEntity x" )
} )
public class ApplicationParametersEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="application_parameters_id", nullable=false)
    private Integer    applicationParametersId ;


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
    public ApplicationParametersEntity() {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setApplicationParametersId( Integer applicationParametersId ) {
        this.applicationParametersId = applicationParametersId ;
    }
    public Integer getApplicationParametersId() {
        return this.applicationParametersId;
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
        sb.append(applicationParametersId);
        sb.append("]:"); 
        sb.append(value);
        return sb.toString(); 
    } 

}
