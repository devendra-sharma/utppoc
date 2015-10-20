package net.atos.transport.data.repository.jpa;


import java.util.List;
import java.util.Date;
import net.atos.transport.entity.jpa.CalendarEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Repository : Calendar.
 */
public interface CalendarJpaRepository extends PagingAndSortingRepository<CalendarEntity, Integer> {

    public List<CalendarEntity> findByCalIdIn(List<Integer> ids);
    
    @Query("select c from CalendarEntity c where c.calendarDate = :saleDate")
    CalendarEntity findBySaleDate(
            @Param("saleDate") Date saleDate);
}
