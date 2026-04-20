package com.cts.agrichaincam.controller;

import com.cts.agrichaincam.entity.Audit;
import com.cts.agrichaincam.service.AuditService;
import com.cts.agrichaincam.dto.AuditDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/audits")
public class AuditController {

    private final AuditService service;

    public AuditController(AuditService service) {
        this.service = service;
    }

    @PostMapping
    public Audit create(@RequestBody AuditDTO dto) {
        return service.createAudit(dto);
    }

    @GetMapping
    public List<Audit> getAll() {
        return service.getAll();
    }
}
