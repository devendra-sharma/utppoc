package net.atos.transport.test;

import net.atos.transport.entity.jpa.ProductEntity;

public class ProductEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public ProductEntity newProductEntity()
    {

        Integer proId = mockValues.nextInteger();

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProId(proId);
        return productEntity;
    }

}
