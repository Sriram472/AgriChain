package com.cts.agrichaincam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "audit")
@Getter
@Setter
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    private Long officerId;
    private String scope;
    private String findings;
    private LocalDate date;
    private String status;
}

