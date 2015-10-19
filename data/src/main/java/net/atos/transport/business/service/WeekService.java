/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.Week;

/**
 * Business Service Interface for entity Week.
 */
public interface WeekService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param weekId
	 * @return entity
	 */
	Week findById( Integer weekId  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Week> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Week save(Week entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Week update(Week entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Week create(Week entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param weekId
	 */
	void delete( Integer weekId );


}
