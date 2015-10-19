/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.business.service.TicketClassService;
import net.atos.transport.business.service.mapping.TicketClassServiceMapper;
import net.atos.transport.data.repository.jpa.TicketClassJpaRepository;
import net.atos.transport.entity.TicketClass;
import net.atos.transport.entity.jpa.TicketClassEntity;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of TicketClassService
 */
@Component
@Transactional
public class TicketClassServiceImpl implements TicketClassService {

    @Resource
    private TicketClassJpaRepository ticketClassJpaRepository;

    @Resource
    private TicketClassServiceMapper ticketClassServiceMapper;
    
    @Override
    public TicketClass findById(Integer ticId) {
        TicketClassEntity ticketClassEntity = ticketClassJpaRepository.findOne(ticId);
        return ticketClassServiceMapper.mapTicketClassEntityToTicketClass(ticketClassEntity);
    }

    @Override
    public List<TicketClass> findAll() {
        Iterable<TicketClassEntity> entities = ticketClassJpaRepository.findAll();
        List<TicketClass> beans = new ArrayList<TicketClass>();
        for(TicketClassEntity ticketClassEntity : entities) {
            beans.add(ticketClassServiceMapper.mapTicketClassEntityToTicketClass(ticketClassEntity));
        }
        return beans;
    }

    @Override
    public TicketClass save(TicketClass ticketClass) {
        return update(ticketClass) ;
    }

    @Override
    public TicketClass create(TicketClass ticketClass) {
        TicketClassEntity ticketClassEntity = ticketClassJpaRepository.findOne(ticketClass.getTicId());
        if( ticketClassEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        ticketClassEntity = new TicketClassEntity();
        ticketClassServiceMapper.mapTicketClassToTicketClassEntity(ticketClass, ticketClassEntity);
        TicketClassEntity ticketClassEntitySaved = ticketClassJpaRepository.save(ticketClassEntity);
        return ticketClassServiceMapper.mapTicketClassEntityToTicketClass(ticketClassEntitySaved);
    }

    @Override
    public TicketClass update(TicketClass ticketClass) {
        TicketClassEntity ticketClassEntity = ticketClassJpaRepository.findOne(ticketClass.getTicId());
        ticketClassServiceMapper.mapTicketClassToTicketClassEntity(ticketClass, ticketClassEntity);
        TicketClassEntity ticketClassEntitySaved = ticketClassJpaRepository.save(ticketClassEntity);
        return ticketClassServiceMapper.mapTicketClassEntityToTicketClass(ticketClassEntitySaved);
    }

    @Override
    public void delete(Integer ticId) {
        ticketClassJpaRepository.delete(ticId);
    }

    public TicketClassJpaRepository getTicketClassJpaRepository() {
        return ticketClassJpaRepository;
    }

    public void setTicketClassJpaRepository(TicketClassJpaRepository ticketClassJpaRepository) {
        this.ticketClassJpaRepository = ticketClassJpaRepository;
    }

    public TicketClassServiceMapper getTicketClassServiceMapper() {
        return ticketClassServiceMapper;
    }

    public void setTicketClassServiceMapper(TicketClassServiceMapper ticketClassServiceMapper) {
        this.ticketClassServiceMapper = ticketClassServiceMapper;
    }

}
