package net.atos.transport.business;

import java.util.Date;

import net.atos.htts.transport.common.constants.AppConstants;
import net.atos.htts.transport.common.domain.CheckFaresDTO;
import net.atos.htts.transport.common.domain.CodeBookDetailsDTO;
import net.atos.htts.transport.common.domain.RetailItemDTO;
import net.atos.htts.transport.common.exceptions.UTPException;
import net.atos.transport.business.service.FaresCheckingExclusionService;
import net.atos.transport.business.service.LocationService;
import net.atos.transport.business.service.ProductService;
import net.atos.transport.business.service.RouteService;
import net.atos.transport.business.service.TicketStatusService;
import net.atos.transport.entity.FaresCheckingExclusion;
import net.atos.transport.entity.Location;
import net.atos.transport.entity.Product;
import net.atos.transport.entity.Route;
import net.atos.transport.entity.TicketStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckFaresServiceImpl implements CheckFaresService {

    @Autowired
    private LocationService locationService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private TicketStatusService ticketStatusService;

    @Autowired
    private ProductService productService;

    @Autowired
    private FaresCheckingExclusionService faresService;

    @Override
    public CodeBookDetailsDTO checkFares(CheckFaresDTO checkFares)
            throws UTPException {
        RetailItemDTO retailItem = checkFares.getRetailItem();

        String originlocation = this.getLocation(retailItem.getOriginLocId());
        String destinationLocation = this.getLocation(retailItem
                .getDestinationLocId());
        String sellingLocation = this.getLocation(retailItem
                .getSellingLocationLocId());
        String routeCode = this.getRouteCode(retailItem.getRouteRouId());
        String ticketCode = this.getTicketCode(retailItem.getTicketStatusTisId());
        String productCode = this.getProductCode(retailItem.getProductProId());

        return this.getCodeBookDetailsDTO(originlocation, destinationLocation,
                sellingLocation, routeCode, ticketCode, productCode, retailItem);

    }

    private String getLocation(Long id) throws UTPException {
        Location location = locationService.findById(id.intValue());
        if (location != null) {

            return location.getLocation();
        } else {
            throw new UTPException("Location entry not found for location Id: "
                    + id);
        }
    }

    private String getRouteCode(Long id) throws UTPException {
        Route route = routeService.findById(id.intValue());
        if (route != null) {
            return route.getRouteCode();
        } else {
            throw new UTPException(AppConstants.ROUTE_ENTRY_EXCEPTION + id);
        }
    }

    private String getTicketCode(Long id) throws UTPException {
        TicketStatus tickStatus = ticketStatusService.findById(id.intValue());
        if (tickStatus != null) {
            return tickStatus.getTicketStatusCode();
        } else {
            throw new UTPException(AppConstants.ROUTE_ENTRY_EXCEPTION + id);
        }
    }

    private String getProductCode(Long id) throws UTPException {
        Product tickStatus = productService.findById(id.intValue());
        if (tickStatus != null) {
            return tickStatus.getProductCode();
        } else {
            throw new UTPException(AppConstants.ROUTE_ENTRY_EXCEPTION + id);
        }
    }

    private CodeBookDetailsDTO getCodeBookDetailsDTO(String originlocation,
            String destinationLocation, String sellingLocation,
            String routeCode, String ticketCode, String productCode, RetailItemDTO retailItem) {

        FaresCheckingExclusion exclusion = faresService
                .getFaresExclusionByParams(sellingLocation, originlocation,
                        destinationLocation, routeCode, productCode, ticketCode);
        CodeBookDetailsDTO codeBookDetailsDTO = new CodeBookDetailsDTO();
       
        codeBookDetailsDTO.setGeneratingRetailItem("RETAILDMM");
        if (exclusion != null) {
            codeBookDetailsDTO
                    .setFcFullFare(Long.parseLong(exclusion.getFare()));
            Date effectFrom = exclusion.getWithEffectFrom();
            Date effectTo = exclusion.getWithEffectUntil();
            codeBookDetailsDTO.setFaresCheckingResult("RESDMM");
            if (retailItem.getDateOfTravel().after(effectFrom)
                    && retailItem.getDateOfTravel().before(effectTo)) {
                codeBookDetailsDTO.setCobId(1L);
            } else {
                codeBookDetailsDTO.setCobId(0L);
            }
        } else {
            codeBookDetailsDTO.setCobId(0L);
        }

        return codeBookDetailsDTO;
    }
}
