package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.LocationLinkEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : LocationLink.
 */
public interface LocationLinkJpaRepository extends PagingAndSortingRepository<LocationLinkEntity, Integer>
{

}
