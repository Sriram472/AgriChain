package com.cts.agrichain.repository;

import com.cts.agrichain.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByUserId(Long userId);

    List<AuditLog> findByResource(String resource);

    List<AuditLog> findByAuditAction(AuditLog.AuditAction action);

    @Query("SELECT a FROM AuditLog a WHERE a.timestamp BETWEEN :startTime AND :endTime")
    List<AuditLog> findAuditLogsByTimestampRange(@Param("startTime") LocalDateTime startTime,
                                                 @Param("endTime") LocalDateTime endTime);

    @Query("SELECT a FROM AuditLog a WHERE a.userId = :userId AND a.timestamp BETWEEN :startTime AND :endTime")
    List<AuditLog> findUserAuditLogsByDateRange(@Param("userId") Long userId,
                                                @Param("startTime") LocalDateTime startTime,
                                                @Param("endTime") LocalDateTime endTime);

    List<AuditLog> findByResourceAndAuditAction(String resource, AuditLog.AuditAction action);
}

