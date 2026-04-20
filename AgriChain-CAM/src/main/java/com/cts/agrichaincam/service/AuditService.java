package com.cts.agrichaincam.service;

import com.cts.agrichaincam.entity.Audit;
import com.cts.agrichaincam.repository.AuditRepository;
import com.cts.agrichaincam.dto.AuditDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AuditService {

    private final AuditRepository repository;

    public AuditService(AuditRepository repository) {
        this.repository = repository;
    }

    public Audit createAudit(AuditDTO dto) {

        Audit audit = new Audit();
        audit.setOfficerId(dto.getOfficerId());
        audit.setScope(dto.getScope());
        audit.setFindings(dto.getFindings());
        audit.setDate(LocalDate.now());
        audit.setStatus("OPEN");

        return repository.save(audit);
    }

    public List<Audit> getAll() {
        return repository.findAll();
    }
}
