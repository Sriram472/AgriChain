package com.cts.agrichaincam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplianceDTO {

    private Long entityId;
    private String entityType;
    private String result;
    private String notes;
}

