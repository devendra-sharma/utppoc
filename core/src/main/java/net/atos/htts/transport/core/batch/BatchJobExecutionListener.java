package net.atos.htts.transport.core.batch;

import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

public class BatchJobExecutionListener implements JobExecutionListener
{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BatchJobExecutionListener.class);

    @Override
    @AfterJob
    public void afterJob(JobExecution jobExecution)
    {
        logger.info("Batch run completed with job id -->" + jobExecution.getJobId());
        if (jobExecution.getStatus() == BatchStatus.COMPLETED)
        {
            // job success
            logger.info("Batch run completed with status -->" + jobExecution.getStatus().name());
        }
        else if (jobExecution.getStatus() == BatchStatus.FAILED)
        {
            // job failure
            logger.info("Batch run completed with status -->" + jobExecution.getStatus().name());
        }
    }

    @Override
    @BeforeJob
    public void beforeJob(JobExecution jobExecution)
    {
        // TODO Actions before the batch run
        logger.info("Batch run started with job id -->" + jobExecution.getJobId());
    }
}
