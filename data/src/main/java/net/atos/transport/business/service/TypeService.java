/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.Type;

/**
 * Business Service Interface for entity Type.
 */
public interface TypeService
{

    /**
     * Loads an entity from the database using its Primary Key
     * 
     * @param typId
     * @return entity
     */
    Type findById(Integer typId);

    /**
     * Loads all entities.
     * 
     * @return all entities
     */
    List<Type> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * 
     * @param entity
     * @return entity
     */
    Type save(Type entity);

    /**
     * Updates the given entity in the database
     * 
     * @param entity
     * @return
     */
    Type update(Type entity);

    /**
     * Creates the given entity in the database
     * 
     * @param entity
     * @return
     */
    Type create(Type entity);

    /**
     * Deletes an entity using its Primary Key
     * 
     * @param typId
     */
    void delete(Integer typId);

}
