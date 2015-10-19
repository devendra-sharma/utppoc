package net.atos.transport.test;

import net.atos.transport.entity.jpa.CodeBookEntity;

public class CodeBookEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public CodeBookEntity newCodeBookEntity() {

		Integer cobId = mockValues.nextInteger();

		CodeBookEntity codeBookEntity = new CodeBookEntity();
		codeBookEntity.setCobId(cobId);
		return codeBookEntity;
	}
	
}
