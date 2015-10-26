package net.atos.transport.entity.jpa;

import java.io.Serializable;
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

/**
 * Persistent class for entity stored in table "location_type"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "location_type", catalog = "mydb")
// Define named queries here
@NamedQueries(
{@NamedQuery(name = "LocationTypeEntity.countAll", query = "SELECT COUNT(x) FROM LocationTypeEntity x") })
public class LocationTypeEntity extends CommonEntity implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lot_id", nullable = false)
    private Integer lotId;

    // ----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    // ----------------------------------------------------------------------
    @Column(name = "location_type_desc", length = 32)
    private String locationTypeDesc;

    // ----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    // ----------------------------------------------------------------------
    @OneToMany(mappedBy = "locationType", targetEntity = LocationEntity.class)
    private transient List<LocationEntity> listOfLocation;

    // ----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    // ----------------------------------------------------------------------
    public LocationTypeEntity()
    {
        super();
    }

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------
    public void setLotId(Integer lotId)
    {
        this.lotId = lotId;
    }

    public Integer getLotId()
    {
        return this.lotId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    // ----------------------------------------------------------------------
    // --- DATABASE MAPPING : location_type_desc ( VARCHAR )
    public void setLocationTypeDesc(String locationTypeDesc)
    {
        this.locationTypeDesc = locationTypeDesc;
    }

    public String getLocationTypeDesc()
    {
        return this.locationTypeDesc;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    // ----------------------------------------------------------------------
    public void setListOfLocation(List<LocationEntity> listOfLocation)
    {
        this.listOfLocation = listOfLocation;
    }

    public List<LocationEntity> getListOfLocation()
    {
        return this.listOfLocation;
    }

    // ----------------------------------------------------------------------
    // toString METHOD
    // ----------------------------------------------------------------------
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(lotId);
        sb.append("]:");
        sb.append(locationTypeDesc);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString();
    }

}
