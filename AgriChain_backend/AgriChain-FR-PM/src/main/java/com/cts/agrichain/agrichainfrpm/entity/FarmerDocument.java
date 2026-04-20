package com.cts.agrichain.agrichainfrpm.farmer.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "farmer_documents")
public class FarmerDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;

    private String docType; // IDProof / LandRecord
    private String fileUri;
    private LocalDate uploadedDate;
    private String verificationStatus; // PENDING / VERIFIED / REJECTED

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    public FarmerDocument() {}

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }

    public LocalDate getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(LocalDate uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }
}