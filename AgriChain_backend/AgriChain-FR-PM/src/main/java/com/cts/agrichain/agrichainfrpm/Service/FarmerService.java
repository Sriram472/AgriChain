package com.cts.agrichain.agrichainfrpm.farmer.service;

import com.cts.agrichain.agrichainfrpm.farmer.dto.FarmerRequestDTO;
import com.cts.agrichain.agrichainfrpm.farmer.entity.Farmer;
import com.cts.agrichain.agrichainfrpm.farmer.repository.FarmerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public Farmer registerFarmer(FarmerRequestDTO dto) {
        Farmer farmer = new Farmer();
        farmer.setName(dto.getName());
        farmer.setDob(dto.getDob());
        farmer.setGender(dto.getGender());
        farmer.setAddress(dto.getAddress());
        farmer.setContactInfo(dto.getContactInfo());
        farmer.setLandDetails(dto.getLandDetails());
        farmer.setStatus("PENDING");

        return farmerRepository.save(farmer);
    }

    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }

    public Farmer approveFarmer(Long farmerId) {
        Farmer farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
        farmer.setStatus("APPROVED");
        return farmerRepository.save(farmer);
    }
}