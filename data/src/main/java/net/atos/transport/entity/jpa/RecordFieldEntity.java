package net.atos.transport.entity.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Persistent class for entity stored in table "record_field"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "record_field", catalog = "mydb")
// Define named queries here
@NamedQueries(
{@NamedQuery(name = "RecordFieldEntity.countAll", query = "SELECT COUNT(x) FROM RecordFieldEntity x") })
public class RecordFieldEntity extends CommonEntity implements Serializable
{

    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    // ----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ref_id", nullable = false)
    private Integer refId;

    // ----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    // ----------------------------------------------------------------------
    @Column(name = "ref_id_tp")
    private Integer refIdTp;

    @Column(name = "name_of_source_field", length = 32)
    private String nameOfSourceField;

    @Column(name = "field_number")
    private Integer fieldNumber;

    @Column(name = "position")
    private Integer position;

    @Column(name = "length")
    private Integer length;

    @Column(name = "record_type", length = 2)
    private String recordType;

    // ----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    // ----------------------------------------------------------------------

    // ----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    // ----------------------------------------------------------------------
    public RecordFieldEntity()
    {
        super();
    }

    // ----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    // ----------------------------------------------------------------------
    public void setRefId(Integer refId)
    {
        this.refId = refId;
    }

    public Integer getRefId()
    {
        return this.refId;
    }

    // ----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    // ----------------------------------------------------------------------
    // --- DATABASE MAPPING : ref_id_tp ( INT )
    public void setRefIdTp(Integer refIdTp)
    {
        this.refIdTp = refIdTp;
    }

    public Integer getRefIdTp()
    {
        return this.refIdTp;
    }

    // --- DATABASE MAPPING : name_of_source_field ( VARCHAR )
    public void setNameOfSourceField(String nameOfSourceField)
    {
        this.nameOfSourceField = nameOfSourceField;
    }

    public String getNameOfSourceField()
    {
        return this.nameOfSourceField;
    }

    // --- DATABASE MAPPING : field_number ( INT )
    public void setFieldNumber(Integer fieldNumber)
    {
        this.fieldNumber = fieldNumber;
    }

    public Integer getFieldNumber()
    {
        return this.fieldNumber;
    }

    // --- DATABASE MAPPING : position ( INT )
    public void setPosition(Integer position)
    {
        this.position = position;
    }

    public Integer getPosition()
    {
        return this.position;
    }

    // --- DATABASE MAPPING : length ( INT )
    public void setLength(Integer length)
    {
        this.length = length;
    }

    public Integer getLength()
    {
        return this.length;
    }

    // --- DATABASE MAPPING : record_type ( CHAR )
    public void setRecordType(String recordType)
    {
        this.recordType = recordType;
    }

    public String getRecordType()
    {
        return this.recordType;
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
        sb.append(refId);
        sb.append("]:");
        sb.append(refIdTp);
        sb.append("|");
        sb.append(nameOfSourceField);
        sb.append("|");
        sb.append(fieldNumber);
        sb.append("|");
        sb.append(position);
        sb.append("|");
        sb.append(length);
        sb.append("|");
        sb.append(recordType);
        sb.append("|");
        sb.append(getExpired());
        sb.append("|");
        sb.append(getEffectiveFrom());
        sb.append("|");
        sb.append(getEffectiveTo());
        return sb.toString();
    }

}
