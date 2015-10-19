/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.Location;

/**
 * Business Service Interface for entity Location.
 */
public interface LocationService { 

    /**
     * Loads an entity from the database using its Primary Key
     * @param locId
     * @return entity
     */
    Location findById( Integer locId  ) ;

    /**
     * Loads all entities.
     * @return all entities
     */
    List<Location> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * @param entity
     * @return entity
     */
    Location save(Location entity);

    /**
     * Updates the given entity in the database
     * @param entity
     * @return
     */
    Location update(Location entity);

    /**
     * Creates the given entity in the database
     * @param entity
     * @return
     */
    Location create(Location entity);

    /**
     * Deletes an entity using its Primary Key
     * @param locId
     */
    void delete( Integer locId );


}
