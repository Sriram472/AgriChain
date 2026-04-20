package com.cts.agrichain.agrichainfrpm.farmer.repository;

import com.cts.agrichain.agrichainfrpm.farmer.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {
}