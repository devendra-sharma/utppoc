package net.atos.htts.transport.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

    private CommonUtil(){
        
    }
    public static Date getDateForFormat(String input,String format) throws ParseException{        
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(input);        
    }
}
