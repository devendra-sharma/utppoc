package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.RecordFieldEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : RecordField.
 */
public interface RecordFieldJpaRepository extends PagingAndSortingRepository<RecordFieldEntity, Integer>
{

}
