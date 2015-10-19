package net.atos.htts.transport.core.batch;

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
	public String process(String item) throws Exception {
		try{			
			FieldSet dataSet = tokenizer.tokenize(item);
					
			String strResult = zProcessorService.ProcessZRecord(dataSet);
			strResult=strResult.replace(", ", "").replace("[", "").replace("]", "");
			return strResult;
		}
		catch (Exception e) {
			throw e;
		}
	}

	

	public FixedLengthTokenizer getTokenizer() {
		return tokenizer;
	}

	public void setTokenizer(FixedLengthTokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

}
