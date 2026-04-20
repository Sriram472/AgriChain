package com.cts.agrichaincam.controller;

import com.cts.agrichaincam.entity.ComplianceRecord;
import com.cts.agrichaincam.service.ComplianceService;
import com.cts.agrichaincam.dto.ComplianceDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceController {

    private final ComplianceService service;

    public ComplianceController(ComplianceService service) {
        this.service = service;
    }

    @PostMapping
    public ComplianceRecord create(@RequestBody ComplianceDTO dto) {
        return service.createCompliance(dto);
    }

    @GetMapping
    public List<ComplianceRecord> getAll() {
        return service.getAll();
    }
}
