package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.TicketClassEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : TicketClass.
 */
public interface TicketClassJpaRepository extends PagingAndSortingRepository<TicketClassEntity, Integer>
{

}
