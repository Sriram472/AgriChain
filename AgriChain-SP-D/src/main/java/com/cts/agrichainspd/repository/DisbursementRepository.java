package com.cts.agrichainspd.repository;

import com.cts.agrichainspd.entity.Disbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface DisbursementRepository extends JpaRepository<Disbursement, Long> {

    List<Disbursement> findByFarmerId(Long farmerId);
}