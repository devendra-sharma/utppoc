package net.atos.transport.test;

import net.atos.transport.entity.ProductType;

public class ProductTypeFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public ProductType newProductType()
    {

        Integer prtId = mockValues.nextInteger();

        ProductType productType = new ProductType();
        productType.setPrtId(prtId);
        return productType;
    }

}
