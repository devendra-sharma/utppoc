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
import net.atos.transport.entity.Product;
import net.atos.transport.entity.jpa.ProductEntity;
import net.atos.transport.entity.jpa.TicketAllocationCodeEntity;
import net.atos.transport.entity.jpa.BusinessEntity;
import net.atos.transport.entity.jpa.ProductTypeEntity;
import net.atos.transport.entity.jpa.TicketClassEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class ProductServiceMapperTest
{

    private ProductServiceMapper productServiceMapper;

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
        productServiceMapper = new ProductServiceMapper();
        productServiceMapper.setModelMapper(modelMapper);
    }

    /**
     * Mapping from 'ProductEntity' to 'Product'
     * 
     * @param productEntity
     */
    @Test
    public void testMapProductEntityToProduct()
    {
        // Given
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductCode(mockValues.nextString(5));
        productEntity.setProductDescription(mockValues.nextString(32));
        productEntity.setJofJourneyFactor(mockValues.nextBigDecimal());
        productEntity.setProIdGroup1(mockValues.nextInteger());
        productEntity.setProGroup1Code(mockValues.nextString(5));
        productEntity.setProGroup1Desc(mockValues.nextString(32));
        productEntity.setProIdGroup2(mockValues.nextInteger());
        productEntity.setProGroup2Code(mockValues.nextString(5));
        productEntity.setProGroup2Desc(mockValues.nextString(32));
        productEntity.setExpired(mockValues.nextString(1));
        productEntity.setEffectiveFrom(mockValues.nextDate());
        productEntity.setEffectiveTo(mockValues.nextDate());
        productEntity.setBusIdCorrective(mockValues.nextInteger());
        productEntity.setExcludeFromNgtSundries(mockValues.nextString(1));
        productEntity.setCobIdDebitCreditType(mockValues.nextInteger());
        productEntity.setCobIdRailcardType(mockValues.nextInteger());
        productEntity.setCobIdSuspendableInd(mockValues.nextInteger());
        productEntity.setTicketAllocationCode(new TicketAllocationCodeEntity());
        productEntity.getTicketAllocationCode().setTacId(mockValues.nextInteger());
        productEntity.setBusiness2(new BusinessEntity());
        productEntity.getBusiness2().setBusId(mockValues.nextInteger());
        productEntity.setProductType(new ProductTypeEntity());
        productEntity.getProductType().setPrtId(mockValues.nextInteger());
        productEntity.setTicketClass(new TicketClassEntity());
        productEntity.getTicketClass().setTicId(mockValues.nextInteger());

        // When
        Product product = productServiceMapper.mapProductEntityToProduct(productEntity);

        // Then
        assertEquals(productEntity.getProductCode(), product.getProductCode());
        assertEquals(productEntity.getProductDescription(), product.getProductDescription());
        assertEquals(productEntity.getJofJourneyFactor(), product.getJofJourneyFactor());
        assertEquals(productEntity.getProIdGroup1(), product.getProIdGroup1());
        assertEquals(productEntity.getProGroup1Code(), product.getProGroup1Code());
        assertEquals(productEntity.getProGroup1Desc(), product.getProGroup1Desc());
        assertEquals(productEntity.getProIdGroup2(), product.getProIdGroup2());
        assertEquals(productEntity.getProGroup2Code(), product.getProGroup2Code());
        assertEquals(productEntity.getProGroup2Desc(), product.getProGroup2Desc());
        assertEquals(productEntity.getExpired(), product.getExpired());
        assertEquals(productEntity.getEffectiveFrom(), product.getEffectiveFrom());
        assertEquals(productEntity.getEffectiveTo(), product.getEffectiveTo());
        assertEquals(productEntity.getBusIdCorrective(), product.getBusIdCorrective());
        assertEquals(productEntity.getExcludeFromNgtSundries(), product.getExcludeFromNgtSundries());
        assertEquals(productEntity.getCobIdDebitCreditType(), product.getCobIdDebitCreditType());
        assertEquals(productEntity.getCobIdRailcardType(), product.getCobIdRailcardType());
        assertEquals(productEntity.getCobIdSuspendableInd(), product.getCobIdSuspendableInd());
        assertEquals(productEntity.getTicketAllocationCode().getTacId(), product.getTacId());
        assertEquals(productEntity.getBusiness2().getBusId(), product.getBusiness());
        assertEquals(productEntity.getProductType().getPrtId(), product.getPrtId());
        assertEquals(productEntity.getTicketClass().getTicId(), product.getTicId());
    }

    /**
     * Test : Mapping from 'Product' to 'ProductEntity'
     */
    @Test
    public void testMapProductToProductEntity()
    {
        // Given
        Product product = new Product();
        product.setProductCode(mockValues.nextString(5));
        product.setProductDescription(mockValues.nextString(32));
        product.setJofJourneyFactor(mockValues.nextBigDecimal());
        product.setProIdGroup1(mockValues.nextInteger());
        product.setProGroup1Code(mockValues.nextString(5));
        product.setProGroup1Desc(mockValues.nextString(32));
        product.setProIdGroup2(mockValues.nextInteger());
        product.setProGroup2Code(mockValues.nextString(5));
        product.setProGroup2Desc(mockValues.nextString(32));
        product.setExpired(mockValues.nextString(1));
        product.setEffectiveFrom(mockValues.nextDate());
        product.setEffectiveTo(mockValues.nextDate());
        product.setBusIdCorrective(mockValues.nextInteger());
        product.setExcludeFromNgtSundries(mockValues.nextString(1));
        product.setCobIdDebitCreditType(mockValues.nextInteger());
        product.setCobIdRailcardType(mockValues.nextInteger());
        product.setCobIdSuspendableInd(mockValues.nextInteger());
        product.setTacId(mockValues.nextInteger());
        product.setBusiness(mockValues.nextInteger());
        product.setPrtId(mockValues.nextInteger());
        product.setTicId(mockValues.nextInteger());

        ProductEntity productEntity = new ProductEntity();

        // When
        productServiceMapper.mapProductToProductEntity(product, productEntity);

        // Then
        assertEquals(product.getProductCode(), productEntity.getProductCode());
        assertEquals(product.getProductDescription(), productEntity.getProductDescription());
        assertEquals(product.getJofJourneyFactor(), productEntity.getJofJourneyFactor());
        assertEquals(product.getProIdGroup1(), productEntity.getProIdGroup1());
        assertEquals(product.getProGroup1Code(), productEntity.getProGroup1Code());
        assertEquals(product.getProGroup1Desc(), productEntity.getProGroup1Desc());
        assertEquals(product.getProIdGroup2(), productEntity.getProIdGroup2());
        assertEquals(product.getProGroup2Code(), productEntity.getProGroup2Code());
        assertEquals(product.getProGroup2Desc(), productEntity.getProGroup2Desc());
        assertEquals(product.getExpired(), productEntity.getExpired());
        assertEquals(product.getEffectiveFrom(), productEntity.getEffectiveFrom());
        assertEquals(product.getEffectiveTo(), productEntity.getEffectiveTo());
        assertEquals(product.getBusIdCorrective(), productEntity.getBusIdCorrective());
        assertEquals(product.getExcludeFromNgtSundries(), productEntity.getExcludeFromNgtSundries());
        assertEquals(product.getCobIdDebitCreditType(), productEntity.getCobIdDebitCreditType());
        assertEquals(product.getCobIdRailcardType(), productEntity.getCobIdRailcardType());
        assertEquals(product.getCobIdSuspendableInd(), productEntity.getCobIdSuspendableInd());
        assertEquals(product.getTacId(), productEntity.getTicketAllocationCode().getTacId());
        assertEquals(product.getBusiness(), productEntity.getBusiness2().getBusId());
        assertEquals(product.getPrtId(), productEntity.getProductType().getPrtId());
        assertEquals(product.getTicId(), productEntity.getTicketClass().getTicId());
    }

}
