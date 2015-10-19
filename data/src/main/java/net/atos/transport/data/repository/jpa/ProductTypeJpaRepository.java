package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.ProductTypeEntity;

/**
 * Repository : ProductType.
 */
public interface ProductTypeJpaRepository extends PagingAndSortingRepository<ProductTypeEntity, Integer> {

}