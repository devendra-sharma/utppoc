/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.TicketAllocationCode;

/**
 * Business Service Interface for entity TicketAllocationCode.
 */
public interface TicketAllocationCodeService
{

    /**
     * Loads an entity from the database using its Primary Key
     * 
     * @param tacId
     * @return entity
     */
    TicketAllocationCode findById(Integer tacId);

    /**
     * Loads all entities.
     * 
     * @return all entities
     */
    List<TicketAllocationCode> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * 
     * @param entity
     * @return entity
     */
    TicketAllocationCode save(TicketAllocationCode entity);

    /**
     * Updates the given entity in the database
     * 
     * @param entity
     * @return
     */
    TicketAllocationCode update(TicketAllocationCode entity);

    /**
     * Creates the given entity in the database
     * 
     * @param entity
     * @return
     */
    TicketAllocationCode create(TicketAllocationCode entity);

    /**
     * Deletes an entity using its Primary Key
     * 
     * @param tacId
     */
    void delete(Integer tacId);

}
