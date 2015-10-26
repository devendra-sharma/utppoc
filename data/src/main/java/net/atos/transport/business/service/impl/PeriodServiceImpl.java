/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.business.service.PeriodService;
import net.atos.transport.business.service.mapping.PeriodServiceMapper;
import net.atos.transport.data.repository.jpa.PeriodJpaRepository;
import net.atos.transport.entity.Period;
import net.atos.transport.entity.jpa.PeriodEntity;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of PeriodService
 */
@Component
@Transactional
public class PeriodServiceImpl implements PeriodService
{

    @Resource
    private PeriodJpaRepository periodJpaRepository;

    @Resource
    private PeriodServiceMapper periodServiceMapper;

    @Override
    public Period findById(Integer perId)
    {
        PeriodEntity periodEntity = periodJpaRepository.findOne(perId);
        return periodServiceMapper.mapPeriodEntityToPeriod(periodEntity);
    }

    @Override
    public List<Period> findAll()
    {
        Iterable<PeriodEntity> entities = periodJpaRepository.findAll();
        List<Period> beans = new ArrayList<Period>();
        for (PeriodEntity periodEntity : entities)
        {
            beans.add(periodServiceMapper.mapPeriodEntityToPeriod(periodEntity));
        }
        return beans;
    }

    @Override
    public Period save(Period period)
    {
        return update(period);
    }

    @Override
    public Period create(Period period)
    {
        PeriodEntity periodEntity = periodJpaRepository.findOne(period.getPerId());
        if (periodEntity != null)
        {
            throw new IllegalStateException("already.exists");
        }
        periodEntity = new PeriodEntity();
        periodServiceMapper.mapPeriodToPeriodEntity(period, periodEntity);
        PeriodEntity periodEntitySaved = periodJpaRepository.save(periodEntity);
        return periodServiceMapper.mapPeriodEntityToPeriod(periodEntitySaved);
    }

    @Override
    public Period update(Period period)
    {
        PeriodEntity periodEntity = periodJpaRepository.findOne(period.getPerId());
        periodServiceMapper.mapPeriodToPeriodEntity(period, periodEntity);
        PeriodEntity periodEntitySaved = periodJpaRepository.save(periodEntity);
        return periodServiceMapper.mapPeriodEntityToPeriod(periodEntitySaved);
    }

    @Override
    public void delete(Integer perId)
    {
        periodJpaRepository.delete(perId);
    }

    public PeriodJpaRepository getPeriodJpaRepository()
    {
        return periodJpaRepository;
    }

    public void setPeriodJpaRepository(PeriodJpaRepository periodJpaRepository)
    {
        this.periodJpaRepository = periodJpaRepository;
    }

    public PeriodServiceMapper getPeriodServiceMapper()
    {
        return periodServiceMapper;
    }

    public void setPeriodServiceMapper(PeriodServiceMapper periodServiceMapper)
    {
        this.periodServiceMapper = periodServiceMapper;
    }

}
