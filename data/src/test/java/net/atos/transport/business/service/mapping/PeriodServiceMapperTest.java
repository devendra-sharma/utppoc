/*


 */
package net.atos.transport.business.service.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.Period;
import net.atos.transport.entity.jpa.PeriodEntity;
import net.atos.transport.entity.jpa.YearEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class PeriodServiceMapperTest {

	private PeriodServiceMapper periodServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		periodServiceMapper = new PeriodServiceMapper();
		periodServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'PeriodEntity' to 'Period'
	 * @param periodEntity
	 */
	@Test
	public void testMapPeriodEntityToPeriod() {
		// Given
		PeriodEntity periodEntity = new PeriodEntity();
		periodEntity.setPeriod(mockValues.nextInteger());
		periodEntity.setStartDate(mockValues.nextDate());
		periodEntity.setEndDate(mockValues.nextDate());
		periodEntity.setStatus(mockValues.nextString(6));
		periodEntity.setPeriodMask(mockValues.nextString(8));
		periodEntity.setYear2(new YearEntity());
		periodEntity.getYear2().setYear(mockValues.nextInteger());
		
		// When
		Period period = periodServiceMapper.mapPeriodEntityToPeriod(periodEntity);
		
		// Then
		assertEquals(periodEntity.getPeriod(), period.getPeriod());
		assertEquals(periodEntity.getStartDate(), period.getStartDate());
		assertEquals(periodEntity.getEndDate(), period.getEndDate());
		assertEquals(periodEntity.getStatus(), period.getStatus());
		assertEquals(periodEntity.getPeriodMask(), period.getPeriodMask());
		assertEquals(periodEntity.getYear2().getYear(), period.getYear());
	}
	
	/**
	 * Test : Mapping from 'Period' to 'PeriodEntity'
	 */
	@Test
	public void testMapPeriodToPeriodEntity() {
		// Given
		Period period = new Period();
		period.setPeriod(mockValues.nextInteger());
		period.setStartDate(mockValues.nextDate());
		period.setEndDate(mockValues.nextDate());
		period.setStatus(mockValues.nextString(6));
		period.setPeriodMask(mockValues.nextString(8));
		period.setYear(mockValues.nextInteger());

		PeriodEntity periodEntity = new PeriodEntity();
		
		// When
		periodServiceMapper.mapPeriodToPeriodEntity(period, periodEntity);
		
		// Then
		assertEquals(period.getPeriod(), periodEntity.getPeriod());
		assertEquals(period.getStartDate(), periodEntity.getStartDate());
		assertEquals(period.getEndDate(), periodEntity.getEndDate());
		assertEquals(period.getStatus(), periodEntity.getStatus());
		assertEquals(period.getPeriodMask(), periodEntity.getPeriodMask());
		assertEquals(period.getYear(), periodEntity.getYear2().getYear());
	}

}