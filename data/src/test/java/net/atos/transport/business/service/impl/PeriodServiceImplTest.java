/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.Period;
import net.atos.transport.entity.jpa.PeriodEntity;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.PeriodServiceMapper;
import net.atos.transport.data.repository.jpa.PeriodJpaRepository;
import net.atos.transport.test.PeriodFactoryForTest;
import net.atos.transport.test.PeriodEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of PeriodService
 */
@RunWith(MockitoJUnitRunner.class)
public class PeriodServiceImplTest {

	@InjectMocks
	private PeriodServiceImpl periodService;
	@Mock
	private PeriodJpaRepository periodJpaRepository;
	@Mock
	private PeriodServiceMapper periodServiceMapper;
	
	private PeriodFactoryForTest periodFactoryForTest = new PeriodFactoryForTest();

	private PeriodEntityFactoryForTest periodEntityFactoryForTest = new PeriodEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer perId = mockValues.nextInteger();
		
		PeriodEntity periodEntity = periodJpaRepository.findOne(perId);
		
		Period period = periodFactoryForTest.newPeriod();
		when(periodServiceMapper.mapPeriodEntityToPeriod(periodEntity)).thenReturn(period);

		// When
		Period periodFound = periodService.findById(perId);

		// Then
		assertEquals(period.getPerId(),periodFound.getPerId());
	}

	@Test
	public void findAll() {
		// Given
		List<PeriodEntity> periodEntitys = new ArrayList<PeriodEntity>();
		PeriodEntity periodEntity1 = periodEntityFactoryForTest.newPeriodEntity();
		periodEntitys.add(periodEntity1);
		PeriodEntity periodEntity2 = periodEntityFactoryForTest.newPeriodEntity();
		periodEntitys.add(periodEntity2);
		when(periodJpaRepository.findAll()).thenReturn(periodEntitys);
		
		Period period1 = periodFactoryForTest.newPeriod();
		when(periodServiceMapper.mapPeriodEntityToPeriod(periodEntity1)).thenReturn(period1);
		Period period2 = periodFactoryForTest.newPeriod();
		when(periodServiceMapper.mapPeriodEntityToPeriod(periodEntity2)).thenReturn(period2);

		// When
		List<Period> periodsFounds = periodService.findAll();

		// Then
		assertTrue(period1 == periodsFounds.get(0));
		assertTrue(period2 == periodsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Period period = periodFactoryForTest.newPeriod();

		PeriodEntity periodEntity = periodEntityFactoryForTest.newPeriodEntity();
		when(periodJpaRepository.findOne(period.getPerId())).thenReturn(null);
		
		periodEntity = new PeriodEntity();
		periodServiceMapper.mapPeriodToPeriodEntity(period, periodEntity);
		PeriodEntity periodEntitySaved = periodJpaRepository.save(periodEntity);
		
		Period periodSaved = periodFactoryForTest.newPeriod();
		when(periodServiceMapper.mapPeriodEntityToPeriod(periodEntitySaved)).thenReturn(periodSaved);

		// When
		Period periodResult = periodService.create(period);

		// Then
		assertTrue(periodResult == periodSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Period period = periodFactoryForTest.newPeriod();

		PeriodEntity periodEntity = periodEntityFactoryForTest.newPeriodEntity();
		when(periodJpaRepository.findOne(period.getPerId())).thenReturn(periodEntity);

		// When
		Exception exception = null;
		try {
			periodService.create(period);
		} catch(Exception e) {
			exception = e;
		}

		// Then
		assertTrue(exception instanceof IllegalStateException);
		assertEquals("already.exists", exception.getMessage());
	}

	@Test
	public void update() {
		// Given
		Period period = periodFactoryForTest.newPeriod();

		PeriodEntity periodEntity = periodEntityFactoryForTest.newPeriodEntity();
		when(periodJpaRepository.findOne(period.getPerId())).thenReturn(periodEntity);
		
		PeriodEntity periodEntitySaved = periodEntityFactoryForTest.newPeriodEntity();
		when(periodJpaRepository.save(periodEntity)).thenReturn(periodEntitySaved);
		
		Period periodSaved = periodFactoryForTest.newPeriod();
		when(periodServiceMapper.mapPeriodEntityToPeriod(periodEntitySaved)).thenReturn(periodSaved);

		// When
		Period periodResult = periodService.update(period);

		// Then
		verify(periodServiceMapper).mapPeriodToPeriodEntity(period, periodEntity);
		assertTrue(periodResult == periodSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer perId = mockValues.nextInteger();

		// When
		periodService.delete(perId);

		// Then
		verify(periodJpaRepository).delete(perId);
		
	}

}
