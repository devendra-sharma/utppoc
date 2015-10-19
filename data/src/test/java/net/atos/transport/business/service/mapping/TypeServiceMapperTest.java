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
import net.atos.transport.entity.Type;
import net.atos.transport.entity.jpa.TypeEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class TypeServiceMapperTest {

	private TypeServiceMapper typeServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		typeServiceMapper = new TypeServiceMapper();
		typeServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'TypeEntity' to 'Type'
	 * @param typeEntity
	 */
	@Test
	public void testMapTypeEntityToType() {
		// Given
		TypeEntity typeEntity = new TypeEntity();
		typeEntity.setType(mockValues.nextString(32));
		typeEntity.setMaintainType(mockValues.nextString(1));
		typeEntity.setExpired(mockValues.nextString(1));
		typeEntity.setEffectiveFrom(mockValues.nextDate());
		typeEntity.setEffectiveTo(mockValues.nextDate());
		
		// When
		Type type = typeServiceMapper.mapTypeEntityToType(typeEntity);
		
		// Then
		assertEquals(typeEntity.getType(), type.getType());
		assertEquals(typeEntity.getMaintainType(), type.getMaintainType());
		assertEquals(typeEntity.getExpired(), type.getExpired());
		assertEquals(typeEntity.getEffectiveFrom(), type.getEffectiveFrom());
		assertEquals(typeEntity.getEffectiveTo(), type.getEffectiveTo());
	}
	
	/**
	 * Test : Mapping from 'Type' to 'TypeEntity'
	 */
	@Test
	public void testMapTypeToTypeEntity() {
		// Given
		Type type = new Type();
		type.setType(mockValues.nextString(32));
		type.setMaintainType(mockValues.nextString(1));
		type.setExpired(mockValues.nextString(1));
		type.setEffectiveFrom(mockValues.nextDate());
		type.setEffectiveTo(mockValues.nextDate());

		TypeEntity typeEntity = new TypeEntity();
		
		// When
		typeServiceMapper.mapTypeToTypeEntity(type, typeEntity);
		
		// Then
		assertEquals(type.getType(), typeEntity.getType());
		assertEquals(type.getMaintainType(), typeEntity.getMaintainType());
		assertEquals(type.getExpired(), typeEntity.getExpired());
		assertEquals(type.getEffectiveFrom(), typeEntity.getEffectiveFrom());
		assertEquals(type.getEffectiveTo(), typeEntity.getEffectiveTo());
	}

}