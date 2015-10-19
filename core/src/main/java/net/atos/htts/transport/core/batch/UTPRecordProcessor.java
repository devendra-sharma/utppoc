package net.atos.htts.transport.core.batch;

import java.util.Collections;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

public class UTPRecordProcessor implements ItemProcessor<String, String> {
	
	
	
	private Map<String, ItemProcessor<String,String>> processorMap = Collections.emptyMap();

	@Override
	public String process(String item) throws Exception {
		if(item!=null && item.length() > 63){
			String recordType = Character.toString(item.charAt(62)) ;
			if(processorMap.get(recordType) != null){
				ItemProcessor<String,String> processor = processorMap.get(recordType);
				return processor.process(item);
			}
		}
		return item;
	}

	public void setProcessorMap(Map<String, ItemProcessor<String,String>> processorMap) {
		this.processorMap = processorMap;
	}

}