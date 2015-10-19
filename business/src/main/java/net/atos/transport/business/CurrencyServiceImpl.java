package net.atos.transport.business;

import net.atos.htts.transport.common.constants.AppConstants;
import net.atos.htts.transport.common.exceptions.UTPException;
import net.atos.transport.business.service.CodeBookMap;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyServiceImpl implements CurrencyService{
    
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);
    @Autowired
    CodeBookMap codeBookMap;
    
    public CurrencyServiceImpl(){
        
    }
    
    @Override
    public String ifConvertCurrency(String currencyCode) throws UTPException{
        try{            
        
            String lennonCurrency = codeBookMap.getCodeBookByTypeAndCobId(AppConstants.CURRENCY_GROUP, AppConstants.LENNON_CURR_COB_ID);            
            String inputCurrency = codeBookMap.getCodeBookByTypeAndCobId(AppConstants.CURRENCY_GROUP, Integer.valueOf(curr_code));
        
            if(inputCurrency.equals(lennonCurrency)){            
                return AppConstants.NO_CONVERSION;
            }
            else if(!inputCurrency.equals(lennonCurrency)){
                if(inputCurrency.equals(AppConstants.STERLING)){    
                    return AppConstants.EUROS;
                }
                else {
                    return AppConstants.STERLING;
                }
            }
            else{
                return AppConstants.NO_CONVERSION;
            }
            
            
        }
        catch(NumberFormatException nfe){
            logger.error("Inside method [ifConvertCurrency] : Error :"+nfe.getMessage());
            throw new UTPException(nfe.getMessage());
        }
    }

}
