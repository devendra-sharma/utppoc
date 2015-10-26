/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.RouteLink;

/**
 * Business Service Interface for entity RouteLink.
 */
public interface RouteLinkService
{

    /**
     * Loads an entity from the database using its Primary Key
     * 
     * @param rolId
     * @return entity
     */
    RouteLink findById(Integer rolId);

    /**
     * Loads all entities.
     * 
     * @return all entities
     */
    List<RouteLink> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * 
     * @param entity
     * @return entity
     */
    RouteLink save(RouteLink entity);

    /**
     * Updates the given entity in the database
     * 
     * @param entity
     * @return
     */
    RouteLink update(RouteLink entity);

    /**
     * Creates the given entity in the database
     * 
     * @param entity
     * @return
     */
    RouteLink create(RouteLink entity);

    /**
     * Deletes an entity using its Primary Key
     * 
     * @param rolId
     */
    void delete(Integer rolId);

}
