/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.Year;
import net.atos.transport.entity.jpa.YearEntity;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.YearServiceMapper;
import net.atos.transport.data.repository.jpa.YearJpaRepository;
import net.atos.transport.test.YearFactoryForTest;
import net.atos.transport.test.YearEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of YearService
 */
@RunWith(MockitoJUnitRunner.class)
public class YearServiceImplTest {

	@InjectMocks
	private YearServiceImpl yearService;
	@Mock
	private YearJpaRepository yearJpaRepository;
	@Mock
	private YearServiceMapper yearServiceMapper;
	
	private YearFactoryForTest yearFactoryForTest = new YearFactoryForTest();

	private YearEntityFactoryForTest yearEntityFactoryForTest = new YearEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer curYear = mockValues.nextInteger();
		
		YearEntity yearEntity = yearJpaRepository.findOne(curYear);
		
		Year year = yearFactoryForTest.newYear();
		when(yearServiceMapper.mapYearEntityToYear(yearEntity)).thenReturn(year);

		// When
		Year yearFound = yearService.findById(curYear);

		// Then
		assertEquals(year.getYear(),yearFound.getYear());
	}

	@Test
	public void findAll() {
		// Given
		List<YearEntity> yearEntitys = new ArrayList<YearEntity>();
		YearEntity yearEntity1 = yearEntityFactoryForTest.newYearEntity();
		yearEntitys.add(yearEntity1);
		YearEntity yearEntity2 = yearEntityFactoryForTest.newYearEntity();
		yearEntitys.add(yearEntity2);
		when(yearJpaRepository.findAll()).thenReturn(yearEntitys);
		
		Year year1 = yearFactoryForTest.newYear();
		when(yearServiceMapper.mapYearEntityToYear(yearEntity1)).thenReturn(year1);
		Year year2 = yearFactoryForTest.newYear();
		when(yearServiceMapper.mapYearEntityToYear(yearEntity2)).thenReturn(year2);

		// When
		List<Year> yearsFounds = yearService.findAll();

		// Then
		assertTrue(year1 == yearsFounds.get(0));
		assertTrue(year2 == yearsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Year year = yearFactoryForTest.newYear();

		YearEntity yearEntity = yearEntityFactoryForTest.newYearEntity();
		when(yearJpaRepository.findOne(year.getYear())).thenReturn(null);
		
		yearEntity = new YearEntity();
		yearServiceMapper.mapYearToYearEntity(year, yearEntity);
		YearEntity yearEntitySaved = yearJpaRepository.save(yearEntity);
		
		Year yearSaved = yearFactoryForTest.newYear();
		when(yearServiceMapper.mapYearEntityToYear(yearEntitySaved)).thenReturn(yearSaved);

		// When
		Year yearResult = yearService.create(year);

		// Then
		assertTrue(yearResult == yearSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Year year = yearFactoryForTest.newYear();

		YearEntity yearEntity = yearEntityFactoryForTest.newYearEntity();
		when(yearJpaRepository.findOne(year.getYear())).thenReturn(yearEntity);

		// When
		Exception exception = null;
		try {
			yearService.create(year);
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
		Year year = yearFactoryForTest.newYear();

		YearEntity yearEntity = yearEntityFactoryForTest.newYearEntity();
		when(yearJpaRepository.findOne(year.getYear())).thenReturn(yearEntity);
		
		YearEntity yearEntitySaved = yearEntityFactoryForTest.newYearEntity();
		when(yearJpaRepository.save(yearEntity)).thenReturn(yearEntitySaved);
		
		Year yearSaved = yearFactoryForTest.newYear();
		when(yearServiceMapper.mapYearEntityToYear(yearEntitySaved)).thenReturn(yearSaved);

		// When
		Year yearResult = yearService.update(year);

		// Then
		verify(yearServiceMapper).mapYearToYearEntity(year, yearEntity);
		assertTrue(yearResult == yearSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer year = mockValues.nextInteger();

		// When
		yearService.delete(year);

		// Then
		verify(yearJpaRepository).delete(year);
		
	}

}
