/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.ProductType;

/**
 * Business Service Interface for entity ProductType.
 */
public interface ProductTypeService
{

    /**
     * Loads an entity from the database using its Primary Key
     * 
     * @param prtId
     * @return entity
     */
    ProductType findById(Integer prtId);

    /**
     * Loads all entities.
     * 
     * @return all entities
     */
    List<ProductType> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * 
     * @param entity
     * @return entity
     */
    ProductType save(ProductType entity);

    /**
     * Updates the given entity in the database
     * 
     * @param entity
     * @return
     */
    ProductType update(ProductType entity);

    /**
     * Creates the given entity in the database
     * 
     * @param entity
     * @return
     */
    ProductType create(ProductType entity);

    /**
     * Deletes an entity using its Primary Key
     * 
     * @param prtId
     */
    void delete(Integer prtId);

}
