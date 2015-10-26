/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.RecordField;

/**
 * Business Service Interface for entity RecordField.
 */
public interface RecordFieldService
{

    /**
     * Loads an entity from the database using its Primary Key
     * 
     * @param refId
     * @return entity
     */
    RecordField findById(Integer refId);

    /**
     * Loads all entities.
     * 
     * @return all entities
     */
    List<RecordField> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * 
     * @param entity
     * @return entity
     */
    RecordField save(RecordField entity);

    /**
     * Updates the given entity in the database
     * 
     * @param entity
     * @return
     */
    RecordField update(RecordField entity);

    /**
     * Creates the given entity in the database
     * 
     * @param entity
     * @return
     */
    RecordField create(RecordField entity);

    /**
     * Deletes an entity using its Primary Key
     * 
     * @param refId
     */
    void delete(Integer refId);

}
