/*


 */
package net.atos.transport.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.atos.transport.entity.Product;
import net.atos.transport.entity.jpa.ProductEntity;
import net.atos.transport.business.service.ProductService;
import net.atos.transport.business.service.mapping.ProductServiceMapper;
import net.atos.transport.data.repository.jpa.ProductJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ProductService
 */
@Component
@Transactional
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductJpaRepository productJpaRepository;

    @Resource
    private ProductServiceMapper productServiceMapper;
    
    @Override
    public Product findById(Integer proId) {
        ProductEntity productEntity = productJpaRepository.findOne(proId);
        return productServiceMapper.mapProductEntityToProduct(productEntity);
    }

    @Override
    public List<Product> findAll() {
        Iterable<ProductEntity> entities = productJpaRepository.findAll();
        List<Product> beans = new ArrayList<Product>();
        for(ProductEntity productEntity : entities) {
            beans.add(productServiceMapper.mapProductEntityToProduct(productEntity));
        }
        return beans;
    }

    @Override
    public Product save(Product product) {
        return update(product) ;
    }

    @Override
    public Product create(Product product) {
        ProductEntity productEntity = productJpaRepository.findOne(product.getProId());
        if( productEntity != null ) {
            throw new IllegalStateException("already.exists");
        }
        productEntity = new ProductEntity();
        productServiceMapper.mapProductToProductEntity(product, productEntity);
        ProductEntity productEntitySaved = productJpaRepository.save(productEntity);
        return productServiceMapper.mapProductEntityToProduct(productEntitySaved);
    }

    @Override
    public Product update(Product product) {
        ProductEntity productEntity = productJpaRepository.findOne(product.getProId());
        productServiceMapper.mapProductToProductEntity(product, productEntity);
        ProductEntity productEntitySaved = productJpaRepository.save(productEntity);
        return productServiceMapper.mapProductEntityToProduct(productEntitySaved);
    }

    @Override
    public void delete(Integer proId) {
        productJpaRepository.delete(proId);
    }

    public ProductJpaRepository getProductJpaRepository() {
        return productJpaRepository;
    }

    public void setProductJpaRepository(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    public ProductServiceMapper getProductServiceMapper() {
        return productServiceMapper;
    }

    public void setProductServiceMapper(ProductServiceMapper productServiceMapper) {
        this.productServiceMapper = productServiceMapper;
    }

}
