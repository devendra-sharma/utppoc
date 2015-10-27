package net.atos.htts.transport.core.batch;

import net.atos.htts.transport.common.exceptions.UTPException;

import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.LoggerFactory;

public class RetailItemProcessor implements ItemProcessor<String, String> {
	private static final org.slf4j.Logger logger = LoggerFactory
			.getLogger(RetailItemProcessor.class);

	@Autowired
	private FixedLengthTokenizer tokenizer;

	@Autowired
	private ZProcessorService zProcessorService;

	public RetailItemProcessor(FixedLengthTokenizer utpTokenizer) {
		tokenizer = utpTokenizer;
	}

	public RetailItemProcessor() {

	}

	@Override
	public String process(String item) throws UTPException {
		try {
			FieldSet dataSet = tokenizer.tokenize(item);
			String strResult = zProcessorService.processZRecord(dataSet);
			strResult = strResult.replace(", ", "").replace("[", "")
					.replace("]", "");
			logger.info("strResult is :::" + strResult);
			return strResult;

		} catch (Exception e) {

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
