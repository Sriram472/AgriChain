package com.cts.agrichain.agrichainfrpm.farmer.repository;

import com.cts.agrichain.agrichainfrpm.farmer.entity.FarmerDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerDocumentRepository extends JpaRepository<FarmerDocument, Long> {
}