/*


 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.ProductLink;

/**
 * Business Service Interface for entity ProductLink.
 */
public interface ProductLinkService { 

    /**
     * Loads an entity from the database using its Primary Key
     * @return entity
     */
    ProductLink findById(Integer proLinkId) ;

    /**
     * Loads all entities.
     * @return all entities
     */
    List<ProductLink> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * @param entity
     * @return entity
     */
    ProductLink save(ProductLink entity);

    /**
     * Updates the given entity in the database
     * @param entity
     * @return
     */
    ProductLink update(ProductLink entity);

    /**
     * Creates the given entity in the database
     * @param entity
     * @return
     */
    ProductLink create(ProductLink entity);

    /**
     * Deletes an entity using its Primary Key
     */
    void delete(Integer proId );


}
