/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.business.service.BusinessService;
import net.atos.transport.business.service.mapping.BusinessServiceMapper;
import net.atos.transport.data.repository.jpa.BusinessJpaRepository;
import net.atos.transport.entity.Business;
import net.atos.transport.entity.jpa.BusinessEntity;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of BusinessService
 */
@Component
@Transactional
public class BusinessServiceImpl implements BusinessService
{

    @Resource
    private BusinessJpaRepository businessJpaRepository;

    @Resource
    private BusinessServiceMapper businessServiceMapper;

    @Override
    public Business findById(Integer busId)
    {
        BusinessEntity businessEntity = businessJpaRepository.findOne(busId);
        return businessServiceMapper.mapBusinessEntityToBusiness(businessEntity);
    }

    @Override
    public List<Business> findAll()
    {
        Iterable<BusinessEntity> entities = businessJpaRepository.findAll();
        List<Business> beans = new ArrayList<Business>();
        for (BusinessEntity businessEntity : entities)
        {
            beans.add(businessServiceMapper.mapBusinessEntityToBusiness(businessEntity));
        }
        return beans;
    }

    @Override
    public Business save(Business business)
    {
        return update(business);
    }

    @Override
    public Business create(Business business)
    {
        BusinessEntity businessEntity = businessJpaRepository.findOne(business.getBusId());
        if (businessEntity != null)
        {
            throw new IllegalStateException("already.exists");
        }
        businessEntity = new BusinessEntity();
        businessServiceMapper.mapBusinessToBusinessEntity(business, businessEntity);
        BusinessEntity businessEntitySaved = businessJpaRepository.save(businessEntity);
        return businessServiceMapper.mapBusinessEntityToBusiness(businessEntitySaved);
    }

    @Override
    public Business update(Business business)
    {
        BusinessEntity businessEntity = businessJpaRepository.findOne(business.getBusId());
        businessServiceMapper.mapBusinessToBusinessEntity(business, businessEntity);
        BusinessEntity businessEntitySaved = businessJpaRepository.save(businessEntity);
        return businessServiceMapper.mapBusinessEntityToBusiness(businessEntitySaved);
    }

    @Override
    public void delete(Integer busId)
    {
        businessJpaRepository.delete(busId);
    }

    public BusinessJpaRepository getBusinessJpaRepository()
    {
        return businessJpaRepository;
    }

    public void setBusinessJpaRepository(BusinessJpaRepository businessJpaRepository)
    {
        this.businessJpaRepository = businessJpaRepository;
    }

    public BusinessServiceMapper getBusinessServiceMapper()
    {
        return businessServiceMapper;
    }

    public void setBusinessServiceMapper(BusinessServiceMapper businessServiceMapper)
    {
        this.businessServiceMapper = businessServiceMapper;
    }

}
