package net.atos.transport.entity.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Persistent class for entity stored in table "route_link"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "route_link", catalog = "mydb")
// Define named queries here
@NamedQueries(
{@NamedQuery(name = "RouteLinkEntity.countAll", query = "SELECT COUNT(x) FROM RouteLinkEntity x") })
public class RouteLinkEntity extends CommonEntity implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rol_id", nullable = false)
    private Integer rolId;

    // ----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    // ----------------------------------------------------------------------

    // "rouIdChild" (column "rou_id_child") is not defined by itself because used as FK in a link
    // "rouIdParent" (column "rou_id_parent") is not defined by itself because used as FK in a link

    // ----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    // ----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "rou_id_parent", referencedColumnName = "rou_id")
    private RouteEntity route2;

    @ManyToOne
    @JoinColumn(name = "rou_id_child", referencedColumnName = "rou_id")
    private RouteEntity route;

    // ----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    // ----------------------------------------------------------------------
    public RouteLinkEntity()
    {
        super();
    }

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------
    public void setRolId(Integer rolId)
    {
        this.rolId = rolId;
    }

    public Integer getRolId()
    {
        return this.rolId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    // ----------------------------------------------------------------------

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    // ----------------------------------------------------------------------
    public void setRoute2(RouteEntity route2)
    {
        this.route2 = route2;
    }

    public RouteEntity getRoute2()
    {
        return this.route2;
    }

    public void setRoute(RouteEntity route)
    {
        this.route = route;
    }

    public RouteEntity getRoute()
    {
        return this.route;
    }

    // ----------------------------------------------------------------------
    // toString METHOD
    // ----------------------------------------------------------------------
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(rolId);
        sb.append("]:");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString();
    }

}
