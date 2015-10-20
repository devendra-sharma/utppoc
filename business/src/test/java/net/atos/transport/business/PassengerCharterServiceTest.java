package net.atos.transport.business;



import java.math.BigDecimal;

import net.atos.htts.transport.common.domain.CodeBookDTO;
import net.atos.htts.transport.common.domain.PassengerCharterDTO;

import org.junit.Ignore;
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
public class PassengerCharterServiceTest {
 
    @Autowired
    private PassengerCharterService passengerCharterService;
    @Ignore
    @Test
    public void testIfConvertCurrency() {
    	PassengerCharterDTO passengerCharterDTO = new PassengerCharterDTO();
    	passengerCharterDTO.setDiscountPercent(10);
    	passengerCharterDTO.setTicketStatus("ACTIVE");
    	passengerCharterDTO.setTransactionValue(new BigDecimal("10.9"));
    	CodeBookDTO codeBookDTO = new CodeBookDTO(); 
    	codeBookDTO.setCobId(1);
    	codeBookDTO.setValue("134");;
    	BigDecimal result = passengerCharterService.calculatePassengerCharterFullFare(passengerCharterDTO, codeBookDTO);
    	System.out.println(">>>>>>>>>>>>>> "+result);
    }

    
   
    
}
