/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.RouteLink;
import net.atos.transport.entity.jpa.RouteEntity;
import net.atos.transport.entity.jpa.RouteLinkEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class RouteLinkServiceMapper extends AbstractServiceMapper
{

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;

    /**
     * Constructor.
     */
    public RouteLinkServiceMapper()
    {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'RouteLinkEntity' to 'RouteLink'
     * 
     * @param routeLinkEntity
     */
    public RouteLink mapRouteLinkEntityToRouteLink(RouteLinkEntity routeLinkEntity)
    {
        if (routeLinkEntity == null)
        {
            return null;
        }

        // --- Generic mapping
        RouteLink routeLink = map(routeLinkEntity, RouteLink.class);

        // --- Link mapping ( link to Route )
        if (routeLinkEntity.getRoute2() != null)
        {
            routeLink.setRouIdParent(routeLinkEntity.getRoute2().getRouId());
        }
        // --- Link mapping ( link to Route )
        if (routeLinkEntity.getRoute() != null)
        {
            routeLink.setRouIdChild(routeLinkEntity.getRoute().getRouId());
        }
        return routeLink;
    }

    /**
     * Mapping from 'RouteLink' to 'RouteLinkEntity'
     * 
     * @param routeLink
     * @param routeLinkEntity
     */
    public void mapRouteLinkToRouteLinkEntity(RouteLink routeLink, RouteLinkEntity routeLinkEntity)
    {
        if (routeLink == null)
        {
            return;
        }

        // --- Generic mapping
        map(routeLink, routeLinkEntity);

        // --- Link mapping ( link : routeLink )
        if (hasLinkToRoute(routeLink))
        {
            RouteEntity route1 = new RouteEntity();
            route1.setRouId(routeLink.getRouIdParent());
            routeLinkEntity.setRoute2(route1);
        }
        else
        {
            routeLinkEntity.setRoute2(null);
        }

        // --- Link mapping ( link : routeLink )
        if (hasLinkToRoute(routeLink))
        {
            RouteEntity route2 = new RouteEntity();
            route2.setRouId(routeLink.getRouIdChild());
            routeLinkEntity.setRoute(route2);
        }
        else
        {
            routeLinkEntity.setRoute(null);
        }

    }

    /**
     * Verify that Route id is valid.
     * 
     * @param Route
     *            Route
     * @return boolean
     */
    private boolean hasLinkToRoute(RouteLink routeLink)
    {
        if (routeLink.getRouIdParent() != null)
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
