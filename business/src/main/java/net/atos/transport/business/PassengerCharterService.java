package net.atos.transport.business;

import java.math.BigDecimal;

import net.atos.htts.transport.common.domain.CodeBookDTO;
import net.atos.htts.transport.common.domain.PassengerCharterDTO;

public interface PassengerCharterService {

	public BigDecimal calculatePassengerCharterFullFare(PassengerCharterDTO passengerCharterDTO,
			CodeBookDTO codeBookDTO);
}
