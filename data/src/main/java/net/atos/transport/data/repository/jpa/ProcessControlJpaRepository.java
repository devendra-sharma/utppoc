package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.ProcessControlEntity;

/**
 * Repository : ProcessControl.
 */
public interface ProcessControlJpaRepository extends PagingAndSortingRepository<ProcessControlEntity, Integer> {

}
