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
import net.atos.transport.entity.GroupFunctionType;
import net.atos.transport.entity.jpa.GroupFunctionTypeEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class GroupFunctionTypeServiceMapperTest {

	private GroupFunctionTypeServiceMapper groupFunctionTypeServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		groupFunctionTypeServiceMapper = new GroupFunctionTypeServiceMapper();
		groupFunctionTypeServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'GroupFunctionTypeEntity' to 'GroupFunctionType'
	 * @param groupFunctionTypeEntity
	 */
	@Test
	public void testMapGroupFunctionTypeEntityToGroupFunctionType() {
		// Given
		GroupFunctionTypeEntity groupFunctionTypeEntity = new GroupFunctionTypeEntity();
		groupFunctionTypeEntity.setGroupFunctionTypeDesc(mockValues.nextString(32));
		groupFunctionTypeEntity.setExpired(mockValues.nextString(1));
		groupFunctionTypeEntity.setEffectiveFrom(mockValues.nextDate());
		groupFunctionTypeEntity.setEffectiveTo(mockValues.nextDate());
		
		// When
		GroupFunctionType groupFunctionType = groupFunctionTypeServiceMapper.mapGroupFunctionTypeEntityToGroupFunctionType(groupFunctionTypeEntity);
		
		// Then
		assertEquals(groupFunctionTypeEntity.getGroupFunctionTypeDesc(), groupFunctionType.getGroupFunctionTypeDesc());
		assertEquals(groupFunctionTypeEntity.getExpired(), groupFunctionType.getExpired());
		assertEquals(groupFunctionTypeEntity.getEffectiveFrom(), groupFunctionType.getEffectiveFrom());
		assertEquals(groupFunctionTypeEntity.getEffectiveTo(), groupFunctionType.getEffectiveTo());
	}
	
	/**
	 * Test : Mapping from 'GroupFunctionType' to 'GroupFunctionTypeEntity'
	 */
	@Test
	public void testMapGroupFunctionTypeToGroupFunctionTypeEntity() {
		// Given
		GroupFunctionType groupFunctionType = new GroupFunctionType();
		groupFunctionType.setGroupFunctionTypeDesc(mockValues.nextString(32));
		groupFunctionType.setExpired(mockValues.nextString(1));
		groupFunctionType.setEffectiveFrom(mockValues.nextDate());
		groupFunctionType.setEffectiveTo(mockValues.nextDate());

		GroupFunctionTypeEntity groupFunctionTypeEntity = new GroupFunctionTypeEntity();
		
		// When
		groupFunctionTypeServiceMapper.mapGroupFunctionTypeToGroupFunctionTypeEntity(groupFunctionType, groupFunctionTypeEntity);
		
		// Then
		assertEquals(groupFunctionType.getGroupFunctionTypeDesc(), groupFunctionTypeEntity.getGroupFunctionTypeDesc());
		assertEquals(groupFunctionType.getExpired(), groupFunctionTypeEntity.getExpired());
		assertEquals(groupFunctionType.getEffectiveFrom(), groupFunctionTypeEntity.getEffectiveFrom());
		assertEquals(groupFunctionType.getEffectiveTo(), groupFunctionTypeEntity.getEffectiveTo());
	}

}