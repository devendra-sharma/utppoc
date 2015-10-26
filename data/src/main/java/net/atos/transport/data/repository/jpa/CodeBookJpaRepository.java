package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.CodeBookEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : CodeBook.
 */
public interface CodeBookJpaRepository extends PagingAndSortingRepository<CodeBookEntity, Integer>
{

}
