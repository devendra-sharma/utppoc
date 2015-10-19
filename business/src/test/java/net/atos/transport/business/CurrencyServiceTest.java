package net.atos.transport.business;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import net.atos.htts.transport.common.constants.AppConstants;
import net.atos.transport.business.CurrencyService;
/**
 * @author A154968
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/testBusinessApplicationContext.xml")
@Transactional
public class CurrencyServiceTest {
 
    @Autowired
    private CurrencyService currencyService;
    
    @Test
    public void testIfConvertCurrency() throws Exception {
    	System.out.println("hhhhhhhhhhhh"+AppConstants.EUROS_CURR_COB_ID.toString());
		String strTargetCurrency = currencyService.ifConvertCurrency(AppConstants.EUROS_CURR_COB_ID.toString());
		Assert.assertEquals(strTargetCurrency, AppConstants.STERLING);
    }

    
   
    
}
