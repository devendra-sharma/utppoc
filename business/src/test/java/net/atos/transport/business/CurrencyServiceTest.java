package net.atos.transport.business;



import net.atos.htts.transport.common.constants.AppConstants;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
@DbUnitConfiguration(databaseConnection="dataSource")
@Transactional
@DatabaseSetup("/sql/business.xml")
public class CurrencyServiceTest {
 
    @Autowired
    private CurrencyService currencyService;
    
    @Test
    public void testIfConvertCurrency() throws Exception {
		String strTargetCurrency = currencyService.ifConvertCurrency(AppConstants.EUROS_CURR_COB_ID.toString());
		Assert.assertEquals(strTargetCurrency, AppConstants.STERLING);
    }

    
   
    
}
