package com.cts.agrichainra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.agrichainra.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}