/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.CodeBook;
import net.atos.transport.entity.jpa.CodeBookEntity;
import net.atos.transport.business.service.CodeBookService;
import net.atos.transport.business.service.mapping.CodeBookServiceMapper;
import net.atos.transport.data.repository.jpa.CodeBookJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of CodeBookService
 */
@Component
@Transactional
public class CodeBookServiceImpl implements CodeBookService {

    @Resource
    private CodeBookJpaRepository codeBookJpaRepository;

    @Resource
    private CodeBookServiceMapper codeBookServiceMapper;
    
    @Override
    public CodeBook findById(Integer cobId) {
        CodeBookEntity codeBookEntity = codeBookJpaRepository.findOne(cobId);
        return codeBookServiceMapper.mapCodeBookEntityToCodeBook(codeBookEntity);
    }

    @Override
    public List<CodeBook> findAll() {
        Iterable<CodeBookEntity> entities = codeBookJpaRepository.findAll();
        List<CodeBook> beans = new ArrayList<CodeBook>();
        for(CodeBookEntity codeBookEntity : entities) {
            beans.add(codeBookServiceMapper.mapCodeBookEntityToCodeBook(codeBookEntity));
        }
        return beans;
    }

    @Override
    public CodeBook save(CodeBook codeBook) {
        return update(codeBook) ;
    }

    @Override
    public CodeBook create(CodeBook codeBook) {
        CodeBookEntity codeBookEntity = codeBookJpaRepository.findOne(codeBook.getCobId());
        if( codeBookEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        codeBookEntity = new CodeBookEntity();
        codeBookServiceMapper.mapCodeBookToCodeBookEntity(codeBook, codeBookEntity);
        CodeBookEntity codeBookEntitySaved = codeBookJpaRepository.save(codeBookEntity);
        return codeBookServiceMapper.mapCodeBookEntityToCodeBook(codeBookEntitySaved);
    }

    @Override
    public CodeBook update(CodeBook codeBook) {
        CodeBookEntity codeBookEntity = codeBookJpaRepository.findOne(codeBook.getCobId());
        codeBookServiceMapper.mapCodeBookToCodeBookEntity(codeBook, codeBookEntity);
        CodeBookEntity codeBookEntitySaved = codeBookJpaRepository.save(codeBookEntity);
        return codeBookServiceMapper.mapCodeBookEntityToCodeBook(codeBookEntitySaved);
    }

    @Override
    public void delete(Integer cobId) {
        codeBookJpaRepository.delete(cobId);
    }

    public CodeBookJpaRepository getCodeBookJpaRepository() {
        return codeBookJpaRepository;
    }

    public void setCodeBookJpaRepository(CodeBookJpaRepository codeBookJpaRepository) {
        this.codeBookJpaRepository = codeBookJpaRepository;
    }

    public CodeBookServiceMapper getCodeBookServiceMapper() {
        return codeBookServiceMapper;
    }

    public void setCodeBookServiceMapper(CodeBookServiceMapper codeBookServiceMapper) {
        this.codeBookServiceMapper = codeBookServiceMapper;
    }

}
