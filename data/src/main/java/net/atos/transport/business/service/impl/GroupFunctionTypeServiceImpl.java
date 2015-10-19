/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.GroupFunctionType;
import net.atos.transport.entity.jpa.GroupFunctionTypeEntity;
import net.atos.transport.business.service.GroupFunctionTypeService;
import net.atos.transport.business.service.mapping.GroupFunctionTypeServiceMapper;
import net.atos.transport.data.repository.jpa.GroupFunctionTypeJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of GroupFunctionTypeService
 */
@Component
@Transactional
public class GroupFunctionTypeServiceImpl implements GroupFunctionTypeService {

    @Resource
    private GroupFunctionTypeJpaRepository groupFunctionTypeJpaRepository;

    @Resource
    private GroupFunctionTypeServiceMapper groupFunctionTypeServiceMapper;
    
    @Override
    public GroupFunctionType findById(Integer gftId) {
        GroupFunctionTypeEntity groupFunctionTypeEntity = groupFunctionTypeJpaRepository.findOne(gftId);
        return groupFunctionTypeServiceMapper.mapGroupFunctionTypeEntityToGroupFunctionType(groupFunctionTypeEntity);
    }

    @Override
    public List<GroupFunctionType> findAll() {
        Iterable<GroupFunctionTypeEntity> entities = groupFunctionTypeJpaRepository.findAll();
        List<GroupFunctionType> beans = new ArrayList<GroupFunctionType>();
        for(GroupFunctionTypeEntity groupFunctionTypeEntity : entities) {
            beans.add(groupFunctionTypeServiceMapper.mapGroupFunctionTypeEntityToGroupFunctionType(groupFunctionTypeEntity));
        }
        return beans;
    }

    @Override
    public GroupFunctionType save(GroupFunctionType groupFunctionType) {
        return update(groupFunctionType) ;
    }

    @Override
    public GroupFunctionType create(GroupFunctionType groupFunctionType) {
        GroupFunctionTypeEntity groupFunctionTypeEntity = groupFunctionTypeJpaRepository.findOne(groupFunctionType.getGftId());
        if( groupFunctionTypeEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        groupFunctionTypeEntity = new GroupFunctionTypeEntity();
        groupFunctionTypeServiceMapper.mapGroupFunctionTypeToGroupFunctionTypeEntity(groupFunctionType, groupFunctionTypeEntity);
        GroupFunctionTypeEntity groupFunctionTypeEntitySaved = groupFunctionTypeJpaRepository.save(groupFunctionTypeEntity);
        return groupFunctionTypeServiceMapper.mapGroupFunctionTypeEntityToGroupFunctionType(groupFunctionTypeEntitySaved);
    }

    @Override
    public GroupFunctionType update(GroupFunctionType groupFunctionType) {
        GroupFunctionTypeEntity groupFunctionTypeEntity = groupFunctionTypeJpaRepository.findOne(groupFunctionType.getGftId());
        groupFunctionTypeServiceMapper.mapGroupFunctionTypeToGroupFunctionTypeEntity(groupFunctionType, groupFunctionTypeEntity);
        GroupFunctionTypeEntity groupFunctionTypeEntitySaved = groupFunctionTypeJpaRepository.save(groupFunctionTypeEntity);
        return groupFunctionTypeServiceMapper.mapGroupFunctionTypeEntityToGroupFunctionType(groupFunctionTypeEntitySaved);
    }

    @Override
    public void delete(Integer gftId) {
        groupFunctionTypeJpaRepository.delete(gftId);
    }

    public GroupFunctionTypeJpaRepository getGroupFunctionTypeJpaRepository() {
        return groupFunctionTypeJpaRepository;
    }

    public void setGroupFunctionTypeJpaRepository(GroupFunctionTypeJpaRepository groupFunctionTypeJpaRepository) {
        this.groupFunctionTypeJpaRepository = groupFunctionTypeJpaRepository;
    }

    public GroupFunctionTypeServiceMapper getGroupFunctionTypeServiceMapper() {
        return groupFunctionTypeServiceMapper;
    }

    public void setGroupFunctionTypeServiceMapper(GroupFunctionTypeServiceMapper groupFunctionTypeServiceMapper) {
        this.groupFunctionTypeServiceMapper = groupFunctionTypeServiceMapper;
    }

}
