/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.ProductType;
import net.atos.transport.entity.jpa.ProductTypeEntity;
import net.atos.transport.business.service.ProductTypeService;
import net.atos.transport.business.service.mapping.ProductTypeServiceMapper;
import net.atos.transport.data.repository.jpa.ProductTypeJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ProductTypeService
 */
@Component
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {

    @Resource
    private ProductTypeJpaRepository productTypeJpaRepository;

    @Resource
    private ProductTypeServiceMapper productTypeServiceMapper;
    
    @Override
    public ProductType findById(Integer prtId) {
        ProductTypeEntity productTypeEntity = productTypeJpaRepository.findOne(prtId);
        return productTypeServiceMapper.mapProductTypeEntityToProductType(productTypeEntity);
    }

    @Override
    public List<ProductType> findAll() {
        Iterable<ProductTypeEntity> entities = productTypeJpaRepository.findAll();
        List<ProductType> beans = new ArrayList<ProductType>();
        for(ProductTypeEntity productTypeEntity : entities) {
            beans.add(productTypeServiceMapper.mapProductTypeEntityToProductType(productTypeEntity));
        }
        return beans;
    }

    @Override
    public ProductType save(ProductType productType) {
        return update(productType) ;
    }

    @Override
    public ProductType create(ProductType productType) {
        ProductTypeEntity productTypeEntity = productTypeJpaRepository.findOne(productType.getPrtId());
        if( productTypeEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        productTypeEntity = new ProductTypeEntity();
        productTypeServiceMapper.mapProductTypeToProductTypeEntity(productType, productTypeEntity);
        ProductTypeEntity productTypeEntitySaved = productTypeJpaRepository.save(productTypeEntity);
        return productTypeServiceMapper.mapProductTypeEntityToProductType(productTypeEntitySaved);
    }

    @Override
    public ProductType update(ProductType productType) {
        ProductTypeEntity productTypeEntity = productTypeJpaRepository.findOne(productType.getPrtId());
        productTypeServiceMapper.mapProductTypeToProductTypeEntity(productType, productTypeEntity);
        ProductTypeEntity productTypeEntitySaved = productTypeJpaRepository.save(productTypeEntity);
        return productTypeServiceMapper.mapProductTypeEntityToProductType(productTypeEntitySaved);
    }

    @Override
    public void delete(Integer prtId) {
        productTypeJpaRepository.delete(prtId);
    }

    public ProductTypeJpaRepository getProductTypeJpaRepository() {
        return productTypeJpaRepository;
    }

    public void setProductTypeJpaRepository(ProductTypeJpaRepository productTypeJpaRepository) {
        this.productTypeJpaRepository = productTypeJpaRepository;
    }

    public ProductTypeServiceMapper getProductTypeServiceMapper() {
        return productTypeServiceMapper;
    }

    public void setProductTypeServiceMapper(ProductTypeServiceMapper productTypeServiceMapper) {
        this.productTypeServiceMapper = productTypeServiceMapper;
    }

}
