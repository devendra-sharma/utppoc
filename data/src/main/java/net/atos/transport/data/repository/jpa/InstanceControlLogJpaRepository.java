package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.InstanceControlLogEntity;

/**
 * Repository : InstanceControlLog.
 */
public interface InstanceControlLogJpaRepository extends PagingAndSortingRepository<InstanceControlLogEntity, Integer> {

}
