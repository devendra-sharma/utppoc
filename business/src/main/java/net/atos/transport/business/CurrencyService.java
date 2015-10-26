package net.atos.transport.business;

import net.atos.htts.transport.common.exceptions.UTPException;

public interface CurrencyService
{

    public String ifConvertCurrency(String currencyCode) throws UTPException;

}
