/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.ApplicationParameters;

/**
 * Business Service Interface for entity ApplicationParameters.
 */
public interface ApplicationParametersService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param applicationParametersId
	 * @return entity
	 */
	ApplicationParameters findById( Integer applicationParametersId  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<ApplicationParameters> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	ApplicationParameters save(ApplicationParameters entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	ApplicationParameters update(ApplicationParameters entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	ApplicationParameters create(ApplicationParameters entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param applicationParametersId
	 */
	void delete( Integer applicationParametersId );


}
