/*


 */
package net.atos.transport.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product extends Common implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------
    @NotNull
    private Integer proId;

    // ----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    // ----------------------------------------------------------------------
    @Size(max = 5)
    private String productCode;

    @Size(max = 32)
    private String productDescription;

    private BigDecimal jofJourneyFactor;

    private Integer proIdGroup1;

    @Size(max = 5)
    private String proGroup1Code;

    @Size(max = 32)
    private String proGroup1Desc;

    private Integer proIdGroup2;

    @Size(max = 5)
    private String proGroup2Code;

    @Size(max = 32)
    private String proGroup2Desc;

    private Integer busIdCorrective;

    @Size(max = 1)
    private String excludeFromNgtSundries;

    @NotNull
    private Integer business;

    @NotNull
    private Integer prtId;

    @NotNull
    private Integer cobIdDebitCreditType;

    @NotNull
    private Integer cobIdRailcardType;

    @NotNull
    private Integer cobIdSuspendableInd;

    @NotNull
    private Integer ticId;

    @NotNull
    private Integer tacId;

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------
    public void setProId(Integer proId)
    {
        this.proId = proId;
    }

    public Integer getProId()
    {
        return this.proId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    // ----------------------------------------------------------------------
    public void setProductCode(String productCode)
    {
        this.productCode = productCode;
    }

    public String getProductCode()
    {
        return this.productCode;
    }

    public void setProductDescription(String productDescription)
    {
        this.productDescription = productDescription;
    }

    public String getProductDescription()
    {
        return this.productDescription;
    }

    public void setJofJourneyFactor(BigDecimal jofJourneyFactor)
    {
        this.jofJourneyFactor = jofJourneyFactor;
    }

    public BigDecimal getJofJourneyFactor()
    {
        return this.jofJourneyFactor;
    }

    public void setProIdGroup1(Integer proIdGroup1)
    {
        this.proIdGroup1 = proIdGroup1;
    }

    public Integer getProIdGroup1()
    {
        return this.proIdGroup1;
    }

    public void setProGroup1Code(String proGroup1Code)
    {
        this.proGroup1Code = proGroup1Code;
    }

    public String getProGroup1Code()
    {
        return this.proGroup1Code;
    }

    public void setProGroup1Desc(String proGroup1Desc)
    {
        this.proGroup1Desc = proGroup1Desc;
    }

    public String getProGroup1Desc()
    {
        return this.proGroup1Desc;
    }

    public void setProIdGroup2(Integer proIdGroup2)
    {
        this.proIdGroup2 = proIdGroup2;
    }

    public Integer getProIdGroup2()
    {
        return this.proIdGroup2;
    }

    public void setProGroup2Code(String proGroup2Code)
    {
        this.proGroup2Code = proGroup2Code;
    }

    public String getProGroup2Code()
    {
        return this.proGroup2Code;
    }

    public void setProGroup2Desc(String proGroup2Desc)
    {
        this.proGroup2Desc = proGroup2Desc;
    }

    public String getProGroup2Desc()
    {
        return this.proGroup2Desc;
    }

    public void setBusIdCorrective(Integer busIdCorrective)
    {
        this.busIdCorrective = busIdCorrective;
    }

    public Integer getBusIdCorrective()
    {
        return this.busIdCorrective;
    }

    public void setExcludeFromNgtSundries(String excludeFromNgtSundries)
    {
        this.excludeFromNgtSundries = excludeFromNgtSundries;
    }

    public String getExcludeFromNgtSundries()
    {
        return this.excludeFromNgtSundries;
    }

    public void setBusiness(Integer business)
    {
        this.business = business;
    }

    public Integer getBusiness()
    {
        return this.business;
    }

    public void setPrtId(Integer prtId)
    {
        this.prtId = prtId;
    }

    public Integer getPrtId()
    {
        return this.prtId;
    }

    public void setCobIdDebitCreditType(Integer cobIdDebitCreditType)
    {
        this.cobIdDebitCreditType = cobIdDebitCreditType;
    }

    public Integer getCobIdDebitCreditType()
    {
        return this.cobIdDebitCreditType;
    }

    public void setCobIdRailcardType(Integer cobIdRailcardType)
    {
        this.cobIdRailcardType = cobIdRailcardType;
    }

    public Integer getCobIdRailcardType()
    {
        return this.cobIdRailcardType;
    }

    public void setCobIdSuspendableInd(Integer cobIdSuspendableInd)
    {
        this.cobIdSuspendableInd = cobIdSuspendableInd;
    }

    public Integer getCobIdSuspendableInd()
    {
        return this.cobIdSuspendableInd;
    }

    public void setTicId(Integer ticId)
    {
        this.ticId = ticId;
    }

    public Integer getTicId()
    {
        return this.ticId;
    }

    public void setTacId(Integer tacId)
    {
        this.tacId = tacId;
    }

    public Integer getTacId()
    {
        return this.tacId;
    }

    // ----------------------------------------------------------------------
    // toString METHOD
    // ----------------------------------------------------------------------
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(proId);
        sb.append("|");
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
        sb.append(business);
        sb.append("|");
        sb.append(prtId);
        sb.append("|");
        sb.append(cobIdDebitCreditType);
        sb.append("|");
        sb.append(cobIdRailcardType);
        sb.append("|");
        sb.append(cobIdSuspendableInd);
        sb.append("|");
        sb.append(ticId);
        sb.append("|");
        sb.append(tacId);
        return sb.toString();
    }

}
