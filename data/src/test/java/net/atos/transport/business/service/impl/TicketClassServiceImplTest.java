/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.TicketClass;
import net.atos.transport.entity.jpa.TicketClassEntity;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.TicketClassServiceMapper;
import net.atos.transport.data.repository.jpa.TicketClassJpaRepository;
import net.atos.transport.test.TicketClassFactoryForTest;
import net.atos.transport.test.TicketClassEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of TicketClassService
 */
@RunWith(MockitoJUnitRunner.class)
public class TicketClassServiceImplTest {

	@InjectMocks
	private TicketClassServiceImpl ticketClassService;
	@Mock
	private TicketClassJpaRepository ticketClassJpaRepository;
	@Mock
	private TicketClassServiceMapper ticketClassServiceMapper;
	
	private TicketClassFactoryForTest ticketClassFactoryForTest = new TicketClassFactoryForTest();

	private TicketClassEntityFactoryForTest ticketClassEntityFactoryForTest = new TicketClassEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer ticId = mockValues.nextInteger();
		
		TicketClassEntity ticketClassEntity = ticketClassJpaRepository.findOne(ticId);
		
		TicketClass ticketClass = ticketClassFactoryForTest.newTicketClass();
		when(ticketClassServiceMapper.mapTicketClassEntityToTicketClass(ticketClassEntity)).thenReturn(ticketClass);

		// When
		TicketClass ticketClassFound = ticketClassService.findById(ticId);

		// Then
		assertEquals(ticketClass.getTicId(),ticketClassFound.getTicId());
	}

	@Test
	public void findAll() {
		// Given
		List<TicketClassEntity> ticketClassEntitys = new ArrayList<TicketClassEntity>();
		TicketClassEntity ticketClassEntity1 = ticketClassEntityFactoryForTest.newTicketClassEntity();
		ticketClassEntitys.add(ticketClassEntity1);
		TicketClassEntity ticketClassEntity2 = ticketClassEntityFactoryForTest.newTicketClassEntity();
		ticketClassEntitys.add(ticketClassEntity2);
		when(ticketClassJpaRepository.findAll()).thenReturn(ticketClassEntitys);
		
		TicketClass ticketClass1 = ticketClassFactoryForTest.newTicketClass();
		when(ticketClassServiceMapper.mapTicketClassEntityToTicketClass(ticketClassEntity1)).thenReturn(ticketClass1);
		TicketClass ticketClass2 = ticketClassFactoryForTest.newTicketClass();
		when(ticketClassServiceMapper.mapTicketClassEntityToTicketClass(ticketClassEntity2)).thenReturn(ticketClass2);

		// When
		List<TicketClass> ticketClasssFounds = ticketClassService.findAll();

		// Then
		assertTrue(ticketClass1 == ticketClasssFounds.get(0));
		assertTrue(ticketClass2 == ticketClasssFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		TicketClass ticketClass = ticketClassFactoryForTest.newTicketClass();

		TicketClassEntity ticketClassEntity = ticketClassEntityFactoryForTest.newTicketClassEntity();
		when(ticketClassJpaRepository.findOne(ticketClass.getTicId())).thenReturn(null);
		
		ticketClassEntity = new TicketClassEntity();
		ticketClassServiceMapper.mapTicketClassToTicketClassEntity(ticketClass, ticketClassEntity);
		TicketClassEntity ticketClassEntitySaved = ticketClassJpaRepository.save(ticketClassEntity);
		
		TicketClass ticketClassSaved = ticketClassFactoryForTest.newTicketClass();
		when(ticketClassServiceMapper.mapTicketClassEntityToTicketClass(ticketClassEntitySaved)).thenReturn(ticketClassSaved);

		// When
		TicketClass ticketClassResult = ticketClassService.create(ticketClass);

		// Then
		assertTrue(ticketClassResult == ticketClassSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		TicketClass ticketClass = ticketClassFactoryForTest.newTicketClass();

		TicketClassEntity ticketClassEntity = ticketClassEntityFactoryForTest.newTicketClassEntity();
		when(ticketClassJpaRepository.findOne(ticketClass.getTicId())).thenReturn(ticketClassEntity);

		// When
		Exception exception = null;
		try {
			ticketClassService.create(ticketClass);
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
		TicketClass ticketClass = ticketClassFactoryForTest.newTicketClass();

		TicketClassEntity ticketClassEntity = ticketClassEntityFactoryForTest.newTicketClassEntity();
		when(ticketClassJpaRepository.findOne(ticketClass.getTicId())).thenReturn(ticketClassEntity);
		
		TicketClassEntity ticketClassEntitySaved = ticketClassEntityFactoryForTest.newTicketClassEntity();
		when(ticketClassJpaRepository.save(ticketClassEntity)).thenReturn(ticketClassEntitySaved);
		
		TicketClass ticketClassSaved = ticketClassFactoryForTest.newTicketClass();
		when(ticketClassServiceMapper.mapTicketClassEntityToTicketClass(ticketClassEntitySaved)).thenReturn(ticketClassSaved);

		// When
		TicketClass ticketClassResult = ticketClassService.update(ticketClass);

		// Then
		verify(ticketClassServiceMapper).mapTicketClassToTicketClassEntity(ticketClass, ticketClassEntity);
		assertTrue(ticketClassResult == ticketClassSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer ticId = mockValues.nextInteger();

		// When
		ticketClassService.delete(ticId);

		// Then
		verify(ticketClassJpaRepository).delete(ticId);
		
	}

}
