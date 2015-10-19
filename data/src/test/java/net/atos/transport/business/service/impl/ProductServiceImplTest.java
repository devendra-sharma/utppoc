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
import net.atos.transport.entity.jpa.ProductEntity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.ProductServiceMapper;
import net.atos.transport.data.repository.jpa.ProductJpaRepository;
import net.atos.transport.test.ProductFactoryForTest;
import net.atos.transport.test.ProductEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of ProductService
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	@InjectMocks
	private ProductServiceImpl productService;
	@Mock
	private ProductJpaRepository productJpaRepository;
	@Mock
	private ProductServiceMapper productServiceMapper;
	
	private ProductFactoryForTest productFactoryForTest = new ProductFactoryForTest();

	private ProductEntityFactoryForTest productEntityFactoryForTest = new ProductEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer proId = mockValues.nextInteger();
		
		ProductEntity productEntity = productJpaRepository.findOne(proId);
		
		Product product = productFactoryForTest.newProduct();
		when(productServiceMapper.mapProductEntityToProduct(productEntity)).thenReturn(product);

		// When
		Product productFound = productService.findById(proId);

		// Then
		assertEquals(product.getProId(),productFound.getProId());
	}

	@Test
	public void findAll() {
		// Given
		List<ProductEntity> productEntitys = new ArrayList<ProductEntity>();
		ProductEntity productEntity1 = productEntityFactoryForTest.newProductEntity();
		productEntitys.add(productEntity1);
		ProductEntity productEntity2 = productEntityFactoryForTest.newProductEntity();
		productEntitys.add(productEntity2);
		when(productJpaRepository.findAll()).thenReturn(productEntitys);
		
		Product product1 = productFactoryForTest.newProduct();
		when(productServiceMapper.mapProductEntityToProduct(productEntity1)).thenReturn(product1);
		Product product2 = productFactoryForTest.newProduct();
		when(productServiceMapper.mapProductEntityToProduct(productEntity2)).thenReturn(product2);

		// When
		List<Product> productsFounds = productService.findAll();

		// Then
		assertTrue(product1 == productsFounds.get(0));
		assertTrue(product2 == productsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Product product = productFactoryForTest.newProduct();

		ProductEntity productEntity = productEntityFactoryForTest.newProductEntity();
		when(productJpaRepository.findOne(product.getProId())).thenReturn(null);
		
		productEntity = new ProductEntity();
		productServiceMapper.mapProductToProductEntity(product, productEntity);
		ProductEntity productEntitySaved = productJpaRepository.save(productEntity);
		
		Product productSaved = productFactoryForTest.newProduct();
		when(productServiceMapper.mapProductEntityToProduct(productEntitySaved)).thenReturn(productSaved);

		// When
		Product productResult = productService.create(product);

		// Then
		assertTrue(productResult == productSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Product product = productFactoryForTest.newProduct();

		ProductEntity productEntity = productEntityFactoryForTest.newProductEntity();
		when(productJpaRepository.findOne(product.getProId())).thenReturn(productEntity);

		// When
		Exception exception = null;
		try {
			productService.create(product);
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
		Product product = productFactoryForTest.newProduct();

		ProductEntity productEntity = productEntityFactoryForTest.newProductEntity();
		when(productJpaRepository.findOne(product.getProId())).thenReturn(productEntity);
		
		ProductEntity productEntitySaved = productEntityFactoryForTest.newProductEntity();
		when(productJpaRepository.save(productEntity)).thenReturn(productEntitySaved);
		
		Product productSaved = productFactoryForTest.newProduct();
		when(productServiceMapper.mapProductEntityToProduct(productEntitySaved)).thenReturn(productSaved);

		// When
		Product productResult = productService.update(product);

		// Then
		verify(productServiceMapper).mapProductToProductEntity(product, productEntity);
		assertTrue(productResult == productSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer proId = mockValues.nextInteger();

		// When
		productService.delete(proId);

		// Then
		verify(productJpaRepository).delete(proId);
		
	}

}
