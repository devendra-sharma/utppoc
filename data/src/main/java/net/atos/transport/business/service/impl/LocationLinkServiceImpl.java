/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.business.service.LocationLinkService;
import net.atos.transport.business.service.mapping.LocationLinkServiceMapper;
import net.atos.transport.data.repository.jpa.LocationLinkJpaRepository;
import net.atos.transport.entity.LocationLink;
import net.atos.transport.entity.jpa.LocationLinkEntity;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of LocationLinkService
 */
@Component
@Transactional
public class LocationLinkServiceImpl implements LocationLinkService {

    @Resource
    private LocationLinkJpaRepository locationLinkJpaRepository;

    @Resource
    private LocationLinkServiceMapper locationLinkServiceMapper;
    
    @Override
    public LocationLink findById(Integer lolId) {
        LocationLinkEntity locationLinkEntity = locationLinkJpaRepository.findOne(lolId);
        return locationLinkServiceMapper.mapLocationLinkEntityToLocationLink(locationLinkEntity);
    }

    @Override
    public List<LocationLink> findAll() {
        Iterable<LocationLinkEntity> entities = locationLinkJpaRepository.findAll();
        List<LocationLink> beans = new ArrayList<LocationLink>();
        for(LocationLinkEntity locationLinkEntity : entities) {
            beans.add(locationLinkServiceMapper.mapLocationLinkEntityToLocationLink(locationLinkEntity));
        }
        return beans;
    }

    @Override
    public LocationLink save(LocationLink locationLink) {
        return update(locationLink) ;
    }

    @Override
    public LocationLink create(LocationLink locationLink) {
        LocationLinkEntity locationLinkEntity = locationLinkJpaRepository.findOne(locationLink.getLolId());
        if( locationLinkEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        locationLinkEntity = new LocationLinkEntity();
        locationLinkServiceMapper.mapLocationLinkToLocationLinkEntity(locationLink, locationLinkEntity);
        LocationLinkEntity locationLinkEntitySaved = locationLinkJpaRepository.save(locationLinkEntity);
        return locationLinkServiceMapper.mapLocationLinkEntityToLocationLink(locationLinkEntitySaved);
    }

    @Override
    public LocationLink update(LocationLink locationLink) {
        LocationLinkEntity locationLinkEntity = locationLinkJpaRepository.findOne(locationLink.getLolId());
        locationLinkServiceMapper.mapLocationLinkToLocationLinkEntity(locationLink, locationLinkEntity);
        LocationLinkEntity locationLinkEntitySaved = locationLinkJpaRepository.save(locationLinkEntity);
        return locationLinkServiceMapper.mapLocationLinkEntityToLocationLink(locationLinkEntitySaved);
    }

    @Override
    public void delete(Integer lolId) {
        locationLinkJpaRepository.delete(lolId);
    }

    public LocationLinkJpaRepository getLocationLinkJpaRepository() {
        return locationLinkJpaRepository;
    }

    public void setLocationLinkJpaRepository(LocationLinkJpaRepository locationLinkJpaRepository) {
        this.locationLinkJpaRepository = locationLinkJpaRepository;
    }

    public LocationLinkServiceMapper getLocationLinkServiceMapper() {
        return locationLinkServiceMapper;
    }

    public void setLocationLinkServiceMapper(LocationLinkServiceMapper locationLinkServiceMapper) {
        this.locationLinkServiceMapper = locationLinkServiceMapper;
    }

}
