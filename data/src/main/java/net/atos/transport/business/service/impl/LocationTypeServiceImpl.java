/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.business.service.LocationTypeService;
import net.atos.transport.business.service.mapping.LocationTypeServiceMapper;
import net.atos.transport.data.repository.jpa.LocationTypeJpaRepository;
import net.atos.transport.entity.LocationType;
import net.atos.transport.entity.jpa.LocationTypeEntity;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of LocationTypeService
 */
@Component
@Transactional
public class LocationTypeServiceImpl implements LocationTypeService
{

    @Resource
    private LocationTypeJpaRepository locationTypeJpaRepository;

    @Resource
    private LocationTypeServiceMapper locationTypeServiceMapper;

    @Override
    public LocationType findById(Integer lotId)
    {
        LocationTypeEntity locationTypeEntity = locationTypeJpaRepository.findOne(lotId);
        return locationTypeServiceMapper.mapLocationTypeEntityToLocationType(locationTypeEntity);
    }

    @Override
    public List<LocationType> findAll()
    {
        Iterable<LocationTypeEntity> entities = locationTypeJpaRepository.findAll();
        List<LocationType> beans = new ArrayList<LocationType>();
        for (LocationTypeEntity locationTypeEntity : entities)
        {
            beans.add(locationTypeServiceMapper.mapLocationTypeEntityToLocationType(locationTypeEntity));
        }
        return beans;
    }

    @Override
    public LocationType save(LocationType locationType)
    {
        return update(locationType);
    }

    @Override
    public LocationType create(LocationType locationType)
    {
        LocationTypeEntity locationTypeEntity = locationTypeJpaRepository.findOne(locationType.getLotId());
        if (locationTypeEntity != null)
        {
            throw new IllegalStateException("already.exists");
        }
        locationTypeEntity = new LocationTypeEntity();
        locationTypeServiceMapper.mapLocationTypeToLocationTypeEntity(locationType, locationTypeEntity);
        LocationTypeEntity locationTypeEntitySaved = locationTypeJpaRepository.save(locationTypeEntity);
        return locationTypeServiceMapper.mapLocationTypeEntityToLocationType(locationTypeEntitySaved);
    }

    @Override
    public LocationType update(LocationType locationType)
    {
        LocationTypeEntity locationTypeEntity = locationTypeJpaRepository.findOne(locationType.getLotId());
        locationTypeServiceMapper.mapLocationTypeToLocationTypeEntity(locationType, locationTypeEntity);
        LocationTypeEntity locationTypeEntitySaved = locationTypeJpaRepository.save(locationTypeEntity);
        return locationTypeServiceMapper.mapLocationTypeEntityToLocationType(locationTypeEntitySaved);
    }

    @Override
    public void delete(Integer lotId)
    {
        locationTypeJpaRepository.delete(lotId);
    }

    public LocationTypeJpaRepository getLocationTypeJpaRepository()
    {
        return locationTypeJpaRepository;
    }

    public void setLocationTypeJpaRepository(LocationTypeJpaRepository locationTypeJpaRepository)
    {
        this.locationTypeJpaRepository = locationTypeJpaRepository;
    }

    public LocationTypeServiceMapper getLocationTypeServiceMapper()
    {
        return locationTypeServiceMapper;
    }

    public void setLocationTypeServiceMapper(LocationTypeServiceMapper locationTypeServiceMapper)
    {
        this.locationTypeServiceMapper = locationTypeServiceMapper;
    }

}
