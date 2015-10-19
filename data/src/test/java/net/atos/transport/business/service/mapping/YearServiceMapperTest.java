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
import net.atos.transport.entity.Year;
import net.atos.transport.entity.jpa.YearEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class YearServiceMapperTest {

	private YearServiceMapper yearServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		yearServiceMapper = new YearServiceMapper();
		yearServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'YearEntity' to 'Year'
	 * @param yearEntity
	 */
	@Test
	public void testMapYearEntityToYear() {
		// Given
		YearEntity yearEntity = new YearEntity();
		yearEntity.setStartDate(mockValues.nextDate());
		yearEntity.setEndDate(mockValues.nextDate());
		
		// When
		Year year = yearServiceMapper.mapYearEntityToYear(yearEntity);
		
		// Then
		assertEquals(yearEntity.getStartDate(), year.getStartDate());
		assertEquals(yearEntity.getEndDate(), year.getEndDate());
	}
	
	/**
	 * Test : Mapping from 'Year' to 'YearEntity'
	 */
	@Test
	public void testMapYearToYearEntity() {
		// Given
		Year year = new Year();
		year.setStartDate(mockValues.nextDate());
		year.setEndDate(mockValues.nextDate());

		YearEntity yearEntity = new YearEntity();
		
		// When
		yearServiceMapper.mapYearToYearEntity(year, yearEntity);
		
		// Then
		assertEquals(year.getStartDate(), yearEntity.getStartDate());
		assertEquals(year.getEndDate(), yearEntity.getEndDate());
	}

}