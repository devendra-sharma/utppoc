/*


 */
package net.atos.transport.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CodeBook extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer cobId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 32 )
    private String value;

    @Size( max = 32 )
    private String externalRepresentation;

    @Size( max = 1 )
    private String maintainValue;

    @Size( max = 1 )
    private String maintainExtRep;

   

    @Size( max = 1 )
    private String maintainParentCodeBook;

    @NotNull
    private Integer typId;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setCobId( Integer cobId ) {
        this.cobId = cobId ;
    }

    public Integer getCobId() {
        return this.cobId;
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

    public void setExternalRepresentation( String externalRepresentation ) {
        this.externalRepresentation = externalRepresentation;
    }
    public String getExternalRepresentation() {
        return this.externalRepresentation;
    }

    public void setMaintainValue( String maintainValue ) {
        this.maintainValue = maintainValue;
    }
    public String getMaintainValue() {
        return this.maintainValue;
    }

    public void setMaintainExtRep( String maintainExtRep ) {
        this.maintainExtRep = maintainExtRep;
    }
    public String getMaintainExtRep() {
        return this.maintainExtRep;
    }

   
    public void setMaintainParentCodeBook( String maintainParentCodeBook ) {
        this.maintainParentCodeBook = maintainParentCodeBook;
    }
    public String getMaintainParentCodeBook() {
        return this.maintainParentCodeBook;
    }

    public void setTypId( Integer typId ) {
        this.typId = typId;
    }
    public Integer getTypId() {
        return this.typId;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
        @Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(cobId);
        sb.append("|");
        sb.append(value);
        sb.append("|");
        sb.append(externalRepresentation);
        sb.append("|");
        sb.append(maintainValue);
        sb.append("|");
        sb.append(maintainExtRep);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        sb.append("|");
        sb.append(maintainParentCodeBook);
        sb.append("|");
        sb.append(typId);
        return sb.toString(); 
    } 


}
