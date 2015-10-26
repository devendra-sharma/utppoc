package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.PeriodEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : Period.
 */
public interface PeriodJpaRepository extends PagingAndSortingRepository<PeriodEntity, Integer>
{

}
