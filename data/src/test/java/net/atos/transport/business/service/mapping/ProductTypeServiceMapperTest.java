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
import net.atos.transport.entity.ProductType;
import net.atos.transport.entity.jpa.ProductTypeEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class ProductTypeServiceMapperTest
{

    private ProductTypeServiceMapper productTypeServiceMapper;

    private static ModelMapper modelMapper = new ModelMapper();

    private MockValues mockValues = new MockValues();

    @BeforeClass
    public static void setUp()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Before
    public void before()
    {
        productTypeServiceMapper = new ProductTypeServiceMapper();
        productTypeServiceMapper.setModelMapper(modelMapper);
    }

    /**
     * Mapping from 'ProductTypeEntity' to 'ProductType'
     * 
     * @param productTypeEntity
     */
    @Test
    public void testMapProductTypeEntityToProductType()
    {
        // Given
        ProductTypeEntity productTypeEntity = new ProductTypeEntity();
        productTypeEntity.setProductTypeDescription(mockValues.nextString(32));
        productTypeEntity.setEffectiveFrom(mockValues.nextDate());
        productTypeEntity.setEffectiveTo(mockValues.nextDate());
        productTypeEntity.setExpired(mockValues.nextString(1));

        // When
        ProductType productType = productTypeServiceMapper.mapProductTypeEntityToProductType(productTypeEntity);

        // Then
        assertEquals(productTypeEntity.getProductTypeDescription(), productType.getProductTypeDescription());
        assertEquals(productTypeEntity.getEffectiveFrom(), productType.getEffectiveFrom());
        assertEquals(productTypeEntity.getEffectiveTo(), productType.getEffectiveTo());
        assertEquals(productTypeEntity.getExpired(), productType.getExpired());
    }

    /**
     * Test : Mapping from 'ProductType' to 'ProductTypeEntity'
     */
    @Test
    public void testMapProductTypeToProductTypeEntity()
    {
        // Given
        ProductType productType = new ProductType();
        productType.setProductTypeDescription(mockValues.nextString(32));
        productType.setEffectiveFrom(mockValues.nextDate());
        productType.setEffectiveTo(mockValues.nextDate());
        productType.setExpired(mockValues.nextString(1));

        ProductTypeEntity productTypeEntity = new ProductTypeEntity();

        // When
        productTypeServiceMapper.mapProductTypeToProductTypeEntity(productType, productTypeEntity);

        // Then
        assertEquals(productType.getProductTypeDescription(), productTypeEntity.getProductTypeDescription());
        assertEquals(productType.getEffectiveFrom(), productTypeEntity.getEffectiveFrom());
        assertEquals(productType.getEffectiveTo(), productTypeEntity.getEffectiveTo());
        assertEquals(productType.getExpired(), productTypeEntity.getExpired());
    }

}
