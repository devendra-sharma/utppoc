package net.atos.transport.data.repository.jpa;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.atos.transport.entity.jpa.CalendarEntity;

/**
 * Repository : Calendar.
 */
public interface CalendarJpaRepository extends PagingAndSortingRepository<CalendarEntity, Integer> {

    public List<CalendarEntity> findByCalIdIn(List<Integer> ids);
}
