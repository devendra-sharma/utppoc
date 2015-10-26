/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.InstanceControlLog;

/**
 * Business Service Interface for entity InstanceControlLog.
 */
public interface InstanceControlLogService
{

    /**
     * Loads an entity from the database using its Primary Key
     * 
     * @param iclId
     * @return entity
     */
    InstanceControlLog findById(Integer iclId);

    /**
     * Loads all entities.
     * 
     * @return all entities
     */
    List<InstanceControlLog> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * 
     * @param entity
     * @return entity
     */
    InstanceControlLog save(InstanceControlLog entity);

    /**
     * Updates the given entity in the database
     * 
     * @param entity
     * @return
     */
    InstanceControlLog update(InstanceControlLog entity);

    /**
     * Creates the given entity in the database
     * 
     * @param entity
     * @return
     */
    InstanceControlLog create(InstanceControlLog entity);

    /**
     * Deletes an entity using its Primary Key
     * 
     * @param iclId
     */
    void delete(Integer iclId);

}
