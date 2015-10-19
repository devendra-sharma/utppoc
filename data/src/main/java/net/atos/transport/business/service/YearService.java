/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.Year;

/**
 * Business Service Interface for entity Year.
 */
public interface YearService { 

    /**
     * Loads an entity from the database using its Primary Key
     * @param year
     * @return entity
     */
    Year findById( Integer year  ) ;

    /**
     * Loads all entities.
     * @return all entities
     */
    List<Year> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * @param entity
     * @return entity
     */
    Year save(Year entity);

    /**
     * Updates the given entity in the database
     * @param entity
     * @return
     */
    Year update(Year entity);

    /**
     * Creates the given entity in the database
     * @param entity
     * @return
     */
    Year create(Year entity);

    /**
     * Deletes an entity using its Primary Key
     * @param year
     */
    void delete( Integer year );


}
