/*


 */
package net.atos.transport.entity;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class RecordField extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer refId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    private Integer refIdTp;

    @Size( max = 32 )
    private String nameOfSourceField;


    private Integer fieldNumber;


    private Integer position;


    private Integer length;

    @Size( max = 2 )
    private String recordType;


   

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setRefId( Integer refId ) {
        this.refId = refId ;
    }

    public Integer getRefId() {
        return this.refId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setRefIdTp( Integer refIdTp ) {
        this.refIdTp = refIdTp;
    }
    public Integer getRefIdTp() {
        return this.refIdTp;
    }

    public void setNameOfSourceField( String nameOfSourceField ) {
        this.nameOfSourceField = nameOfSourceField;
    }
    public String getNameOfSourceField() {
        return this.nameOfSourceField;
    }

    public void setFieldNumber( Integer fieldNumber ) {
        this.fieldNumber = fieldNumber;
    }
    public Integer getFieldNumber() {
        return this.fieldNumber;
    }

    public void setPosition( Integer position ) {
        this.position = position;
    }
    public Integer getPosition() {
        return this.position;
    }

    public void setLength( Integer length ) {
        this.length = length;
    }
    public Integer getLength() {
        return this.length;
    }

    public void setRecordType( String recordType ) {
        this.recordType = recordType;
    }
    public String getRecordType() {
        return this.recordType;
    }

   

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    	@Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(refId);
        sb.append("|");
        sb.append(refIdTp);
        sb.append("|");
        sb.append(nameOfSourceField);
        sb.append("|");
        sb.append(fieldNumber);
        sb.append("|");
        sb.append(position);
        sb.append("|");
        sb.append(length);
        sb.append("|");
        sb.append(recordType);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 


}
