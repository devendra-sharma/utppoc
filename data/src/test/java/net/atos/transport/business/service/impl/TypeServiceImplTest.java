/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.Type;
import net.atos.transport.entity.jpa.TypeEntity;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.TypeServiceMapper;
import net.atos.transport.data.repository.jpa.TypeJpaRepository;
import net.atos.transport.test.TypeFactoryForTest;
import net.atos.transport.test.TypeEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of TypeService
 */
@RunWith(MockitoJUnitRunner.class)
public class TypeServiceImplTest {

	@InjectMocks
	private TypeServiceImpl typeService;
	@Mock
	private TypeJpaRepository typeJpaRepository;
	@Mock
	private TypeServiceMapper typeServiceMapper;
	
	private TypeFactoryForTest typeFactoryForTest = new TypeFactoryForTest();

	private TypeEntityFactoryForTest typeEntityFactoryForTest = new TypeEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer typId = mockValues.nextInteger();
		
		TypeEntity typeEntity = typeJpaRepository.findOne(typId);
		
		Type type = typeFactoryForTest.newType();
		when(typeServiceMapper.mapTypeEntityToType(typeEntity)).thenReturn(type);

		// When
		Type typeFound = typeService.findById(typId);

		// Then
		assertEquals(type.getTypId(),typeFound.getTypId());
	}

	@Test
	public void findAll() {
		// Given
		List<TypeEntity> typeEntitys = new ArrayList<TypeEntity>();
		TypeEntity typeEntity1 = typeEntityFactoryForTest.newTypeEntity();
		typeEntitys.add(typeEntity1);
		TypeEntity typeEntity2 = typeEntityFactoryForTest.newTypeEntity();
		typeEntitys.add(typeEntity2);
		when(typeJpaRepository.findAll()).thenReturn(typeEntitys);
		
		Type type1 = typeFactoryForTest.newType();
		when(typeServiceMapper.mapTypeEntityToType(typeEntity1)).thenReturn(type1);
		Type type2 = typeFactoryForTest.newType();
		when(typeServiceMapper.mapTypeEntityToType(typeEntity2)).thenReturn(type2);

		// When
		List<Type> typesFounds = typeService.findAll();

		// Then
		assertTrue(type1 == typesFounds.get(0));
		assertTrue(type2 == typesFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Type type = typeFactoryForTest.newType();

		TypeEntity typeEntity = typeEntityFactoryForTest.newTypeEntity();
		when(typeJpaRepository.findOne(type.getTypId())).thenReturn(null);
		
		typeEntity = new TypeEntity();
		typeServiceMapper.mapTypeToTypeEntity(type, typeEntity);
		TypeEntity typeEntitySaved = typeJpaRepository.save(typeEntity);
		
		Type typeSaved = typeFactoryForTest.newType();
		when(typeServiceMapper.mapTypeEntityToType(typeEntitySaved)).thenReturn(typeSaved);

		// When
		Type typeResult = typeService.create(type);

		// Then
		assertTrue(typeResult == typeSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Type type = typeFactoryForTest.newType();

		TypeEntity typeEntity = typeEntityFactoryForTest.newTypeEntity();
		when(typeJpaRepository.findOne(type.getTypId())).thenReturn(typeEntity);

		// When
		Exception exception = null;
		try {
			typeService.create(type);
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
		Type type = typeFactoryForTest.newType();

		TypeEntity typeEntity = typeEntityFactoryForTest.newTypeEntity();
		when(typeJpaRepository.findOne(type.getTypId())).thenReturn(typeEntity);
		
		TypeEntity typeEntitySaved = typeEntityFactoryForTest.newTypeEntity();
		when(typeJpaRepository.save(typeEntity)).thenReturn(typeEntitySaved);
		
		Type typeSaved = typeFactoryForTest.newType();
		when(typeServiceMapper.mapTypeEntityToType(typeEntitySaved)).thenReturn(typeSaved);

		// When
		Type typeResult = typeService.update(type);

		// Then
		verify(typeServiceMapper).mapTypeToTypeEntity(type, typeEntity);
		assertTrue(typeResult == typeSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer typId = mockValues.nextInteger();

		// When
		typeService.delete(typId);

		// Then
		verify(typeJpaRepository).delete(typId);
		
	}

}
