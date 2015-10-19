package net.atos.transport.test;

import net.atos.transport.entity.ProductLink;

public class ProductLinkFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ProductLink newProductLink() {

		Integer proLinkId = mockValues.nextInteger();
		ProductLink productLink = new ProductLink();
		productLink.setPrlId(proLinkId);
		return productLink;
	}
	
}
