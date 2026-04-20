package com.example.agrichaincl_ml.repository;

import com.example.agrichaincl_ml.entity.CropListing;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CropListingRepository extends JpaRepository<CropListing, Long> {
    List<CropListing> findByStatus(String status);
}