package com.cts.agrichain.controller;

import com.cts.agrichain.dto.AuditLogDTO;
import com.cts.agrichain.entity.AuditLog;
import com.cts.agrichain.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/audit-logs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuditLogController {

    private final AuditLogService auditLogService;

    @GetMapping
    public ResponseEntity<?> getAllAuditLogs() {
        try {
            List<AuditLogDTO> auditLogs = auditLogService.getAllAuditLogs();
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Audit logs retrieved successfully");
            response.put("logs", auditLogs);
            response.put("count", auditLogs.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAuditLogsByUserId(@PathVariable Long userId) {
        try {
            List<AuditLogDTO> auditLogs = auditLogService.getAuditLogsByUserId(userId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "User audit logs retrieved successfully");
            response.put("logs", auditLogs);
            response.put("count", auditLogs.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping("/resource/{resource}")
    public ResponseEntity<?> getAuditLogsByResource(@PathVariable String resource) {
        try {
            List<AuditLogDTO> auditLogs = auditLogService.getAuditLogsByResource(resource);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Audit logs by resource retrieved successfully");
            response.put("logs", auditLogs);
            response.put("count", auditLogs.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping("/action/{action}")
    public ResponseEntity<?> getAuditLogsByAction(@PathVariable String action) {
        try {
            AuditLog.AuditAction auditAction = AuditLog.AuditAction.valueOf(action.toUpperCase());
            List<AuditLogDTO> auditLogs = auditLogService.getAuditLogsByAction(auditAction);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Audit logs by action retrieved successfully");
            response.put("logs", auditLogs);
            response.put("count", auditLogs.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping("/date-range")
    public ResponseEntity<?> getAuditLogsByDateRange(@RequestParam String startTime,
                                                     @RequestParam String endTime) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            LocalDateTime start = LocalDateTime.parse(startTime, formatter);
            LocalDateTime end = LocalDateTime.parse(endTime, formatter);

            List<AuditLogDTO> auditLogs = auditLogService.getAuditLogsByDateRange(start, end);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Audit logs by date range retrieved successfully");
            response.put("logs", auditLogs);
            response.put("count", auditLogs.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping("/user/{userId}/date-range")
    public ResponseEntity<?> getUserAuditLogsByDateRange(@PathVariable Long userId,
                                                         @RequestParam String startTime,
                                                         @RequestParam String endTime) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            LocalDateTime start = LocalDateTime.parse(startTime, formatter);
            LocalDateTime end = LocalDateTime.parse(endTime, formatter);

            List<AuditLogDTO> auditLogs = auditLogService.getUserAuditLogsByDateRange(userId, start, end);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "User audit logs by date range retrieved successfully");
            response.put("logs", auditLogs);
            response.put("count", auditLogs.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping("/resource-action")
    public ResponseEntity<?> getAuditLogsByResourceAndAction(@RequestParam String resource,
                                                             @RequestParam String action) {
        try {
            AuditLog.AuditAction auditAction = AuditLog.AuditAction.valueOf(action.toUpperCase());
            List<AuditLogDTO> auditLogs = auditLogService.getAuditLogsByResourceAndAction(resource, auditAction);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Audit logs retrieved successfully");
            response.put("logs", auditLogs);
            response.put("count", auditLogs.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}

