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
import net.atos.transport.entity.RouteLink;
import net.atos.transport.entity.jpa.RouteLinkEntity;
import net.atos.transport.entity.jpa.RouteEntity;
import net.atos.transport.entity.jpa.RouteEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class RouteLinkServiceMapperTest {

	private RouteLinkServiceMapper routeLinkServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		routeLinkServiceMapper = new RouteLinkServiceMapper();
		routeLinkServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'RouteLinkEntity' to 'RouteLink'
	 * @param routeLinkEntity
	 */
	@Test
	public void testMapRouteLinkEntityToRouteLink() {
		// Given
		RouteLinkEntity routeLinkEntity = new RouteLinkEntity();
		routeLinkEntity.setExpired(mockValues.nextString(1));
		routeLinkEntity.setEffectiveFrom(mockValues.nextDate());
		routeLinkEntity.setEffectiveTo(mockValues.nextDate());
		routeLinkEntity.setRoute2(new RouteEntity());
		routeLinkEntity.getRoute2().setRouId(mockValues.nextInteger());
		routeLinkEntity.setRoute(new RouteEntity());
		routeLinkEntity.getRoute().setRouId(mockValues.nextInteger());
		
		// When
		RouteLink routeLink = routeLinkServiceMapper.mapRouteLinkEntityToRouteLink(routeLinkEntity);
		
		// Then
		assertEquals(routeLinkEntity.getExpired(), routeLink.getExpired());
		assertEquals(routeLinkEntity.getEffectiveFrom(), routeLink.getEffectiveFrom());
		assertEquals(routeLinkEntity.getEffectiveTo(), routeLink.getEffectiveTo());
		assertEquals(routeLinkEntity.getRoute2().getRouId(), routeLink.getRouIdParent());
		assertEquals(routeLinkEntity.getRoute().getRouId(), routeLink.getRouIdChild());
	}
	
	/**
	 * Test : Mapping from 'RouteLink' to 'RouteLinkEntity'
	 */
	@Test
	public void testMapRouteLinkToRouteLinkEntity() {
		// Given
		RouteLink routeLink = new RouteLink();
		routeLink.setExpired(mockValues.nextString(1));
		routeLink.setEffectiveFrom(mockValues.nextDate());
		routeLink.setEffectiveTo(mockValues.nextDate());
		routeLink.setRouIdParent(mockValues.nextInteger());
		routeLink.setRouIdChild(mockValues.nextInteger());

		RouteLinkEntity routeLinkEntity = new RouteLinkEntity();
		
		// When
		routeLinkServiceMapper.mapRouteLinkToRouteLinkEntity(routeLink, routeLinkEntity);
		
		// Then
		assertEquals(routeLink.getExpired(), routeLinkEntity.getExpired());
		assertEquals(routeLink.getEffectiveFrom(), routeLinkEntity.getEffectiveFrom());
		assertEquals(routeLink.getEffectiveTo(), routeLinkEntity.getEffectiveTo());
		assertEquals(routeLink.getRouIdParent(), routeLinkEntity.getRoute2().getRouId());
		assertEquals(routeLink.getRouIdChild(), routeLinkEntity.getRoute().getRouId());
	}

}