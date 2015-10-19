package net.atos.htts.transport.common.domain;

import java.util.Date;

public class CalendarDTO {

	
	private Date date;
	private String currencyRate;
	private String conversionPower;
	private Integer calId;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCurrencyRate() {
		return currencyRate;
	}
	public void setCurrencyRate(String currencyRate) {
		this.currencyRate = currencyRate;
	}
	public String getConversionPower() {
		return conversionPower;
	}
	public void setConversionPower(String conversionPower) {
		this.conversionPower = conversionPower;
	}
	public Integer getCalId() {
		return calId;
	}
	public void setCalId(Integer calId) {
		this.calId = calId;
	}
	
}
