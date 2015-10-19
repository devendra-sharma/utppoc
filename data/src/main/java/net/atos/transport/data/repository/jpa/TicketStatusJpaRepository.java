package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.TicketStatusEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : TicketStatus.
 */
public interface TicketStatusJpaRepository extends PagingAndSortingRepository<TicketStatusEntity, Integer> {

}
