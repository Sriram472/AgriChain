package com.cts.agrichaincam.service;

import com.cts.agrichaincam.entity.ComplianceRecord;
import com.cts.agrichaincam.repository.ComplianceRecordRepository;
import com.cts.agrichaincam.dto.ComplianceDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ComplianceService {

    private final ComplianceRecordRepository repository;

    public ComplianceService(ComplianceRecordRepository repository) {
        this.repository = repository;
    }

    public ComplianceRecord createCompliance(ComplianceDTO dto) {

        ComplianceRecord record = new ComplianceRecord();
        record.setEntityId(dto.getEntityId());
        record.setEntityType(dto.getEntityType());
        record.setResult(dto.getResult());
        record.setNotes(dto.getNotes());
        record.setDate(LocalDate.now());

        return repository.save(record);
    }

    public List<ComplianceRecord> getAll() {
        return repository.findAll();
    }
}
