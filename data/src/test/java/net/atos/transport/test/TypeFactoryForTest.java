package net.atos.transport.test;

import net.atos.transport.entity.Type;

public class TypeFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public Type newType() {

		Integer typId = mockValues.nextInteger();

		Type type = new Type();
		type.setTypId(typId);
		return type;
	}
	
}
