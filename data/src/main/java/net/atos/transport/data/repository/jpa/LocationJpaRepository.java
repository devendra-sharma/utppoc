package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.LocationEntity;

/**
 * Repository : Location.
 */
public interface LocationJpaRepository extends PagingAndSortingRepository<LocationEntity, Integer> {

}
