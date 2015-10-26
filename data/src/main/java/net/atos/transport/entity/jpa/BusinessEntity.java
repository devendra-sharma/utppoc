package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persistent class for entity stored in table "business"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "business", catalog = "mydb")
// Define named queries here
@NamedQueries(
{@NamedQuery(name = "BusinessEntity.countAll", query = "SELECT COUNT(x) FROM BusinessEntity x") })
public class BusinessEntity extends CommonEntity implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bus_id", nullable = false)
    private Integer busId;

    // ----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    // ----------------------------------------------------------------------
    @Column(name = "bus_id_tp")
    private Integer busIdTp;

    @Column(name = "bus_description", length = 32)
    private String busDescription;

    @Column(name = "bus_name", length = 6)
    private String busName;

    @Column(name = "bus_code", length = 3)
    private String busCode;

    @Column(name = "scans_substitute_bus_code", length = 3)
    private String scansSubstituteBusCode;

    @Column(name = "businesscol", length = 45)
    private String businesscol;

    @Column(name = "atoc_substitute_bus_code", length = 3)
    private String atocSubstituteBusCode;

    @Column(name = "bus_id_tp_parent")
    private Integer busIdTpParent;

    @Column(name = "tp_par_bus_description", length = 32)
    private String tpParBusDescription;

    @Column(name = "tp_par_bus_name", length = 6)
    private String tpParBusName;

    @Column(name = "tp_par_bus_code", length = 3)
    private String tpParBusCode;

    @Column(name = "bus_id_hoc")
    private Integer busIdHoc;

    @Column(name = "hoc_bus_description", length = 32)
    private String hocBusDescription;

    @Column(name = "hoc_bus_name", length = 6)
    private String hocBusName;

    @Column(name = "hoc_bus_code", length = 3)
    private String hocBusCode;

    @Column(name = "bus_id_prc")
    private Integer busIdPrc;

    @Column(name = "prc_bus_description", length = 32)
    private String prcBusDescription;

    @Column(name = "prc_bus_name", length = 6)
    private String prcBusName;

    @Column(name = "prc_bus_code", length = 3)
    private String prcBusCode;

    @Column(name = "bus_id_isd")
    private Integer busIdIsd;

    @Column(name = "isd_bus_description", length = 32)
    private String isdBusDescription;

    @Column(name = "isd_bus_name", length = 6)
    private String isdBusName;

    @Column(name = "isd_bus_code", length = 3)
    private String isdBusCode;

    @Column(name = "bus_id_esd")
    private Integer busIdEsd;

    @Column(name = "esd_bus_description", length = 32)
    private String esdBusDescription;

    @Column(name = "esd_bus_name", length = 6)
    private String esdBusName;

    @Column(name = "esd_bus_code", length = 3)
    private String esdBusCode;

    @Column(name = "bus_id_but")
    private Integer busIdBut;

    @Column(name = "but_bus_description", length = 32)
    private String butBusDescription;

    @Column(name = "but_bus_name", length = 6)
    private String butBusName;

    @Column(name = "but_bus_code", length = 3)
    private String butBusCode;

    @Column(name = "ftf_site_identity", length = 4)
    private String ftfSiteIdentity;

    @Temporal(TemporalType.DATE)
    @Column(name = "euro_conversion_date")
    private Date euroConversionDate;

    // ----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    // ----------------------------------------------------------------------
    @OneToMany(mappedBy = "business2", targetEntity = ProductEntity.class)
    private transient List<ProductEntity> listOfProduct;

    // ----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    // ----------------------------------------------------------------------
    public BusinessEntity()
    {
        super();
    }

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------
    public void setBusId(Integer busId)
    {
        this.busId = busId;
    }

    public Integer getBusId()
    {
        return this.busId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    // ----------------------------------------------------------------------
    // --- DATABASE MAPPING : bus_id_tp ( INT )
    public void setBusIdTp(Integer busIdTp)
    {
        this.busIdTp = busIdTp;
    }

    public Integer getBusIdTp()
    {
        return this.busIdTp;
    }

    // --- DATABASE MAPPING : bus_description ( VARCHAR )
    public void setBusDescription(String busDescription)
    {
        this.busDescription = busDescription;
    }

    public String getBusDescription()
    {
        return this.busDescription;
    }

    // --- DATABASE MAPPING : bus_name ( VARCHAR )
    public void setBusName(String busName)
    {
        this.busName = busName;
    }

    public String getBusName()
    {
        return this.busName;
    }

    // --- DATABASE MAPPING : bus_code ( CHAR )
    public void setBusCode(String busCode)
    {
        this.busCode = busCode;
    }

    public String getBusCode()
    {
        return this.busCode;
    }

    // --- DATABASE MAPPING : scans_substitute_bus_code ( CHAR )
    public void setScansSubstituteBusCode(String scansSubstituteBusCode)
    {
        this.scansSubstituteBusCode = scansSubstituteBusCode;
    }

    public String getScansSubstituteBusCode()
    {
        return this.scansSubstituteBusCode;
    }

    // --- DATABASE MAPPING : businesscol ( VARCHAR )
    public void setBusinesscol(String businesscol)
    {
        this.businesscol = businesscol;
    }

    public String getBusinesscol()
    {
        return this.businesscol;
    }

    // --- DATABASE MAPPING : atoc_substitute_bus_code ( CHAR )
    public void setAtocSubstituteBusCode(String atocSubstituteBusCode)
    {
        this.atocSubstituteBusCode = atocSubstituteBusCode;
    }

    public String getAtocSubstituteBusCode()
    {
        return this.atocSubstituteBusCode;
    }

    // --- DATABASE MAPPING : bus_id_tp_parent ( INT )
    public void setBusIdTpParent(Integer busIdTpParent)
    {
        this.busIdTpParent = busIdTpParent;
    }

    public Integer getBusIdTpParent()
    {
        return this.busIdTpParent;
    }

    // --- DATABASE MAPPING : tp_par_bus_description ( VARCHAR )
    public void setTpParBusDescription(String tpParBusDescription)
    {
        this.tpParBusDescription = tpParBusDescription;
    }

    public String getTpParBusDescription()
    {
        return this.tpParBusDescription;
    }

    // --- DATABASE MAPPING : tp_par_bus_name ( VARCHAR )
    public void setTpParBusName(String tpParBusName)
    {
        this.tpParBusName = tpParBusName;
    }

    public String getTpParBusName()
    {
        return this.tpParBusName;
    }

    // --- DATABASE MAPPING : tp_par_bus_code ( CHAR )
    public void setTpParBusCode(String tpParBusCode)
    {
        this.tpParBusCode = tpParBusCode;
    }

    public String getTpParBusCode()
    {
        return this.tpParBusCode;
    }

    // --- DATABASE MAPPING : bus_id_hoc ( INT )
    public void setBusIdHoc(Integer busIdHoc)
    {
        this.busIdHoc = busIdHoc;
    }

    public Integer getBusIdHoc()
    {
        return this.busIdHoc;
    }

    // --- DATABASE MAPPING : hoc_bus_description ( VARCHAR )
    public void setHocBusDescription(String hocBusDescription)
    {
        this.hocBusDescription = hocBusDescription;
    }

    public String getHocBusDescription()
    {
        return this.hocBusDescription;
    }

    // --- DATABASE MAPPING : hoc_bus_name ( VARCHAR )
    public void setHocBusName(String hocBusName)
    {
        this.hocBusName = hocBusName;
    }

    public String getHocBusName()
    {
        return this.hocBusName;
    }

    // --- DATABASE MAPPING : hoc_bus_code ( CHAR )
    public void setHocBusCode(String hocBusCode)
    {
        this.hocBusCode = hocBusCode;
    }

    public String getHocBusCode()
    {
        return this.hocBusCode;
    }

    // --- DATABASE MAPPING : bus_id_prc ( INT )
    public void setBusIdPrc(Integer busIdPrc)
    {
        this.busIdPrc = busIdPrc;
    }

    public Integer getBusIdPrc()
    {
        return this.busIdPrc;
    }

    // --- DATABASE MAPPING : prc_bus_description ( VARCHAR )
    public void setPrcBusDescription(String prcBusDescription)
    {
        this.prcBusDescription = prcBusDescription;
    }

    public String getPrcBusDescription()
    {
        return this.prcBusDescription;
    }

    // --- DATABASE MAPPING : prc_bus_name ( VARCHAR )
    public void setPrcBusName(String prcBusName)
    {
        this.prcBusName = prcBusName;
    }

    public String getPrcBusName()
    {
        return this.prcBusName;
    }

    // --- DATABASE MAPPING : prc_bus_code ( CHAR )
    public void setPrcBusCode(String prcBusCode)
    {
        this.prcBusCode = prcBusCode;
    }

    public String getPrcBusCode()
    {
        return this.prcBusCode;
    }

    // --- DATABASE MAPPING : bus_id_isd ( INT )
    public void setBusIdIsd(Integer busIdIsd)
    {
        this.busIdIsd = busIdIsd;
    }

    public Integer getBusIdIsd()
    {
        return this.busIdIsd;
    }

    // --- DATABASE MAPPING : isd_bus_description ( VARCHAR )
    public void setIsdBusDescription(String isdBusDescription)
    {
        this.isdBusDescription = isdBusDescription;
    }

    public String getIsdBusDescription()
    {
        return this.isdBusDescription;
    }

    // --- DATABASE MAPPING : isd_bus_name ( VARCHAR )
    public void setIsdBusName(String isdBusName)
    {
        this.isdBusName = isdBusName;
    }

    public String getIsdBusName()
    {
        return this.isdBusName;
    }

    // --- DATABASE MAPPING : isd_bus_code ( CHAR )
    public void setIsdBusCode(String isdBusCode)
    {
        this.isdBusCode = isdBusCode;
    }

    public String getIsdBusCode()
    {
        return this.isdBusCode;
    }

    // --- DATABASE MAPPING : bus_id_esd ( INT )
    public void setBusIdEsd(Integer busIdEsd)
    {
        this.busIdEsd = busIdEsd;
    }

    public Integer getBusIdEsd()
    {
        return this.busIdEsd;
    }

    // --- DATABASE MAPPING : esd_bus_description ( VARCHAR )
    public void setEsdBusDescription(String esdBusDescription)
    {
        this.esdBusDescription = esdBusDescription;
    }

    public String getEsdBusDescription()
    {
        return this.esdBusDescription;
    }

    // --- DATABASE MAPPING : esd_bus_name ( VARCHAR )
    public void setEsdBusName(String esdBusName)
    {
        this.esdBusName = esdBusName;
    }

    public String getEsdBusName()
    {
        return this.esdBusName;
    }

    // --- DATABASE MAPPING : esd_bus_code ( CHAR )
    public void setEsdBusCode(String esdBusCode)
    {
        this.esdBusCode = esdBusCode;
    }

    public String getEsdBusCode()
    {
        return this.esdBusCode;
    }

    // --- DATABASE MAPPING : bus_id_but ( INT )
    public void setBusIdBut(Integer busIdBut)
    {
        this.busIdBut = busIdBut;
    }

    public Integer getBusIdBut()
    {
        return this.busIdBut;
    }

    // --- DATABASE MAPPING : but_bus_description ( VARCHAR )
    public void setButBusDescription(String butBusDescription)
    {
        this.butBusDescription = butBusDescription;
    }

    public String getButBusDescription()
    {
        return this.butBusDescription;
    }

    // --- DATABASE MAPPING : but_bus_name ( VARCHAR )
    public void setButBusName(String butBusName)
    {
        this.butBusName = butBusName;
    }

    public String getButBusName()
    {
        return this.butBusName;
    }

    // --- DATABASE MAPPING : but_bus_code ( CHAR )
    public void setButBusCode(String butBusCode)
    {
        this.butBusCode = butBusCode;
    }

    public String getButBusCode()
    {
        return this.butBusCode;
    }

    // --- DATABASE MAPPING : ftf_site_identity ( VARCHAR )
    public void setFtfSiteIdentity(String ftfSiteIdentity)
    {
        this.ftfSiteIdentity = ftfSiteIdentity;
    }

    public String getFtfSiteIdentity()
    {
        return this.ftfSiteIdentity;
    }

    // --- DATABASE MAPPING : euro_conversion_date ( DATE )
    public void setEuroConversionDate(Date euroConversionDate)
    {
        this.euroConversionDate = euroConversionDate;
    }

    public Date getEuroConversionDate()
    {
        return this.euroConversionDate;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    // ----------------------------------------------------------------------
    public void setListOfProduct(List<ProductEntity> listOfProduct)
    {
        this.listOfProduct = listOfProduct;
    }

    public List<ProductEntity> getListOfProduct()
    {
        return this.listOfProduct;
    }

    // ----------------------------------------------------------------------
    // toString METHOD
    // ----------------------------------------------------------------------
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(busId);
        sb.append("]:");
        sb.append(busIdTp);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        sb.append("|");
        sb.append(busDescription);
        sb.append("|");
        sb.append(busName);
        sb.append("|");
        sb.append(busCode);
        sb.append("|");
        sb.append(scansSubstituteBusCode);
        sb.append("|");
        sb.append(businesscol);
        sb.append("|");
        sb.append(atocSubstituteBusCode);
        sb.append("|");
        sb.append(busIdTpParent);
        sb.append("|");
        sb.append(tpParBusDescription);
        sb.append("|");
        sb.append(tpParBusName);
        sb.append("|");
        sb.append(tpParBusCode);
        sb.append("|");
        sb.append(busIdHoc);
        sb.append("|");
        sb.append(hocBusDescription);
        sb.append("|");
        sb.append(hocBusName);
        sb.append("|");
        sb.append(hocBusCode);
        sb.append("|");
        sb.append(busIdPrc);
        sb.append("|");
        sb.append(prcBusDescription);
        sb.append("|");
        sb.append(prcBusName);
        sb.append("|");
        sb.append(prcBusCode);
        sb.append("|");
        sb.append(busIdIsd);
        sb.append("|");
        sb.append(isdBusDescription);
        sb.append("|");
        sb.append(isdBusName);
        sb.append("|");
        sb.append(isdBusCode);
        sb.append("|");
        sb.append(busIdEsd);
        sb.append("|");
        sb.append(esdBusDescription);
        sb.append("|");
        sb.append(esdBusName);
        sb.append("|");
        sb.append(esdBusCode);
        sb.append("|");
        sb.append(busIdBut);
        sb.append("|");
        sb.append(butBusDescription);
        sb.append("|");
        sb.append(butBusName);
        sb.append("|");
        sb.append(butBusCode);
        sb.append("|");
        sb.append(ftfSiteIdentity);
        sb.append("|");
        sb.append(euroConversionDate);
        return sb.toString();
    }

}
