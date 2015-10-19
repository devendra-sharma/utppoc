package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.ProductEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : Product.
 */
public interface ProductJpaRepository extends PagingAndSortingRepository<ProductEntity, Integer> {

}
