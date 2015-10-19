package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.LocationLinkEntity;

/**
 * Repository : LocationLink.
 */
public interface LocationLinkJpaRepository extends PagingAndSortingRepository<LocationLinkEntity, Integer> {

}
