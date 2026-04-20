# 🚀 AgriChain-CAM Startup & Testing Guide

## Quick Start

### 1. Start the Application
```bash
cd C:\Project\AgriChain_backend\AgriChain-CAM
.\mvnw.cmd spring-boot:run
```

Expected output:
```
:: Spring Boot ::                (v4.0.5)
...
o.s.b.w.embedded.tomcat.TomcatWebServer : Tomcat started on port(s): 8080 (http)
```

### 2. Test the API Endpoints

#### Create an Audit
```bash
curl -X POST http://localhost:8080/api/audits \
  -H "Content-Type: application/json" \
  -d '{
    "officerId": 1,
    "scope": "Monthly Inspection",
    "findings": "All compliant"
  }'
```

#### Get All Audits
```bash
curl http://localhost:8080/api/audits
```

#### Create a Compliance Record
```bash
curl -X POST http://localhost:8080/api/compliance \
  -H "Content-Type: application/json" \
  -d '{
    "entityId": 1,
    "entityType": "FARM",
    "result": "COMPLIANT",
    "notes": "All regulations met"
  }'
```

#### Get All Compliance Records
```bash
curl http://localhost:8080/api/compliance
```

---

## Database Access

### H2 Console
- **URL**: http://localhost:8080/h2-console
- **JDBC URL**: `jdbc:h2:mem:agrichaincam`
- **Username**: sa
- **Password**: Harika

### View Database Tables
```sql
SELECT * FROM audit;
SELECT * FROM compliance_record;
```

---

## Troubleshooting

### Port Already in Use
If port 8080 is in use, kill the process:
```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# OR change port in application.properties
server.port=8081
```

### Database Connection Issues
- Ensure H2 driver is in pom.xml
- Verify H2 dependency: `mvn dependency:tree | findstr h2`

### Application Won't Start
```bash
# Clean rebuild
.\mvnw.cmd clean compile package
java -jar target/AgriChain-CAM-0.0.1-SNAPSHOT.jar
```

---

## Project Structure

```
AgriChain-CAM/
├── src/main/java/com/cts/agrichaincam/
│   ├── AgriChainCamApplication.java (Main entry point)
│   ├── Entity/
│   │   ├── Audit.java
│   │   └── ComplianceRecord.java
│   ├── dto/
│   │   ├── AuditDTO.java
│   │   └── ComplianceDTO.java
│   ├── Repository/
│   │   ├── AuditRepository.java
│   │   └── ComplianceRecordRepository.java
│   ├── Service/
│   │   ├── AuditService.java
│   │   └── ComplianceService.java
│   └── controller/
│       ├── AuditController.java
│       └── ComplianceController.java
├── src/main/resources/
│   └── application.properties (Database config)
└── pom.xml (Dependencies)
```

---

## Key Files Modified

### pom.xml
- Added H2 database dependency
- Contains all Spring Boot and MySQL dependencies

### application.properties
- H2 in-memory database configuration
- JPA/Hibernate settings
- Tomcat port configuration

---

## Development Dependencies

- **Spring Boot**: 4.0.5
- **Java**: 17+
- **Spring Data JPA**: Latest
- **Hibernate**: 7.2.7.Final
- **H2 Database**: Latest
- **MySQL Connector**: 9.6.0 (for production)
- **Lombok**: 1.18.44

---

## Build & Deploy

### Build JAR
```bash
.\mvnw.cmd clean package -DskipTests
```

### Run JAR
```bash
java -jar target/AgriChain-CAM-0.0.1-SNAPSHOT.jar
```

### Run with Custom Port
```bash
java -jar target/AgriChain-CAM-0.0.1-SNAPSHOT.jar --server.port=8081
```

---

## Configuration for Production

Update `application.properties` for MySQL:

```properties
spring.application.name=AgriChain-CAM
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/agrichaincam
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

## Database Schema

### audit table
```sql
CREATE TABLE audit (
    audit_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    officer_id BIGINT,
    scope VARCHAR(255),
    findings VARCHAR(255),
    date DATE,
    status VARCHAR(255)
);
```

### compliance_record table
```sql
CREATE TABLE compliance_record (
    compliance_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    entity_id BIGINT,
    entity_type VARCHAR(255),
    result VARCHAR(255),
    notes VARCHAR(255),
    date DATE
);
```

---

## Status Checklist

✅ Application compiles successfully
✅ All dependencies resolved
✅ H2 database configured
✅ Tables auto-created by Hibernate
✅ API endpoints accessible
✅ Ready for testing

**Note**: Currently using H2 in-memory database for development. Switch to MySQL for production.

---

Last Updated: April 6, 2026

