/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.RouteLink;
import net.atos.transport.entity.jpa.RouteLinkEntity;
import net.atos.transport.business.service.RouteLinkService;
import net.atos.transport.business.service.mapping.RouteLinkServiceMapper;
import net.atos.transport.data.repository.jpa.RouteLinkJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of RouteLinkService
 */
@Component
@Transactional
public class RouteLinkServiceImpl implements RouteLinkService {

    @Resource
    private RouteLinkJpaRepository routeLinkJpaRepository;

    @Resource
    private RouteLinkServiceMapper routeLinkServiceMapper;
    
    @Override
    public RouteLink findById(Integer rolId) {
        RouteLinkEntity routeLinkEntity = routeLinkJpaRepository.findOne(rolId);
        return routeLinkServiceMapper.mapRouteLinkEntityToRouteLink(routeLinkEntity);
    }

    @Override
    public List<RouteLink> findAll() {
        Iterable<RouteLinkEntity> entities = routeLinkJpaRepository.findAll();
        List<RouteLink> beans = new ArrayList<RouteLink>();
        for(RouteLinkEntity routeLinkEntity : entities) {
            beans.add(routeLinkServiceMapper.mapRouteLinkEntityToRouteLink(routeLinkEntity));
        }
        return beans;
    }

    @Override
    public RouteLink save(RouteLink routeLink) {
        return update(routeLink) ;
    }

    @Override
    public RouteLink create(RouteLink routeLink) {
        RouteLinkEntity routeLinkEntity = routeLinkJpaRepository.findOne(routeLink.getRolId());
        if( routeLinkEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        routeLinkEntity = new RouteLinkEntity();
        routeLinkServiceMapper.mapRouteLinkToRouteLinkEntity(routeLink, routeLinkEntity);
        RouteLinkEntity routeLinkEntitySaved = routeLinkJpaRepository.save(routeLinkEntity);
        return routeLinkServiceMapper.mapRouteLinkEntityToRouteLink(routeLinkEntitySaved);
    }

    @Override
    public RouteLink update(RouteLink routeLink) {
        RouteLinkEntity routeLinkEntity = routeLinkJpaRepository.findOne(routeLink.getRolId());
        routeLinkServiceMapper.mapRouteLinkToRouteLinkEntity(routeLink, routeLinkEntity);
        RouteLinkEntity routeLinkEntitySaved = routeLinkJpaRepository.save(routeLinkEntity);
        return routeLinkServiceMapper.mapRouteLinkEntityToRouteLink(routeLinkEntitySaved);
    }

    @Override
    public void delete(Integer rolId) {
        routeLinkJpaRepository.delete(rolId);
    }

    public RouteLinkJpaRepository getRouteLinkJpaRepository() {
        return routeLinkJpaRepository;
    }

    public void setRouteLinkJpaRepository(RouteLinkJpaRepository routeLinkJpaRepository) {
        this.routeLinkJpaRepository = routeLinkJpaRepository;
    }

    public RouteLinkServiceMapper getRouteLinkServiceMapper() {
        return routeLinkServiceMapper;
    }

    public void setRouteLinkServiceMapper(RouteLinkServiceMapper routeLinkServiceMapper) {
        this.routeLinkServiceMapper = routeLinkServiceMapper;
    }

}
