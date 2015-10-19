/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.TicketStatusLink;

/**
 * Business Service Interface for entity TicketStatusLink.
 */
public interface TicketStatusLinkService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param tslId
	 * @return entity
	 */
	TicketStatusLink findById( Integer tslId  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<TicketStatusLink> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	TicketStatusLink save(TicketStatusLink entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	TicketStatusLink update(TicketStatusLink entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	TicketStatusLink create(TicketStatusLink entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param tslId
	 */
	void delete( Integer tslId );


}
