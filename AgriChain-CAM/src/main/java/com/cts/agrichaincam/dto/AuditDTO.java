package com.cts.agrichaincam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditDTO {

    private Long officerId;
    private String scope;
    private String findings;
}
