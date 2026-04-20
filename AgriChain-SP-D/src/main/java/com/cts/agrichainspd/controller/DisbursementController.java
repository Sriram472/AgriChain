package com.cts.agrichainspd.controller;

import com.cts.agrichainspd.entity.Disbursement;
import com.cts.agrichainspd.service.DisbursementService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/disbursements")
public class DisbursementController {

    private final DisbursementService service;

    public DisbursementController(DisbursementService service) {
        this.service = service;
    }

    @PostMapping
    public Disbursement createDisbursement(@RequestBody Disbursement disbursement) {
        return service.createDisbursement(disbursement);
    }

    @GetMapping("/farmer/{farmerId}")
    public List<Disbursement> getByFarmer(@PathVariable Long farmerId) {
        return service.getByFarmerId(farmerId);
    }
}