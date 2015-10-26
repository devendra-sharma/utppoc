/*


 */
package net.atos.transport.business.service;

import java.util.List;
import java.util.Date;
import net.atos.transport.entity.Calendar;

/**
 * Business Service Interface for entity Calendar.
 */
public interface CalendarService
{

    /**
     * Loads an entity from the database using its Primary Key
     * 
     * @param calId
     * @return entity
     */
    Calendar findById(Integer calId);

    /**
     * Loads all entities.
     * 
     * @return all entities
     */
    List<Calendar> findAll();

    /**
     * Saves the given entity in the database (create or update)
     * 
     * @param entity
     * @return entity
     */
    Calendar save(Calendar entity);

    /**
     * Updates the given entity in the database
     * 
     * @param entity
     * @return
     */
    Calendar update(Calendar entity);

    /**
     * Creates the given entity in the database
     * 
     * @param entity
     * @return
     */
    Calendar create(Calendar entity);

    /**
     * Deletes an entity using its Primary Key
     * 
     * @param calId
     */
    void delete(Integer calId);

    public List<Calendar> getbyCalendarIds(List<Integer> ids);

    /**
     * Retrieves the Calendar for saleDate.
     * 
     * @param saleDate
     * @return
     */
    public Calendar findBySaleDate(Date saleDate);
}
