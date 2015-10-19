/*


 */
package net.atos.transport.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Route extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer rouId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    


    @Size( max = 5 )
    private String routeCode;

    @Size( max = 35 )
    private String routeDescription;

    @NotNull
    private Integer tacId;

    @NotNull
    private Integer cobIdRouteType;



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
    

    public void setRouteCode( String routeCode ) {
        this.routeCode = routeCode;
    }
    public String getRouteCode() {
        return this.routeCode;
    }

    public void setRouteDescription( String routeDescription ) {
        this.routeDescription = routeDescription;
    }
    public String getRouteDescription() {
        return this.routeDescription;
    }

    public void setTacId( Integer tacId ) {
        this.tacId = tacId;
    }
    public Integer getTacId() {
        return this.tacId;
    }

    public void setCobIdRouteType( Integer cobIdRouteType ) {
        this.cobIdRouteType = cobIdRouteType;
    }
    public Integer getCobIdRouteType() {
        return this.cobIdRouteType;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
        @Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(rouId);
        sb.append("|");
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
        sb.append(tacId);
        sb.append("|");
        sb.append(cobIdRouteType);
        return sb.toString(); 
    } 


}
