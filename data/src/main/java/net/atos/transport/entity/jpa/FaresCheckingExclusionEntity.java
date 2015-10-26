package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persistent class for entity stored in table "fares_checking_exclusion"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "fares_checking_exclusion", catalog = "mydb")
// Define named queries here
@NamedQueries(
{@NamedQuery(name = "FaresCheckingExclusionEntity.countAll",
        query = "SELECT COUNT(x) FROM FaresCheckingExclusionEntity x") })
public class FaresCheckingExclusionEntity implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fares_checking_exclusion_id", nullable = false)
    private Long faresCheckingExclusionId;

    // ----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    // ----------------------------------------------------------------------
    @Column(name = "value", length = 45)
    private String value;

    @Column(name = "ISSUING_LOCATION", length = 45)
    private String issuingLocation;

    @Column(name = "SELLING_LOCATION", length = 45)
    private String sellingLocation;

    @Column(name = "ORIGIN_LOCATION", length = 45)
    private String originLocation;

    @Column(name = "DESTINATION_LOCATION", length = 45)
    private String destinationLocation;

    @Column(name = "ROUTE", length = 45)
    private String route;

    @Column(name = "PRODUCT", length = 45)
    private String product;

    @Column(name = "TICKET_STATUS", length = 45)
    private String ticketStatus;

    @Column(name = "FARE", length = 45)
    private String fare;

    @Temporal(TemporalType.DATE)
    @Column(name = "WITH_EFFECT_FROM")
    private Date withEffectFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "WITH_EFFECT_UNTIL")
    private Date withEffectUntil;

    @Column(name = "NULL_FARE", length = 45)
    private String nullFare;

    // ----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    // ----------------------------------------------------------------------

    // ----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    // ----------------------------------------------------------------------
    public FaresCheckingExclusionEntity()
    {
        super();
    }

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------
    public void setFaresCheckingExclusionId(Long faresCheckingExclusionId)
    {
        this.faresCheckingExclusionId = faresCheckingExclusionId;
    }

    public Long getFaresCheckingExclusionId()
    {
        return this.faresCheckingExclusionId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    // ----------------------------------------------------------------------
    // --- DATABASE MAPPING : value ( VARCHAR )
    public void setValue(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return this.value;
    }

    // --- DATABASE MAPPING : ISSUING_LOCATION ( VARCHAR )
    public void setIssuingLocation(String issuingLocation)
    {
        this.issuingLocation = issuingLocation;
    }

    public String getIssuingLocation()
    {
        return this.issuingLocation;
    }

    // --- DATABASE MAPPING : SELLING_LOCATION ( VARCHAR )
    public void setSellingLocation(String sellingLocation)
    {
        this.sellingLocation = sellingLocation;
    }

    public String getSellingLocation()
    {
        return this.sellingLocation;
    }

    // --- DATABASE MAPPING : ORIGIN_LOCATION ( VARCHAR )
    public void setOriginLocation(String originLocation)
    {
        this.originLocation = originLocation;
    }

    public String getOriginLocation()
    {
        return this.originLocation;
    }

    // --- DATABASE MAPPING : DESTINATION_LOCATION ( VARCHAR )
    public void setDestinationLocation(String destinationLocation)
    {
        this.destinationLocation = destinationLocation;
    }

    public String getDestinationLocation()
    {
        return this.destinationLocation;
    }

    // --- DATABASE MAPPING : ROUTE ( VARCHAR )
    public void setRoute(String route)
    {
        this.route = route;
    }

    public String getRoute()
    {
        return this.route;
    }

    // --- DATABASE MAPPING : PRODUCT ( VARCHAR )
    public void setProduct(String product)
    {
        this.product = product;
    }

    public String getProduct()
    {
        return this.product;
    }

    // --- DATABASE MAPPING : TICKET_STATUS ( VARCHAR )
    public void setTicketStatus(String ticketStatus)
    {
        this.ticketStatus = ticketStatus;
    }

    public String getTicketStatus()
    {
        return this.ticketStatus;
    }

    // --- DATABASE MAPPING : FARE ( VARCHAR )
    public void setFare(String fare)
    {
        this.fare = fare;
    }

    public String getFare()
    {
        return this.fare;
    }

    // --- DATABASE MAPPING : WITH_EFFECT_FROM ( DATE )
    public void setWithEffectFrom(Date withEffectFrom)
    {
        this.withEffectFrom = withEffectFrom;
    }

    public Date getWithEffectFrom()
    {
        return this.withEffectFrom;
    }

    // --- DATABASE MAPPING : WITH_EFFECT_UNTIL ( DATE )
    public void setWithEffectUntil(Date withEffectUntil)
    {
        this.withEffectUntil = withEffectUntil;
    }

    public Date getWithEffectUntil()
    {
        return this.withEffectUntil;
    }

    // --- DATABASE MAPPING : NULL_FARE ( VARCHAR )
    public void setNullFare(String nullFare)
    {
        this.nullFare = nullFare;
    }

    public String getNullFare()
    {
        return this.nullFare;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    // ----------------------------------------------------------------------

    // ----------------------------------------------------------------------
    // toString METHOD
    // ----------------------------------------------------------------------
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(faresCheckingExclusionId);
        sb.append("]:");
        sb.append(value);
        sb.append("|");
        sb.append(issuingLocation);
        sb.append("|");
        sb.append(sellingLocation);
        sb.append("|");
        sb.append(originLocation);
        sb.append("|");
        sb.append(destinationLocation);
        sb.append("|");
        sb.append(route);
        sb.append("|");
        sb.append(product);
        sb.append("|");
        sb.append(ticketStatus);
        sb.append("|");
        sb.append(fare);
        sb.append("|");
        sb.append(withEffectFrom);
        sb.append("|");
        sb.append(withEffectUntil);
        sb.append("|");
        sb.append(nullFare);
        return sb.toString();
    }

}
