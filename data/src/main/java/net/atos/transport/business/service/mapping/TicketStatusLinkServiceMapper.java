/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.TicketStatusLink;
import net.atos.transport.entity.jpa.TicketStatusEntity;
import net.atos.transport.entity.jpa.TicketStatusLinkEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class TicketStatusLinkServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public TicketStatusLinkServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'TicketStatusLinkEntity' to 'TicketStatusLink'
     * @param ticketStatusLinkEntity
     */
    public TicketStatusLink mapTicketStatusLinkEntityToTicketStatusLink(TicketStatusLinkEntity ticketStatusLinkEntity) {
        if(ticketStatusLinkEntity == null) {
            return null;
        }

        //--- Generic mapping 
        TicketStatusLink ticketStatusLink = map(ticketStatusLinkEntity, TicketStatusLink.class);

        //--- Link mapping ( link to TicketStatus )
        if(ticketStatusLinkEntity.getTicketStatus2() != null) {
            ticketStatusLink.setTisIdLinkedBy(ticketStatusLinkEntity.getTicketStatus2().getTisId());
        }
        //--- Link mapping ( link to TicketStatus )
        if(ticketStatusLinkEntity.getTicketStatus() != null) {
            ticketStatusLink.setTisIdLinks(ticketStatusLinkEntity.getTicketStatus().getTisId());
        }
        return ticketStatusLink;
    }
    
    /**
     * Mapping from 'TicketStatusLink' to 'TicketStatusLinkEntity'
     * @param ticketStatusLink
     * @param ticketStatusLinkEntity
     */
    public void mapTicketStatusLinkToTicketStatusLinkEntity(TicketStatusLink ticketStatusLink, TicketStatusLinkEntity ticketStatusLinkEntity) {
        if(ticketStatusLink == null) {
            return;
        }

        //--- Generic mapping 
        map(ticketStatusLink, ticketStatusLinkEntity);

        //--- Link mapping ( link : ticketStatusLink )
        if( hasLinkToTicketStatus(ticketStatusLink) ) {
            TicketStatusEntity ticketStatus1 = new TicketStatusEntity();
            ticketStatus1.setTisId( ticketStatusLink.getTisIdLinkedBy() );
            ticketStatusLinkEntity.setTicketStatus2( ticketStatus1 );
        } else {
            ticketStatusLinkEntity.setTicketStatus2( null );
        }

        //--- Link mapping ( link : ticketStatusLink )
        if( hasLinkToTicketStatus(ticketStatusLink) ) {
            TicketStatusEntity ticketStatus2 = new TicketStatusEntity();
            ticketStatus2.setTisId( ticketStatusLink.getTisIdLinks() );
            ticketStatusLinkEntity.setTicketStatus( ticketStatus2 );
        } else {
            ticketStatusLinkEntity.setTicketStatus( null );
        }

    }
    
    /**
     * Verify that TicketStatus id is valid.
     * @param TicketStatus TicketStatus
     * @return boolean
     */
    private boolean hasLinkToTicketStatus(TicketStatusLink ticketStatusLink) {
        if(ticketStatusLink.getTisIdLinkedBy() != null) {
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