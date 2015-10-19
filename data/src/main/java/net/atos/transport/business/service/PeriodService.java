/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.Period;

/**
 * Business Service Interface for entity Period.
 */
public interface PeriodService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param perId
	 * @return entity
	 */
	Period findById( Integer perId  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Period> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Period save(Period entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Period update(Period entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Period create(Period entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param perId
	 */
	void delete( Integer perId );


}
