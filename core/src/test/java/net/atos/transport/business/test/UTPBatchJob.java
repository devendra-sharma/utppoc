package net.atos.transport.business.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{"classpath:spring-batch/test-utp-context.xml" })
@TestExecutionListeners(
{DependencyInjectionTestExecutionListener.class , DirtiesContextTestExecutionListener.class ,
        TransactionalTestExecutionListener.class , DbUnitTestExecutionListener.class })
@DbUnitConfiguration(databaseConnection = "dataSource")
@Transactional
@DatabaseSetup("/sql/core.xml")
// classpath:META-INF/spring/context.config.xml
public class UTPBatchJob
{
    @Autowired
    private JobLauncherTestUtils launcher;

    @Test
    public void testJob()
    {
        try
        {

            JobExecution execution = launcher.launchJob();
            Assert.assertEquals(BatchStatus.COMPLETED, execution.getStatus());

        }
        catch (Exception e)
        {

            e.printStackTrace();

        }

    }

    @Test
    public void testStep()
    {
        JobExecution execution = launcher.launchStep("step1");
        Assert.assertEquals(BatchStatus.COMPLETED, execution.getStatus());
    }

}
