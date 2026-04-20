package com.example.agrichaincl_ml.dto;

import java.time.LocalDateTime;

public class CropListingResponse {
    private Long listingId;
    private Long farmerId;
    private String cropType;
    private Double quantity;
    private Double price;
    private String location;
    private String status;
    private LocalDateTime createdDate;

    // getters and setters
}