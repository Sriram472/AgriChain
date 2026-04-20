package com.cts.agrichain.agrichainfrpm.farmer.controller;

import com.cts.agrichain.agrichainfrpm.farmer.dto.FarmerRequestDTO;
import com.cts.agrichain.agrichainfrpm.farmer.entity.Farmer;
import com.cts.agrichain.agrichainfrpm.farmer.service.FarmerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {

    private final FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping
    public Farmer registerFarmer(@RequestBody FarmerRequestDTO dto) {
        return farmerService.registerFarmer(dto);
    }

    @GetMapping
    public List<Farmer> getAllFarmers() {
        return farmerService.getAllFarmers();
    }

    @PutMapping("/{farmerId}/approve")
    public Farmer approveFarmer(@PathVariable Long farmerId) {
        return farmerService.approveFarmer(farmerId);
    }
}