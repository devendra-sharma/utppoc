/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.Business;

/**
 * Business Service Interface for entity Business.
 */
public interface BusinessService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param busId
	 * @return entity
	 */
	Business findById( Integer busId  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Business> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Business save(Business entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Business update(Business entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Business create(Business entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param busId
	 */
	void delete( Integer busId );


}
