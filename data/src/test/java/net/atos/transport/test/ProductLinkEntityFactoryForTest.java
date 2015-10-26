package net.atos.transport.test;

import net.atos.transport.entity.jpa.ProductLinkEntity;

public class ProductLinkEntityFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public ProductLinkEntity newProductLinkEntity()
    {

        Integer proLinkId = mockValues.nextInteger();

        ProductLinkEntity productLinkEntity = new ProductLinkEntity();
        productLinkEntity.setPrlId(proLinkId);
        return productLinkEntity;
    }

}
