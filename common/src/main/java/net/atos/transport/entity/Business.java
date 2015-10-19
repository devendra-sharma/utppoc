package net.atos.transport.entity;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Business extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer busId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    private Integer busIdTp;

    
    @Size( max = 32 )
    private String busDescription;

    @Size( max = 6 )
    private String busName;

    @Size( max = 3 )
    private String busCode;

    @Size( max = 3 )
    private String scansSubstituteBusCode;

    @Size( max = 45 )
    private String businesscol;

    @Size( max = 3 )
    private String atocSubstituteBusCode;


    private Integer busIdTpParent;

    @Size( max = 32 )
    private String tpParBusDescription;

    @Size( max = 6 )
    private String tpParBusName;

    @Size( max = 3 )
    private String tpParBusCode;


    private Integer busIdHoc;

    @Size( max = 32 )
    private String hocBusDescription;

    @Size( max = 6 )
    private String hocBusName;

    @Size( max = 3 )
    private String hocBusCode;


    private Integer busIdPrc;

    @Size( max = 32 )
    private String prcBusDescription;

    @Size( max = 6 )
    private String prcBusName;

    @Size( max = 3 )
    private String prcBusCode;


    private Integer busIdIsd;

    @Size( max = 32 )
    private String isdBusDescription;

    @Size( max = 6 )
    private String isdBusName;

    @Size( max = 3 )
    private String isdBusCode;


    private Integer busIdEsd;

    @Size( max = 32 )
    private String esdBusDescription;

    @Size( max = 6 )
    private String esdBusName;

    @Size( max = 3 )
    private String esdBusCode;


    private Integer busIdBut;

    @Size( max = 32 )
    private String butBusDescription;

    @Size( max = 6 )
    private String butBusName;

    @Size( max = 3 )
    private String butBusCode;

    @Size( max = 4 )
    private String ftfSiteIdentity;


    private Date euroConversionDate;

    public void setBusId( Integer busId ) {
        this.busId = busId ;
    }

    public Integer getBusId() {
        return this.busId;
    }

    public void setBusIdTp( Integer busIdTp ) {
        this.busIdTp = busIdTp;
    }
    public Integer getBusIdTp() {
        return this.busIdTp;
    }


    public void setBusDescription( String busDescription ) {
        this.busDescription = busDescription;
    }
    public String getBusDescription() {
        return this.busDescription;
    }

    public void setBusName( String busName ) {
        this.busName = busName;
    }
    public String getBusName() {
        return this.busName;
    }

    public void setBusCode( String busCode ) {
        this.busCode = busCode;
    }
    public String getBusCode() {
        return this.busCode;
    }

    public void setScansSubstituteBusCode( String scansSubstituteBusCode ) {
        this.scansSubstituteBusCode = scansSubstituteBusCode;
    }
    public String getScansSubstituteBusCode() {
        return this.scansSubstituteBusCode;
    }

    public void setBusinesscol( String businesscol ) {
        this.businesscol = businesscol;
    }
    public String getBusinesscol() {
        return this.businesscol;
    }

    public void setAtocSubstituteBusCode( String atocSubstituteBusCode ) {
        this.atocSubstituteBusCode = atocSubstituteBusCode;
    }
    public String getAtocSubstituteBusCode() {
        return this.atocSubstituteBusCode;
    }

    public void setBusIdTpParent( Integer busIdTpParent ) {
        this.busIdTpParent = busIdTpParent;
    }
    public Integer getBusIdTpParent() {
        return this.busIdTpParent;
    }

    public void setTpParBusDescription( String tpParBusDescription ) {
        this.tpParBusDescription = tpParBusDescription;
    }
    public String getTpParBusDescription() {
        return this.tpParBusDescription;
    }

    public void setTpParBusName( String tpParBusName ) {
        this.tpParBusName = tpParBusName;
    }
    public String getTpParBusName() {
        return this.tpParBusName;
    }

    public void setTpParBusCode( String tpParBusCode ) {
        this.tpParBusCode = tpParBusCode;
    }
    public String getTpParBusCode() {
        return this.tpParBusCode;
    }

    public void setBusIdHoc( Integer busIdHoc ) {
        this.busIdHoc = busIdHoc;
    }
    public Integer getBusIdHoc() {
        return this.busIdHoc;
    }

    public void setHocBusDescription( String hocBusDescription ) {
        this.hocBusDescription = hocBusDescription;
    }
    public String getHocBusDescription() {
        return this.hocBusDescription;
    }

    public void setHocBusName( String hocBusName ) {
        this.hocBusName = hocBusName;
    }
    public String getHocBusName() {
        return this.hocBusName;
    }

    public void setHocBusCode( String hocBusCode ) {
        this.hocBusCode = hocBusCode;
    }
    public String getHocBusCode() {
        return this.hocBusCode;
    }

    public void setBusIdPrc( Integer busIdPrc ) {
        this.busIdPrc = busIdPrc;
    }
    public Integer getBusIdPrc() {
        return this.busIdPrc;
    }

    public void setPrcBusDescription( String prcBusDescription ) {
        this.prcBusDescription = prcBusDescription;
    }
    public String getPrcBusDescription() {
        return this.prcBusDescription;
    }

    public void setPrcBusName( String prcBusName ) {
        this.prcBusName = prcBusName;
    }
    public String getPrcBusName() {
        return this.prcBusName;
    }

    public void setPrcBusCode( String prcBusCode ) {
        this.prcBusCode = prcBusCode;
    }
    public String getPrcBusCode() {
        return this.prcBusCode;
    }

    public void setBusIdIsd( Integer busIdIsd ) {
        this.busIdIsd = busIdIsd;
    }
    public Integer getBusIdIsd() {
        return this.busIdIsd;
    }

    public void setIsdBusDescription( String isdBusDescription ) {
        this.isdBusDescription = isdBusDescription;
    }
    public String getIsdBusDescription() {
        return this.isdBusDescription;
    }

    public void setIsdBusName( String isdBusName ) {
        this.isdBusName = isdBusName;
    }
    public String getIsdBusName() {
        return this.isdBusName;
    }

    public void setIsdBusCode( String isdBusCode ) {
        this.isdBusCode = isdBusCode;
    }
    public String getIsdBusCode() {
        return this.isdBusCode;
    }

    public void setBusIdEsd( Integer busIdEsd ) {
        this.busIdEsd = busIdEsd;
    }
    public Integer getBusIdEsd() {
        return this.busIdEsd;
    }

    public void setEsdBusDescription( String esdBusDescription ) {
        this.esdBusDescription = esdBusDescription;
    }
    public String getEsdBusDescription() {
        return this.esdBusDescription;
    }

    public void setEsdBusName( String esdBusName ) {
        this.esdBusName = esdBusName;
    }
    public String getEsdBusName() {
        return this.esdBusName;
    }

    public void setEsdBusCode( String esdBusCode ) {
        this.esdBusCode = esdBusCode;
    }
    public String getEsdBusCode() {
        return this.esdBusCode;
    }

    public void setBusIdBut( Integer busIdBut ) {
        this.busIdBut = busIdBut;
    }
    public Integer getBusIdBut() {
        return this.busIdBut;
    }

    public void setButBusDescription( String butBusDescription ) {
        this.butBusDescription = butBusDescription;
    }
    public String getButBusDescription() {
        return this.butBusDescription;
    }

    public void setButBusName( String butBusName ) {
        this.butBusName = butBusName;
    }
    public String getButBusName() {
        return this.butBusName;
    }

    public void setButBusCode( String butBusCode ) {
        this.butBusCode = butBusCode;
    }
    public String getButBusCode() {
        return this.butBusCode;
    }

    public void setFtfSiteIdentity( String ftfSiteIdentity ) {
        this.ftfSiteIdentity = ftfSiteIdentity;
    }
    public String getFtfSiteIdentity() {
        return this.ftfSiteIdentity;
    }

    public void setEuroConversionDate( Date euroConversionDate ) {
        this.euroConversionDate = euroConversionDate;
    }
    public Date getEuroConversionDate() {
        return this.euroConversionDate;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(busId);
        sb.append("|");
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
