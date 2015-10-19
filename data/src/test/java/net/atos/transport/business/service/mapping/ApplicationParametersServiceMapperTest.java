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
import net.atos.transport.entity.ApplicationParameters;
import net.atos.transport.entity.jpa.ApplicationParametersEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class ApplicationParametersServiceMapperTest {

	private ApplicationParametersServiceMapper applicationParametersServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		applicationParametersServiceMapper = new ApplicationParametersServiceMapper();
		applicationParametersServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'ApplicationParametersEntity' to 'ApplicationParameters'
	 * @param applicationParametersEntity
	 */
	@Test
	public void testMapApplicationParametersEntityToApplicationParameters() {
		// Given
		ApplicationParametersEntity applicationParametersEntity = new ApplicationParametersEntity();
		applicationParametersEntity.setValue(mockValues.nextString(45));
		
		// When
		ApplicationParameters applicationParameters = applicationParametersServiceMapper.mapApplicationParametersEntityToApplicationParameters(applicationParametersEntity);
		
		// Then
		assertEquals(applicationParametersEntity.getValue(), applicationParameters.getValue());
	}
	
	/**
	 * Test : Mapping from 'ApplicationParameters' to 'ApplicationParametersEntity'
	 */
	@Test
	public void testMapApplicationParametersToApplicationParametersEntity() {
		// Given
		ApplicationParameters applicationParameters = new ApplicationParameters();
		applicationParameters.setValue(mockValues.nextString(45));

		ApplicationParametersEntity applicationParametersEntity = new ApplicationParametersEntity();
		
		// When
		applicationParametersServiceMapper.mapApplicationParametersToApplicationParametersEntity(applicationParameters, applicationParametersEntity);
		
		// Then
		assertEquals(applicationParameters.getValue(), applicationParametersEntity.getValue());
	}

}