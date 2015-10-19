package net.atos.transport.business;



import java.math.BigDecimal;

import net.atos.htts.transport.common.constants.AppConstants;
import net.atos.htts.transport.common.domain.ConvertCurrency;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author A154968
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/testBusinessApplicationContext.xml")
@Transactional
public class CurrencyConversionServiceTest {
    @Autowired
    private CurrencyConversionService currencyConversionService;

    private static final transient org.slf4j.Logger logger = LoggerFactory.getLogger(CurrencyConversionServiceTest.class);
    
    @Test
    public void testConvertCurrency() throws Exception {
    	ConvertCurrency conCurrency=new ConvertCurrency();
		conCurrency.setAmountInOrgCurr(new BigDecimal("0.62"));		
		conCurrency.setTargetCurrency(AppConstants.EUROS);
		conCurrency.setSaleDate(new DateTime("2015-10-10").toDate());
		BigDecimal convertedAmount  = currencyConversionService.convertCurrency(conCurrency);
		System.out.println("convertedAmount.doubleValue()>>>>>"+convertedAmount.doubleValue());
		Assert.assertTrue(convertedAmount.doubleValue() == 93.62d);
    }
    
}
