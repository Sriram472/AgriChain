package com.cts.agrichain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.cts.agrichain.entity.AuditLog;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogDTO {
    private Long auditId;
    private Long userId;
    private String action;
    private String resource;
    private String description;
    private LocalDateTime timestamp;
    private String ipAddress;
    private String userAgent;
    private AuditLog.AuditAction auditAction;
    private String status;
}

