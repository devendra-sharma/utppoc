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
 * Persistent class for entity stored in table "ticket_class"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "ticket_class", catalog = "mydb")
// Define named queries here
@NamedQueries(
{@NamedQuery(name = "TicketClassEntity.countAll", query = "SELECT COUNT(x) FROM TicketClassEntity x") })
public class TicketClassEntity extends CommonEntity implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tic_id", nullable = false)
    private Integer ticId;

    // ----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    // ----------------------------------------------------------------------
    @Column(name = "ticket_class_description", length = 32)
    private String ticketClassDescription;

    // ----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    // ----------------------------------------------------------------------
    @OneToMany(mappedBy = "ticketClass", targetEntity = ProductEntity.class)
    private transient List<ProductEntity> listOfProduct;

    // ----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    // ----------------------------------------------------------------------
    public TicketClassEntity()
    {
        super();
    }

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------
    public void setTicId(Integer ticId)
    {
        this.ticId = ticId;
    }

    public Integer getTicId()
    {
        return this.ticId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    // ----------------------------------------------------------------------
    // --- DATABASE MAPPING : ticket_class_description ( VARCHAR )
    public void setTicketClassDescription(String ticketClassDescription)
    {
        this.ticketClassDescription = ticketClassDescription;
    }

    public String getTicketClassDescription()
    {
        return this.ticketClassDescription;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    // ----------------------------------------------------------------------
    public void setListOfProduct(List<ProductEntity> listOfProduct)
    {
        this.listOfProduct = listOfProduct;
    }

    public List<ProductEntity> getListOfProduct()
    {
        return this.listOfProduct;
    }

    // ----------------------------------------------------------------------
    // toString METHOD
    // ----------------------------------------------------------------------
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(ticId);
        sb.append("]:");
        sb.append(ticketClassDescription);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString();
    }

}
