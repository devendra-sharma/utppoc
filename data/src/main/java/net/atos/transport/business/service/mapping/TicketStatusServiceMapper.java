/*


 */
package net.atos.transport.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.TicketStatus;
import net.atos.transport.entity.jpa.TicketStatusEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class TicketStatusServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public TicketStatusServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'TicketStatusEntity' to 'TicketStatus'
     * @param ticketStatusEntity
     */
    public TicketStatus mapTicketStatusEntityToTicketStatus(TicketStatusEntity ticketStatusEntity) {
        if(ticketStatusEntity == null) {
            return null;
        }

        //--- Generic mapping 
        TicketStatus ticketStatus = map(ticketStatusEntity, TicketStatus.class);

        return ticketStatus;
    }
    
    /**
     * Mapping from 'TicketStatus' to 'TicketStatusEntity'
     * @param ticketStatus
     * @param ticketStatusEntity
     */
    public void mapTicketStatusToTicketStatusEntity(TicketStatus ticketStatus, TicketStatusEntity ticketStatusEntity) {
        if(ticketStatus == null) {
            return;
        }

        //--- Generic mapping 
        map(ticketStatus, ticketStatusEntity);

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