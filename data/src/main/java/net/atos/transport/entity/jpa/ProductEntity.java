package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "product"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="product", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ProductEntity.countAll", query="SELECT COUNT(x) FROM ProductEntity x" )
} )
public class ProductEntity extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pro_id", nullable=false)
    private Integer    proId        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="product_code", length=5)
    private String     productCode  ;

    @Column(name="product_description", length=32)
    private String     productDescription ;

    @Column(name="jof_journey_factor")
    private BigDecimal jofJourneyFactor ;

    @Column(name="pro_id_group_1")
    private Integer    proIdGroup1  ;

    @Column(name="pro_group_1_code", length=5)
    private String     proGroup1Code ;

    @Column(name="pro_group_1_desc", length=32)
    private String     proGroup1Desc ;

    @Column(name="pro_id_group_2")
    private Integer    proIdGroup2  ;

    @Column(name="pro_group_2_code", length=5)
    private String     proGroup2Code ;

    @Column(name="pro_group_2_desc", length=32)
    private String     proGroup2Desc ;

   
    @Column(name="bus_id_corrective")
    private Integer    busIdCorrective ;

    @Column(name="exclude_from_ngt_sundries", length=1)
    private String     excludeFromNgtSundries ;

    @Column(name="cob_id_debit_credit_type", nullable=false)
    private Integer    cobIdDebitCreditType ;

    @Column(name="cob_id_railcard_type", nullable=false)
    private Integer    cobIdRailcardType ;

    @Column(name="cob_id_suspendable_ind", nullable=false)
    private Integer    cobIdSuspendableInd ;

	// "business" (column "business") is not defined by itself because used as FK in a link 
	// "prtId" (column "prt_id") is not defined by itself because used as FK in a link 
	// "ticId" (column "tic_id") is not defined by itself because used as FK in a link 
	// "tacId" (column "tac_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="tac_id", referencedColumnName="tac_id")
    private TicketAllocationCodeEntity ticketAllocationCode;

    @OneToMany(mappedBy="product2", targetEntity=ProductLinkEntity.class)
    private transient List<ProductLinkEntity> listOfProductLink2;

    @OneToMany(mappedBy="product", targetEntity=ProductLinkEntity.class)
    private transient List<ProductLinkEntity> listOfProductLink;

    @ManyToOne
    @JoinColumn(name="business", referencedColumnName="bus_id")
    private BusinessEntity business2   ;

    @ManyToOne
    @JoinColumn(name="prt_id", referencedColumnName="prt_id")
    private ProductTypeEntity productType ;

    @ManyToOne
    @JoinColumn(name="tic_id", referencedColumnName="tic_id")
    private TicketClassEntity ticketClass ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ProductEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setProId( Integer proId ) {
        this.proId = proId ;
    }
    public Integer getProId() {
        return this.proId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : product_code ( VARCHAR ) 
    public void setProductCode( String productCode ) {
        this.productCode = productCode;
    }
    public String getProductCode() {
        return this.productCode;
    }

    //--- DATABASE MAPPING : product_description ( VARCHAR ) 
    public void setProductDescription( String productDescription ) {
        this.productDescription = productDescription;
    }
    public String getProductDescription() {
        return this.productDescription;
    }

    //--- DATABASE MAPPING : jof_journey_factor ( DECIMAL ) 
    public void setJofJourneyFactor( BigDecimal jofJourneyFactor ) {
        this.jofJourneyFactor = jofJourneyFactor;
    }
    public BigDecimal getJofJourneyFactor() {
        return this.jofJourneyFactor;
    }

    //--- DATABASE MAPPING : pro_id_group_1 ( INT ) 
    public void setProIdGroup1( Integer proIdGroup1 ) {
        this.proIdGroup1 = proIdGroup1;
    }
    public Integer getProIdGroup1() {
        return this.proIdGroup1;
    }

    //--- DATABASE MAPPING : pro_group_1_code ( VARCHAR ) 
    public void setProGroup1Code( String proGroup1Code ) {
        this.proGroup1Code = proGroup1Code;
    }
    public String getProGroup1Code() {
        return this.proGroup1Code;
    }

    //--- DATABASE MAPPING : pro_group_1_desc ( VARCHAR ) 
    public void setProGroup1Desc( String proGroup1Desc ) {
        this.proGroup1Desc = proGroup1Desc;
    }
    public String getProGroup1Desc() {
        return this.proGroup1Desc;
    }

    //--- DATABASE MAPPING : pro_id_group_2 ( INT ) 
    public void setProIdGroup2( Integer proIdGroup2 ) {
        this.proIdGroup2 = proIdGroup2;
    }
    public Integer getProIdGroup2() {
        return this.proIdGroup2;
    }

    //--- DATABASE MAPPING : pro_group_2_code ( VARCHAR ) 
    public void setProGroup2Code( String proGroup2Code ) {
        this.proGroup2Code = proGroup2Code;
    }
    public String getProGroup2Code() {
        return this.proGroup2Code;
    }

    //--- DATABASE MAPPING : pro_group_2_desc ( VARCHAR ) 
    public void setProGroup2Desc( String proGroup2Desc ) {
        this.proGroup2Desc = proGroup2Desc;
    }
    public String getProGroup2Desc() {
        return this.proGroup2Desc;
    }

   

    //--- DATABASE MAPPING : bus_id_corrective ( INT ) 
    public void setBusIdCorrective( Integer busIdCorrective ) {
        this.busIdCorrective = busIdCorrective;
    }
    public Integer getBusIdCorrective() {
        return this.busIdCorrective;
    }

    //--- DATABASE MAPPING : exclude_from_ngt_sundries ( VARCHAR ) 
    public void setExcludeFromNgtSundries( String excludeFromNgtSundries ) {
        this.excludeFromNgtSundries = excludeFromNgtSundries;
    }
    public String getExcludeFromNgtSundries() {
        return this.excludeFromNgtSundries;
    }

    //--- DATABASE MAPPING : cob_id_debit_credit_type ( INT ) 
    public void setCobIdDebitCreditType( Integer cobIdDebitCreditType ) {
        this.cobIdDebitCreditType = cobIdDebitCreditType;
    }
    public Integer getCobIdDebitCreditType() {
        return this.cobIdDebitCreditType;
    }

    //--- DATABASE MAPPING : cob_id_railcard_type ( INT ) 
    public void setCobIdRailcardType( Integer cobIdRailcardType ) {
        this.cobIdRailcardType = cobIdRailcardType;
    }
    public Integer getCobIdRailcardType() {
        return this.cobIdRailcardType;
    }

    //--- DATABASE MAPPING : cob_id_suspendable_ind ( INT ) 
    public void setCobIdSuspendableInd( Integer cobIdSuspendableInd ) {
        this.cobIdSuspendableInd = cobIdSuspendableInd;
    }
    public Integer getCobIdSuspendableInd() {
        return this.cobIdSuspendableInd;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setTicketAllocationCode( TicketAllocationCodeEntity ticketAllocationCode ) {
        this.ticketAllocationCode = ticketAllocationCode;
    }
    public TicketAllocationCodeEntity getTicketAllocationCode() {
        return this.ticketAllocationCode;
    }

    public void setListOfProductLink2( List<ProductLinkEntity> listOfProductLink2 ) {
        this.listOfProductLink2 = listOfProductLink2;
    }
    public List<ProductLinkEntity> getListOfProductLink2() {
        return this.listOfProductLink2;
    }

    public void setListOfProductLink( List<ProductLinkEntity> listOfProductLink ) {
        this.listOfProductLink = listOfProductLink;
    }
    public List<ProductLinkEntity> getListOfProductLink() {
        return this.listOfProductLink;
    }

    public void setBusiness2( BusinessEntity business2 ) {
        this.business2 = business2;
    }
    public BusinessEntity getBusiness2() {
        return this.business2;
    }

    public void setProductType( ProductTypeEntity productType ) {
        this.productType = productType;
    }
    public ProductTypeEntity getProductType() {
        return this.productType;
    }

    public void setTicketClass( TicketClassEntity ticketClass ) {
        this.ticketClass = ticketClass;
    }
    public TicketClassEntity getTicketClass() {
        return this.ticketClass;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(proId);
        sb.append("]:"); 
        sb.append(productCode);
        sb.append("|");
        sb.append(productDescription);
        sb.append("|");
        sb.append(jofJourneyFactor);
        sb.append("|");
        sb.append(proIdGroup1);
        sb.append("|");
        sb.append(proGroup1Code);
        sb.append("|");
        sb.append(proGroup1Desc);
        sb.append("|");
        sb.append(proIdGroup2);
        sb.append("|");
        sb.append(proGroup2Code);
        sb.append("|");
        sb.append(proGroup2Desc);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        sb.append("|");
        sb.append(busIdCorrective);
        sb.append("|");
        sb.append(excludeFromNgtSundries);
        sb.append("|");
        sb.append(cobIdDebitCreditType);
        sb.append("|");
        sb.append(cobIdRailcardType);
        sb.append("|");
        sb.append(cobIdSuspendableInd);
        return sb.toString(); 
    } 

}
