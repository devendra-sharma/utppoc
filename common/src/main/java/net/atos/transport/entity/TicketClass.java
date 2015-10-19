/*


 */
package net.atos.transport.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TicketClass extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer ticId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 32 )
    private String ticketClassDescription;





    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setTicId( Integer ticId ) {
        this.ticId = ticId ;
    }

    public Integer getTicId() {
        return this.ticId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setTicketClassDescription( String ticketClassDescription ) {
        this.ticketClassDescription = ticketClassDescription;
    }
    public String getTicketClassDescription() {
        return this.ticketClassDescription;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
        @Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(ticId);
        sb.append("|");
        sb.append(ticketClassDescription);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 


}
