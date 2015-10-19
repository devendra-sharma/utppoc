/*


 */
package net.atos.transport.entity;

import javax.validation.constraints.NotNull;

public class TicketStatusLink extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer tslId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    

    @NotNull
    private Integer tisIdLinks;

    @NotNull
    private Integer tisIdLinkedBy;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setTslId( Integer tslId ) {
        this.tslId = tslId ;
    }

    public Integer getTslId() {
        return this.tslId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    
    public void setTisIdLinks( Integer tisIdLinks ) {
        this.tisIdLinks = tisIdLinks;
    }
    public Integer getTisIdLinks() {
        return this.tisIdLinks;
    }

    public void setTisIdLinkedBy( Integer tisIdLinkedBy ) {
        this.tisIdLinkedBy = tisIdLinkedBy;
    }
    public Integer getTisIdLinkedBy() {
        return this.tisIdLinkedBy;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
        @Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(tslId);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        sb.append("|");
        sb.append(tisIdLinks);
        sb.append("|");
        sb.append(tisIdLinkedBy);
        return sb.toString(); 
    } 


}
