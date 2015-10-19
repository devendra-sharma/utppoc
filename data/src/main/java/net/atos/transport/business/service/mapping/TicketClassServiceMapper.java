/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.TicketClass;
import net.atos.transport.entity.jpa.TicketClassEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class TicketClassServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public TicketClassServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'TicketClassEntity' to 'TicketClass'
     * @param ticketClassEntity
     */
    public TicketClass mapTicketClassEntityToTicketClass(TicketClassEntity ticketClassEntity) {
        if(ticketClassEntity == null) {
            return null;
        }

        //--- Generic mapping 
        return map(ticketClassEntity, TicketClass.class);

    }
    
    /**
     * Mapping from 'TicketClass' to 'TicketClassEntity'
     * @param ticketClass
     * @param ticketClassEntity
     */
    public void mapTicketClassToTicketClassEntity(TicketClass ticketClass, TicketClassEntity ticketClassEntity) {
        if(ticketClass == null) {
            return;
        }

        //--- Generic mapping 
        map(ticketClass, ticketClassEntity);

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