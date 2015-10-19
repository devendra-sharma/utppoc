/*
 * Created on 15 Oct 2015 ( Time 20:28:40 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.atos.transport.entity;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class FaresCheckingExclusion implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long faresCheckingExclusionId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 45 )
    private String value;

    @Size( max = 45 )
    private String issuingLocation;

    @Size( max = 45 )
    private String sellingLocation;

    @Size( max = 45 )
    private String originLocation;

    @Size( max = 45 )
    private String destinationLocation;

    @Size( max = 45 )
    private String route;

    @Size( max = 45 )
    private String product;

    @Size( max = 45 )
    private String ticketStatus;

    @Size( max = 45 )
    private String fare;


    private Date withEffectFrom;


    private Date withEffectUntil;

    @Size( max = 45 )
    private String nullFare;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFaresCheckingExclusionId( Long faresCheckingExclusionId ) {
        this.faresCheckingExclusionId = faresCheckingExclusionId ;
    }

    public Long getFaresCheckingExclusionId() {
        return this.faresCheckingExclusionId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setValue( String value ) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }

    public void setIssuingLocation( String issuingLocation ) {
        this.issuingLocation = issuingLocation;
    }
    public String getIssuingLocation() {
        return this.issuingLocation;
    }

    public void setSellingLocation( String sellingLocation ) {
        this.sellingLocation = sellingLocation;
    }
    public String getSellingLocation() {
        return this.sellingLocation;
    }

    public void setOriginLocation( String originLocation ) {
        this.originLocation = originLocation;
    }
    public String getOriginLocation() {
        return this.originLocation;
    }

    public void setDestinationLocation( String destinationLocation ) {
        this.destinationLocation = destinationLocation;
    }
    public String getDestinationLocation() {
        return this.destinationLocation;
    }

    public void setRoute( String route ) {
        this.route = route;
    }
    public String getRoute() {
        return this.route;
    }

    public void setProduct( String product ) {
        this.product = product;
    }
    public String getProduct() {
        return this.product;
    }

    public void setTicketStatus( String ticketStatus ) {
        this.ticketStatus = ticketStatus;
    }
    public String getTicketStatus() {
        return this.ticketStatus;
    }

    public void setFare( String fare ) {
        this.fare = fare;
    }
    public String getFare() {
        return this.fare;
    }

    public void setWithEffectFrom( Date withEffectFrom ) {
        this.withEffectFrom = withEffectFrom;
    }
    public Date getWithEffectFrom() {
        return this.withEffectFrom;
    }

    public void setWithEffectUntil( Date withEffectUntil ) {
        this.withEffectUntil = withEffectUntil;
    }
    public Date getWithEffectUntil() {
        return this.withEffectUntil;
    }

    public void setNullFare( String nullFare ) {
        this.nullFare = nullFare;
    }
    public String getNullFare() {
        return this.nullFare;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    	@Override
        public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(faresCheckingExclusionId);
        sb.append("|");
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
