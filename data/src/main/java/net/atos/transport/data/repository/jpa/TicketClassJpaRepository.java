package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.TicketClassEntity;

/**
 * Repository : TicketClass.
 */
public interface TicketClassJpaRepository extends PagingAndSortingRepository<TicketClassEntity, Integer> {

}
