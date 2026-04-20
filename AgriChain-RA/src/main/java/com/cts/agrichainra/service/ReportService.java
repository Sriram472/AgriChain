package com.cts.agrichainra.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import com.cts.agrichainra.repository.ReportRepository;
import com.cts.agrichainra.dto.ReportDTO;
import com.cts.agrichainra.entity.Report;

@Service
public class ReportService {

    private final ReportRepository repository;

    public ReportService(ReportRepository repository) {
        this.repository = repository;
    }

    public Report generateReport(ReportDTO dto) {

        Report report = new Report();
        report.setScope(dto.getScope());
        report.setMetrics(dto.getMetrics());
        report.setGeneratedDate(LocalDate.now());

        return repository.save(report);
    }

    public List<Report> getAllReports() {
        return repository.findAll();
    }
}