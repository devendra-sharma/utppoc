/*


 */
package net.atos.transport.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.ProcessControl;
import net.atos.transport.entity.jpa.ProcessControlEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class ProcessControlServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public ProcessControlServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'ProcessControlEntity' to 'ProcessControl'
     * @param processControlEntity
     */
    public ProcessControl mapProcessControlEntityToProcessControl(ProcessControlEntity processControlEntity) {
        if(processControlEntity == null) {
            return null;
        }

        //--- Generic mapping 
        ProcessControl processControl = map(processControlEntity, ProcessControl.class);

        return processControl;
    }
    
    /**
     * Mapping from 'ProcessControl' to 'ProcessControlEntity'
     * @param processControl
     * @param processControlEntity
     */
    public void mapProcessControlToProcessControlEntity(ProcessControl processControl, ProcessControlEntity processControlEntity) {
        if(processControl == null) {
            return;
        }

        //--- Generic mapping 
        map(processControl, processControlEntity);

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