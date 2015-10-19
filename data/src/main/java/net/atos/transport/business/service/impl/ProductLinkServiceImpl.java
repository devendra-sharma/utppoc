/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.business.service.ProductLinkService;
import net.atos.transport.business.service.mapping.ProductLinkServiceMapper;
import net.atos.transport.data.repository.jpa.ProductLinkJpaRepository;
import net.atos.transport.entity.ProductLink;
import net.atos.transport.entity.jpa.ProductLinkEntity;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ProductService
 */
@Component
@Transactional
public class ProductLinkServiceImpl implements ProductLinkService {

    @Resource
    private ProductLinkJpaRepository productLinkJpaRepository;

    @Resource
    private ProductLinkServiceMapper productLinkServiceMapper;
    
    @Override
    public ProductLink findById(Integer proLinkId) {
        ProductLinkEntity productEntity = productLinkJpaRepository.findOne(proLinkId);
        return productLinkServiceMapper.mapProductLinkEntityToProductLink(productEntity);
        
    }

    
    
    @Override
    public List<ProductLink> findAll() {
        Iterable<ProductLinkEntity> entities = productLinkJpaRepository.findAll();
        List<ProductLink> beans = new ArrayList<ProductLink>();
        for(ProductLinkEntity productEntity : entities) {
            beans.add(productLinkServiceMapper.mapProductLinkEntityToProductLink(productEntity));
        }
        return beans;
    }

    @Override
    public ProductLink save(ProductLink product) {
        return update(product) ;
    }

    @Override
    public ProductLink create(ProductLink product) {
        ProductLinkEntity productEntity = productLinkJpaRepository.findOne(product.getProId());
        if( productEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        productEntity = new ProductLinkEntity();
        productLinkServiceMapper.mapProductLinkToProductLinkEntity(product, productEntity);
        ProductLinkEntity productEntitySaved = productLinkJpaRepository.save(productEntity);
        return productLinkServiceMapper.mapProductLinkEntityToProductLink(productEntitySaved);
    }

    @Override
    public ProductLink update(ProductLink product) {
        ProductLinkEntity productEntity = productLinkJpaRepository.findOne(product.getProId());
        productLinkServiceMapper.mapProductLinkToProductLinkEntity(product, productEntity);
        ProductLinkEntity productEntitySaved = productLinkJpaRepository.save(productEntity);
        return productLinkServiceMapper.mapProductLinkEntityToProductLink(productEntitySaved);
    }

    @Override
    public void delete(Integer proId) {
        productLinkJpaRepository.delete(proId);
    }

}
