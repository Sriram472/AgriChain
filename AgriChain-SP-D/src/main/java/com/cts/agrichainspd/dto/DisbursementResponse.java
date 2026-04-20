package com.cts.agrichainspd.dto;

import java.time.LocalDate;

public class DisbursementResponse {

    private Long disbursementId;
    private Long farmerId;
    private Long programId;
    private Double amount;
    private LocalDate date;
    private String status;

    // Constructors
    public DisbursementResponse() {
    }

    public DisbursementResponse(Long disbursementId, Long farmerId, Long programId, Double amount, LocalDate date, String status) {
        this.disbursementId = disbursementId;
        this.farmerId = farmerId;
        this.programId = programId;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    // Getters and Setters
    public Long getDisbursementId() {
        return disbursementId;
    }

    public void setDisbursementId(Long disbursementId) {
        this.disbursementId = disbursementId;
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

