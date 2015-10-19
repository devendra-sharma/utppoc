package net.atos.transport.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import net.atos.transport.entity.jpa.ApplicationParametersEntity;

/**
 * Repository : ApplicationParameters.
 */
public interface ApplicationParametersJpaRepository extends PagingAndSortingRepository<ApplicationParametersEntity, Integer> {

}
