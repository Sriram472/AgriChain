package com.cts.agrichainspd.service;

import com.cts.agrichainspd.entity.Disbursement;
import com.cts.agrichainspd.repository.DisbursementRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class DisbursementService {

    private final DisbursementRepository repository;

    public DisbursementService(DisbursementRepository repository) {
        this.repository = repository;
    }

    public Disbursement createDisbursement(Disbursement disbursement) {
        disbursement.setDate(LocalDate.now());
        disbursement.setStatus("PENDING");
        return repository.save(disbursement);
    }

    public List<Disbursement> getByFarmerId(Long farmerId) {
        return repository.findByFarmerId(farmerId);
    }
}
