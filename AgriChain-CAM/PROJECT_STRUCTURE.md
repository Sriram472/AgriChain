# AgriChain-CAM Project Structure - H2 Database Version

## Project Overview
This is a Spring Boot application for managing Agricultural Compliance and Audit records. It uses H2 in-memory/file database for persistence.

## Directory Structure

```
AgriChain-CAM/
│
├── src/
│   ├── main/
│   │   ├── java/com/cts/agrichaincam/
│   │   │   ├── AgriChainCamApplication.java          [Main Spring Boot Application]
│   │   │   │
│   │   │   ├── config/
│   │   │   │   └── SecurityConfig.java               [Spring Security Configuration - H2 Console Access]
│   │   │   │
│   │   │   ├── controller/
│   │   │   │   ├── HomeController.java               [Home & Health Endpoints]
│   │   │   │   ├── AuditController.java              [Audit REST API]
│   │   │   │   ├── ComplianceController.java         [Compliance REST API]
│   │   │   │   └── GlobalExceptionHandler.java       [Error Handling]
│   │   │   │
│   │   │   ├── dto/
│   │   │   │   ├── AuditDTO.java                     [Audit Data Transfer Object]
│   │   │   │   └── ComplianceDTO.java                [Compliance Data Transfer Object]
│   │   │   │
│   │   │   ├── entity/
│   │   │   │   ├── Audit.java                        [Audit Entity/Table]
│   │   │   │   └── ComplianceRecord.java             [ComplianceRecord Entity/Table]
│   │   │   │
│   │   │   ├── repository/
│   │   │   │   ├── AuditRepository.java              [Audit Data Access Layer]
│   │   │   │   └── ComplianceRecordRepository.java   [Compliance Data Access Layer]
│   │   │   │
│   │   │   └── service/
│   │   │       ├── AuditService.java                 [Audit Business Logic]
│   │   │       └── ComplianceService.java            [Compliance Business Logic]
│   │   │
│   │   └── resources/
│   │       ├── application.properties                [Spring Boot Configuration - H2 Setup]
│   │       ├── static/                               [Static Resources (CSS, JS)]
│   │       └── templates/                            [HTML Templates]
│   │
│   └── test/
│       └── java/com/cts/agrichaincam/
│           └── AgriChainCamApplicationTests.java     [Application Tests]
│
├── target/                                            [Compiled Classes & JAR File]
│   ├── classes/
│   └── AgriChain-CAM-0.0.1-SNAPSHOT.jar             [Executable JAR]
│
├── data/                                              [H2 Database File - Created at Runtime]
│   └── disasterdb.mv.db                             [H2 Database File]
│
├── pom.xml                                            [Maven Configuration]
├── mvnw                                               [Maven Wrapper (Linux/Mac)]
├── mvnw.cmd                                           [Maven Wrapper (Windows)]
│
├── README.md                                          [Project README]
├── STARTUP_GUIDE.md                                   [Startup Instructions]
├── H2_DATABASE_SETUP.md                              [H2 Database Configuration Guide]
├── TEST_API.md                                        [API Testing Examples]
├── VERIFICATION_CHECKLIST.md                         [Verification Steps]
├── ERROR_RESOLUTION.md                               [Error Troubleshooting]
└── HELP.md                                            [Help Documentation]
```

## Technology Stack

| Component | Technology | Version |
|-----------|-----------|---------|
| **Framework** | Spring Boot | 4.0.5 |
| **Language** | Java | 17 |
| **Database** | H2 Database | Latest (from spring-boot-starter-parent) |
| **ORM** | JPA/Hibernate | Auto (via Spring Boot) |
| **Security** | Spring Security | 4.0.5 |
| **Build Tool** | Maven | 3.x (via mvnw wrapper) |
| **Logging** | SLF4J + Logback | Auto (via Spring Boot) |

## Key Configurations

### application.properties Settings
- **Server Port:** 8085
- **Database:** H2 File-based at `./data/disasterdb`
- **H2 Console:** Enabled at `/h2-console`
- **JPA/Hibernate:** DDL Auto-update mode
- **SQL Logging:** Enabled

### Database Tables (Auto-Created)
1. **audit** - Stores audit records
   - auditId (PK)
   - officerId
   - scope
   - findings
   - date
   - status

2. **compliance_record** - Stores compliance records
   - complianceId (PK)
   - entityId
   - entityType
   - result
   - notes
   - date

## API Endpoints Summary

### Public Endpoints (No Authentication)
- `GET /` - Welcome page
- `GET /health` - Health status
- `GET /api/audits` - List all audits
- `POST /api/audits` - Create new audit
- `GET /api/compliance` - List all compliance records
- `POST /api/compliance` - Create new compliance record
- `GET /h2-console` - H2 Database console (Web UI)

## Dependencies

### Core Dependencies
- **spring-boot-starter-data-jpa** - JPA/Hibernate support
- **spring-boot-starter-webmvc** - Spring Web MVC
- **spring-boot-starter-security** - Spring Security

### Database
- **h2** - H2 Database (file-based)
- **mysql-connector-j** - MySQL driver (kept for potential migration)

### Utilities
- **lombok** - Annotation processor for boilerplate code
- **spring-boot-starter-test** - Testing framework

## File Locations

| Purpose | Location |
|---------|----------|
| Database File | `./data/disasterdb.mv.db` |
| Configuration | `src/main/resources/application.properties` |
| Java Source | `src/main/java/com/cts/agrichaincam/` |
| Compiled Output | `target/classes/` |
| JAR Executable | `target/AgriChain-CAM-0.0.1-SNAPSHOT.jar` |
| Maven Config | `pom.xml` |

## Running the Application

### Option 1: Maven Wrapper
```bash
./mvnw.cmd spring-boot:run
```

### Option 2: Compiled JAR
```bash
java -jar target/AgriChain-CAM-0.0.1-SNAPSHOT.jar
```

### Option 3: IDE (IntelliJ/Eclipse)
- Import project as Maven project
- Run `AgriChainCamApplication.java` as Spring Boot App

## Application Startup Sequence
1. Maven/Spring Boot loads configuration from `application.properties`
2. H2 Database driver initializes
3. Hibernate creates/updates tables based on @Entity classes
4. Spring Security configuration applies
5. Controllers register endpoints
6. Application listens on `http://localhost:8085`
7. H2 Console available at `http://localhost:8085/h2-console`

## Important Notes
- ✅ No external MySQL server required
- ✅ Database persists to disk at `./data/disasterdb.mv.db`
- ✅ H2 Console is publicly accessible (can be restricted in SecurityConfig if needed)
- ✅ All API endpoints are public by default
- ✅ Entities use Lombok for less boilerplate code
- ✅ JPA automatically generates SQL queries

---
**Last Updated:** April 17, 2026

