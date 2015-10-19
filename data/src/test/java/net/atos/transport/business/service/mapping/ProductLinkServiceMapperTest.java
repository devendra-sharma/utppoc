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
import net.atos.transport.entity.ProductLink;
import net.atos.transport.entity.jpa.ProductLinkEntity;
import net.atos.transport.entity.jpa.ProductEntity;
import net.atos.transport.entity.jpa.ProductEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class ProductLinkServiceMapperTest {

	private ProductLinkServiceMapper productLinkServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		productLinkServiceMapper = new ProductLinkServiceMapper();
		productLinkServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'ProductLinkEntity' to 'ProductLink'
	 * @param productLinkEntity
	 */
	@Test
	public void testMapProductLinkEntityToProductLink() {
		// Given
		ProductLinkEntity productLinkEntity = new ProductLinkEntity();
		productLinkEntity.setPrlId(mockValues.nextInteger());
		productLinkEntity.setExpired(mockValues.nextString(1));
		productLinkEntity.setEffectiveFrom(mockValues.nextDate());
		productLinkEntity.setEffectiveTo(mockValues.nextDate());
		productLinkEntity.setProduct(new ProductEntity());
		productLinkEntity.getProduct().setProId(mockValues.nextInteger());
		productLinkEntity.setProduct2(new ProductEntity());
		productLinkEntity.getProduct2().setProId(mockValues.nextInteger());
		
		// When
		ProductLink productLink = productLinkServiceMapper.mapProductLinkEntityToProductLink(productLinkEntity);
		
		// Then
		assertEquals(productLinkEntity.getPrlId(), productLink.getPrlId());
		assertEquals(productLinkEntity.getExpired(), productLink.getExpired());
		assertEquals(productLinkEntity.getEffectiveFrom(), productLink.getEffectiveFrom());
		assertEquals(productLinkEntity.getEffectiveTo(), productLink.getEffectiveTo());
		assertEquals(productLinkEntity.getProduct().getProId(), productLink.getProId());
		assertEquals(productLinkEntity.getProduct2().getProId(), productLink.getProIdParent());
	}
	
	/**
	 * Test : Mapping from 'ProductLink' to 'ProductLinkEntity'
	 */
	@Test
	public void testMapProductLinkToProductLinkEntity() {
		// Given
		ProductLink productLink = new ProductLink();
		productLink.setPrlId(mockValues.nextInteger());
		productLink.setExpired(mockValues.nextString(1));
		productLink.setEffectiveFrom(mockValues.nextDate());
		productLink.setEffectiveTo(mockValues.nextDate());
		productLink.setProId(mockValues.nextInteger());
		productLink.setProIdParent(mockValues.nextInteger());

		ProductLinkEntity productLinkEntity = new ProductLinkEntity();
		
		// When
		productLinkServiceMapper.mapProductLinkToProductLinkEntity(productLink, productLinkEntity);
		
		// Then
		assertEquals(productLink.getPrlId(), productLinkEntity.getPrlId());
		assertEquals(productLink.getExpired(), productLinkEntity.getExpired());
		assertEquals(productLink.getEffectiveFrom(), productLinkEntity.getEffectiveFrom());
		assertEquals(productLink.getEffectiveTo(), productLinkEntity.getEffectiveTo());
		assertEquals(productLink.getProId(), productLinkEntity.getProduct().getProId());
		assertEquals(productLink.getProIdParent(), productLinkEntity.getProduct2().getProId());
	}

}