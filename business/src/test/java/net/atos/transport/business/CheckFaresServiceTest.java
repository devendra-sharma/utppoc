package net.atos.transport.business;

import java.util.GregorianCalendar;

import net.atos.htts.transport.common.domain.CheckFaresDTO;
import net.atos.htts.transport.common.domain.CodeBookDetailsDTO;
import net.atos.htts.transport.common.domain.RetailItemDTO;
import net.atos.htts.transport.common.exceptions.UTPException;

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
@TestExecutionListeners(
{DependencyInjectionTestExecutionListener.class , DirtiesContextTestExecutionListener.class ,
        TransactionalTestExecutionListener.class , DbUnitTestExecutionListener.class })
@DbUnitConfiguration(databaseConnection = "dataSource")
@Transactional
@DatabaseSetup("/sql/business.xml")
public class CheckFaresServiceTest
{
    @Autowired
    private CheckFaresService checkFaresService;

    @Test
    public void testConvertCurrency()
    {
        RetailItemDTO retailItem = new RetailItemDTO();
        retailItem.setDateOfIssue(new GregorianCalendar(2014, 9, 9).getTime());
        retailItem.setDateOfSale(new GregorianCalendar(2015, 9, 9).getTime());
        retailItem.setOriginLocId(1L);
        retailItem.setDestinationLocId(2L);
        retailItem.setSellingLocationLocId(3L);
        retailItem.setTransactionValue(100L);
        retailItem.setRouteRouId(1L);
        retailItem.setTicketStatusTisId(1L);
        retailItem.setProductProId(1L);
        retailItem.setDeferredIssueTypeCobId(300L);
        retailItem.setDateOfTravel(new GregorianCalendar(2015, 9, 9).getTime());

        CheckFaresDTO checkFares = new CheckFaresDTO();
        checkFares.setCobId(300L);
        checkFares.setRetailItem(retailItem);
        CodeBookDetailsDTO codeBookDetails = null;
        try
        {
            codeBookDetails = checkFaresService.checkFares(checkFares);
        }
        catch (UTPException e)
        {
            Assert.assertFalse("Error while calling checkFares service " + e, true);
        }

        Assert.assertEquals(codeBookDetails.getCobId().longValue(), 0L);
        Assert.assertEquals(codeBookDetails.getFcFullFare().longValue(), 300L);
    }

}
