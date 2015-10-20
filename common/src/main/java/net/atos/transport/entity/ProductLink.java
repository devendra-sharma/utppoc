/*


 */
package net.atos.transport.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ProductLink extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Integer proId;

    @NotNull
    private Integer proIdParent;


    private Integer prlId;

    


    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setProId( Integer proId ) {
        this.proId = proId;
    }
    public Integer getProId() {
        return this.proId;
    }

    public void setProIdParent( Integer proIdParent ) {
        this.proIdParent = proIdParent;
    }
    public Integer getProIdParent() {
        return this.proIdParent;
    }

    public void setPrlId( Integer prlId ) {
        this.prlId = prlId;
    }
    public Integer getPrlId() {
        return this.prlId;
    }

    

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
        @Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(proId);
        sb.append("|");
        sb.append(proIdParent);
        sb.append("|");
        sb.append(prlId);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 


}
