/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.Year;
import net.atos.transport.entity.jpa.YearEntity;
import net.atos.transport.business.service.YearService;
import net.atos.transport.business.service.mapping.YearServiceMapper;
import net.atos.transport.data.repository.jpa.YearJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of YearService
 */
@Component
@Transactional
public class YearServiceImpl implements YearService {

    @Resource
    private YearJpaRepository yearJpaRepository;

    @Resource
    private YearServiceMapper yearServiceMapper;
    
    @Override
    public Year findById(Integer year) {
        YearEntity yearEntity = yearJpaRepository.findOne(year);
        return yearServiceMapper.mapYearEntityToYear(yearEntity);
    }

    @Override
    public List<Year> findAll() {
        Iterable<YearEntity> entities = yearJpaRepository.findAll();
        List<Year> beans = new ArrayList<Year>();
        for(YearEntity yearEntity : entities) {
            beans.add(yearServiceMapper.mapYearEntityToYear(yearEntity));
        }
        return beans;
    }

    @Override
    public Year save(Year year) {
        return update(year) ;
    }

    @Override
    public Year create(Year year) {
        YearEntity yearEntity = yearJpaRepository.findOne(year.getYear());
        if( yearEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        yearEntity = new YearEntity();
        yearServiceMapper.mapYearToYearEntity(year, yearEntity);
        YearEntity yearEntitySaved = yearJpaRepository.save(yearEntity);
        return yearServiceMapper.mapYearEntityToYear(yearEntitySaved);
    }

    @Override
    public Year update(Year year) {
        YearEntity yearEntity = yearJpaRepository.findOne(year.getYear());
        yearServiceMapper.mapYearToYearEntity(year, yearEntity);
        YearEntity yearEntitySaved = yearJpaRepository.save(yearEntity);
        return yearServiceMapper.mapYearEntityToYear(yearEntitySaved);
    }

    @Override
    public void delete(Integer year) {
        yearJpaRepository.delete(year);
    }

    public YearJpaRepository getYearJpaRepository() {
        return yearJpaRepository;
    }

    public void setYearJpaRepository(YearJpaRepository yearJpaRepository) {
        this.yearJpaRepository = yearJpaRepository;
    }

    public YearServiceMapper getYearServiceMapper() {
        return yearServiceMapper;
    }

    public void setYearServiceMapper(YearServiceMapper yearServiceMapper) {
        this.yearServiceMapper = yearServiceMapper;
    }

}
