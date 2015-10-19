package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.TicketStatusLinkEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : TicketStatusLink.
 */
public interface TicketStatusLinkJpaRepository extends PagingAndSortingRepository<TicketStatusLinkEntity, Integer> {

}
