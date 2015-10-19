package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.LocationEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : Location.
 */
public interface LocationJpaRepository extends PagingAndSortingRepository<LocationEntity, Integer> {

}
