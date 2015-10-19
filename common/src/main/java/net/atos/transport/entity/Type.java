/*


 */
package net.atos.transport.entity;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Type extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer typId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 32 )
    private String types;

    @Size( max = 1 )
    private String maintainType;

    

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setTypId( Integer typId ) {
        this.typId = typId ;
    }

    public Integer getTypId() {
        return this.typId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setType( String type ) {
        this.types = type;
    }
    public String getType() {
        return this.types;
    }

    public void setMaintainType( String maintainType ) {
        this.maintainType = maintainType;
    }
    public String getMaintainType() {
        return this.maintainType;
    }

  


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    	@Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(typId);
        sb.append("|");
        sb.append(types);
        sb.append("|");
        sb.append(maintainType);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 


}
