/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.RecordField;
import net.atos.transport.entity.jpa.RecordFieldEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class RecordFieldServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public RecordFieldServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'RecordFieldEntity' to 'RecordField'
     * @param recordFieldEntity
     */
    public RecordField mapRecordFieldEntityToRecordField(RecordFieldEntity recordFieldEntity) {
        if(recordFieldEntity == null) {
            return null;
        }

        //--- Generic mapping 
        return map(recordFieldEntity, RecordField.class);

    }
    
    /**
     * Mapping from 'RecordField' to 'RecordFieldEntity'
     * @param recordField
     * @param recordFieldEntity
     */
    public void mapRecordFieldToRecordFieldEntity(RecordField recordField, RecordFieldEntity recordFieldEntity) {
        if(recordField == null) {
            return;
        }

        //--- Generic mapping 
        map(recordField, recordFieldEntity);

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