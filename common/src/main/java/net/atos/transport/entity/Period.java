/*


 */
package net.atos.transport.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Period implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer perId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Integer year;


    private Integer periodNumber;


    private Date startDate;


    private Date endDate;

    @Size( max = 6 )
    private String status;

    @Size( max = 8 )
    private String periodMask;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPerId( Integer perId ) {
        this.perId = perId ;
    }

    public Integer getPerId() {
        return this.perId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setYear( Integer year ) {
        this.year = year;
    }
    public Integer getYear() {
        return this.year;
    }

    public void setPeriod( Integer period ) {
        this.periodNumber = period;
    }
    public Integer getPeriod() {
        return this.periodNumber;
    }

    public void setStartDate( Date startDate ) {
        this.startDate = startDate;
    }
    public Date getStartDate() {
        return this.startDate;
    }

    public void setEndDate( Date endDate ) {
        this.endDate = endDate;
    }
    public Date getEndDate() {
        return this.endDate;
    }

    public void setStatus( String status ) {
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }

    public void setPeriodMask( String periodMask ) {
        this.periodMask = periodMask;
    }
    public String getPeriodMask() {
        return this.periodMask;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
        @Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(perId);
        sb.append("|");
        sb.append(year);
        sb.append("|");
        sb.append(periodNumber);
        sb.append("|");
        sb.append(startDate);
        sb.append("|");
        sb.append(endDate);
        sb.append("|");
        sb.append(status);
        sb.append("|");
        sb.append(periodMask);
        return sb.toString(); 
    } 


}
