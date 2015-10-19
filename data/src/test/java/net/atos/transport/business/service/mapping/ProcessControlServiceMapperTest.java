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
import net.atos.transport.entity.ProcessControl;
import net.atos.transport.entity.jpa.ProcessControlEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class ProcessControlServiceMapperTest {

	private ProcessControlServiceMapper processControlServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		processControlServiceMapper = new ProcessControlServiceMapper();
		processControlServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'ProcessControlEntity' to 'ProcessControl'
	 * @param processControlEntity
	 */
	@Test
	public void testMapProcessControlEntityToProcessControl() {
		// Given
		ProcessControlEntity processControlEntity = new ProcessControlEntity();
		processControlEntity.setValue(mockValues.nextString(45));
		
		// When
		ProcessControl processControl = processControlServiceMapper.mapProcessControlEntityToProcessControl(processControlEntity);
		
		// Then
		assertEquals(processControlEntity.getValue(), processControl.getValue());
	}
	
	/**
	 * Test : Mapping from 'ProcessControl' to 'ProcessControlEntity'
	 */
	@Test
	public void testMapProcessControlToProcessControlEntity() {
		// Given
		ProcessControl processControl = new ProcessControl();
		processControl.setValue(mockValues.nextString(45));

		ProcessControlEntity processControlEntity = new ProcessControlEntity();
		
		// When
		processControlServiceMapper.mapProcessControlToProcessControlEntity(processControl, processControlEntity);
		
		// Then
		assertEquals(processControl.getValue(), processControlEntity.getValue());
	}

}