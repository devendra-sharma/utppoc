package net.atos.transport.test;

import net.atos.transport.entity.jpa.ProductTypeEntity;

public class ProductTypeEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ProductTypeEntity newProductTypeEntity() {

		Integer prtId = mockValues.nextInteger();

		ProductTypeEntity productTypeEntity = new ProductTypeEntity();
		productTypeEntity.setPrtId(prtId);
		return productTypeEntity;
	}
	
}
