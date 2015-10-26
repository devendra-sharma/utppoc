/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.Route;
import net.atos.transport.entity.jpa.RouteEntity;
import net.atos.transport.entity.jpa.TicketAllocationCodeEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class RouteServiceMapper extends AbstractServiceMapper
{

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;

    /**
     * Constructor.
     */
    public RouteServiceMapper()
    {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'RouteEntity' to 'Route'
     * 
     * @param routeEntity
     */
    public Route mapRouteEntityToRoute(RouteEntity routeEntity)
    {
        if (routeEntity == null)
        {
            return null;
        }

        // --- Generic mapping
        Route route = map(routeEntity, Route.class);

        // --- Link mapping ( link to TicketAllocationCode )
        if (routeEntity.getTicketAllocationCode() != null)
        {
            route.setTacId(routeEntity.getTicketAllocationCode().getTacId());
        }
        return route;
    }

    /**
     * Mapping from 'Route' to 'RouteEntity'
     * 
     * @param route
     * @param routeEntity
     */
    public void mapRouteToRouteEntity(Route route, RouteEntity routeEntity)
    {
        if (route == null)
        {
            return;
        }

        // --- Generic mapping
        map(route, routeEntity);

        // --- Link mapping ( link : route )
        if (hasLinkToTicketAllocationCode(route))
        {
            TicketAllocationCodeEntity ticketAllocationCode1 = new TicketAllocationCodeEntity();
            ticketAllocationCode1.setTacId(route.getTacId());
            routeEntity.setTicketAllocationCode(ticketAllocationCode1);
        }
        else
        {
            routeEntity.setTicketAllocationCode(null);
        }

    }

    /**
     * Verify that TicketAllocationCode id is valid.
     * 
     * @param TicketAllocationCode
     *            TicketAllocationCode
     * @return boolean
     */
    private boolean hasLinkToTicketAllocationCode(Route route)
    {
        if (route.getTacId() != null)
        {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelMapper getModelMapper()
    {
        return modelMapper;
    }

    protected void setModelMapper(ModelMapper modelMapper)
    {
        this.modelMapper = modelMapper;
    }

}
