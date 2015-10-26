package net.atos.htts.transport.core.batch;

import org.springframework.batch.item.ItemProcessor;

public class DeleteItemProcessor implements ItemProcessor<String, String>
{

    @Override
    public String process(String item) throws Exception
    {
        // Delete Type V Records
        return null;
    }

}
