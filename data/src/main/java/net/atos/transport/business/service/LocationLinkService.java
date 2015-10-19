/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.LocationLink;

/**
 * Business Service Interface for entity LocationLink.
 */
public interface LocationLinkService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param lolId
	 * @return entity
	 */
	LocationLink findById( Integer lolId  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<LocationLink> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	LocationLink save(LocationLink entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	LocationLink update(LocationLink entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	LocationLink create(LocationLink entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param lolId
	 */
	void delete( Integer lolId );


}
