/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.TicketStatusLink;
import net.atos.transport.entity.jpa.TicketStatusLinkEntity;
import net.atos.transport.business.service.TicketStatusLinkService;
import net.atos.transport.business.service.mapping.TicketStatusLinkServiceMapper;
import net.atos.transport.data.repository.jpa.TicketStatusLinkJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of TicketStatusLinkService
 */
@Component
@Transactional
public class TicketStatusLinkServiceImpl implements TicketStatusLinkService {

	@Resource
	private TicketStatusLinkJpaRepository ticketStatusLinkJpaRepository;

	@Resource
	private TicketStatusLinkServiceMapper ticketStatusLinkServiceMapper;
	
	@Override
	public TicketStatusLink findById(Integer tslId) {
		TicketStatusLinkEntity ticketStatusLinkEntity = ticketStatusLinkJpaRepository.findOne(tslId);
		return ticketStatusLinkServiceMapper.mapTicketStatusLinkEntityToTicketStatusLink(ticketStatusLinkEntity);
	}

	@Override
	public List<TicketStatusLink> findAll() {
		Iterable<TicketStatusLinkEntity> entities = ticketStatusLinkJpaRepository.findAll();
		List<TicketStatusLink> beans = new ArrayList<TicketStatusLink>();
		for(TicketStatusLinkEntity ticketStatusLinkEntity : entities) {
			beans.add(ticketStatusLinkServiceMapper.mapTicketStatusLinkEntityToTicketStatusLink(ticketStatusLinkEntity));
		}
		return beans;
	}

	@Override
	public TicketStatusLink save(TicketStatusLink ticketStatusLink) {
		return update(ticketStatusLink) ;
	}

	@Override
	public TicketStatusLink create(TicketStatusLink ticketStatusLink) {
		TicketStatusLinkEntity ticketStatusLinkEntity = ticketStatusLinkJpaRepository.findOne(ticketStatusLink.getTslId());
		if( ticketStatusLinkEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		ticketStatusLinkEntity = new TicketStatusLinkEntity();
		ticketStatusLinkServiceMapper.mapTicketStatusLinkToTicketStatusLinkEntity(ticketStatusLink, ticketStatusLinkEntity);
		TicketStatusLinkEntity ticketStatusLinkEntitySaved = ticketStatusLinkJpaRepository.save(ticketStatusLinkEntity);
		return ticketStatusLinkServiceMapper.mapTicketStatusLinkEntityToTicketStatusLink(ticketStatusLinkEntitySaved);
	}

	@Override
	public TicketStatusLink update(TicketStatusLink ticketStatusLink) {
		TicketStatusLinkEntity ticketStatusLinkEntity = ticketStatusLinkJpaRepository.findOne(ticketStatusLink.getTslId());
		ticketStatusLinkServiceMapper.mapTicketStatusLinkToTicketStatusLinkEntity(ticketStatusLink, ticketStatusLinkEntity);
		TicketStatusLinkEntity ticketStatusLinkEntitySaved = ticketStatusLinkJpaRepository.save(ticketStatusLinkEntity);
		return ticketStatusLinkServiceMapper.mapTicketStatusLinkEntityToTicketStatusLink(ticketStatusLinkEntitySaved);
	}

	@Override
	public void delete(Integer tslId) {
		ticketStatusLinkJpaRepository.delete(tslId);
	}

	public TicketStatusLinkJpaRepository getTicketStatusLinkJpaRepository() {
		return ticketStatusLinkJpaRepository;
	}

	public void setTicketStatusLinkJpaRepository(TicketStatusLinkJpaRepository ticketStatusLinkJpaRepository) {
		this.ticketStatusLinkJpaRepository = ticketStatusLinkJpaRepository;
	}

	public TicketStatusLinkServiceMapper getTicketStatusLinkServiceMapper() {
		return ticketStatusLinkServiceMapper;
	}

	public void setTicketStatusLinkServiceMapper(TicketStatusLinkServiceMapper ticketStatusLinkServiceMapper) {
		this.ticketStatusLinkServiceMapper = ticketStatusLinkServiceMapper;
	}

}
