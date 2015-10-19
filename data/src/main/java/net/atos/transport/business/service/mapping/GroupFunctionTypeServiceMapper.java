/*


 */
package net.atos.transport.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.GroupFunctionType;
import net.atos.transport.entity.jpa.GroupFunctionTypeEntity;

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
        GroupFunctionType groupFunctionType = map(groupFunctionTypeEntity, GroupFunctionType.class);

        return groupFunctionType;
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