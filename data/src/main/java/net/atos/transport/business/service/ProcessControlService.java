/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.ProcessControl;

/**
 * Business Service Interface for entity ProcessControl.
 */
public interface ProcessControlService { 

    /**
     * Loads an entity from the database using its Primary Key
     * @param processId
     * @return entity
     */
    ProcessControl findById( Integer processId  ) ;

    /**
     * Loads all entities.
     * @return all entities
     */
    List<ProcessControl> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * @param entity
     * @return entity
     */
    ProcessControl save(ProcessControl entity);

    /**
     * Updates the given entity in the database
     * @param entity
     * @return
     */
    ProcessControl update(ProcessControl entity);

    /**
     * Creates the given entity in the database
     * @param entity
     * @return
     */
    ProcessControl create(ProcessControl entity);

    /**
     * Deletes an entity using its Primary Key
     * @param processId
     */
    void delete( Integer processId );


}
