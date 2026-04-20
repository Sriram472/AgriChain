package com.cts.agrichain.agrichainiam_.controller;

import com.cts.agrichain.agrichainiam_.entity.AuditLog;
import com.cts.agrichain.agrichainiam_.service.AuditLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auditlogs")
public class AuditLogController {

    private final AuditLogService auditLogService;

    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @GetMapping
    public List<AuditLog> getAll() {
        return auditLogService.getAll();
    }
}
