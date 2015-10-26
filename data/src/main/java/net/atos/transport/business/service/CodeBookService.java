/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.CodeBook;

/**
 * Business Service Interface for entity CodeBook.
 */
public interface CodeBookService
{

    /**
     * Loads an entity from the database using its Primary Key
     * 
     * @param cobId
     * @return entity
     */
    CodeBook findById(Integer cobId);

    /**
     * Loads all entities.
     * 
     * @return all entities
     */
    List<CodeBook> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * 
     * @param entity
     * @return entity
     */
    CodeBook save(CodeBook entity);

    /**
     * Updates the given entity in the database
     * 
     * @param entity
     * @return
     */
    CodeBook update(CodeBook entity);

    /**
     * Creates the given entity in the database
     * 
     * @param entity
     * @return
     */
    CodeBook create(CodeBook entity);

    /**
     * Deletes an entity using its Primary Key
     * 
     * @param cobId
     */
    void delete(Integer cobId);

}
