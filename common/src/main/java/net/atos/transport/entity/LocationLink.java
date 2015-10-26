/*


 */
package net.atos.transport.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class LocationLink extends Common implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------
    @NotNull
    private Integer lolId;

    // ----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    // ----------------------------------------------------------------------

    @NotNull
    private Integer locIdChild;

    @NotNull
    private Integer locIdParent;

    @NotNull
    private Integer gftId;

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------
    public void setLolId(Integer lolId)
    {
        this.lolId = lolId;
    }

    public Integer getLolId()
    {
        return this.lolId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    // ----------------------------------------------------------------------

    public void setLocIdChild(Integer locIdChild)
    {
        this.locIdChild = locIdChild;
    }

    public Integer getLocIdChild()
    {
        return this.locIdChild;
    }

    public void setLocIdParent(Integer locIdParent)
    {
        this.locIdParent = locIdParent;
    }

    public Integer getLocIdParent()
    {
        return this.locIdParent;
    }

    public void setGftId(Integer gftId)
    {
        this.gftId = gftId;
    }

    public Integer getGftId()
    {
        return this.gftId;
    }

    // ----------------------------------------------------------------------
    // toString METHOD
    // ----------------------------------------------------------------------
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(lolId);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        sb.append("|");
        sb.append(locIdChild);
        sb.append("|");
        sb.append(locIdParent);
        sb.append("|");
        sb.append(gftId);
        return sb.toString();
    }

}
