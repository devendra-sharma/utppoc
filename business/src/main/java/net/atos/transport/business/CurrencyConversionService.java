package net.atos.transport.business;

import java.math.BigDecimal;

import net.atos.htts.transport.common.domain.ConvertCurrency;
import net.atos.htts.transport.common.exceptions.UTPException;

public interface CurrencyConversionService {

    public BigDecimal convertCurrency(ConvertCurrency convCurr) throws UTPException;
}
