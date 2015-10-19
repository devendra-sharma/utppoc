package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "type"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="type", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TypeEntity.countAll", query="SELECT COUNT(x) FROM TypeEntity x" )
} )
public class TypeEntity extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="typ_id", nullable=false)
    private Integer    typId        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="type", length=32)
    private String     type         ;

    @Column(name="maintain_type", length=1)
    private String     maintainType ;




    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="type", targetEntity=CodeBookEntity.class)
    private transient List<CodeBookEntity> listOfCodeBook;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TypeEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setTypId( Integer typId ) {
        this.typId = typId ;
    }
    public Integer getTypId() {
        return this.typId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : type ( VARCHAR ) 
    public void setType( String type ) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }

    //--- DATABASE MAPPING : maintain_type ( CHAR ) 
    public void setMaintainType( String maintainType ) {
        this.maintainType = maintainType;
    }
    public String getMaintainType() {
        return this.maintainType;
    }

    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfCodeBook( List<CodeBookEntity> listOfCodeBook ) {
        this.listOfCodeBook = listOfCodeBook;
    }
    public List<CodeBookEntity> getListOfCodeBook() {
        return this.listOfCodeBook;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(typId);
        sb.append("]:"); 
        sb.append(type);
        sb.append("|");
        sb.append(maintainType);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 

}
