package net.atos.transport.test;

import net.atos.transport.entity.Product;

public class ProductFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Product newProduct() {

		Integer proId = mockValues.nextInteger();

		Product product = new Product();
		product.setProId(proId);
		return product;
	}
	
}
