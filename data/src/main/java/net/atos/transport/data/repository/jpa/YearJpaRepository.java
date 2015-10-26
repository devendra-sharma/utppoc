package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.YearEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : Year.
 */
public interface YearJpaRepository extends PagingAndSortingRepository<YearEntity, Integer>
{

}
