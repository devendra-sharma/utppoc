/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.TicketAllocationCode;
import net.atos.transport.entity.jpa.TicketAllocationCodeEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class TicketAllocationCodeServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public TicketAllocationCodeServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'TicketAllocationCodeEntity' to 'TicketAllocationCode'
     * @param ticketAllocationCodeEntity
     */
    public TicketAllocationCode mapTicketAllocationCodeEntityToTicketAllocationCode(TicketAllocationCodeEntity ticketAllocationCodeEntity) {
        if(ticketAllocationCodeEntity == null) {
            return null;
        }

        //--- Generic mapping 
        return map(ticketAllocationCodeEntity, TicketAllocationCode.class);

    }
    
    /**
     * Mapping from 'TicketAllocationCode' to 'TicketAllocationCodeEntity'
     * @param ticketAllocationCode
     * @param ticketAllocationCodeEntity
     */
    public void mapTicketAllocationCodeToTicketAllocationCodeEntity(TicketAllocationCode ticketAllocationCode, TicketAllocationCodeEntity ticketAllocationCodeEntity) {
        if(ticketAllocationCode == null) {
            return;
        }

        //--- Generic mapping 
        map(ticketAllocationCode, ticketAllocationCodeEntity);

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