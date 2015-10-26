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
import net.atos.transport.entity.Business;
import net.atos.transport.entity.jpa.BusinessEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class BusinessServiceMapperTest
{

    private BusinessServiceMapper businessServiceMapper;

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
        businessServiceMapper = new BusinessServiceMapper();
        businessServiceMapper.setModelMapper(modelMapper);
    }

    /**
     * Mapping from 'BusinessEntity' to 'Business'
     * 
     * @param businessEntity
     */
    @Test
    public void testMapBusinessEntityToBusiness()
    {
        // Given
        BusinessEntity businessEntity = new BusinessEntity();
        businessEntity.setBusIdTp(mockValues.nextInteger());
        businessEntity.setExpired(mockValues.nextString(1));
        businessEntity.setEffectiveFrom(mockValues.nextDate());
        businessEntity.setEffectiveTo(mockValues.nextDate());
        businessEntity.setBusDescription(mockValues.nextString(32));
        businessEntity.setBusName(mockValues.nextString(6));
        businessEntity.setBusCode(mockValues.nextString(3));
        businessEntity.setScansSubstituteBusCode(mockValues.nextString(3));
        businessEntity.setBusinesscol(mockValues.nextString(45));
        businessEntity.setAtocSubstituteBusCode(mockValues.nextString(3));
        businessEntity.setBusIdTpParent(mockValues.nextInteger());
        businessEntity.setTpParBusDescription(mockValues.nextString(32));
        businessEntity.setTpParBusName(mockValues.nextString(6));
        businessEntity.setTpParBusCode(mockValues.nextString(3));
        businessEntity.setBusIdHoc(mockValues.nextInteger());
        businessEntity.setHocBusDescription(mockValues.nextString(32));
        businessEntity.setHocBusName(mockValues.nextString(6));
        businessEntity.setHocBusCode(mockValues.nextString(3));
        businessEntity.setBusIdPrc(mockValues.nextInteger());
        businessEntity.setPrcBusDescription(mockValues.nextString(32));
        businessEntity.setPrcBusName(mockValues.nextString(6));
        businessEntity.setPrcBusCode(mockValues.nextString(3));
        businessEntity.setBusIdIsd(mockValues.nextInteger());
        businessEntity.setIsdBusDescription(mockValues.nextString(32));
        businessEntity.setIsdBusName(mockValues.nextString(6));
        businessEntity.setIsdBusCode(mockValues.nextString(3));
        businessEntity.setBusIdEsd(mockValues.nextInteger());
        businessEntity.setEsdBusDescription(mockValues.nextString(32));
        businessEntity.setEsdBusName(mockValues.nextString(6));
        businessEntity.setEsdBusCode(mockValues.nextString(3));
        businessEntity.setBusIdBut(mockValues.nextInteger());
        businessEntity.setButBusDescription(mockValues.nextString(32));
        businessEntity.setButBusName(mockValues.nextString(6));
        businessEntity.setButBusCode(mockValues.nextString(3));
        businessEntity.setFtfSiteIdentity(mockValues.nextString(4));
        businessEntity.setEuroConversionDate(mockValues.nextDate());

        // When
        Business business = businessServiceMapper.mapBusinessEntityToBusiness(businessEntity);

        // Then
        assertEquals(businessEntity.getBusIdTp(), business.getBusIdTp());
        assertEquals(businessEntity.getExpired(), business.getExpired());
        assertEquals(businessEntity.getEffectiveFrom(), business.getEffectiveFrom());
        assertEquals(businessEntity.getEffectiveTo(), business.getEffectiveTo());
        assertEquals(businessEntity.getBusDescription(), business.getBusDescription());
        assertEquals(businessEntity.getBusName(), business.getBusName());
        assertEquals(businessEntity.getBusCode(), business.getBusCode());
        assertEquals(businessEntity.getScansSubstituteBusCode(), business.getScansSubstituteBusCode());
        assertEquals(businessEntity.getBusinesscol(), business.getBusinesscol());
        assertEquals(businessEntity.getAtocSubstituteBusCode(), business.getAtocSubstituteBusCode());
        assertEquals(businessEntity.getBusIdTpParent(), business.getBusIdTpParent());
        assertEquals(businessEntity.getTpParBusDescription(), business.getTpParBusDescription());
        assertEquals(businessEntity.getTpParBusName(), business.getTpParBusName());
        assertEquals(businessEntity.getTpParBusCode(), business.getTpParBusCode());
        assertEquals(businessEntity.getBusIdHoc(), business.getBusIdHoc());
        assertEquals(businessEntity.getHocBusDescription(), business.getHocBusDescription());
        assertEquals(businessEntity.getHocBusName(), business.getHocBusName());
        assertEquals(businessEntity.getHocBusCode(), business.getHocBusCode());
        assertEquals(businessEntity.getBusIdPrc(), business.getBusIdPrc());
        assertEquals(businessEntity.getPrcBusDescription(), business.getPrcBusDescription());
        assertEquals(businessEntity.getPrcBusName(), business.getPrcBusName());
        assertEquals(businessEntity.getPrcBusCode(), business.getPrcBusCode());
        assertEquals(businessEntity.getBusIdIsd(), business.getBusIdIsd());
        assertEquals(businessEntity.getIsdBusDescription(), business.getIsdBusDescription());
        assertEquals(businessEntity.getIsdBusName(), business.getIsdBusName());
        assertEquals(businessEntity.getIsdBusCode(), business.getIsdBusCode());
        assertEquals(businessEntity.getBusIdEsd(), business.getBusIdEsd());
        assertEquals(businessEntity.getEsdBusDescription(), business.getEsdBusDescription());
        assertEquals(businessEntity.getEsdBusName(), business.getEsdBusName());
        assertEquals(businessEntity.getEsdBusCode(), business.getEsdBusCode());
        assertEquals(businessEntity.getBusIdBut(), business.getBusIdBut());
        assertEquals(businessEntity.getButBusDescription(), business.getButBusDescription());
        assertEquals(businessEntity.getButBusName(), business.getButBusName());
        assertEquals(businessEntity.getButBusCode(), business.getButBusCode());
        assertEquals(businessEntity.getFtfSiteIdentity(), business.getFtfSiteIdentity());
        assertEquals(businessEntity.getEuroConversionDate(), business.getEuroConversionDate());
    }

    /**
     * Test : Mapping from 'Business' to 'BusinessEntity'
     */
    @Test
    public void testMapBusinessToBusinessEntity()
    {
        // Given
        Business business = new Business();
        business.setBusIdTp(mockValues.nextInteger());
        business.setExpired(mockValues.nextString(1));
        business.setEffectiveFrom(mockValues.nextDate());
        business.setEffectiveTo(mockValues.nextDate());
        business.setBusDescription(mockValues.nextString(32));
        business.setBusName(mockValues.nextString(6));
        business.setBusCode(mockValues.nextString(3));
        business.setScansSubstituteBusCode(mockValues.nextString(3));
        business.setBusinesscol(mockValues.nextString(45));
        business.setAtocSubstituteBusCode(mockValues.nextString(3));
        business.setBusIdTpParent(mockValues.nextInteger());
        business.setTpParBusDescription(mockValues.nextString(32));
        business.setTpParBusName(mockValues.nextString(6));
        business.setTpParBusCode(mockValues.nextString(3));
        business.setBusIdHoc(mockValues.nextInteger());
        business.setHocBusDescription(mockValues.nextString(32));
        business.setHocBusName(mockValues.nextString(6));
        business.setHocBusCode(mockValues.nextString(3));
        business.setBusIdPrc(mockValues.nextInteger());
        business.setPrcBusDescription(mockValues.nextString(32));
        business.setPrcBusName(mockValues.nextString(6));
        business.setPrcBusCode(mockValues.nextString(3));
        business.setBusIdIsd(mockValues.nextInteger());
        business.setIsdBusDescription(mockValues.nextString(32));
        business.setIsdBusName(mockValues.nextString(6));
        business.setIsdBusCode(mockValues.nextString(3));
        business.setBusIdEsd(mockValues.nextInteger());
        business.setEsdBusDescription(mockValues.nextString(32));
        business.setEsdBusName(mockValues.nextString(6));
        business.setEsdBusCode(mockValues.nextString(3));
        business.setBusIdBut(mockValues.nextInteger());
        business.setButBusDescription(mockValues.nextString(32));
        business.setButBusName(mockValues.nextString(6));
        business.setButBusCode(mockValues.nextString(3));
        business.setFtfSiteIdentity(mockValues.nextString(4));
        business.setEuroConversionDate(mockValues.nextDate());

        BusinessEntity businessEntity = new BusinessEntity();

        // When
        businessServiceMapper.mapBusinessToBusinessEntity(business, businessEntity);

        // Then
        assertEquals(business.getBusIdTp(), businessEntity.getBusIdTp());
        assertEquals(business.getExpired(), businessEntity.getExpired());
        assertEquals(business.getEffectiveFrom(), businessEntity.getEffectiveFrom());
        assertEquals(business.getEffectiveTo(), businessEntity.getEffectiveTo());
        assertEquals(business.getBusDescription(), businessEntity.getBusDescription());
        assertEquals(business.getBusName(), businessEntity.getBusName());
        assertEquals(business.getBusCode(), businessEntity.getBusCode());
        assertEquals(business.getScansSubstituteBusCode(), businessEntity.getScansSubstituteBusCode());
        assertEquals(business.getBusinesscol(), businessEntity.getBusinesscol());
        assertEquals(business.getAtocSubstituteBusCode(), businessEntity.getAtocSubstituteBusCode());
        assertEquals(business.getBusIdTpParent(), businessEntity.getBusIdTpParent());
        assertEquals(business.getTpParBusDescription(), businessEntity.getTpParBusDescription());
        assertEquals(business.getTpParBusName(), businessEntity.getTpParBusName());
        assertEquals(business.getTpParBusCode(), businessEntity.getTpParBusCode());
        assertEquals(business.getBusIdHoc(), businessEntity.getBusIdHoc());
        assertEquals(business.getHocBusDescription(), businessEntity.getHocBusDescription());
        assertEquals(business.getHocBusName(), businessEntity.getHocBusName());
        assertEquals(business.getHocBusCode(), businessEntity.getHocBusCode());
        assertEquals(business.getBusIdPrc(), businessEntity.getBusIdPrc());
        assertEquals(business.getPrcBusDescription(), businessEntity.getPrcBusDescription());
        assertEquals(business.getPrcBusName(), businessEntity.getPrcBusName());
        assertEquals(business.getPrcBusCode(), businessEntity.getPrcBusCode());
        assertEquals(business.getBusIdIsd(), businessEntity.getBusIdIsd());
        assertEquals(business.getIsdBusDescription(), businessEntity.getIsdBusDescription());
        assertEquals(business.getIsdBusName(), businessEntity.getIsdBusName());
        assertEquals(business.getIsdBusCode(), businessEntity.getIsdBusCode());
        assertEquals(business.getBusIdEsd(), businessEntity.getBusIdEsd());
        assertEquals(business.getEsdBusDescription(), businessEntity.getEsdBusDescription());
        assertEquals(business.getEsdBusName(), businessEntity.getEsdBusName());
        assertEquals(business.getEsdBusCode(), businessEntity.getEsdBusCode());
        assertEquals(business.getBusIdBut(), businessEntity.getBusIdBut());
        assertEquals(business.getButBusDescription(), businessEntity.getButBusDescription());
        assertEquals(business.getButBusName(), businessEntity.getButBusName());
        assertEquals(business.getButBusCode(), businessEntity.getButBusCode());
        assertEquals(business.getFtfSiteIdentity(), businessEntity.getFtfSiteIdentity());
        assertEquals(business.getEuroConversionDate(), businessEntity.getEuroConversionDate());
    }

}
