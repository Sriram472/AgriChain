package com.cts.agrichain.agrichainiam_.service;

import com.cts.agrichain.agrichainiam_.entity.AuditLog;
import com.cts.agrichain.agrichainiam_.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository repo) {
        this.auditLogRepository = repo;
    }

    public void log(Long userID, String action, String resource) {
        AuditLog log = new AuditLog();
        log.setUserID(userID);
        log.setAction(action);
        log.setResource(resource);
        log.setTimestamp(LocalDateTime.now());
        auditLogRepository.save(log);
    }

    public List<AuditLog> getAll() {
        return auditLogRepository.findAll();
    }
}
