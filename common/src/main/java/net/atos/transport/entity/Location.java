/*


 */
package net.atos.transport.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Location extends Common implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer locId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 8 )
    private String locations;

    @Size( max = 32 )
    private String locationDescription;

    @NotNull
    private Integer lotId;

    @Size( max = 220 )
    private String address;

    @Size( max = 8 )
    private String postcode;

    @Size( max = 15 )
    private String telephone;


    private Integer locIdPrimaryZone;

    @Size( max = 8 )
    private String primaryZoneCode;

    @Size( max = 32 )
    private String primaryZoneDesc;


    private Integer locIdSecondaryZone;

    @Size( max = 8 )
    private String secondaryZoneCode;

    @Size( max = 32 )
    private String secondaryZoneDesc;


    private Integer locIdTertiaryZone;

    @Size( max = 8 )
    private String tertiaryZoneCode;

    @Size( max = 32 )
    private String tertiaryZoneDesc;


    private Integer locIdTvStation;

    @Size( max = 8 )
    private String tvStationCode;

    @Size( max = 32 )
    private String tvStationName;


    private Integer locIdLocalAuthority;

    @Size( max = 8 )
    private String localAuthorityCode;

    @Size( max = 32 )
    private String localAuthorityName;


    private Integer locIdStationGroup;

    @Size( max = 8 )
    private String stationGroup;

    @Size( max = 32 )
    private String stationGroupDesc;


    private Integer locIdLondonStationGrp;

    @Size( max = 8 )
    private String londonStationGrpCode;

    @Size( max = 32 )
    private String londonStationGrpDesc;

    @Size( max = 8 )
    private String osGridReference;

    @Size( max = 2 )
    private String postalRegion;

    @Size( max = 12 )
    private String nalco12charDescription;

    @Size( max = 16 )
    private String nalco16charDescription;

    @Size( max = 26 )
    private String nalco26charDescription;

    @Size( max = 7 )
    private String nalcoTiploc;

    @Size( max = 3 )
    private String nalco3charCode;


   


    private Integer locIdMasterAccount;

    @Size( max = 8 )
    private String masterAccountCode;

    @Size( max = 32 )
    private String masterAccountName;

    @NotNull
    private Integer cobIdGroupType;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setLocId( Integer locId ) {
        this.locId = locId ;
    }

    public Integer getLocId() {
        return this.locId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setLocation( String location ) {
        this.locations = location;
    }
    public String getLocation() {
        return this.locations;
    }

    public void setLocationDescription( String locationDescription ) {
        this.locationDescription = locationDescription;
    }
    public String getLocationDescription() {
        return this.locationDescription;
    }

    public void setLotId( Integer lotId ) {
        this.lotId = lotId;
    }
    public Integer getLotId() {
        return this.lotId;
    }

    public void setAddress( String address ) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }

    public void setPostcode( String postcode ) {
        this.postcode = postcode;
    }
    public String getPostcode() {
        return this.postcode;
    }

    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }
    public String getTelephone() {
        return this.telephone;
    }

    public void setLocIdPrimaryZone( Integer locIdPrimaryZone ) {
        this.locIdPrimaryZone = locIdPrimaryZone;
    }
    public Integer getLocIdPrimaryZone() {
        return this.locIdPrimaryZone;
    }

    public void setPrimaryZoneCode( String primaryZoneCode ) {
        this.primaryZoneCode = primaryZoneCode;
    }
    public String getPrimaryZoneCode() {
        return this.primaryZoneCode;
    }

    public void setPrimaryZoneDesc( String primaryZoneDesc ) {
        this.primaryZoneDesc = primaryZoneDesc;
    }
    public String getPrimaryZoneDesc() {
        return this.primaryZoneDesc;
    }

    public void setLocIdSecondaryZone( Integer locIdSecondaryZone ) {
        this.locIdSecondaryZone = locIdSecondaryZone;
    }
    public Integer getLocIdSecondaryZone() {
        return this.locIdSecondaryZone;
    }

    public void setSecondaryZoneCode( String secondaryZoneCode ) {
        this.secondaryZoneCode = secondaryZoneCode;
    }
    public String getSecondaryZoneCode() {
        return this.secondaryZoneCode;
    }

    public void setSecondaryZoneDesc( String secondaryZoneDesc ) {
        this.secondaryZoneDesc = secondaryZoneDesc;
    }
    public String getSecondaryZoneDesc() {
        return this.secondaryZoneDesc;
    }

    public void setLocIdTertiaryZone( Integer locIdTertiaryZone ) {
        this.locIdTertiaryZone = locIdTertiaryZone;
    }
    public Integer getLocIdTertiaryZone() {
        return this.locIdTertiaryZone;
    }

    public void setTertiaryZoneCode( String tertiaryZoneCode ) {
        this.tertiaryZoneCode = tertiaryZoneCode;
    }
    public String getTertiaryZoneCode() {
        return this.tertiaryZoneCode;
    }

    public void setTertiaryZoneDesc( String tertiaryZoneDesc ) {
        this.tertiaryZoneDesc = tertiaryZoneDesc;
    }
    public String getTertiaryZoneDesc() {
        return this.tertiaryZoneDesc;
    }

    public void setLocIdTvStation( Integer locIdTvStation ) {
        this.locIdTvStation = locIdTvStation;
    }
    public Integer getLocIdTvStation() {
        return this.locIdTvStation;
    }

    public void setTvStationCode( String tvStationCode ) {
        this.tvStationCode = tvStationCode;
    }
    public String getTvStationCode() {
        return this.tvStationCode;
    }

    public void setTvStationName( String tvStationName ) {
        this.tvStationName = tvStationName;
    }
    public String getTvStationName() {
        return this.tvStationName;
    }

    public void setLocIdLocalAuthority( Integer locIdLocalAuthority ) {
        this.locIdLocalAuthority = locIdLocalAuthority;
    }
    public Integer getLocIdLocalAuthority() {
        return this.locIdLocalAuthority;
    }

    public void setLocalAuthorityCode( String localAuthorityCode ) {
        this.localAuthorityCode = localAuthorityCode;
    }
    public String getLocalAuthorityCode() {
        return this.localAuthorityCode;
    }

    public void setLocalAuthorityName( String localAuthorityName ) {
        this.localAuthorityName = localAuthorityName;
    }
    public String getLocalAuthorityName() {
        return this.localAuthorityName;
    }

    public void setLocIdStationGroup( Integer locIdStationGroup ) {
        this.locIdStationGroup = locIdStationGroup;
    }
    public Integer getLocIdStationGroup() {
        return this.locIdStationGroup;
    }

    public void setStationGroup( String stationGroup ) {
        this.stationGroup = stationGroup;
    }
    public String getStationGroup() {
        return this.stationGroup;
    }

    public void setStationGroupDesc( String stationGroupDesc ) {
        this.stationGroupDesc = stationGroupDesc;
    }
    public String getStationGroupDesc() {
        return this.stationGroupDesc;
    }

    public void setLocIdLondonStationGrp( Integer locIdLondonStationGrp ) {
        this.locIdLondonStationGrp = locIdLondonStationGrp;
    }
    public Integer getLocIdLondonStationGrp() {
        return this.locIdLondonStationGrp;
    }

    public void setLondonStationGrpCode( String londonStationGrpCode ) {
        this.londonStationGrpCode = londonStationGrpCode;
    }
    public String getLondonStationGrpCode() {
        return this.londonStationGrpCode;
    }

    public void setLondonStationGrpDesc( String londonStationGrpDesc ) {
        this.londonStationGrpDesc = londonStationGrpDesc;
    }
    public String getLondonStationGrpDesc() {
        return this.londonStationGrpDesc;
    }

    public void setOsGridReference( String osGridReference ) {
        this.osGridReference = osGridReference;
    }
    public String getOsGridReference() {
        return this.osGridReference;
    }

    public void setPostalRegion( String postalRegion ) {
        this.postalRegion = postalRegion;
    }
    public String getPostalRegion() {
        return this.postalRegion;
    }

    public void setNalco12charDescription( String nalco12charDescription ) {
        this.nalco12charDescription = nalco12charDescription;
    }
    public String getNalco12charDescription() {
        return this.nalco12charDescription;
    }

    public void setNalco16charDescription( String nalco16charDescription ) {
        this.nalco16charDescription = nalco16charDescription;
    }
    public String getNalco16charDescription() {
        return this.nalco16charDescription;
    }

    public void setNalco26charDescription( String nalco26charDescription ) {
        this.nalco26charDescription = nalco26charDescription;
    }
    public String getNalco26charDescription() {
        return this.nalco26charDescription;
    }

    public void setNalcoTiploc( String nalcoTiploc ) {
        this.nalcoTiploc = nalcoTiploc;
    }
    public String getNalcoTiploc() {
        return this.nalcoTiploc;
    }

    public void setNalco3charCode( String nalco3charCode ) {
        this.nalco3charCode = nalco3charCode;
    }
    public String getNalco3charCode() {
        return this.nalco3charCode;
    }

  

    public void setLocIdMasterAccount( Integer locIdMasterAccount ) {
        this.locIdMasterAccount = locIdMasterAccount;
    }
    public Integer getLocIdMasterAccount() {
        return this.locIdMasterAccount;
    }

    public void setMasterAccountCode( String masterAccountCode ) {
        this.masterAccountCode = masterAccountCode;
    }
    public String getMasterAccountCode() {
        return this.masterAccountCode;
    }

    public void setMasterAccountName( String masterAccountName ) {
        this.masterAccountName = masterAccountName;
    }
    public String getMasterAccountName() {
        return this.masterAccountName;
    }

    public void setCobIdGroupType( Integer cobIdGroupType ) {
        this.cobIdGroupType = cobIdGroupType;
    }
    public Integer getCobIdGroupType() {
        return this.cobIdGroupType;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
        @Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(locId);
        sb.append("|");
        sb.append(locations);
        sb.append("|");
        sb.append(locationDescription);
        sb.append("|");
        sb.append(lotId);
        sb.append("|");
        sb.append(address);
        sb.append("|");
        sb.append(postcode);
        sb.append("|");
        sb.append(telephone);
        sb.append("|");
        sb.append(locIdPrimaryZone);
        sb.append("|");
        sb.append(primaryZoneCode);
        sb.append("|");
        sb.append(primaryZoneDesc);
        sb.append("|");
        sb.append(locIdSecondaryZone);
        sb.append("|");
        sb.append(secondaryZoneCode);
        sb.append("|");
        sb.append(secondaryZoneDesc);
        sb.append("|");
        sb.append(locIdTertiaryZone);
        sb.append("|");
        sb.append(tertiaryZoneCode);
        sb.append("|");
        sb.append(tertiaryZoneDesc);
        sb.append("|");
        sb.append(locIdTvStation);
        sb.append("|");
        sb.append(tvStationCode);
        sb.append("|");
        sb.append(tvStationName);
        sb.append("|");
        sb.append(locIdLocalAuthority);
        sb.append("|");
        sb.append(localAuthorityCode);
        sb.append("|");
        sb.append(localAuthorityName);
        sb.append("|");
        sb.append(locIdStationGroup);
        sb.append("|");
        sb.append(stationGroup);
        sb.append("|");
        sb.append(stationGroupDesc);
        sb.append("|");
        sb.append(locIdLondonStationGrp);
        sb.append("|");
        sb.append(londonStationGrpCode);
        sb.append("|");
        sb.append(londonStationGrpDesc);
        sb.append("|");
        sb.append(osGridReference);
        sb.append("|");
        sb.append(postalRegion);
        sb.append("|");
        sb.append(nalco12charDescription);
        sb.append("|");
        sb.append(nalco16charDescription);
        sb.append("|");
        sb.append(nalco26charDescription);
        sb.append("|");
        sb.append(nalcoTiploc);
        sb.append("|");
        sb.append(nalco3charCode);
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(locIdMasterAccount);
        sb.append("|");
        sb.append(masterAccountCode);
        sb.append("|");
        sb.append(masterAccountName);
        sb.append("|");
        sb.append(cobIdGroupType);
        return sb.toString(); 
    } 


}
