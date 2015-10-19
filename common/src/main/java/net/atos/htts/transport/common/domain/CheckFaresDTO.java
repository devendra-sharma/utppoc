package net.atos.htts.transport.common.domain;

import java.util.Date;

public class CheckFaresDTO {
	private RetailItemDTO retailItem;
	private Long maxSeasonFare;
	private Long maxNonSeasonFare;
	private Long cobId;
	private Integer faresCheckAheadDays;
	private Integer applyDiscount;
	
	public RetailItemDTO getRetailItem() {
		return retailItem;
	}
	public void setRetailItem(RetailItemDTO retailItem) {
		this.retailItem = retailItem;
	}
	public Long getMaxSeasonFare() {
		return maxSeasonFare;
	}
	public void setMaxSeasonFare(Long maxSeasonFare) {
		this.maxSeasonFare = maxSeasonFare;
	}
	public Long getMaxNonSeasonFare() {
		return maxNonSeasonFare;
	}
	public void setMaxNonSeasonFare(Long maxNonSeasonFare) {
		this.maxNonSeasonFare = maxNonSeasonFare;
	}

	public Integer getFaresCheckAheadDays() {
		return faresCheckAheadDays;
	}
	public void setFaresCheckAheadDays(Integer faresCheckAheadDays) {
		this.faresCheckAheadDays = faresCheckAheadDays;
	}
	public Integer getApplyDiscount() {
		return applyDiscount;
	}
	public void setApplyDiscount(Integer applyDiscount) {
		this.applyDiscount = applyDiscount;
	}
	public Long getCobId() {
		return cobId;
	}
	public void setCobId(Long cobId) {
		this.cobId = cobId;
	}
	

}
