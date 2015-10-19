/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.InstanceControlLog;
import net.atos.transport.entity.jpa.InstanceControlLogEntity;
import net.atos.transport.business.service.InstanceControlLogService;
import net.atos.transport.business.service.mapping.InstanceControlLogServiceMapper;
import net.atos.transport.data.repository.jpa.InstanceControlLogJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of InstanceControlLogService
 */
@Component
@Transactional
public class InstanceControlLogServiceImpl implements InstanceControlLogService {

	@Resource
	private InstanceControlLogJpaRepository instanceControlLogJpaRepository;

	@Resource
	private InstanceControlLogServiceMapper instanceControlLogServiceMapper;
	
	@Override
	public InstanceControlLog findById(Integer iclId) {
		InstanceControlLogEntity instanceControlLogEntity = instanceControlLogJpaRepository.findOne(iclId);
		return instanceControlLogServiceMapper.mapInstanceControlLogEntityToInstanceControlLog(instanceControlLogEntity);
	}

	@Override
	public List<InstanceControlLog> findAll() {
		Iterable<InstanceControlLogEntity> entities = instanceControlLogJpaRepository.findAll();
		List<InstanceControlLog> beans = new ArrayList<InstanceControlLog>();
		for(InstanceControlLogEntity instanceControlLogEntity : entities) {
			beans.add(instanceControlLogServiceMapper.mapInstanceControlLogEntityToInstanceControlLog(instanceControlLogEntity));
		}
		return beans;
	}

	@Override
	public InstanceControlLog save(InstanceControlLog instanceControlLog) {
		return update(instanceControlLog) ;
	}

	@Override
	public InstanceControlLog create(InstanceControlLog instanceControlLog) {
		InstanceControlLogEntity instanceControlLogEntity = instanceControlLogJpaRepository.findOne(instanceControlLog.getIclId());
		if( instanceControlLogEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		instanceControlLogEntity = new InstanceControlLogEntity();
		instanceControlLogServiceMapper.mapInstanceControlLogToInstanceControlLogEntity(instanceControlLog, instanceControlLogEntity);
		InstanceControlLogEntity instanceControlLogEntitySaved = instanceControlLogJpaRepository.save(instanceControlLogEntity);
		return instanceControlLogServiceMapper.mapInstanceControlLogEntityToInstanceControlLog(instanceControlLogEntitySaved);
	}

	@Override
	public InstanceControlLog update(InstanceControlLog instanceControlLog) {
		InstanceControlLogEntity instanceControlLogEntity = instanceControlLogJpaRepository.findOne(instanceControlLog.getIclId());
		instanceControlLogServiceMapper.mapInstanceControlLogToInstanceControlLogEntity(instanceControlLog, instanceControlLogEntity);
		InstanceControlLogEntity instanceControlLogEntitySaved = instanceControlLogJpaRepository.save(instanceControlLogEntity);
		return instanceControlLogServiceMapper.mapInstanceControlLogEntityToInstanceControlLog(instanceControlLogEntitySaved);
	}

	@Override
	public void delete(Integer iclId) {
		instanceControlLogJpaRepository.delete(iclId);
	}

	public InstanceControlLogJpaRepository getInstanceControlLogJpaRepository() {
		return instanceControlLogJpaRepository;
	}

	public void setInstanceControlLogJpaRepository(InstanceControlLogJpaRepository instanceControlLogJpaRepository) {
		this.instanceControlLogJpaRepository = instanceControlLogJpaRepository;
	}

	public InstanceControlLogServiceMapper getInstanceControlLogServiceMapper() {
		return instanceControlLogServiceMapper;
	}

	public void setInstanceControlLogServiceMapper(InstanceControlLogServiceMapper instanceControlLogServiceMapper) {
		this.instanceControlLogServiceMapper = instanceControlLogServiceMapper;
	}

}
