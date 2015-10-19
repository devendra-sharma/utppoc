/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.ApplicationParameters;
import net.atos.transport.entity.jpa.ApplicationParametersEntity;
import net.atos.transport.business.service.ApplicationParametersService;
import net.atos.transport.business.service.mapping.ApplicationParametersServiceMapper;
import net.atos.transport.data.repository.jpa.ApplicationParametersJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ApplicationParametersService
 */
@Component
@Transactional
public class ApplicationParametersServiceImpl implements ApplicationParametersService {

    @Resource
    private ApplicationParametersJpaRepository applicationParametersJpaRepository;

    @Resource
    private ApplicationParametersServiceMapper applicationParametersServiceMapper;
    
    @Override
    public ApplicationParameters findById(Integer applicationParametersId) {
        ApplicationParametersEntity applicationParametersEntity = applicationParametersJpaRepository.findOne(applicationParametersId);
        return applicationParametersServiceMapper.mapApplicationParametersEntityToApplicationParameters(applicationParametersEntity);
    }

    @Override
    public List<ApplicationParameters> findAll() {
        Iterable<ApplicationParametersEntity> entities = applicationParametersJpaRepository.findAll();
        List<ApplicationParameters> beans = new ArrayList<ApplicationParameters>();
        for(ApplicationParametersEntity applicationParametersEntity : entities) {
            beans.add(applicationParametersServiceMapper.mapApplicationParametersEntityToApplicationParameters(applicationParametersEntity));
        }
        return beans;
    }

    @Override
    public ApplicationParameters save(ApplicationParameters applicationParameters) {
        return update(applicationParameters) ;
    }

    @Override
    public ApplicationParameters create(ApplicationParameters applicationParameters) {
        ApplicationParametersEntity applicationParametersEntity = applicationParametersJpaRepository.findOne(applicationParameters.getApplicationParametersId());
        if( applicationParametersEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        applicationParametersEntity = new ApplicationParametersEntity();
        applicationParametersServiceMapper.mapApplicationParametersToApplicationParametersEntity(applicationParameters, applicationParametersEntity);
        ApplicationParametersEntity applicationParametersEntitySaved = applicationParametersJpaRepository.save(applicationParametersEntity);
        return applicationParametersServiceMapper.mapApplicationParametersEntityToApplicationParameters(applicationParametersEntitySaved);
    }

    @Override
    public ApplicationParameters update(ApplicationParameters applicationParameters) {
        ApplicationParametersEntity applicationParametersEntity = applicationParametersJpaRepository.findOne(applicationParameters.getApplicationParametersId());
        applicationParametersServiceMapper.mapApplicationParametersToApplicationParametersEntity(applicationParameters, applicationParametersEntity);
        ApplicationParametersEntity applicationParametersEntitySaved = applicationParametersJpaRepository.save(applicationParametersEntity);
        return applicationParametersServiceMapper.mapApplicationParametersEntityToApplicationParameters(applicationParametersEntitySaved);
    }

    @Override
    public void delete(Integer applicationParametersId) {
        applicationParametersJpaRepository.delete(applicationParametersId);
    }

    public ApplicationParametersJpaRepository getApplicationParametersJpaRepository() {
        return applicationParametersJpaRepository;
    }

    public void setApplicationParametersJpaRepository(ApplicationParametersJpaRepository applicationParametersJpaRepository) {
        this.applicationParametersJpaRepository = applicationParametersJpaRepository;
    }

    public ApplicationParametersServiceMapper getApplicationParametersServiceMapper() {
        return applicationParametersServiceMapper;
    }

    public void setApplicationParametersServiceMapper(ApplicationParametersServiceMapper applicationParametersServiceMapper) {
        this.applicationParametersServiceMapper = applicationParametersServiceMapper;
    }

}
