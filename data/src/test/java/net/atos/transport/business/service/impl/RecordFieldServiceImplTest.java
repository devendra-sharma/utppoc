/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.RecordField;
import net.atos.transport.entity.jpa.RecordFieldEntity;
import java.util.Date;
import net.atos.transport.business.service.mapping.RecordFieldServiceMapper;
import net.atos.transport.data.repository.jpa.RecordFieldJpaRepository;
import net.atos.transport.test.RecordFieldFactoryForTest;
import net.atos.transport.test.RecordFieldEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of RecordFieldService
 */
@RunWith(MockitoJUnitRunner.class)
public class RecordFieldServiceImplTest {

	@InjectMocks
	private RecordFieldServiceImpl recordFieldService;
	@Mock
	private RecordFieldJpaRepository recordFieldJpaRepository;
	@Mock
	private RecordFieldServiceMapper recordFieldServiceMapper;
	
	private RecordFieldFactoryForTest recordFieldFactoryForTest = new RecordFieldFactoryForTest();

	private RecordFieldEntityFactoryForTest recordFieldEntityFactoryForTest = new RecordFieldEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer refId = mockValues.nextInteger();
		
		RecordFieldEntity recordFieldEntity = recordFieldJpaRepository.findOne(refId);
		
		RecordField recordField = recordFieldFactoryForTest.newRecordField();
		when(recordFieldServiceMapper.mapRecordFieldEntityToRecordField(recordFieldEntity)).thenReturn(recordField);

		// When
		RecordField recordFieldFound = recordFieldService.findById(refId);

		// Then
		assertEquals(recordField.getRefId(),recordFieldFound.getRefId());
	}

	@Test
	public void findAll() {
		// Given
		List<RecordFieldEntity> recordFieldEntitys = new ArrayList<RecordFieldEntity>();
		RecordFieldEntity recordFieldEntity1 = recordFieldEntityFactoryForTest.newRecordFieldEntity();
		recordFieldEntitys.add(recordFieldEntity1);
		RecordFieldEntity recordFieldEntity2 = recordFieldEntityFactoryForTest.newRecordFieldEntity();
		recordFieldEntitys.add(recordFieldEntity2);
		when(recordFieldJpaRepository.findAll()).thenReturn(recordFieldEntitys);
		
		RecordField recordField1 = recordFieldFactoryForTest.newRecordField();
		when(recordFieldServiceMapper.mapRecordFieldEntityToRecordField(recordFieldEntity1)).thenReturn(recordField1);
		RecordField recordField2 = recordFieldFactoryForTest.newRecordField();
		when(recordFieldServiceMapper.mapRecordFieldEntityToRecordField(recordFieldEntity2)).thenReturn(recordField2);

		// When
		List<RecordField> recordFieldsFounds = recordFieldService.findAll();

		// Then
		assertTrue(recordField1 == recordFieldsFounds.get(0));
		assertTrue(recordField2 == recordFieldsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		RecordField recordField = recordFieldFactoryForTest.newRecordField();

		RecordFieldEntity recordFieldEntity = recordFieldEntityFactoryForTest.newRecordFieldEntity();
		when(recordFieldJpaRepository.findOne(recordField.getRefId())).thenReturn(null);
		
		recordFieldEntity = new RecordFieldEntity();
		recordFieldServiceMapper.mapRecordFieldToRecordFieldEntity(recordField, recordFieldEntity);
		RecordFieldEntity recordFieldEntitySaved = recordFieldJpaRepository.save(recordFieldEntity);
		
		RecordField recordFieldSaved = recordFieldFactoryForTest.newRecordField();
		when(recordFieldServiceMapper.mapRecordFieldEntityToRecordField(recordFieldEntitySaved)).thenReturn(recordFieldSaved);

		// When
		RecordField recordFieldResult = recordFieldService.create(recordField);

		// Then
		assertTrue(recordFieldResult == recordFieldSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		RecordField recordField = recordFieldFactoryForTest.newRecordField();

		RecordFieldEntity recordFieldEntity = recordFieldEntityFactoryForTest.newRecordFieldEntity();
		when(recordFieldJpaRepository.findOne(recordField.getRefId())).thenReturn(recordFieldEntity);

		// When
		Exception exception = null;
		try {
			recordFieldService.create(recordField);
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
		RecordField recordField = recordFieldFactoryForTest.newRecordField();

		RecordFieldEntity recordFieldEntity = recordFieldEntityFactoryForTest.newRecordFieldEntity();
		when(recordFieldJpaRepository.findOne(recordField.getRefId())).thenReturn(recordFieldEntity);
		
		RecordFieldEntity recordFieldEntitySaved = recordFieldEntityFactoryForTest.newRecordFieldEntity();
		when(recordFieldJpaRepository.save(recordFieldEntity)).thenReturn(recordFieldEntitySaved);
		
		RecordField recordFieldSaved = recordFieldFactoryForTest.newRecordField();
		when(recordFieldServiceMapper.mapRecordFieldEntityToRecordField(recordFieldEntitySaved)).thenReturn(recordFieldSaved);

		// When
		RecordField recordFieldResult = recordFieldService.update(recordField);

		// Then
		verify(recordFieldServiceMapper).mapRecordFieldToRecordFieldEntity(recordField, recordFieldEntity);
		assertTrue(recordFieldResult == recordFieldSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer refId = mockValues.nextInteger();

		// When
		recordFieldService.delete(refId);

		// Then
		verify(recordFieldJpaRepository).delete(refId);
		
	}

}
