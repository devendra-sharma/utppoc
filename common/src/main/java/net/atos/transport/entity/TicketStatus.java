/*


 */
package net.atos.transport.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TicketStatus extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer tisId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    

    @Size( max = 3 )
    private String ticketStatusCode;

    @Size( max = 32 )
    private String ticketStatusDescription;


    private BigDecimal percentDiscount;

    @Size( max = 32 )
    private String ratRailcardTypeDesc;

    @Size( max = 32 )
    private String ticketStatusTypeDesc;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setTisId( Integer tisId ) {
        this.tisId = tisId ;
    }

    public Integer getTisId() {
        return this.tisId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    

    public void setTicketStatusCode( String ticketStatusCode ) {
        this.ticketStatusCode = ticketStatusCode;
    }
    public String getTicketStatusCode() {
        return this.ticketStatusCode;
    }

    public void setTicketStatusDescription( String ticketStatusDescription ) {
        this.ticketStatusDescription = ticketStatusDescription;
    }
    public String getTicketStatusDescription() {
        return this.ticketStatusDescription;
    }

    public void setPercentDiscount( BigDecimal percentDiscount ) {
        this.percentDiscount = percentDiscount;
    }
    public BigDecimal getPercentDiscount() {
        return this.percentDiscount;
    }

    public void setRatRailcardTypeDesc( String ratRailcardTypeDesc ) {
        this.ratRailcardTypeDesc = ratRailcardTypeDesc;
    }
    public String getRatRailcardTypeDesc() {
        return this.ratRailcardTypeDesc;
    }

    public void setTicketStatusTypeDesc( String ticketStatusTypeDesc ) {
        this.ticketStatusTypeDesc = ticketStatusTypeDesc;
    }
    public String getTicketStatusTypeDesc() {
        return this.ticketStatusTypeDesc;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
        @Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(tisId);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        sb.append("|");
        sb.append(ticketStatusCode);
        sb.append("|");
        sb.append(ticketStatusDescription);
        sb.append("|");
        sb.append(percentDiscount);
        sb.append("|");
        sb.append(ratRailcardTypeDesc);
        sb.append("|");
        sb.append(ticketStatusTypeDesc);
        return sb.toString(); 
    } 


}
