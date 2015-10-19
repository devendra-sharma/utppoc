package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.TicketAllocationCodeEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : TicketAllocationCode.
 */
public interface TicketAllocationCodeJpaRepository extends PagingAndSortingRepository<TicketAllocationCodeEntity, Integer> {

}
