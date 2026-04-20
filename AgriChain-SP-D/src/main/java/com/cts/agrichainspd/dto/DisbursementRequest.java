package com.cts.agrichainspd.dto;

import java.time.LocalDate;

public class DisbursementRequest {

    private Long farmerId;
    private Long programId;
    private Double amount;

    // Constructors
    public DisbursementRequest() {
    }

    public DisbursementRequest(Long farmerId, Long programId, Double amount) {
        this.farmerId = farmerId;
        this.programId = programId;
        this.amount = amount;
    }

    // Getters and Setters
    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

