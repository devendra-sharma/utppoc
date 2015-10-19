/*


 */
package net.atos.transport.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.CodeBook;
import net.atos.transport.entity.jpa.CodeBookEntity;
import net.atos.transport.entity.jpa.TypeEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class CodeBookServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public CodeBookServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'CodeBookEntity' to 'CodeBook'
     * @param codeBookEntity
     */
    public CodeBook mapCodeBookEntityToCodeBook(CodeBookEntity codeBookEntity) {
        if(codeBookEntity == null) {
            return null;
        }

        //--- Generic mapping 
        CodeBook codeBook = map(codeBookEntity, CodeBook.class);

        //--- Link mapping ( link to Type )
        if(codeBookEntity.getType() != null) {
            codeBook.setTypId(codeBookEntity.getType().getTypId());
        }
        return codeBook;
    }
    
    /**
     * Mapping from 'CodeBook' to 'CodeBookEntity'
     * @param codeBook
     * @param codeBookEntity
     */
    public void mapCodeBookToCodeBookEntity(CodeBook codeBook, CodeBookEntity codeBookEntity) {
        if(codeBook == null) {
            return;
        }

        //--- Generic mapping 
        map(codeBook, codeBookEntity);

        //--- Link mapping ( link : codeBook )
        if( hasLinkToType(codeBook) ) {
            TypeEntity type1 = new TypeEntity();
            type1.setTypId( codeBook.getTypId() );
            codeBookEntity.setType( type1 );
        } else {
            codeBookEntity.setType( null );
        }

    }
    
    /**
     * Verify that Type id is valid.
     * @param Type Type
     * @return boolean
     */
    private boolean hasLinkToType(CodeBook codeBook) {
        if(codeBook.getTypId() != null) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    protected void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

}