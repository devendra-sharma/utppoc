/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.TicketStatus;

/**
 * Business Service Interface for entity TicketStatus.
 */
public interface TicketStatusService { 

    /**
     * Loads an entity from the database using its Primary Key
     * @param tisId
     * @return entity
     */
    TicketStatus findById( Integer tisId  ) ;

    /**
     * Loads all entities.
     * @return all entities
     */
    List<TicketStatus> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * @param entity
     * @return entity
     */
    TicketStatus save(TicketStatus entity);

    /**
     * Updates the given entity in the database
     * @param entity
     * @return
     */
    TicketStatus update(TicketStatus entity);

    /**
     * Creates the given entity in the database
     * @param entity
     * @return
     */
    TicketStatus create(TicketStatus entity);

    /**
     * Deletes an entity using its Primary Key
     * @param tisId
     */
    void delete( Integer tisId );


}
