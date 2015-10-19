package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.LocationTypeEntity;

/**
 * Repository : LocationType.
 */
public interface LocationTypeJpaRepository extends PagingAndSortingRepository<LocationTypeEntity, Integer> {

}
