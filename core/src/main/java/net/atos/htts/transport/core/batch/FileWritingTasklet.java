package net.atos.htts.transport.core.batch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import net.atos.transport.business.Item;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

public class FileWritingTasklet implements Tasklet, StepExecutionListener
{

    private Resource filePath;

    private String content;

    List<Item> errorItems;

    public Resource getFilePath()
    {
        return filePath;
    }

    public void setFilePath(Resource filePath)
    {
        this.filePath = filePath;
    }

    public void setContent(String content)
    {

        this.content = content;

    }

    @Override
    public void beforeStep(StepExecution stepExecution)
    {
        errorItems = (List) stepExecution.getJobExecution().getExecutionContext().get("ErrorItem");
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception
    {

        FileWriter fileWriter = null;

        BufferedWriter bWriter = null;

        try
        {

            stepContribution.incrementReadCount();
            fileWriter = new FileWriter(filePath.getFile());

            bWriter = new BufferedWriter(fileWriter);

            for (Item item : errorItems)
            {
                content = item.getDataItem() + "\n " + item.getMessage() + "\n";
                bWriter.write(content);
            }

        }
        catch (Exception e)
        {
            throw e;

        }
        finally
        {

            if (bWriter != null)
            {
                bWriter.close();
            }

            if (fileWriter != null)
            {
                fileWriter.close();
            }

        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution)
    {
        return null;
    }

}
