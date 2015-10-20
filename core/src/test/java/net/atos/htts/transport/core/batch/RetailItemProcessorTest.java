package net.atos.htts.transport.core.batch;



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
@ContextConfiguration(locations = { "classpath:spring-batch/test-utp-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
@DbUnitConfiguration(databaseConnection="dataSource")
@Transactional
@DatabaseSetup("/sql/core.xml")
public class RetailItemProcessorTest{
    @Autowired
    private RetailItemProcessor retailItemProcessor;

 
    
    @Test
    public void testConvertCurrency() throws Exception {
		String preocessedResult  = retailItemProcessor.process("R99999946741680246366449809170000000000000000000000 0000000000ZG050483050483050483000008002545000001000313000320000000000020150908182800000000+00001                    20151010000307 0000000022.00644980917020150901 00+00304168024636         +81923 00000 0000       2015093000000000+00001+01 0020150909010239591000000003        0000000000000000000444000000000000000000000000000000000000000000000000 00000432000000 0000000000.00 0000000000.0000040020160607601600010440+10782000000023848023848000000      20150909YY0.0000076016000000");
	
		Assert.assertEquals(preocessedResult, "R99999946741680246366449809170000000000000000000000 0000000000ZG050483050483050483000008002545000001000313000320000000000020150908182800000000+00001                    201510100003070.1456953642384106644980917020150901 00+00304168024636         +81923 00000 0000       2015093000000000+00001+01 0020150909010239591000000003        0000000000000000000444000000000000000000000000000000000000000000000000 000004320000000.14569536423841060.145695364238410600040020160607601600010440+10782000000023848023848000000      20150909YY0.0000PROD100000000000");
    }
    
}
