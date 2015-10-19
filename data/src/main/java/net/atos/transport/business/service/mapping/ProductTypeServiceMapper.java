/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.ProductType;
import net.atos.transport.entity.jpa.ProductTypeEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class ProductTypeServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;
    
    /**
     * Constructor.
     */
    public ProductTypeServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'ProductTypeEntity' to 'ProductType'
     * @param productTypeEntity
     */
    public ProductType mapProductTypeEntityToProductType(ProductTypeEntity productTypeEntity) {
        if(productTypeEntity == null) {
            return null;
        }

        //--- Generic mapping 
        return map(productTypeEntity, ProductType.class);

    }
    
    /**
     * Mapping from 'ProductType' to 'ProductTypeEntity'
     * @param productType
     * @param productTypeEntity
     */
    public void mapProductTypeToProductTypeEntity(ProductType productType, ProductTypeEntity productTypeEntity) {
        if(productType == null) {
            return;
        }

        //--- Generic mapping 
        map(productType, productTypeEntity);

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