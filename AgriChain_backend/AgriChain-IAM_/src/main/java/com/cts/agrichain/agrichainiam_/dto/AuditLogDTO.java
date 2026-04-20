package com.cts.agrichain.agrichainiam_.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AuditLogDTO {
    private String action;
    private String resource;
    private LocalDateTime timestamp;
}
