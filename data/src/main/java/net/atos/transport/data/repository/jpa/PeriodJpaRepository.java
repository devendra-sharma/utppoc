package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.PeriodEntity;

/**
 * Repository : Period.
 */
public interface PeriodJpaRepository extends PagingAndSortingRepository<PeriodEntity, Integer> {

}
