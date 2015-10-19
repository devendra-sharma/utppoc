package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "product_link"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="product_link", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ProductLinkEntity.countAll", query="SELECT COUNT(x) FROM ProductLinkEntity x" )
} )
public class ProductLinkEntity extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //---------------------------------------------------------------------- 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="prl_id")
    private Integer    prlId        ;

   
    // "proId" (column "pro_id") is not defined by itself because used as FK in a link 
    // "proIdParent" (column "pro_id_parent") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="pro_id", referencedColumnName="pro_id")
    private ProductEntity product     ;

    @ManyToOne
    @JoinColumn(name="pro_id_parent", referencedColumnName="pro_id")
    private ProductEntity product2    ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ProductLinkEntity() {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : prl_id ( INT ) 
    public void setPrlId( Integer prlId ) {
        this.prlId = prlId;
    }
    public Integer getPrlId() {
        return this.prlId;
    }

   

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setProduct( ProductEntity product ) {
        this.product = product;
    }
    public ProductEntity getProduct() {
        return this.product;
    }

    public void setProduct2( ProductEntity product2 ) {
        this.product2 = product2;
    }
    public ProductEntity getProduct2() {
        return this.product2;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append("]:"); 
        sb.append(prlId);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString(); 
    } 

}
