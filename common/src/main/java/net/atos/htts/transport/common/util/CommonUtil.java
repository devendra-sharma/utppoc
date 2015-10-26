package net.atos.htts.transport.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtil
{

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

    private CommonUtil()
    {

    }

    public static Date getDateForFormat(String input, String format)
    {

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try
        {
            return dateFormat.parse(input);
        }
        catch (ParseException e)
        {
            LOGGER.error(e.getMessage());
        }
        return new Date();
    }
}
