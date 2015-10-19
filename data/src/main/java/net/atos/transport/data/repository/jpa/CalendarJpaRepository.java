package net.atos.transport.data.repository.jpa;


import java.util.List;

import net.atos.transport.entity.jpa.CalendarEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : Calendar.
 */
public interface CalendarJpaRepository extends PagingAndSortingRepository<CalendarEntity, Integer> {

    public List<CalendarEntity> findByCalIdIn(List<Integer> ids);
}
