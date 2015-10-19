package net.atos.transport.test;

import net.atos.transport.entity.CodeBook;

public class CodeBookFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public CodeBook newCodeBook() {

		Integer cobId = mockValues.nextInteger();

		CodeBook codeBook = new CodeBook();
		codeBook.setCobId(cobId);
		return codeBook;
	}
	
}
