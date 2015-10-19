package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.WeekEntity;

/**
 * Repository : Week.
 */
public interface WeekJpaRepository extends PagingAndSortingRepository<WeekEntity, Integer> {

}
