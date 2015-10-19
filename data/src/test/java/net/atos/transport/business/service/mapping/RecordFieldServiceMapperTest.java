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
import net.atos.transport.entity.RecordField;
import net.atos.transport.entity.jpa.RecordFieldEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class RecordFieldServiceMapperTest {

	private RecordFieldServiceMapper recordFieldServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		recordFieldServiceMapper = new RecordFieldServiceMapper();
		recordFieldServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'RecordFieldEntity' to 'RecordField'
	 * @param recordFieldEntity
	 */
	@Test
	public void testMapRecordFieldEntityToRecordField() {
		// Given
		RecordFieldEntity recordFieldEntity = new RecordFieldEntity();
		recordFieldEntity.setRefIdTp(mockValues.nextInteger());
		recordFieldEntity.setNameOfSourceField(mockValues.nextString(32));
		recordFieldEntity.setFieldNumber(mockValues.nextInteger());
		recordFieldEntity.setPosition(mockValues.nextInteger());
		recordFieldEntity.setLength(mockValues.nextInteger());
		recordFieldEntity.setRecordType(mockValues.nextString(2));
		recordFieldEntity.setEffectiveFrom(mockValues.nextDate());
		recordFieldEntity.setEffectiveTo(mockValues.nextDate());
		recordFieldEntity.setExpired(mockValues.nextString(1));
		
		// When
		RecordField recordField = recordFieldServiceMapper.mapRecordFieldEntityToRecordField(recordFieldEntity);
		
		// Then
		assertEquals(recordFieldEntity.getRefIdTp(), recordField.getRefIdTp());
		assertEquals(recordFieldEntity.getNameOfSourceField(), recordField.getNameOfSourceField());
		assertEquals(recordFieldEntity.getFieldNumber(), recordField.getFieldNumber());
		assertEquals(recordFieldEntity.getPosition(), recordField.getPosition());
		assertEquals(recordFieldEntity.getLength(), recordField.getLength());
		assertEquals(recordFieldEntity.getRecordType(), recordField.getRecordType());
		assertEquals(recordFieldEntity.getEffectiveFrom(), recordField.getEffectiveFrom());
		assertEquals(recordFieldEntity.getEffectiveTo(), recordField.getEffectiveTo());
		assertEquals(recordFieldEntity.getExpired(), recordField.getExpired());
	}
	
	/**
	 * Test : Mapping from 'RecordField' to 'RecordFieldEntity'
	 */
	@Test
	public void testMapRecordFieldToRecordFieldEntity() {
		// Given
		RecordField recordField = new RecordField();
		recordField.setRefIdTp(mockValues.nextInteger());
		recordField.setNameOfSourceField(mockValues.nextString(32));
		recordField.setFieldNumber(mockValues.nextInteger());
		recordField.setPosition(mockValues.nextInteger());
		recordField.setLength(mockValues.nextInteger());
		recordField.setRecordType(mockValues.nextString(2));
		recordField.setEffectiveFrom(mockValues.nextDate());
		recordField.setEffectiveTo(mockValues.nextDate());
		recordField.setExpired(mockValues.nextString(1));

		RecordFieldEntity recordFieldEntity = new RecordFieldEntity();
		
		// When
		recordFieldServiceMapper.mapRecordFieldToRecordFieldEntity(recordField, recordFieldEntity);
		
		// Then
		assertEquals(recordField.getRefIdTp(), recordFieldEntity.getRefIdTp());
		assertEquals(recordField.getNameOfSourceField(), recordFieldEntity.getNameOfSourceField());
		assertEquals(recordField.getFieldNumber(), recordFieldEntity.getFieldNumber());
		assertEquals(recordField.getPosition(), recordFieldEntity.getPosition());
		assertEquals(recordField.getLength(), recordFieldEntity.getLength());
		assertEquals(recordField.getRecordType(), recordFieldEntity.getRecordType());
		assertEquals(recordField.getEffectiveFrom(), recordFieldEntity.getEffectiveFrom());
		assertEquals(recordField.getEffectiveTo(), recordFieldEntity.getEffectiveTo());
		assertEquals(recordField.getExpired(), recordFieldEntity.getExpired());
	}

}