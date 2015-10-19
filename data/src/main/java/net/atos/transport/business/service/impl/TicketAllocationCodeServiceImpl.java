/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.TicketAllocationCode;
import net.atos.transport.entity.jpa.TicketAllocationCodeEntity;
import net.atos.transport.business.service.TicketAllocationCodeService;
import net.atos.transport.business.service.mapping.TicketAllocationCodeServiceMapper;
import net.atos.transport.data.repository.jpa.TicketAllocationCodeJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of TicketAllocationCodeService
 */
@Component
@Transactional
public class TicketAllocationCodeServiceImpl implements TicketAllocationCodeService {

	@Resource
	private TicketAllocationCodeJpaRepository ticketAllocationCodeJpaRepository;

	@Resource
	private TicketAllocationCodeServiceMapper ticketAllocationCodeServiceMapper;
	
	@Override
	public TicketAllocationCode findById(Integer tacId) {
		TicketAllocationCodeEntity ticketAllocationCodeEntity = ticketAllocationCodeJpaRepository.findOne(tacId);
		return ticketAllocationCodeServiceMapper.mapTicketAllocationCodeEntityToTicketAllocationCode(ticketAllocationCodeEntity);
	}

	@Override
	public List<TicketAllocationCode> findAll() {
		Iterable<TicketAllocationCodeEntity> entities = ticketAllocationCodeJpaRepository.findAll();
		List<TicketAllocationCode> beans = new ArrayList<TicketAllocationCode>();
		for(TicketAllocationCodeEntity ticketAllocationCodeEntity : entities) {
			beans.add(ticketAllocationCodeServiceMapper.mapTicketAllocationCodeEntityToTicketAllocationCode(ticketAllocationCodeEntity));
		}
		return beans;
	}

	@Override
	public TicketAllocationCode save(TicketAllocationCode ticketAllocationCode) {
		return update(ticketAllocationCode) ;
	}

	@Override
	public TicketAllocationCode create(TicketAllocationCode ticketAllocationCode) {
		TicketAllocationCodeEntity ticketAllocationCodeEntity = ticketAllocationCodeJpaRepository.findOne(ticketAllocationCode.getTacId());
		if( ticketAllocationCodeEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		ticketAllocationCodeEntity = new TicketAllocationCodeEntity();
		ticketAllocationCodeServiceMapper.mapTicketAllocationCodeToTicketAllocationCodeEntity(ticketAllocationCode, ticketAllocationCodeEntity);
		TicketAllocationCodeEntity ticketAllocationCodeEntitySaved = ticketAllocationCodeJpaRepository.save(ticketAllocationCodeEntity);
		return ticketAllocationCodeServiceMapper.mapTicketAllocationCodeEntityToTicketAllocationCode(ticketAllocationCodeEntitySaved);
	}

	@Override
	public TicketAllocationCode update(TicketAllocationCode ticketAllocationCode) {
		TicketAllocationCodeEntity ticketAllocationCodeEntity = ticketAllocationCodeJpaRepository.findOne(ticketAllocationCode.getTacId());
		ticketAllocationCodeServiceMapper.mapTicketAllocationCodeToTicketAllocationCodeEntity(ticketAllocationCode, ticketAllocationCodeEntity);
		TicketAllocationCodeEntity ticketAllocationCodeEntitySaved = ticketAllocationCodeJpaRepository.save(ticketAllocationCodeEntity);
		return ticketAllocationCodeServiceMapper.mapTicketAllocationCodeEntityToTicketAllocationCode(ticketAllocationCodeEntitySaved);
	}

	@Override
	public void delete(Integer tacId) {
		ticketAllocationCodeJpaRepository.delete(tacId);
	}

	public TicketAllocationCodeJpaRepository getTicketAllocationCodeJpaRepository() {
		return ticketAllocationCodeJpaRepository;
	}

	public void setTicketAllocationCodeJpaRepository(TicketAllocationCodeJpaRepository ticketAllocationCodeJpaRepository) {
		this.ticketAllocationCodeJpaRepository = ticketAllocationCodeJpaRepository;
	}

	public TicketAllocationCodeServiceMapper getTicketAllocationCodeServiceMapper() {
		return ticketAllocationCodeServiceMapper;
	}

	public void setTicketAllocationCodeServiceMapper(TicketAllocationCodeServiceMapper ticketAllocationCodeServiceMapper) {
		this.ticketAllocationCodeServiceMapper = ticketAllocationCodeServiceMapper;
	}

}
