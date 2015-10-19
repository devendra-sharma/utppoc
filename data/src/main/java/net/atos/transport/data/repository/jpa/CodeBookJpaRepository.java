package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.CodeBookEntity;

/**
 * Repository : CodeBook.
 */
public interface CodeBookJpaRepository extends PagingAndSortingRepository<CodeBookEntity, Integer> {

}
