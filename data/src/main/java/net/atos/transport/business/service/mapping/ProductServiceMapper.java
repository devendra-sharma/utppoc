/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.Product;
import net.atos.transport.entity.jpa.BusinessEntity;
import net.atos.transport.entity.jpa.ProductEntity;
import net.atos.transport.entity.jpa.ProductTypeEntity;
import net.atos.transport.entity.jpa.TicketAllocationCodeEntity;
import net.atos.transport.entity.jpa.TicketClassEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class ProductServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public ProductServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'ProductEntity' to 'Product'
     * @param productEntity
     */
    public Product mapProductEntityToProduct(ProductEntity productEntity) {
        if(productEntity == null) {
            return null;
        }

        //--- Generic mapping 
        Product product = map(productEntity, Product.class);

        //--- Link mapping ( link to TicketAllocationCode )
        if(productEntity.getTicketAllocationCode() != null) {
            product.setTacId(productEntity.getTicketAllocationCode().getTacId());
        }
        //--- Link mapping ( link to Business )
        if(productEntity.getBusiness2() != null) {
            product.setBusiness(productEntity.getBusiness2().getBusId());
        }
        //--- Link mapping ( link to ProductType )
        if(productEntity.getProductType() != null) {
            product.setPrtId(productEntity.getProductType().getPrtId());
        }
        //--- Link mapping ( link to TicketClass )
        if(productEntity.getTicketClass() != null) {
            product.setTicId(productEntity.getTicketClass().getTicId());
        }
        return product;
    }
    
    /**
     * Mapping from 'Product' to 'ProductEntity'
     * @param product
     * @param productEntity
     */
    public void mapProductToProductEntity(Product product, ProductEntity productEntity) {
        if(product == null) {
            return;
        }

        //--- Generic mapping 
        map(product, productEntity);

        //--- Link mapping ( link : product )
        if( hasLinkToTicketAllocationCode(product) ) {
            TicketAllocationCodeEntity ticketAllocationCode1 = new TicketAllocationCodeEntity();
            ticketAllocationCode1.setTacId( product.getTacId() );
            productEntity.setTicketAllocationCode( ticketAllocationCode1 );
        } else {
            productEntity.setTicketAllocationCode( null );
        }

        //--- Link mapping ( link : product )
        if( hasLinkToBusiness(product) ) {
            BusinessEntity business2 = new BusinessEntity();
            business2.setBusId( product.getBusiness() );
            productEntity.setBusiness2( business2 );
        } else {
            productEntity.setBusiness2( null );
        }

        //--- Link mapping ( link : product )
        if( hasLinkToProductType(product) ) {
            ProductTypeEntity productType3 = new ProductTypeEntity();
            productType3.setPrtId( product.getPrtId() );
            productEntity.setProductType( productType3 );
        } else {
            productEntity.setProductType( null );
        }

        //--- Link mapping ( link : product )
        if( hasLinkToTicketClass(product) ) {
            TicketClassEntity ticketClass4 = new TicketClassEntity();
            ticketClass4.setTicId( product.getTicId() );
            productEntity.setTicketClass( ticketClass4 );
        } else {
            productEntity.setTicketClass( null );
        }

    }
    
    /**
     * Verify that TicketAllocationCode id is valid.
     * @param TicketAllocationCode TicketAllocationCode
     * @return boolean
     */
    private boolean hasLinkToTicketAllocationCode(Product product) {
        if(product.getTacId() != null) {
            return true;
        }
        return false;
    }

    /**
     * Verify that Business id is valid.
     * @param Business Business
     * @return boolean
     */
    private boolean hasLinkToBusiness(Product product) {
        if(product.getBusiness() != null) {
            return true;
        }
        return false;
    }

    /**
     * Verify that ProductType id is valid.
     * @param ProductType ProductType
     * @return boolean
     */
    private boolean hasLinkToProductType(Product product) {
        if(product.getPrtId() != null) {
            return true;
        }
        return false;
    }

    /**
     * Verify that TicketClass id is valid.
     * @param TicketClass TicketClass
     * @return boolean
     */
    private boolean hasLinkToTicketClass(Product product) {
        if(product.getTicId() != null) {
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