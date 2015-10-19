package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Persistent class for entity stored in table "code_book"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="code_book", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CodeBookEntity.countAll", query="SELECT COUNT(x) FROM CodeBookEntity x" )
} )
public class CodeBookEntity extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cob_id", nullable=false)
    private Integer    cobId        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="value", length=32)
    private String     value        ;

    @Column(name="external_representation", length=32)
    private String     externalRepresentation ;

    @Column(name="maintain_value", length=1)
    private String     maintainValue ;

    @Column(name="maintain_ext_rep", length=1)
    private String     maintainExtRep ;

    

    @Column(name="maintain_parent_code_book", length=1)
    private String     maintainParentCodeBook ;

	// "typId" (column "typ_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="typ_id", referencedColumnName="typ_id")
    private TypeEntity type        ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CodeBookEntity() {
		super();
    }
    
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
    //--- DATABASE MAPPING : value ( VARCHAR ) 
    public void setValue( String value ) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }

    //--- DATABASE MAPPING : external_representation ( VARCHAR ) 
    public void setExternalRepresentation( String externalRepresentation ) {
        this.externalRepresentation = externalRepresentation;
    }
    public String getExternalRepresentation() {
        return this.externalRepresentation;
    }

    //--- DATABASE MAPPING : maintain_value ( CHAR ) 
    public void setMaintainValue( String maintainValue ) {
        this.maintainValue = maintainValue;
    }
    public String getMaintainValue() {
        return this.maintainValue;
    }

    //--- DATABASE MAPPING : maintain_ext_rep ( CHAR ) 
    public void setMaintainExtRep( String maintainExtRep ) {
        this.maintainExtRep = maintainExtRep;
    }
    public String getMaintainExtRep() {
        return this.maintainExtRep;
    }

   
    //--- DATABASE MAPPING : maintain_parent_code_book ( CHAR ) 
    public void setMaintainParentCodeBook( String maintainParentCodeBook ) {
        this.maintainParentCodeBook = maintainParentCodeBook;
    }
    public String getMaintainParentCodeBook() {
        return this.maintainParentCodeBook;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setType( TypeEntity type ) {
        this.type = type;
    }
    public TypeEntity getType() {
        return this.type;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(cobId);
        sb.append("]:"); 
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
        return sb.toString(); 
    } 

}
