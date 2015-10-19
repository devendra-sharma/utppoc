/*


 */
package net.atos.transport.entity;

import java.io.Serializable;

import javax.validation.constraints.*;


public class ProcessControl implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer processId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 45 )
    private String value;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setProcessId( Integer processId ) {
        this.processId = processId ;
    }

    public Integer getProcessId() {
        return this.processId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setValue( String value ) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    	@Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(processId);
        sb.append("|");
        sb.append(value);
        return sb.toString(); 
    } 


}
