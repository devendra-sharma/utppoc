package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.LocationTypeEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : LocationType.
 */
public interface LocationTypeJpaRepository extends PagingAndSortingRepository<LocationTypeEntity, Integer> {

}
