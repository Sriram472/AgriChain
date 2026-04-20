package com.cts.agrichaincam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "compliance_record")
@Getter
@Setter
public class ComplianceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complianceId;

    private Long entityId;
    private String entityType;
    private String result;
    private String notes;
    private LocalDate date;
}
