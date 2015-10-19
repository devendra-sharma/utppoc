package net.atos.htts.transport.common.domain;


public class CodeBookDetailsDTO {
    
    
    private Long cobId;
    private Long fcFullFare;
    private String faresCheckingResult;
    private String generatingRetailItem;
    
    public Long getCobId() {
        return cobId;
    }
    public void setCobId(Long cobId) {
        this.cobId = cobId;
    }
    public Long getFcFullFare() {
        return fcFullFare;
    }
    public void setFcFullFare(Long fcFullFare) {
        this.fcFullFare = fcFullFare;
    }
    public String getFaresCheckingResult() {
        return faresCheckingResult;
    }
    public void setFaresCheckingResult(String faresCheckingResult) {
        this.faresCheckingResult = faresCheckingResult;
    }
    public String getGeneratingRetailItem() {
        return generatingRetailItem;
    }
    public void setGeneratingRetailItem(String generatingRetailItem) {
        this.generatingRetailItem = generatingRetailItem;
    }
    
    
}
