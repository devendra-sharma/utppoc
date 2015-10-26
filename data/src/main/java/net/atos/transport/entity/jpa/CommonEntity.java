package net.atos.transport.entity.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CommonEntity implements Serializable
{

    @Column(name = "expired", length = 1)
    private String expired;

    @Temporal(TemporalType.DATE)
    @Column(name = "effective_from")
    private Date effectiveFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "effective_to")
    private Date effectiveTo;

    // --- DATABASE MAPPING : expired ( CHAR )
    public void setExpired(String expired)
    {
        this.expired = expired;
    }

    public String getExpired()
    {
        return this.expired;
    }

    // --- DATABASE MAPPING : effective_from ( DATE )
    public void setEffectiveFrom(Date effectiveFrom)
    {
        this.effectiveFrom = effectiveFrom;
    }

    public Date getEffectiveFrom()
    {
        return this.effectiveFrom;
    }

    // --- DATABASE MAPPING : effective_to ( DATE )
    public void setEffectiveTo(Date effectiveTo)
    {
        this.effectiveTo = effectiveTo;
    }

    public Date getEffectiveTo()
    {
        return this.effectiveTo;
    }

}
