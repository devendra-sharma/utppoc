/*


 */
package net.atos.transport.entity;

import javax.validation.constraints.NotNull;

public class Year implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer years;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    private Date startDate;


    private Date endDate;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setYear( Integer year ) {
        this.years = year ;
    }

    public Integer getYear() {
        return this.years;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
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


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
        @Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(years);
        sb.append("|");
        sb.append(startDate);
        sb.append("|");
        sb.append(endDate);
        return sb.toString(); 
    } 


}
