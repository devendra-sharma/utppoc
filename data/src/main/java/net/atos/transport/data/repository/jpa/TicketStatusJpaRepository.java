package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.TicketStatusEntity;

/**
 * Repository : TicketStatus.
 */
public interface TicketStatusJpaRepository extends PagingAndSortingRepository<TicketStatusEntity, Integer> {

}
