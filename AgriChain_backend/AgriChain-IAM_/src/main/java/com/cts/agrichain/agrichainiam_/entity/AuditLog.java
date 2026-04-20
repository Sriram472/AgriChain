package com.cts.agrichain.agrichainiam_.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditID;

    private Long userID;
    private String action;
    private String resource;
    private LocalDateTime timestamp;
}
