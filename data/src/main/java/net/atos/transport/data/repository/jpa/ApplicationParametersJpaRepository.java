package net.atos.transport.data.repository.jpa;

import net.atos.transport.entity.jpa.ApplicationParametersEntity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : ApplicationParameters.
 */
public interface ApplicationParametersJpaRepository extends PagingAndSortingRepository<ApplicationParametersEntity, Integer> {

}
