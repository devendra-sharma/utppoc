/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.GroupFunctionType;

/**
 * Business Service Interface for entity GroupFunctionType.
 */
public interface GroupFunctionTypeService { 

    /**
     * Loads an entity from the database using its Primary Key
     * @param gftId
     * @return entity
     */
    GroupFunctionType findById( Integer gftId  ) ;

    /**
     * Loads all entities.
     * @return all entities
     */
    List<GroupFunctionType> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * @param entity
     * @return entity
     */
    GroupFunctionType save(GroupFunctionType entity);

    /**
     * Updates the given entity in the database
     * @param entity
     * @return
     */
    GroupFunctionType update(GroupFunctionType entity);

    /**
     * Creates the given entity in the database
     * @param entity
     * @return
     */
    GroupFunctionType create(GroupFunctionType entity);

    /**
     * Deletes an entity using its Primary Key
     * @param gftId
     */
    void delete( Integer gftId );


}
