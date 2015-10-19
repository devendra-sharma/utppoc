/*


 */
package net.atos.transport.entity;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class RouteLink extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer rolId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Integer rouIdChild;

    @NotNull
    private Integer rouIdParent;

    


    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setRolId( Integer rolId ) {
        this.rolId = rolId ;
    }

    public Integer getRolId() {
        return this.rolId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setRouIdChild( Integer rouIdChild ) {
        this.rouIdChild = rouIdChild;
    }
    public Integer getRouIdChild() {
        return this.rouIdChild;
    }

    public void setRouIdParent( Integer rouIdParent ) {
        this.rouIdParent = rouIdParent;
    }
    public Integer getRouIdParent() {
        return this.rouIdParent;
    }

    

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    	@Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(rolId);
        sb.append("|");
        sb.append(rouIdChild);
        sb.append("|");
        sb.append(rouIdParent);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 


}
