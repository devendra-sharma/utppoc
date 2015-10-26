/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.ProductType;
import net.atos.transport.entity.jpa.ProductTypeEntity;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.ProductTypeServiceMapper;
import net.atos.transport.data.repository.jpa.ProductTypeJpaRepository;
import net.atos.transport.test.ProductTypeFactoryForTest;
import net.atos.transport.test.ProductTypeEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of ProductTypeService
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductTypeServiceImplTest
{

    @InjectMocks
    private ProductTypeServiceImpl productTypeService;

    @Mock
    private ProductTypeJpaRepository productTypeJpaRepository;

    @Mock
    private ProductTypeServiceMapper productTypeServiceMapper;

    private ProductTypeFactoryForTest productTypeFactoryForTest = new ProductTypeFactoryForTest();

    private ProductTypeEntityFactoryForTest productTypeEntityFactoryForTest = new ProductTypeEntityFactoryForTest();

    private MockValues mockValues = new MockValues();

    @Test
    public void findById()
    {
        // Given
        Integer prtId = mockValues.nextInteger();

        ProductTypeEntity productTypeEntity = productTypeJpaRepository.findOne(prtId);

        ProductType productType = productTypeFactoryForTest.newProductType();
        when(productTypeServiceMapper.mapProductTypeEntityToProductType(productTypeEntity)).thenReturn(productType);

        // When
        ProductType productTypeFound = productTypeService.findById(prtId);

        // Then
        assertEquals(productType.getPrtId(), productTypeFound.getPrtId());
    }

    @Test
    public void findAll()
    {
        // Given
        List<ProductTypeEntity> productTypeEntitys = new ArrayList<ProductTypeEntity>();
        ProductTypeEntity productTypeEntity1 = productTypeEntityFactoryForTest.newProductTypeEntity();
        productTypeEntitys.add(productTypeEntity1);
        ProductTypeEntity productTypeEntity2 = productTypeEntityFactoryForTest.newProductTypeEntity();
        productTypeEntitys.add(productTypeEntity2);
        when(productTypeJpaRepository.findAll()).thenReturn(productTypeEntitys);

        ProductType productType1 = productTypeFactoryForTest.newProductType();
        when(productTypeServiceMapper.mapProductTypeEntityToProductType(productTypeEntity1)).thenReturn(productType1);
        ProductType productType2 = productTypeFactoryForTest.newProductType();
        when(productTypeServiceMapper.mapProductTypeEntityToProductType(productTypeEntity2)).thenReturn(productType2);

        // When
        List<ProductType> productTypesFounds = productTypeService.findAll();

        // Then
        assertTrue(productType1 == productTypesFounds.get(0));
        assertTrue(productType2 == productTypesFounds.get(1));
    }

    @Test
    public void create()
    {
        // Given
        ProductType productType = productTypeFactoryForTest.newProductType();

        ProductTypeEntity productTypeEntity = productTypeEntityFactoryForTest.newProductTypeEntity();
        when(productTypeJpaRepository.findOne(productType.getPrtId())).thenReturn(null);

        productTypeEntity = new ProductTypeEntity();
        productTypeServiceMapper.mapProductTypeToProductTypeEntity(productType, productTypeEntity);
        ProductTypeEntity productTypeEntitySaved = productTypeJpaRepository.save(productTypeEntity);

        ProductType productTypeSaved = productTypeFactoryForTest.newProductType();
        when(productTypeServiceMapper.mapProductTypeEntityToProductType(productTypeEntitySaved)).thenReturn(
                productTypeSaved);

        // When
        ProductType productTypeResult = productTypeService.create(productType);

        // Then
        assertTrue(productTypeResult == productTypeSaved);
    }

    @Test
    public void createKOExists()
    {
        // Given
        ProductType productType = productTypeFactoryForTest.newProductType();

        ProductTypeEntity productTypeEntity = productTypeEntityFactoryForTest.newProductTypeEntity();
        when(productTypeJpaRepository.findOne(productType.getPrtId())).thenReturn(productTypeEntity);

        // When
        Exception exception = null;
        try
        {
            productTypeService.create(productType);
        }
        catch (Exception e)
        {
            exception = e;
        }

        // Then
        assertTrue(exception instanceof IllegalStateException);
        assertEquals("already.exists", exception.getMessage());
    }

    @Test
    public void update()
    {
        // Given
        ProductType productType = productTypeFactoryForTest.newProductType();

        ProductTypeEntity productTypeEntity = productTypeEntityFactoryForTest.newProductTypeEntity();
        when(productTypeJpaRepository.findOne(productType.getPrtId())).thenReturn(productTypeEntity);

        ProductTypeEntity productTypeEntitySaved = productTypeEntityFactoryForTest.newProductTypeEntity();
        when(productTypeJpaRepository.save(productTypeEntity)).thenReturn(productTypeEntitySaved);

        ProductType productTypeSaved = productTypeFactoryForTest.newProductType();
        when(productTypeServiceMapper.mapProductTypeEntityToProductType(productTypeEntitySaved)).thenReturn(
                productTypeSaved);

        // When
        ProductType productTypeResult = productTypeService.update(productType);

        // Then
        verify(productTypeServiceMapper).mapProductTypeToProductTypeEntity(productType, productTypeEntity);
        assertTrue(productTypeResult == productTypeSaved);
    }

    @Test
    public void delete()
    {
        // Given
        Integer prtId = mockValues.nextInteger();

        // When
        productTypeService.delete(prtId);

        // Then
        verify(productTypeJpaRepository).delete(prtId);

    }

}
