/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.Route;
import net.atos.transport.entity.jpa.RouteEntity;
import net.atos.transport.business.service.RouteService;
import net.atos.transport.business.service.mapping.RouteServiceMapper;
import net.atos.transport.data.repository.jpa.RouteJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of RouteService
 */
@Component
@Transactional
public class RouteServiceImpl implements RouteService {

	@Resource
	private RouteJpaRepository routeJpaRepository;

	@Resource
	private RouteServiceMapper routeServiceMapper;
	
	@Override
	public Route findById(Integer rouId) {
		RouteEntity routeEntity = routeJpaRepository.findOne(rouId);
		return routeServiceMapper.mapRouteEntityToRoute(routeEntity);
	}

	@Override
	public List<Route> findAll() {
		Iterable<RouteEntity> entities = routeJpaRepository.findAll();
		List<Route> beans = new ArrayList<Route>();
		for(RouteEntity routeEntity : entities) {
			beans.add(routeServiceMapper.mapRouteEntityToRoute(routeEntity));
		}
		return beans;
	}

	@Override
	public Route save(Route route) {
		return update(route) ;
	}

	@Override
	public Route create(Route route) {
		RouteEntity routeEntity = routeJpaRepository.findOne(route.getRouId());
		if( routeEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		routeEntity = new RouteEntity();
		routeServiceMapper.mapRouteToRouteEntity(route, routeEntity);
		RouteEntity routeEntitySaved = routeJpaRepository.save(routeEntity);
		return routeServiceMapper.mapRouteEntityToRoute(routeEntitySaved);
	}

	@Override
	public Route update(Route route) {
		RouteEntity routeEntity = routeJpaRepository.findOne(route.getRouId());
		routeServiceMapper.mapRouteToRouteEntity(route, routeEntity);
		RouteEntity routeEntitySaved = routeJpaRepository.save(routeEntity);
		return routeServiceMapper.mapRouteEntityToRoute(routeEntitySaved);
	}

	@Override
	public void delete(Integer rouId) {
		routeJpaRepository.delete(rouId);
	}

	public RouteJpaRepository getRouteJpaRepository() {
		return routeJpaRepository;
	}

	public void setRouteJpaRepository(RouteJpaRepository routeJpaRepository) {
		this.routeJpaRepository = routeJpaRepository;
	}

	public RouteServiceMapper getRouteServiceMapper() {
		return routeServiceMapper;
	}

	public void setRouteServiceMapper(RouteServiceMapper routeServiceMapper) {
		this.routeServiceMapper = routeServiceMapper;
	}

}
