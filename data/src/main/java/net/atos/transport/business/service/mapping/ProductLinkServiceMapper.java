/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.ProductLink;
import net.atos.transport.entity.jpa.ProductEntity;
import net.atos.transport.entity.jpa.ProductLinkEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class ProductLinkServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public ProductLinkServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'ProductLinkEntity' to 'ProductLink'
     * @param productLinkEntity
     */
    public ProductLink mapProductLinkEntityToProductLink(ProductLinkEntity productLinkEntity) {
        if(productLinkEntity == null) {
            return null;
        }

        //--- Generic mapping 
        ProductLink productLink = map(productLinkEntity, ProductLink.class);

        //--- Link mapping ( link to Product )
        if(productLinkEntity.getProduct() != null) {
            productLink.setProId(productLinkEntity.getProduct().getProId());
        }
        //--- Link mapping ( link to Product )
        if(productLinkEntity.getProduct2() != null) {
            productLink.setProIdParent(productLinkEntity.getProduct2().getProId());
        }
        return productLink;
    }
    
    /**
     * Mapping from 'ProductLink' to 'ProductLinkEntity'
     * @param productLink
     * @param productLinkEntity
     */
    public void mapProductLinkToProductLinkEntity(ProductLink productLink, ProductLinkEntity productLinkEntity) {
        if(productLink == null) {
            return;
        }

        //--- Generic mapping 
        map(productLink, productLinkEntity);

        //--- Link mapping ( link : productLink )
        if( hasLinkToProduct(productLink) ) {
            ProductEntity product1 = new ProductEntity();
            product1.setProId( productLink.getProId() );
            productLinkEntity.setProduct( product1 );
        } else {
            productLinkEntity.setProduct( null );
        }

        //--- Link mapping ( link : productLink )
        if( hasLinkToProduct(productLink) ) {
            ProductEntity product2 = new ProductEntity();
            product2.setProId( productLink.getProIdParent() );
            productLinkEntity.setProduct2( product2 );
        } else {
            productLinkEntity.setProduct2( null );
        }

    }
    
    /**
     * Verify that Product id is valid.
     * @param Product Product
     * @return boolean
     */
    private boolean hasLinkToProduct(ProductLink productLink) {
        if(productLink.getProId() != null) {
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