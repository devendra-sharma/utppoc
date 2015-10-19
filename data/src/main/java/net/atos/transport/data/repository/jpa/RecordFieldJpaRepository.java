package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.RecordFieldEntity;

/**
 * Repository : RecordField.
 */
public interface RecordFieldJpaRepository extends PagingAndSortingRepository<RecordFieldEntity, Integer> {

}
