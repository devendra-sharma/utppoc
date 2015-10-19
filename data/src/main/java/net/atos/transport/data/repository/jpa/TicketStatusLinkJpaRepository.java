package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.TicketStatusLinkEntity;

/**
 * Repository : TicketStatusLink.
 */
public interface TicketStatusLinkJpaRepository extends PagingAndSortingRepository<TicketStatusLinkEntity, Integer> {

}
