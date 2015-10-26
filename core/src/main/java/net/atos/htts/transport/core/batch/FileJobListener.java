package net.atos.htts.transport.core.batch;

import java.util.ArrayList;
import java.util.List;

import net.atos.htts.transport.common.constants.AppConstants;
import net.atos.transport.business.Item;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.listener.ItemListenerSupport;

public class FileJobListener extends ItemListenerSupport<String, Exception> implements StepExecutionListener
{

    private StepExecution stepExecution;

    List<Item> errorItem;

    @Override
    public void onProcessError(String item, Exception e)
    {

        if (null != stepExecution.getJobExecution().getExecutionContext().get(AppConstants.ERROR_ITEM))
        {
            Item data = new Item();
            data.setDataItem(item);
            data.setMessage(e.getMessage());
            errorItem = (List) stepExecution.getJobExecution().getExecutionContext().get(AppConstants.ERROR_ITEM);
            errorItem.add(data);
            stepExecution.getJobExecution().getExecutionContext().put(AppConstants.ERROR_ITEM, errorItem);
        }
        else
        {
            errorItem = new ArrayList<Item>();
            Item data = new Item();
            data.setDataItem(item);
            data.setMessage(e.getMessage());
            errorItem.add(data);
            stepExecution.getJobExecution().getExecutionContext().put(AppConstants.ERROR_ITEM, errorItem);

        }

        stepExecution.setExitStatus(ExitStatus.FAILED);

    }

    @Override
    public void beforeStep(StepExecution stepExecution)
    {
        this.stepExecution = stepExecution;

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution)
    {
        return null;
    }

}
