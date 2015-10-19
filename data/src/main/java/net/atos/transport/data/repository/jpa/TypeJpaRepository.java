package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.TypeEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : Type.
 */
public interface TypeJpaRepository extends PagingAndSortingRepository<TypeEntity, Integer> {

}
