package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.RouteEntity;

/**
 * Repository : Route.
 */
public interface RouteJpaRepository extends PagingAndSortingRepository<RouteEntity, Integer> {

}
