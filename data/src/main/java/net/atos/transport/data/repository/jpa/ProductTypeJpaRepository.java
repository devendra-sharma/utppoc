package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.ProductTypeEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : ProductType.
 */
public interface ProductTypeJpaRepository extends PagingAndSortingRepository<ProductTypeEntity, Integer> {

}
