/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.Route;

/**
 * Business Service Interface for entity Route.
 */
public interface RouteService { 

    /**
     * Loads an entity from the database using its Primary Key
     * @param rouId
     * @return entity
     */
    Route findById( Integer rouId  ) ;

    /**
     * Loads all entities.
     * @return all entities
     */
    List<Route> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * @param entity
     * @return entity
     */
    Route save(Route entity);

    /**
     * Updates the given entity in the database
     * @param entity
     * @return
     */
    Route update(Route entity);

    /**
     * Creates the given entity in the database
     * @param entity
     * @return
     */
    Route create(Route entity);

    /**
     * Deletes an entity using its Primary Key
     * @param rouId
     */
    void delete( Integer rouId );


}
