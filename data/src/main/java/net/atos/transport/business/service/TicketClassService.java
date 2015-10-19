/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.TicketClass;

/**
 * Business Service Interface for entity TicketClass.
 */
public interface TicketClassService { 

    /**
     * Loads an entity from the database using its Primary Key
     * @param ticId
     * @return entity
     */
    TicketClass findById( Integer ticId  ) ;

    /**
     * Loads all entities.
     * @return all entities
     */
    List<TicketClass> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * @param entity
     * @return entity
     */
    TicketClass save(TicketClass entity);

    /**
     * Updates the given entity in the database
     * @param entity
     * @return
     */
    TicketClass update(TicketClass entity);

    /**
     * Creates the given entity in the database
     * @param entity
     * @return
     */
    TicketClass create(TicketClass entity);

    /**
     * Deletes an entity using its Primary Key
     * @param ticId
     */
    void delete( Integer ticId );


}
