package com.cts.agrichaincam.repository;

import com.cts.agrichaincam.entity.ComplianceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplianceRecordRepository
        extends JpaRepository<ComplianceRecord, Long> {
}
