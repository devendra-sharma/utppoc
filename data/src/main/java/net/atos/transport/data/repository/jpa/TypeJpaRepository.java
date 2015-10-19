package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.TypeEntity;

/**
 * Repository : Type.
 */
public interface TypeJpaRepository extends PagingAndSortingRepository<TypeEntity, Integer> {

}
