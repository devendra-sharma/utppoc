/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.Business;
import net.atos.transport.entity.jpa.BusinessEntity;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.BusinessServiceMapper;
import net.atos.transport.data.repository.jpa.BusinessJpaRepository;
import net.atos.transport.test.BusinessFactoryForTest;
import net.atos.transport.test.BusinessEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of BusinessService
 */
@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceImplTest
{

    @InjectMocks
    private BusinessServiceImpl businessService;

    @Mock
    private BusinessJpaRepository businessJpaRepository;

    @Mock
    private BusinessServiceMapper businessServiceMapper;

    private BusinessFactoryForTest businessFactoryForTest = new BusinessFactoryForTest();

    private BusinessEntityFactoryForTest businessEntityFactoryForTest = new BusinessEntityFactoryForTest();

    private MockValues mockValues = new MockValues();

    @Test
    public void findById()
    {
        // Given
        Integer busId = mockValues.nextInteger();

        BusinessEntity businessEntity = businessJpaRepository.findOne(busId);

        Business business = businessFactoryForTest.newBusiness();
        when(businessServiceMapper.mapBusinessEntityToBusiness(businessEntity)).thenReturn(business);

        // When
        Business businessFound = businessService.findById(busId);

        // Then
        assertEquals(business.getBusId(), businessFound.getBusId());
    }

    @Test
    public void findAll()
    {
        // Given
        List<BusinessEntity> businessEntitys = new ArrayList<BusinessEntity>();
        BusinessEntity businessEntity1 = businessEntityFactoryForTest.newBusinessEntity();
        businessEntitys.add(businessEntity1);
        BusinessEntity businessEntity2 = businessEntityFactoryForTest.newBusinessEntity();
        businessEntitys.add(businessEntity2);
        when(businessJpaRepository.findAll()).thenReturn(businessEntitys);

        Business business1 = businessFactoryForTest.newBusiness();
        when(businessServiceMapper.mapBusinessEntityToBusiness(businessEntity1)).thenReturn(business1);
        Business business2 = businessFactoryForTest.newBusiness();
        when(businessServiceMapper.mapBusinessEntityToBusiness(businessEntity2)).thenReturn(business2);

        // When
        List<Business> businesssFounds = businessService.findAll();

        // Then
        assertTrue(business1 == businesssFounds.get(0));
        assertTrue(business2 == businesssFounds.get(1));
    }

    @Test
    public void create()
    {
        // Given
        Business business = businessFactoryForTest.newBusiness();

        BusinessEntity businessEntity = businessEntityFactoryForTest.newBusinessEntity();
        when(businessJpaRepository.findOne(business.getBusId())).thenReturn(null);

        businessEntity = new BusinessEntity();
        businessServiceMapper.mapBusinessToBusinessEntity(business, businessEntity);
        BusinessEntity businessEntitySaved = businessJpaRepository.save(businessEntity);

        Business businessSaved = businessFactoryForTest.newBusiness();
        when(businessServiceMapper.mapBusinessEntityToBusiness(businessEntitySaved)).thenReturn(businessSaved);

        // When
        Business businessResult = businessService.create(business);

        // Then
        assertTrue(businessResult == businessSaved);
    }

    @Test
    public void createKOExists()
    {
        // Given
        Business business = businessFactoryForTest.newBusiness();

        BusinessEntity businessEntity = businessEntityFactoryForTest.newBusinessEntity();
        when(businessJpaRepository.findOne(business.getBusId())).thenReturn(businessEntity);

        // When
        Exception exception = null;
        try
        {
            businessService.create(business);
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
        Business business = businessFactoryForTest.newBusiness();

        BusinessEntity businessEntity = businessEntityFactoryForTest.newBusinessEntity();
        when(businessJpaRepository.findOne(business.getBusId())).thenReturn(businessEntity);

        BusinessEntity businessEntitySaved = businessEntityFactoryForTest.newBusinessEntity();
        when(businessJpaRepository.save(businessEntity)).thenReturn(businessEntitySaved);

        Business businessSaved = businessFactoryForTest.newBusiness();
        when(businessServiceMapper.mapBusinessEntityToBusiness(businessEntitySaved)).thenReturn(businessSaved);

        // When
        Business businessResult = businessService.update(business);

        // Then
        verify(businessServiceMapper).mapBusinessToBusinessEntity(business, businessEntity);
        assertTrue(businessResult == businessSaved);
    }

    @Test
    public void delete()
    {
        // Given
        Integer busId = mockValues.nextInteger();

        // When
        businessService.delete(busId);

        // Then
        verify(businessJpaRepository).delete(busId);

    }

}
