/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.GroupFunctionType;
import net.atos.transport.entity.jpa.GroupFunctionTypeEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class GroupFunctionTypeServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public GroupFunctionTypeServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'GroupFunctionTypeEntity' to 'GroupFunctionType'
     * @param groupFunctionTypeEntity
     */
    public GroupFunctionType mapGroupFunctionTypeEntityToGroupFunctionType(GroupFunctionTypeEntity groupFunctionTypeEntity) {
        if(groupFunctionTypeEntity == null) {
            return null;
        }

        //--- Generic mapping 
        return map(groupFunctionTypeEntity, GroupFunctionType.class);

    }
    
    /**
     * Mapping from 'GroupFunctionType' to 'GroupFunctionTypeEntity'
     * @param groupFunctionType
     * @param groupFunctionTypeEntity
     */
    public void mapGroupFunctionTypeToGroupFunctionTypeEntity(GroupFunctionType groupFunctionType, GroupFunctionTypeEntity groupFunctionTypeEntity) {
        if(groupFunctionType == null) {
            return;
        }

        //--- Generic mapping 
        map(groupFunctionType, groupFunctionTypeEntity);

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