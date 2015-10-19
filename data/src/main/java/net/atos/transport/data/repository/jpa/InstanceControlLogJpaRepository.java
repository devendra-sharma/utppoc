package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.InstanceControlLogEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : InstanceControlLog.
 */
public interface InstanceControlLogJpaRepository extends PagingAndSortingRepository<InstanceControlLogEntity, Integer> {

}
