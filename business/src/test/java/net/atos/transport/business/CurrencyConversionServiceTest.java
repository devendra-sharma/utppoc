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
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

/**
 * @author A154968
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/testBusinessApplicationContext.xml")
@TestExecutionListeners(
{DependencyInjectionTestExecutionListener.class , DirtiesContextTestExecutionListener.class ,
        TransactionalTestExecutionListener.class , DbUnitTestExecutionListener.class })
@DbUnitConfiguration(databaseConnection = "dataSource")
@Transactional
@DatabaseSetup("/sql/business.xml")
public class CurrencyConversionServiceTest
{
    @Autowired
    private CurrencyConversionService currencyConversionService;

    private static final transient org.slf4j.Logger logger = LoggerFactory
            .getLogger(CurrencyConversionServiceTest.class);

    @Test
    public void testConvertCurrency() throws Exception
    {
        ConvertCurrency conCurrency = new ConvertCurrency();
        conCurrency.setAmountInOrgCurr(new BigDecimal("0.62"));
        conCurrency.setTargetCurrency(AppConstants.EUROS);
        conCurrency.setSaleDate(new DateTime("2015-10-10").toDate());
        BigDecimal convertedAmount = currencyConversionService.convertCurrency(conCurrency);
        Assert.assertTrue(convertedAmount.doubleValue() == 93.62d);
    }

}
