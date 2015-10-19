/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.business.service.ProcessControlService;
import net.atos.transport.business.service.mapping.ProcessControlServiceMapper;
import net.atos.transport.data.repository.jpa.ProcessControlJpaRepository;
import net.atos.transport.entity.ProcessControl;
import net.atos.transport.entity.jpa.ProcessControlEntity;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ProcessControlService
 */
@Component
@Transactional
public class ProcessControlServiceImpl implements ProcessControlService {

    @Resource
    private ProcessControlJpaRepository processControlJpaRepository;

    @Resource
    private ProcessControlServiceMapper processControlServiceMapper;
    
    @Override
    public ProcessControl findById(Integer processId) {
        ProcessControlEntity processControlEntity = processControlJpaRepository.findOne(processId);
        return processControlServiceMapper.mapProcessControlEntityToProcessControl(processControlEntity);
    }

    @Override
    public List<ProcessControl> findAll() {
        Iterable<ProcessControlEntity> entities = processControlJpaRepository.findAll();
        List<ProcessControl> beans = new ArrayList<ProcessControl>();
        for(ProcessControlEntity processControlEntity : entities) {
            beans.add(processControlServiceMapper.mapProcessControlEntityToProcessControl(processControlEntity));
        }
        return beans;
    }

    @Override
    public ProcessControl save(ProcessControl processControl) {
        return update(processControl) ;
    }

    @Override
    public ProcessControl create(ProcessControl processControl) {
        ProcessControlEntity processControlEntity = processControlJpaRepository.findOne(processControl.getProcessId());
        if( processControlEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        processControlEntity = new ProcessControlEntity();
        processControlServiceMapper.mapProcessControlToProcessControlEntity(processControl, processControlEntity);
        ProcessControlEntity processControlEntitySaved = processControlJpaRepository.save(processControlEntity);
        return processControlServiceMapper.mapProcessControlEntityToProcessControl(processControlEntitySaved);
    }

    @Override
    public ProcessControl update(ProcessControl processControl) {
        ProcessControlEntity processControlEntity = processControlJpaRepository.findOne(processControl.getProcessId());
        processControlServiceMapper.mapProcessControlToProcessControlEntity(processControl, processControlEntity);
        ProcessControlEntity processControlEntitySaved = processControlJpaRepository.save(processControlEntity);
        return processControlServiceMapper.mapProcessControlEntityToProcessControl(processControlEntitySaved);
    }

    @Override
    public void delete(Integer processId) {
        processControlJpaRepository.delete(processId);
    }

    public ProcessControlJpaRepository getProcessControlJpaRepository() {
        return processControlJpaRepository;
    }

    public void setProcessControlJpaRepository(ProcessControlJpaRepository processControlJpaRepository) {
        this.processControlJpaRepository = processControlJpaRepository;
    }

    public ProcessControlServiceMapper getProcessControlServiceMapper() {
        return processControlServiceMapper;
    }

    public void setProcessControlServiceMapper(ProcessControlServiceMapper processControlServiceMapper) {
        this.processControlServiceMapper = processControlServiceMapper;
    }

}
