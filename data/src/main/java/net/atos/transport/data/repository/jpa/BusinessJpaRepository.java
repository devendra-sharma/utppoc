package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.BusinessEntity;

/**
 * Repository : Business.
 */
public interface BusinessJpaRepository extends PagingAndSortingRepository<BusinessEntity, Integer> {

}
