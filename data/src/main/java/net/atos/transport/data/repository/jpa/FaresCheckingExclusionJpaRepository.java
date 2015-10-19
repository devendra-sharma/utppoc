package net.atos.transport.data.repository.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import net.atos.transport.entity.jpa.FaresCheckingExclusionEntity;

/**
 * Repository : FaresCheckingExclusion.
 */
public interface FaresCheckingExclusionJpaRepository extends PagingAndSortingRepository<FaresCheckingExclusionEntity, Long> {

    @Query("select f from FaresCheckingExclusionEntity f where f.sellingLocation = :sellingLocation and f.originLocation = :originLocation and f.destinationLocation = :destinationLocation and f.route = :route and f.product = :product and f.ticketStatus = :ticketStatus")
    FaresCheckingExclusionEntity findByParams(
            @Param("sellingLocation") String sellingLocation,
            @Param("originLocation") String originLocation,
            @Param("destinationLocation") String destinationLocation,
            @Param("route") String route, @Param("product") String product,
            @Param("ticketStatus") String ticketStatus
            );
}
