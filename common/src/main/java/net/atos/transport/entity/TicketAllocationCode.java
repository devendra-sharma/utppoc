/*


 */
package net.atos.transport.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TicketAllocationCode extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer tacId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 1 )
    private String tacCode;

    @Size( max = 32 )
    private String tacDescription;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setTacId( Integer tacId ) {
        this.tacId = tacId ;
    }

    public Integer getTacId() {
        return this.tacId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setTacCode( String tacCode ) {
        this.tacCode = tacCode;
    }
    public String getTacCode() {
        return this.tacCode;
    }

    public void setTacDescription( String tacDescription ) {
        this.tacDescription = tacDescription;
    }
    public String getTacDescription() {
        return this.tacDescription;
    }



    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
        @Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(tacId);
        sb.append("|");
        sb.append(tacCode);
        sb.append("|");
        sb.append(tacDescription);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 


}
