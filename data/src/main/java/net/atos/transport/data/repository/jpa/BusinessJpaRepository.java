package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.BusinessEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : Business.
 */
public interface BusinessJpaRepository extends PagingAndSortingRepository<BusinessEntity, Integer> {

}
