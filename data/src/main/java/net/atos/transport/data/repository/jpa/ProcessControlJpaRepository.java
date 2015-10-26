package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.ProcessControlEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : ProcessControl.
 */
public interface ProcessControlJpaRepository extends PagingAndSortingRepository<ProcessControlEntity, Integer>
{

}
