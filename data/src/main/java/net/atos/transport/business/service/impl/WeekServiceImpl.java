/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.Week;
import net.atos.transport.entity.jpa.WeekEntity;
import net.atos.transport.business.service.WeekService;
import net.atos.transport.business.service.mapping.WeekServiceMapper;
import net.atos.transport.data.repository.jpa.WeekJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of WeekService
 */
@Component
@Transactional
public class WeekServiceImpl implements WeekService {

    @Resource
    private WeekJpaRepository weekJpaRepository;

    @Resource
    private WeekServiceMapper weekServiceMapper;
    
    @Override
    public Week findById(Integer weekId) {
        WeekEntity weekEntity = weekJpaRepository.findOne(weekId);
        return weekServiceMapper.mapWeekEntityToWeek(weekEntity);
    }

    @Override
    public List<Week> findAll() {
        Iterable<WeekEntity> entities = weekJpaRepository.findAll();
        List<Week> beans = new ArrayList<Week>();
        for(WeekEntity weekEntity : entities) {
            beans.add(weekServiceMapper.mapWeekEntityToWeek(weekEntity));
        }
        return beans;
    }

    @Override
    public Week save(Week week) {
        return update(week) ;
    }

    @Override
    public Week create(Week week) {
        WeekEntity weekEntity = weekJpaRepository.findOne(week.getWeekId());
        if( weekEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        weekEntity = new WeekEntity();
        weekServiceMapper.mapWeekToWeekEntity(week, weekEntity);
        WeekEntity weekEntitySaved = weekJpaRepository.save(weekEntity);
        return weekServiceMapper.mapWeekEntityToWeek(weekEntitySaved);
    }

    @Override
    public Week update(Week week) {
        WeekEntity weekEntity = weekJpaRepository.findOne(week.getWeekId());
        weekServiceMapper.mapWeekToWeekEntity(week, weekEntity);
        WeekEntity weekEntitySaved = weekJpaRepository.save(weekEntity);
        return weekServiceMapper.mapWeekEntityToWeek(weekEntitySaved);
    }

    @Override
    public void delete(Integer weekId) {
        weekJpaRepository.delete(weekId);
    }

    public WeekJpaRepository getWeekJpaRepository() {
        return weekJpaRepository;
    }

    public void setWeekJpaRepository(WeekJpaRepository weekJpaRepository) {
        this.weekJpaRepository = weekJpaRepository;
    }

    public WeekServiceMapper getWeekServiceMapper() {
        return weekServiceMapper;
    }

    public void setWeekServiceMapper(WeekServiceMapper weekServiceMapper) {
        this.weekServiceMapper = weekServiceMapper;
    }

}
