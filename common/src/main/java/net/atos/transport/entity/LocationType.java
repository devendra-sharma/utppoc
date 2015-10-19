/*


 */
package net.atos.transport.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LocationType extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer lotId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 32 )
    private String locationTypeDesc;

  


    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setLotId( Integer lotId ) {
        this.lotId = lotId ;
    }

    public Integer getLotId() {
        return this.lotId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setLocationTypeDesc( String locationTypeDesc ) {
        this.locationTypeDesc = locationTypeDesc;
    }
    public String getLocationTypeDesc() {
        return this.locationTypeDesc;
    }



    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
        @Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(lotId);
        sb.append("|");
        sb.append(locationTypeDesc);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 


}
