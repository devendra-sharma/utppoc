package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "location"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="location", catalog="mydb" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="LocationEntity.countAll", query="SELECT COUNT(x) FROM LocationEntity x" )
} )
public class LocationEntity extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="loc_id", nullable=false)
    private Integer    locId        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="location", length=8)
    private String     location     ;

    @Column(name="location_description", length=32)
    private String     locationDescription ;

    @Column(name="address", length=220)
    private String     address      ;

    @Column(name="postcode", length=8)
    private String     postcode     ;

    @Column(name="telephone", length=15)
    private String     telephone    ;

    @Column(name="loc_id_primary_zone")
    private Integer    locIdPrimaryZone ;

    @Column(name="primary_zone_code", length=8)
    private String     primaryZoneCode ;

    @Column(name="primary_zone_desc", length=32)
    private String     primaryZoneDesc ;

    @Column(name="loc_id_secondary_zone")
    private Integer    locIdSecondaryZone ;

    @Column(name="secondary_zone_code", length=8)
    private String     secondaryZoneCode ;

    @Column(name="secondary_zone_desc", length=32)
    private String     secondaryZoneDesc ;

    @Column(name="loc_id_tertiary_zone")
    private Integer    locIdTertiaryZone ;

    @Column(name="tertiary_zone_code", length=8)
    private String     tertiaryZoneCode ;

    @Column(name="tertiary_zone_desc", length=32)
    private String     tertiaryZoneDesc ;

    @Column(name="loc_id_tv_station")
    private Integer    locIdTvStation ;

    @Column(name="tv_station_code", length=8)
    private String     tvStationCode ;

    @Column(name="tv_station_name", length=32)
    private String     tvStationName ;

    @Column(name="loc_id_local_authority")
    private Integer    locIdLocalAuthority ;

    @Column(name="local_authority_code", length=8)
    private String     localAuthorityCode ;

    @Column(name="local_authority_name", length=32)
    private String     localAuthorityName ;

    @Column(name="loc_id_station_group")
    private Integer    locIdStationGroup ;

    @Column(name="station_group", length=8)
    private String     stationGroup ;

    @Column(name="station_group_desc", length=32)
    private String     stationGroupDesc ;

    @Column(name="loc_id_london_station_grp")
    private Integer    locIdLondonStationGrp ;

    @Column(name="london_station_grp_code", length=8)
    private String     londonStationGrpCode ;

    @Column(name="london_station_grp_desc", length=32)
    private String     londonStationGrpDesc ;

    @Column(name="os_grid_reference", length=8)
    private String     osGridReference ;

    @Column(name="postal_region", length=2)
    private String     postalRegion ;

    @Column(name="nalco_12char_description", length=12)
    private String     nalco12charDescription ;

    @Column(name="nalco_16char_description", length=16)
    private String     nalco16charDescription ;

    @Column(name="nalco_26char_description", length=26)
    private String     nalco26charDescription ;

    @Column(name="nalco_tiploc", length=7)
    private String     nalcoTiploc  ;

    @Column(name="nalco_3char_code", length=3)
    private String     nalco3charCode ;

    @Column(name="loc_id_master_account")
    private Integer    locIdMasterAccount ;

    @Column(name="master_account_code", length=8)
    private String     masterAccountCode ;

    @Column(name="master_account_name", length=32)
    private String     masterAccountName ;

    @Column(name="cob_id_group_type", nullable=false)
    private Integer    cobIdGroupType ;

	// "lotId" (column "lot_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="lot_id", referencedColumnName="lot_id")
    private LocationTypeEntity locationType;

    @OneToMany(mappedBy="location", targetEntity=LocationLinkEntity.class)
    private transient List<LocationLinkEntity> listOfLocationLink;

    @OneToMany(mappedBy="location2", targetEntity=LocationLinkEntity.class)
    private transient List<LocationLinkEntity> listOfLocationLink2;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public LocationEntity() {
		super();
    }
    
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
    //--- DATABASE MAPPING : location ( VARCHAR ) 
    public void setLocation( String location ) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }

    //--- DATABASE MAPPING : location_description ( VARCHAR ) 
    public void setLocationDescription( String locationDescription ) {
        this.locationDescription = locationDescription;
    }
    public String getLocationDescription() {
        return this.locationDescription;
    }

    //--- DATABASE MAPPING : address ( VARCHAR ) 
    public void setAddress( String address ) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }

    //--- DATABASE MAPPING : postcode ( VARCHAR ) 
    public void setPostcode( String postcode ) {
        this.postcode = postcode;
    }
    public String getPostcode() {
        return this.postcode;
    }

    //--- DATABASE MAPPING : telephone ( VARCHAR ) 
    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }
    public String getTelephone() {
        return this.telephone;
    }

    //--- DATABASE MAPPING : loc_id_primary_zone ( INT ) 
    public void setLocIdPrimaryZone( Integer locIdPrimaryZone ) {
        this.locIdPrimaryZone = locIdPrimaryZone;
    }
    public Integer getLocIdPrimaryZone() {
        return this.locIdPrimaryZone;
    }

    //--- DATABASE MAPPING : primary_zone_code ( VARCHAR ) 
    public void setPrimaryZoneCode( String primaryZoneCode ) {
        this.primaryZoneCode = primaryZoneCode;
    }
    public String getPrimaryZoneCode() {
        return this.primaryZoneCode;
    }

    //--- DATABASE MAPPING : primary_zone_desc ( VARCHAR ) 
    public void setPrimaryZoneDesc( String primaryZoneDesc ) {
        this.primaryZoneDesc = primaryZoneDesc;
    }
    public String getPrimaryZoneDesc() {
        return this.primaryZoneDesc;
    }

    //--- DATABASE MAPPING : loc_id_secondary_zone ( INT ) 
    public void setLocIdSecondaryZone( Integer locIdSecondaryZone ) {
        this.locIdSecondaryZone = locIdSecondaryZone;
    }
    public Integer getLocIdSecondaryZone() {
        return this.locIdSecondaryZone;
    }

    //--- DATABASE MAPPING : secondary_zone_code ( VARCHAR ) 
    public void setSecondaryZoneCode( String secondaryZoneCode ) {
        this.secondaryZoneCode = secondaryZoneCode;
    }
    public String getSecondaryZoneCode() {
        return this.secondaryZoneCode;
    }

    //--- DATABASE MAPPING : secondary_zone_desc ( VARCHAR ) 
    public void setSecondaryZoneDesc( String secondaryZoneDesc ) {
        this.secondaryZoneDesc = secondaryZoneDesc;
    }
    public String getSecondaryZoneDesc() {
        return this.secondaryZoneDesc;
    }

    //--- DATABASE MAPPING : loc_id_tertiary_zone ( INT ) 
    public void setLocIdTertiaryZone( Integer locIdTertiaryZone ) {
        this.locIdTertiaryZone = locIdTertiaryZone;
    }
    public Integer getLocIdTertiaryZone() {
        return this.locIdTertiaryZone;
    }

    //--- DATABASE MAPPING : tertiary_zone_code ( VARCHAR ) 
    public void setTertiaryZoneCode( String tertiaryZoneCode ) {
        this.tertiaryZoneCode = tertiaryZoneCode;
    }
    public String getTertiaryZoneCode() {
        return this.tertiaryZoneCode;
    }

    //--- DATABASE MAPPING : tertiary_zone_desc ( VARCHAR ) 
    public void setTertiaryZoneDesc( String tertiaryZoneDesc ) {
        this.tertiaryZoneDesc = tertiaryZoneDesc;
    }
    public String getTertiaryZoneDesc() {
        return this.tertiaryZoneDesc;
    }

    //--- DATABASE MAPPING : loc_id_tv_station ( INT ) 
    public void setLocIdTvStation( Integer locIdTvStation ) {
        this.locIdTvStation = locIdTvStation;
    }
    public Integer getLocIdTvStation() {
        return this.locIdTvStation;
    }

    //--- DATABASE MAPPING : tv_station_code ( VARCHAR ) 
    public void setTvStationCode( String tvStationCode ) {
        this.tvStationCode = tvStationCode;
    }
    public String getTvStationCode() {
        return this.tvStationCode;
    }

    //--- DATABASE MAPPING : tv_station_name ( VARCHAR ) 
    public void setTvStationName( String tvStationName ) {
        this.tvStationName = tvStationName;
    }
    public String getTvStationName() {
        return this.tvStationName;
    }

    //--- DATABASE MAPPING : loc_id_local_authority ( INT ) 
    public void setLocIdLocalAuthority( Integer locIdLocalAuthority ) {
        this.locIdLocalAuthority = locIdLocalAuthority;
    }
    public Integer getLocIdLocalAuthority() {
        return this.locIdLocalAuthority;
    }

    //--- DATABASE MAPPING : local_authority_code ( VARCHAR ) 
    public void setLocalAuthorityCode( String localAuthorityCode ) {
        this.localAuthorityCode = localAuthorityCode;
    }
    public String getLocalAuthorityCode() {
        return this.localAuthorityCode;
    }

    //--- DATABASE MAPPING : local_authority_name ( VARCHAR ) 
    public void setLocalAuthorityName( String localAuthorityName ) {
        this.localAuthorityName = localAuthorityName;
    }
    public String getLocalAuthorityName() {
        return this.localAuthorityName;
    }

    //--- DATABASE MAPPING : loc_id_station_group ( INT ) 
    public void setLocIdStationGroup( Integer locIdStationGroup ) {
        this.locIdStationGroup = locIdStationGroup;
    }
    public Integer getLocIdStationGroup() {
        return this.locIdStationGroup;
    }

    //--- DATABASE MAPPING : station_group ( VARCHAR ) 
    public void setStationGroup( String stationGroup ) {
        this.stationGroup = stationGroup;
    }
    public String getStationGroup() {
        return this.stationGroup;
    }

    //--- DATABASE MAPPING : station_group_desc ( VARCHAR ) 
    public void setStationGroupDesc( String stationGroupDesc ) {
        this.stationGroupDesc = stationGroupDesc;
    }
    public String getStationGroupDesc() {
        return this.stationGroupDesc;
    }

    //--- DATABASE MAPPING : loc_id_london_station_grp ( INT ) 
    public void setLocIdLondonStationGrp( Integer locIdLondonStationGrp ) {
        this.locIdLondonStationGrp = locIdLondonStationGrp;
    }
    public Integer getLocIdLondonStationGrp() {
        return this.locIdLondonStationGrp;
    }

    //--- DATABASE MAPPING : london_station_grp_code ( VARCHAR ) 
    public void setLondonStationGrpCode( String londonStationGrpCode ) {
        this.londonStationGrpCode = londonStationGrpCode;
    }
    public String getLondonStationGrpCode() {
        return this.londonStationGrpCode;
    }

    //--- DATABASE MAPPING : london_station_grp_desc ( VARCHAR ) 
    public void setLondonStationGrpDesc( String londonStationGrpDesc ) {
        this.londonStationGrpDesc = londonStationGrpDesc;
    }
    public String getLondonStationGrpDesc() {
        return this.londonStationGrpDesc;
    }

    //--- DATABASE MAPPING : os_grid_reference ( VARCHAR ) 
    public void setOsGridReference( String osGridReference ) {
        this.osGridReference = osGridReference;
    }
    public String getOsGridReference() {
        return this.osGridReference;
    }

    //--- DATABASE MAPPING : postal_region ( VARCHAR ) 
    public void setPostalRegion( String postalRegion ) {
        this.postalRegion = postalRegion;
    }
    public String getPostalRegion() {
        return this.postalRegion;
    }

    //--- DATABASE MAPPING : nalco_12char_description ( VARCHAR ) 
    public void setNalco12charDescription( String nalco12charDescription ) {
        this.nalco12charDescription = nalco12charDescription;
    }
    public String getNalco12charDescription() {
        return this.nalco12charDescription;
    }

    //--- DATABASE MAPPING : nalco_16char_description ( VARCHAR ) 
    public void setNalco16charDescription( String nalco16charDescription ) {
        this.nalco16charDescription = nalco16charDescription;
    }
    public String getNalco16charDescription() {
        return this.nalco16charDescription;
    }

    //--- DATABASE MAPPING : nalco_26char_description ( VARCHAR ) 
    public void setNalco26charDescription( String nalco26charDescription ) {
        this.nalco26charDescription = nalco26charDescription;
    }
    public String getNalco26charDescription() {
        return this.nalco26charDescription;
    }

    //--- DATABASE MAPPING : nalco_tiploc ( VARCHAR ) 
    public void setNalcoTiploc( String nalcoTiploc ) {
        this.nalcoTiploc = nalcoTiploc;
    }
    public String getNalcoTiploc() {
        return this.nalcoTiploc;
    }

    //--- DATABASE MAPPING : nalco_3char_code ( VARCHAR ) 
    public void setNalco3charCode( String nalco3charCode ) {
        this.nalco3charCode = nalco3charCode;
    }
    public String getNalco3charCode() {
        return this.nalco3charCode;
    }

    

    //--- DATABASE MAPPING : loc_id_master_account ( INT ) 
    public void setLocIdMasterAccount( Integer locIdMasterAccount ) {
        this.locIdMasterAccount = locIdMasterAccount;
    }
    public Integer getLocIdMasterAccount() {
        return this.locIdMasterAccount;
    }

    //--- DATABASE MAPPING : master_account_code ( VARCHAR ) 
    public void setMasterAccountCode( String masterAccountCode ) {
        this.masterAccountCode = masterAccountCode;
    }
    public String getMasterAccountCode() {
        return this.masterAccountCode;
    }

    //--- DATABASE MAPPING : master_account_name ( VARCHAR ) 
    public void setMasterAccountName( String masterAccountName ) {
        this.masterAccountName = masterAccountName;
    }
    public String getMasterAccountName() {
        return this.masterAccountName;
    }

    //--- DATABASE MAPPING : cob_id_group_type ( INT ) 
    public void setCobIdGroupType( Integer cobIdGroupType ) {
        this.cobIdGroupType = cobIdGroupType;
    }
    public Integer getCobIdGroupType() {
        return this.cobIdGroupType;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setLocationType( LocationTypeEntity locationType ) {
        this.locationType = locationType;
    }
    public LocationTypeEntity getLocationType() {
        return this.locationType;
    }

    public void setListOfLocationLink( List<LocationLinkEntity> listOfLocationLink ) {
        this.listOfLocationLink = listOfLocationLink;
    }
    public List<LocationLinkEntity> getListOfLocationLink() {
        return this.listOfLocationLink;
    }

    public void setListOfLocationLink2( List<LocationLinkEntity> listOfLocationLink2 ) {
        this.listOfLocationLink2 = listOfLocationLink2;
    }
    public List<LocationLinkEntity> getListOfLocationLink2() {
        return this.listOfLocationLink2;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(locId);
        sb.append("]:"); 
        sb.append(location);
        sb.append("|");
        sb.append(locationDescription);
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
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
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
