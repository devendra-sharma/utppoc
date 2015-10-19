package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.RouteLinkEntity;

/**
 * Repository : RouteLink.
 */
public interface RouteLinkJpaRepository extends PagingAndSortingRepository<RouteLinkEntity, Integer> {

}
