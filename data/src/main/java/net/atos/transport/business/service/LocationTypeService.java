/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.LocationType;

/**
 * Business Service Interface for entity LocationType.
 */
public interface LocationTypeService
{

    /**
     * Loads an entity from the database using its Primary Key
     * 
     * @param lotId
     * @return entity
     */
    LocationType findById(Integer lotId);

    /**
     * Loads all entities.
     * 
     * @return all entities
     */
    List<LocationType> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * 
     * @param entity
     * @return entity
     */
    LocationType save(LocationType entity);

    /**
     * Updates the given entity in the database
     * 
     * @param entity
     * @return
     */
    LocationType update(LocationType entity);

    /**
     * Creates the given entity in the database
     * 
     * @param entity
     * @return
     */
    LocationType create(LocationType entity);

    /**
     * Deletes an entity using its Primary Key
     * 
     * @param lotId
     */
    void delete(Integer lotId);

}
