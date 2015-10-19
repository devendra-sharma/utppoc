/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.Type;
import net.atos.transport.entity.jpa.TypeEntity;
import net.atos.transport.business.service.TypeService;
import net.atos.transport.business.service.mapping.TypeServiceMapper;
import net.atos.transport.data.repository.jpa.TypeJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of TypeService
 */
@Component
@Transactional
public class TypeServiceImpl implements TypeService {

	@Resource
	private TypeJpaRepository typeJpaRepository;

	@Resource
	private TypeServiceMapper typeServiceMapper;
	
	@Override
	public Type findById(Integer typId) {
		TypeEntity typeEntity = typeJpaRepository.findOne(typId);
		return typeServiceMapper.mapTypeEntityToType(typeEntity);
	}

	@Override
	public List<Type> findAll() {
		Iterable<TypeEntity> entities = typeJpaRepository.findAll();
		List<Type> beans = new ArrayList<Type>();
		for(TypeEntity typeEntity : entities) {
			beans.add(typeServiceMapper.mapTypeEntityToType(typeEntity));
		}
		return beans;
	}

	@Override
	public Type save(Type type) {
		return update(type) ;
	}

	@Override
	public Type create(Type type) {
		TypeEntity typeEntity = typeJpaRepository.findOne(type.getTypId());
		if( typeEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		typeEntity = new TypeEntity();
		typeServiceMapper.mapTypeToTypeEntity(type, typeEntity);
		TypeEntity typeEntitySaved = typeJpaRepository.save(typeEntity);
		return typeServiceMapper.mapTypeEntityToType(typeEntitySaved);
	}

	@Override
	public Type update(Type type) {
		TypeEntity typeEntity = typeJpaRepository.findOne(type.getTypId());
		typeServiceMapper.mapTypeToTypeEntity(type, typeEntity);
		TypeEntity typeEntitySaved = typeJpaRepository.save(typeEntity);
		return typeServiceMapper.mapTypeEntityToType(typeEntitySaved);
	}

	@Override
	public void delete(Integer typId) {
		typeJpaRepository.delete(typId);
	}

	public TypeJpaRepository getTypeJpaRepository() {
		return typeJpaRepository;
	}

	public void setTypeJpaRepository(TypeJpaRepository typeJpaRepository) {
		this.typeJpaRepository = typeJpaRepository;
	}

	public TypeServiceMapper getTypeServiceMapper() {
		return typeServiceMapper;
	}

	public void setTypeServiceMapper(TypeServiceMapper typeServiceMapper) {
		this.typeServiceMapper = typeServiceMapper;
	}

}
