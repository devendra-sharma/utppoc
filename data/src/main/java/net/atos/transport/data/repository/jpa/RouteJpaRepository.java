package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.RouteEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : Route.
 */
public interface RouteJpaRepository extends PagingAndSortingRepository<RouteEntity, Integer> {

}
