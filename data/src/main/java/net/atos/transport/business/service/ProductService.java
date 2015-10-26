/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.Product;

/**
 * Business Service Interface for entity Product.
 */
public interface ProductService
{

    /**
     * Loads an entity from the database using its Primary Key
     * 
     * @param proId
     * @return entity
     */
    Product findById(Integer proId);

    /**
     * Loads all entities.
     * 
     * @return all entities
     */
    List<Product> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * 
     * @param entity
     * @return entity
     */
    Product save(Product entity);

    /**
     * Updates the given entity in the database
     * 
     * @param entity
     * @return
     */
    Product update(Product entity);

    /**
     * Creates the given entity in the database
     * 
     * @param entity
     * @return
     */
    Product create(Product entity);

    /**
     * Deletes an entity using its Primary Key
     * 
     * @param proId
     */
    void delete(Integer proId);

}
