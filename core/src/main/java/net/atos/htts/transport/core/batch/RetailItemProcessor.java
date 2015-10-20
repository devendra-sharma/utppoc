package net.atos.htts.transport.core.batch;

import net.atos.htts.transport.common.exceptions.UTPException;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.beans.factory.annotation.Autowired;

public class RetailItemProcessor implements ItemProcessor<String, String>{
    
    @Autowired
    private FixedLengthTokenizer tokenizer;    
    
    @Autowired
    private ZProcessorService zProcessorService;
    
    @Override
    public String process(String item) throws UTPException {
          
        FieldSet dataSet = tokenizer.tokenize(item);
                
        String strResult = zProcessorService.processZRecord(dataSet);
        strResult=strResult.replace(", ", "").replace("[", "").replace("]", "");
        return strResult;
    }

    

    public FixedLengthTokenizer getTokenizer() {
        return tokenizer;
    }

    public void setTokenizer(FixedLengthTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

}
