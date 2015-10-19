package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "product_type"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="product_type", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ProductTypeEntity.countAll", query="SELECT COUNT(x) FROM ProductTypeEntity x" )
} )
public class ProductTypeEntity extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="prt_id", nullable=false)
    private Integer    prtId        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="product_type_description", length=32)
    private String     productTypeDescription ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="productType", targetEntity=ProductEntity.class)
    private transient List<ProductEntity> listOfProduct;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ProductTypeEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPrtId( Integer prtId ) {
        this.prtId = prtId ;
    }
    public Integer getPrtId() {
        return this.prtId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : product_type_description ( VARCHAR ) 
    public void setProductTypeDescription( String productTypeDescription ) {
        this.productTypeDescription = productTypeDescription;
    }
    public String getProductTypeDescription() {
        return this.productTypeDescription;
    }

   

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfProduct( List<ProductEntity> listOfProduct ) {
        this.listOfProduct = listOfProduct;
    }
    public List<ProductEntity> getListOfProduct() {
        return this.listOfProduct;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(prtId);
        sb.append("]:"); 
        sb.append(productTypeDescription);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 

}
