package com.cts.agrichain.service;

import com.cts.agrichain.dto.AuditLogDTO;
import com.cts.agrichain.entity.AuditLog;
import com.cts.agrichain.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    @Transactional
    public void logAction(Long userId, AuditLog.AuditAction action, String resource, String description) {
        AuditLog auditLog = new AuditLog();
        auditLog.setUserId(userId);
        auditLog.setAuditAction(action);
        auditLog.setAction(action.toString());
        auditLog.setResource(resource);
        auditLog.setDescription(description);
        auditLog.setStatus("SUCCESS");

        // Capture IP address and User-Agent
        HttpServletRequest request = getHttpServletRequest();
        if (request != null) {
            auditLog.setIpAddress(getClientIpAddress(request));
            auditLog.setUserAgent(request.getHeader("User-Agent"));
        }

        auditLogRepository.save(auditLog);
    }

    @Transactional
    public void logFailedAction(Long userId, AuditLog.AuditAction action, String resource, String description) {
        AuditLog auditLog = new AuditLog();
        auditLog.setUserId(userId);
        auditLog.setAuditAction(action);
        auditLog.setAction(action.toString());
        auditLog.setResource(resource);
        auditLog.setDescription(description);
        auditLog.setStatus("FAILED");

        HttpServletRequest request = getHttpServletRequest();
        if (request != null) {
            auditLog.setIpAddress(getClientIpAddress(request));
            auditLog.setUserAgent(request.getHeader("User-Agent"));
        }

        auditLogRepository.save(auditLog);
    }

    public List<AuditLogDTO> getAuditLogsByUserId(Long userId) {
        return auditLogRepository.findByUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AuditLogDTO> getAuditLogsByResource(String resource) {
        return auditLogRepository.findByResource(resource).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AuditLogDTO> getAuditLogsByAction(AuditLog.AuditAction action) {
        return auditLogRepository.findByAuditAction(action).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AuditLogDTO> getAuditLogsByDateRange(LocalDateTime startTime, LocalDateTime endTime) {
        return auditLogRepository.findAuditLogsByTimestampRange(startTime, endTime).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AuditLogDTO> getUserAuditLogsByDateRange(Long userId, LocalDateTime startTime, LocalDateTime endTime) {
        return auditLogRepository.findUserAuditLogsByDateRange(userId, startTime, endTime).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AuditLogDTO> getAuditLogsByResourceAndAction(String resource, AuditLog.AuditAction action) {
        return auditLogRepository.findByResourceAndAuditAction(resource, action).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AuditLogDTO> getAllAuditLogs() {
        return auditLogRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AuditLogDTO convertToDTO(AuditLog auditLog) {
        AuditLogDTO dto = new AuditLogDTO();
        dto.setAuditId(auditLog.getAuditId());
        dto.setUserId(auditLog.getUserId());
        dto.setAction(auditLog.getAction());
        dto.setResource(auditLog.getResource());
        dto.setDescription(auditLog.getDescription());
        dto.setTimestamp(auditLog.getTimestamp());
        dto.setIpAddress(auditLog.getIpAddress());
        dto.setUserAgent(auditLog.getUserAgent());
        dto.setAuditAction(auditLog.getAuditAction());
        dto.setStatus(auditLog.getStatus());
        return dto;
    }

    private HttpServletRequest getHttpServletRequest() {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                return attributes.getRequest();
            }
        } catch (Exception e) {
            // Request context not available
        }
        return null;
    }

    private String getClientIpAddress(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            return xForwardedFor.split(",")[0];
        }
        String xRealIp = request.getHeader("X-Real-IP");
        if (xRealIp != null && !xRealIp.isEmpty()) {
            return xRealIp;
        }
        return request.getRemoteAddr();
    }
}

