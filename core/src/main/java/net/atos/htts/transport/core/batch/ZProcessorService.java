package net.atos.htts.transport.core.batch;

import net.atos.htts.transport.common.exceptions.UTPException;

import org.springframework.batch.item.file.transform.FieldSet;


public interface ZProcessorService {

	public String ProcessZRecord(FieldSet fieldSet) throws UTPException;
}
