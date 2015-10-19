package net.atos.transport.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;

import net.atos.transport.entity.CodeBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CodeBookMap {
    
    private static final Logger logger = LoggerFactory.getLogger(CodeBookMap.class);
    
    private Map<Integer, Map<Integer,String>> codeBookMapper;
    
    @Autowired
    private CodeBookService cbService;
    
    @PostConstruct
    public void initialize(){
        codeBookMapper = new HashMap<Integer, Map<Integer,String>>();
        List<CodeBook> cbList = cbService.findAll();
        for(CodeBook cb : cbList){
            if(codeBookMapper.get(cb.getTypId()) != null){
                codeBookMapper.get(cb.getTypId()).put(cb.getCobId(), cb.getValue());
            } else {
                Map<Integer, String> valMap = new HashMap<Integer, String>();
                valMap.put(cb.getCobId(), cb.getValue());
                codeBookMapper.put(cb.getTypId(), valMap);
            }
        }
        logger.info("Code Book Map :::: " + codeBookMapper);
    }

    
    /**
     * This method will return Code book Map
     * for a type Id
     * .
     * @param typeId
     * @return
     */
    public Map<Integer, String> getCodeBooksByType(Integer typeId){
        Map<Integer, String> valMap = codeBookMapper.get(typeId);
        return valMap;        
    }

    /**
     * This method will return Code book Map
     * for a type Id and cob Id.
     * .
     * @param typeId
     * @param cobId
     * @return
     */
    public String getCodeBookByTypeAndCobId(Integer typeId,Integer cobId){
        Map<Integer, String> valMap = codeBookMapper.get(typeId);
        String value = valMap.get(cobId);
        return value;        
    }
    
    public boolean isCobIdPresent(Long cobId){
        Set<Entry<Integer, Map<Integer, String>>> codeEntry = codeBookMapper.entrySet();
        for( Entry<Integer, Map<Integer, String>> codeBook: codeEntry){
            Map<Integer,String> codeBookRecord = codeBook.getValue();
            if(codeBookRecord.containsKey(cobId.intValue())){
                return true;
            }
        }
        return false;
    }
}
