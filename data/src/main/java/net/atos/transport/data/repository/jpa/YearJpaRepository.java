package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.YearEntity;

/**
 * Repository : Year.
 */
public interface YearJpaRepository extends PagingAndSortingRepository<YearEntity, Integer> {

}
