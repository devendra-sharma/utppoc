package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.TicketAllocationCodeEntity;

/**
 * Repository : TicketAllocationCode.
 */
public interface TicketAllocationCodeJpaRepository extends PagingAndSortingRepository<TicketAllocationCodeEntity, Integer> {

}
