package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.RouteLinkEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : RouteLink.
 */
public interface RouteLinkJpaRepository extends PagingAndSortingRepository<RouteLinkEntity, Integer> {

}
