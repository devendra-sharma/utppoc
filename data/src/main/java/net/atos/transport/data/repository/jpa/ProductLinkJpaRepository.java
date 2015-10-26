package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.ProductLinkEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : Product.
 */
public interface ProductLinkJpaRepository extends PagingAndSortingRepository<ProductLinkEntity, Integer>
{

}
