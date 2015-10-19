package net.atos.htts.transport.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.LoggerFactory;

public class CommonUtil {
	
	private static final transient org.slf4j.Logger logger = LoggerFactory.getLogger(CommonUtil.class);

	private CommonUtil(){}
	public static Date getDateForFormat(String input,String format) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date strToDate;
		try {
			strToDate = dateFormat.parse(input);
			return strToDate;
		} catch (ParseException e) {
			logger.info("Exception Message is ::"+e);
		}
		return null;
	}
}
