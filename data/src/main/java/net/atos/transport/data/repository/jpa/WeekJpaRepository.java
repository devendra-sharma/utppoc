package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.WeekEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : Week.
 */
public interface WeekJpaRepository extends PagingAndSortingRepository<WeekEntity, Integer>
{

}
