/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.business.service.RecordFieldService;
import net.atos.transport.business.service.mapping.RecordFieldServiceMapper;
import net.atos.transport.data.repository.jpa.RecordFieldJpaRepository;
import net.atos.transport.entity.RecordField;
import net.atos.transport.entity.jpa.RecordFieldEntity;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of RecordFieldService
 */
@Component
@Transactional
public class RecordFieldServiceImpl implements RecordFieldService
{

    @Resource
    private RecordFieldJpaRepository recordFieldJpaRepository;

    @Resource
    private RecordFieldServiceMapper recordFieldServiceMapper;

    @Override
    public RecordField findById(Integer refId)
    {
        RecordFieldEntity recordFieldEntity = recordFieldJpaRepository.findOne(refId);
        return recordFieldServiceMapper.mapRecordFieldEntityToRecordField(recordFieldEntity);
    }

    @Override
    public List<RecordField> findAll()
    {
        Iterable<RecordFieldEntity> entities = recordFieldJpaRepository.findAll();
        List<RecordField> beans = new ArrayList<RecordField>();
        for (RecordFieldEntity recordFieldEntity : entities)
        {
            beans.add(recordFieldServiceMapper.mapRecordFieldEntityToRecordField(recordFieldEntity));
        }
        return beans;
    }

    @Override
    public RecordField save(RecordField recordField)
    {
        return update(recordField);
    }

    @Override
    public RecordField create(RecordField recordField)
    {
        RecordFieldEntity recordFieldEntity = recordFieldJpaRepository.findOne(recordField.getRefId());
        if (recordFieldEntity != null)
        {
            throw new IllegalStateException("already.exists");
        }
        recordFieldEntity = new RecordFieldEntity();
        recordFieldServiceMapper.mapRecordFieldToRecordFieldEntity(recordField, recordFieldEntity);
        RecordFieldEntity recordFieldEntitySaved = recordFieldJpaRepository.save(recordFieldEntity);
        return recordFieldServiceMapper.mapRecordFieldEntityToRecordField(recordFieldEntitySaved);
    }

    @Override
    public RecordField update(RecordField recordField)
    {
        RecordFieldEntity recordFieldEntity = recordFieldJpaRepository.findOne(recordField.getRefId());
        recordFieldServiceMapper.mapRecordFieldToRecordFieldEntity(recordField, recordFieldEntity);
        RecordFieldEntity recordFieldEntitySaved = recordFieldJpaRepository.save(recordFieldEntity);
        return recordFieldServiceMapper.mapRecordFieldEntityToRecordField(recordFieldEntitySaved);
    }

    @Override
    public void delete(Integer refId)
    {
        recordFieldJpaRepository.delete(refId);
    }

    public RecordFieldJpaRepository getRecordFieldJpaRepository()
    {
        return recordFieldJpaRepository;
    }

    public void setRecordFieldJpaRepository(RecordFieldJpaRepository recordFieldJpaRepository)
    {
        this.recordFieldJpaRepository = recordFieldJpaRepository;
    }

    public RecordFieldServiceMapper getRecordFieldServiceMapper()
    {
        return recordFieldServiceMapper;
    }

    public void setRecordFieldServiceMapper(RecordFieldServiceMapper recordFieldServiceMapper)
    {
        this.recordFieldServiceMapper = recordFieldServiceMapper;
    }

}
