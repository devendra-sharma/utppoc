/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.annotation.Resource;

import net.atos.transport.business.service.CalendarService;
import net.atos.transport.business.service.mapping.CalendarServiceMapper;
import net.atos.transport.data.repository.jpa.CalendarJpaRepository;
import net.atos.transport.entity.Calendar;
import net.atos.transport.entity.jpa.CalendarEntity;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of CalendarService
 */
@Component
@Transactional
public class CalendarServiceImpl implements CalendarService {

    @Resource
    private CalendarJpaRepository calendarJpaRepository;

    @Resource
    private CalendarServiceMapper calendarServiceMapper;

    @Override
    public Calendar findById(Integer calId) {
        CalendarEntity calendarEntity = calendarJpaRepository.findOne(calId);
        return calendarServiceMapper
                .mapCalendarEntityToCalendar(calendarEntity);
    }

    @Override
    public List<Calendar> findAll() {
        Iterable<CalendarEntity> entities = calendarJpaRepository.findAll();
        List<Calendar> beans = new ArrayList<Calendar>();
        for (CalendarEntity calendarEntity : entities) {
            beans.add(calendarServiceMapper
                    .mapCalendarEntityToCalendar(calendarEntity));
        }
        return beans;
    }

    @Override
    public Calendar save(Calendar calendar) {
        return update(calendar);
    }

    @Override
    public Calendar create(Calendar calendar) {
        CalendarEntity calendarEntity = calendarJpaRepository.findOne(calendar
                .getCalId());
        if (calendarEntity != null) {
            throw new IllegalStateException("already.exists");
        }
        calendarEntity = new CalendarEntity();
        calendarServiceMapper.mapCalendarToCalendarEntity(calendar,
                calendarEntity);
        CalendarEntity calendarEntitySaved = calendarJpaRepository
                .save(calendarEntity);
        return calendarServiceMapper
                .mapCalendarEntityToCalendar(calendarEntitySaved);
    }

    @Override
    public Calendar update(Calendar calendar) {
        CalendarEntity calendarEntity = calendarJpaRepository.findOne(calendar
                .getCalId());
        calendarServiceMapper.mapCalendarToCalendarEntity(calendar,
                calendarEntity);
        CalendarEntity calendarEntitySaved = calendarJpaRepository
                .save(calendarEntity);
        return calendarServiceMapper
                .mapCalendarEntityToCalendar(calendarEntitySaved);
    }

    @Override
    public void delete(Integer calId) {
        calendarJpaRepository.delete(calId);
    }

    public CalendarJpaRepository getCalendarJpaRepository() {
        return calendarJpaRepository;
    }

    public void setCalendarJpaRepository(
            CalendarJpaRepository calendarJpaRepository) {
        this.calendarJpaRepository = calendarJpaRepository;
    }

    public CalendarServiceMapper getCalendarServiceMapper() {
        return calendarServiceMapper;
    }

    public void setCalendarServiceMapper(
            CalendarServiceMapper calendarServiceMapper) {
        this.calendarServiceMapper = calendarServiceMapper;
    }

    @Override
    public List<Calendar> getbyCalendarIds(List<Integer> ids) {
        List<CalendarEntity> calEntity = calendarJpaRepository
                .findByCalIdIn(ids);
        List<Calendar> listCal = new ArrayList<Calendar>();
        for (CalendarEntity cal : calEntity) {
            listCal.add(calendarServiceMapper.mapCalendarEntityToCalendar(cal));
        }
        return listCal;
    }

    @Override
    public Calendar findBySaleDate(Date saleDate) {
        CalendarEntity entity = calendarJpaRepository.findBySaleDate(saleDate);
        return calendarServiceMapper.mapCalendarEntityToCalendar(entity);
    }
}
