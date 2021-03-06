/*
 * Created on 15 Oct 2015 ( Time 20:28:30 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package net.atos.transport.business.service;

import java.util.List;

import net.atos.transport.entity.FaresCheckingExclusion;

/**
 * Business Service Interface for entity FaresCheckingExclusion.
 */
public interface FaresCheckingExclusionService
{

    /**
     * Loads an entity from the database using its Primary Key
     * 
     * @param faresCheckingExclusionId
     * @return entity
     */
    FaresCheckingExclusion findById(Long faresCheckingExclusionId);

    /**
     * Loads all entities.
     * 
     * @return all entities
     */
    List<FaresCheckingExclusion> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * 
     * @param entity
     * @return entity
     */
    FaresCheckingExclusion save(FaresCheckingExclusion entity);

    /**
     * Updates the given entity in the database
     * 
     * @param entity
     * @return
     */
    FaresCheckingExclusion update(FaresCheckingExclusion entity);

    /**
     * Creates the given entity in the database
     * 
     * @param entity
     * @return
     */
    FaresCheckingExclusion create(FaresCheckingExclusion entity);

    /**
     * Deletes an entity using its Primary Key
     * 
     * @param faresCheckingExclusionId
     */
    void delete(Long faresCheckingExclusionId);

    /**
     * Gets an entity using the parameters
     * 
     * @param faresCheckingExclusionId
     */
    FaresCheckingExclusion getFaresExclusionByParams(String sellingLocation, String originLocation,
            String destinationLocation, String route, String product, String ticketStatus);

}
