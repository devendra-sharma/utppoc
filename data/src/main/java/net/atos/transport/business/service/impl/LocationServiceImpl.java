/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.Location;
import net.atos.transport.entity.jpa.LocationEntity;
import net.atos.transport.business.service.LocationService;
import net.atos.transport.business.service.mapping.LocationServiceMapper;
import net.atos.transport.data.repository.jpa.LocationJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of LocationService
 */
@Component
@Transactional
public class LocationServiceImpl implements LocationService {

    @Resource
    private LocationJpaRepository locationJpaRepository;

    @Resource
    private LocationServiceMapper locationServiceMapper;
    
    @Override
    public Location findById(Integer locId) {
        LocationEntity locationEntity = locationJpaRepository.findOne(locId);
        return locationServiceMapper.mapLocationEntityToLocation(locationEntity);
    }

    @Override
    public List<Location> findAll() {
        Iterable<LocationEntity> entities = locationJpaRepository.findAll();
        List<Location> beans = new ArrayList<Location>();
        for(LocationEntity locationEntity : entities) {
            beans.add(locationServiceMapper.mapLocationEntityToLocation(locationEntity));
        }
        return beans;
    }

    @Override
    public Location save(Location location) {
        return update(location) ;
    }

    @Override
    public Location create(Location location) {
        LocationEntity locationEntity = locationJpaRepository.findOne(location.getLocId());
        if( locationEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        locationEntity = new LocationEntity();
        locationServiceMapper.mapLocationToLocationEntity(location, locationEntity);
        LocationEntity locationEntitySaved = locationJpaRepository.save(locationEntity);
        return locationServiceMapper.mapLocationEntityToLocation(locationEntitySaved);
    }

    @Override
    public Location update(Location location) {
        LocationEntity locationEntity = locationJpaRepository.findOne(location.getLocId());
        locationServiceMapper.mapLocationToLocationEntity(location, locationEntity);
        LocationEntity locationEntitySaved = locationJpaRepository.save(locationEntity);
        return locationServiceMapper.mapLocationEntityToLocation(locationEntitySaved);
    }

    @Override
    public void delete(Integer locId) {
        locationJpaRepository.delete(locId);
    }

    public LocationJpaRepository getLocationJpaRepository() {
        return locationJpaRepository;
    }

    public void setLocationJpaRepository(LocationJpaRepository locationJpaRepository) {
        this.locationJpaRepository = locationJpaRepository;
    }

    public LocationServiceMapper getLocationServiceMapper() {
        return locationServiceMapper;
    }

    public void setLocationServiceMapper(LocationServiceMapper locationServiceMapper) {
        this.locationServiceMapper = locationServiceMapper;
    }

}
