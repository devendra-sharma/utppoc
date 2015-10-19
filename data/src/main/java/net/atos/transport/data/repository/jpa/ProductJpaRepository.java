package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.ProductEntity;

/**
 * Repository : Product.
 */
public interface ProductJpaRepository extends PagingAndSortingRepository<ProductEntity, Integer> {

}
