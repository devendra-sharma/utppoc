/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.Product;
import net.atos.transport.entity.ProductLink;
import net.atos.transport.entity.jpa.ProductEntity;
import net.atos.transport.entity.jpa.ProductLinkEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.atos.transport.business.service.mapping.ProductLinkServiceMapper;
import net.atos.transport.business.service.mapping.ProductServiceMapper;
import net.atos.transport.data.repository.jpa.ProductJpaRepository;
import net.atos.transport.data.repository.jpa.ProductLinkJpaRepository;
import net.atos.transport.test.ProductFactoryForTest;
import net.atos.transport.test.ProductEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import net.atos.transport.test.ProductLinkEntityFactoryForTest;
import net.atos.transport.test.ProductLinkFactoryForTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of ProductService
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductLinkServiceImplTest {

	@InjectMocks
	private ProductLinkServiceImpl productLinkService;
	@Mock
	private ProductLinkJpaRepository productLinkJpaRepository;
	@Mock
	private ProductLinkServiceMapper productLinkServiceMapper;
	
	private ProductLinkFactoryForTest productLinkFactoryForTest = new ProductLinkFactoryForTest();

	private ProductLinkEntityFactoryForTest productLinkEntityFactoryForTest = new ProductLinkEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer proId = mockValues.nextInteger();
		
		ProductLinkEntity productEntity = productLinkJpaRepository.findOne(proId);
		
		ProductLink product = productLinkFactoryForTest.newProductLink();
		when(productLinkServiceMapper.mapProductLinkEntityToProductLink(productEntity)).thenReturn(product);

		// When
		ProductLink productFound = productLinkService.findById(proId);

		// Then
		assertEquals(product.getPrlId(),productFound.getPrlId());
	}

	@Test
	public void findAll() {
		// Given
		List<ProductLinkEntity> productEntitys = new ArrayList<ProductLinkEntity>();
		ProductLinkEntity productEntity1 = productLinkEntityFactoryForTest.newProductLinkEntity();
		productEntitys.add(productEntity1);
		ProductLinkEntity productEntity2 = productLinkEntityFactoryForTest.newProductLinkEntity();
		productEntitys.add(productEntity2);
		when(productLinkJpaRepository.findAll()).thenReturn(productEntitys);
		
		ProductLink product1 = productLinkFactoryForTest.newProductLink();
		when(productLinkServiceMapper.mapProductLinkEntityToProductLink(productEntity1)).thenReturn(product1);
		ProductLink product2 = productLinkFactoryForTest.newProductLink();
		when(productLinkServiceMapper.mapProductLinkEntityToProductLink(productEntity2)).thenReturn(product2);

		// When
		List<ProductLink> productsFounds = productLinkService.findAll();

		// Then
		assertTrue(product1 == productsFounds.get(0));
		assertTrue(product2 == productsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		ProductLink product = productLinkFactoryForTest.newProductLink();

		ProductLinkEntity productEntity = productLinkEntityFactoryForTest.newProductLinkEntity();
		when(productLinkJpaRepository.findOne(product.getProId())).thenReturn(null);
		
		productEntity = new ProductLinkEntity();
		productLinkServiceMapper.mapProductLinkToProductLinkEntity(product, productEntity);
		ProductLinkEntity productEntitySaved = productLinkJpaRepository.save(productEntity);
		
		ProductLink productSaved = productLinkFactoryForTest.newProductLink();
		when(productLinkServiceMapper.mapProductLinkEntityToProductLink(productEntitySaved)).thenReturn(productSaved);

		// When
		ProductLink productResult = productLinkService.create(product);

		// Then
		assertTrue(productResult == productSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		ProductLink product = productLinkFactoryForTest.newProductLink();

		ProductLinkEntity productEntity = productLinkEntityFactoryForTest.newProductLinkEntity();
		when(productLinkJpaRepository.findOne(product.getProId())).thenReturn(productEntity);

		// When
		Exception exception = null;
		try {
			productLinkService.create(product);
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
		ProductLink product = productLinkFactoryForTest.newProductLink();

		ProductLinkEntity productEntity = productLinkEntityFactoryForTest.newProductLinkEntity();
		when(productLinkJpaRepository.findOne(product.getProId())).thenReturn(productEntity);
		
		ProductLinkEntity productEntitySaved = productLinkEntityFactoryForTest.newProductLinkEntity();
		when(productLinkJpaRepository.save(productEntity)).thenReturn(productEntitySaved);
		
		ProductLink productSaved = productLinkFactoryForTest.newProductLink();
		when(productLinkServiceMapper.mapProductLinkEntityToProductLink(productEntitySaved)).thenReturn(productSaved);

		// When
		ProductLink productResult = productLinkService.update(product);

		// Then
		verify(productLinkServiceMapper).mapProductLinkToProductLinkEntity(product, productEntity);
		assertTrue(productResult == productSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer proId = mockValues.nextInteger();

		// When
		productLinkService.delete(proId);

		// Then
		verify(productLinkJpaRepository).delete(proId);
		
	}

}
