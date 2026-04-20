package com.cts.agrichainra.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.cts.agrichainra.service.ReportService;
import com.cts.agrichainra.dto.ReportDTO;
import com.cts.agrichainra.entity.Report;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @PostMapping
    public Report generateReport(@RequestBody ReportDTO dto) {
        return service.generateReport(dto);
    }

    @GetMapping
    public List<Report> getAllReports() {
        return service.getAllReports();
    }
}