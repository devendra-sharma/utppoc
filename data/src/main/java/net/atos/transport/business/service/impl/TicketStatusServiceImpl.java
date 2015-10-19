/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.TicketStatus;
import net.atos.transport.entity.jpa.TicketStatusEntity;
import net.atos.transport.business.service.TicketStatusService;
import net.atos.transport.business.service.mapping.TicketStatusServiceMapper;
import net.atos.transport.data.repository.jpa.TicketStatusJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of TicketStatusService
 */
@Component
@Transactional
public class TicketStatusServiceImpl implements TicketStatusService {

    @Resource
    private TicketStatusJpaRepository ticketStatusJpaRepository;

    @Resource
    private TicketStatusServiceMapper ticketStatusServiceMapper;
    
    @Override
    public TicketStatus findById(Integer tisId) {
        TicketStatusEntity ticketStatusEntity = ticketStatusJpaRepository.findOne(tisId);
        return ticketStatusServiceMapper.mapTicketStatusEntityToTicketStatus(ticketStatusEntity);
    }

    @Override
    public List<TicketStatus> findAll() {
        Iterable<TicketStatusEntity> entities = ticketStatusJpaRepository.findAll();
        List<TicketStatus> beans = new ArrayList<TicketStatus>();
        for(TicketStatusEntity ticketStatusEntity : entities) {
            beans.add(ticketStatusServiceMapper.mapTicketStatusEntityToTicketStatus(ticketStatusEntity));
        }
        return beans;
    }

    @Override
    public TicketStatus save(TicketStatus ticketStatus) {
        return update(ticketStatus) ;
    }

    @Override
    public TicketStatus create(TicketStatus ticketStatus) {
        TicketStatusEntity ticketStatusEntity = ticketStatusJpaRepository.findOne(ticketStatus.getTisId());
        if( ticketStatusEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        ticketStatusEntity = new TicketStatusEntity();
        ticketStatusServiceMapper.mapTicketStatusToTicketStatusEntity(ticketStatus, ticketStatusEntity);
        TicketStatusEntity ticketStatusEntitySaved = ticketStatusJpaRepository.save(ticketStatusEntity);
        return ticketStatusServiceMapper.mapTicketStatusEntityToTicketStatus(ticketStatusEntitySaved);
    }

    @Override
    public TicketStatus update(TicketStatus ticketStatus) {
        TicketStatusEntity ticketStatusEntity = ticketStatusJpaRepository.findOne(ticketStatus.getTisId());
        ticketStatusServiceMapper.mapTicketStatusToTicketStatusEntity(ticketStatus, ticketStatusEntity);
        TicketStatusEntity ticketStatusEntitySaved = ticketStatusJpaRepository.save(ticketStatusEntity);
        return ticketStatusServiceMapper.mapTicketStatusEntityToTicketStatus(ticketStatusEntitySaved);
    }

    @Override
    public void delete(Integer tisId) {
        ticketStatusJpaRepository.delete(tisId);
    }

    public TicketStatusJpaRepository getTicketStatusJpaRepository() {
        return ticketStatusJpaRepository;
    }

    public void setTicketStatusJpaRepository(TicketStatusJpaRepository ticketStatusJpaRepository) {
        this.ticketStatusJpaRepository = ticketStatusJpaRepository;
    }

    public TicketStatusServiceMapper getTicketStatusServiceMapper() {
        return ticketStatusServiceMapper;
    }

    public void setTicketStatusServiceMapper(TicketStatusServiceMapper ticketStatusServiceMapper) {
        this.ticketStatusServiceMapper = ticketStatusServiceMapper;
    }

}
