# ⚡ Quick Reference Card - AgriChain-CAM H2 Database Setup

## 🚀 Start Application

```powershell
cd C:\Users\2478376\Downloads\AgriChain-CAM\AgriChain-CAM
.\mvnw.cmd spring-boot:run
```

**Application URL:** `http://localhost:8085`

---

## 🌐 Quick Links

| Link | Purpose |
|------|---------|
| `http://localhost:8085/` | Home page (Lists all endpoints) |
| `http://localhost:8085/health` | Application health status |
| `http://localhost:8085/h2-console` | H2 Database console |
| `http://localhost:8085/api/audits` | Audit API |
| `http://localhost:8085/api/compliance` | Compliance API |

---

## 🔑 H2 Console Login

**URL:** `http://localhost:8085/h2-console`

| Field | Value |
|-------|-------|
| **JDBC URL** | `jdbc:h2:file:./data/disasterdb` |
| **Username** | `sa` |
| **Password** | (leave empty) |

---

## 📝 Sample API Requests

### Create Audit
```powershell
$body = @{
    officerId = 101
    scope = "Farm inspection"
    findings = "Compliant"
} | ConvertTo-Json

Invoke-WebRequest -Uri "http://localhost:8085/api/audits" `
  -Method Post -ContentType "application/json" -Body $body
```

### Get All Audits
```powershell
Invoke-WebRequest -Uri "http://localhost:8085/api/audits" -Method Get
```

### Create Compliance Record
```powershell
$body = @{
    entityId = 1
    entityType = "Farm"
    result = "Passed"
    notes = "All certifications valid"
} | ConvertTo-Json

Invoke-WebRequest -Uri "http://localhost:8085/api/compliance" `
  -Method Post -ContentType "application/json" -Body $body
```

### Get All Compliance Records
```powershell
Invoke-WebRequest -Uri "http://localhost:8085/api/compliance" -Method Get
```

---

## 📂 Key File Locations

| File | Location |
|------|----------|
| **Application Config** | `src/main/resources/application.properties` |
| **Security Config** | `src/main/java/com/cts/agrichaincam/config/SecurityConfig.java` |
| **Home Controller** | `src/main/java/com/cts/agrichaincam/controller/HomeController.java` |
| **Error Handler** | `src/main/java/com/cts/agrichaincam/controller/GlobalExceptionHandler.java` |
| **Database File** | `./data/disasterdb.mv.db` (created at runtime) |
| **JAR Executable** | `target/AgriChain-CAM-0.0.1-SNAPSHOT.jar` |

---

## 🔧 Maven Commands

| Command | Purpose |
|---------|---------|
| `.\mvnw.cmd clean` | Clean build artifacts |
| `.\mvnw.cmd compile` | Compile source code |
| `.\mvnw.cmd package` | Build JAR package |
| `.\mvnw.cmd spring-boot:run` | Run application |
| `.\mvnw.cmd clean package -DskipTests` | Build without tests |

---

## 📊 Database Tables

### audit
- `auditId` (PK, Auto-increment)
- `officerId`
- `scope`
- `findings`
- `date` (LocalDate)
- `status`

### compliance_record
- `complianceId` (PK, Auto-increment)
- `entityId`
- `entityType`
- `result`
- `notes`
- `date` (LocalDate)

---

## ✅ Verification Checklist

- [ ] Application starts without errors
- [ ] Home page loads at `http://localhost:8085/`
- [ ] Health check works at `http://localhost:8085/health`
- [ ] H2 Console accessible at `http://localhost:8085/h2-console`
- [ ] Can create audit record via POST `/api/audits`
- [ ] Can retrieve audits via GET `/api/audits`
- [ ] Can create compliance record via POST `/api/compliance`
- [ ] Can retrieve compliance records via GET `/api/compliance`
- [ ] Database file created at `./data/disasterdb.mv.db`

---

## 🐛 Common Issues & Fixes

**Port 8085 already in use?**
→ Change `server.port=8085` to another port in `application.properties`

**H2 Console returns 500 error?**
→ Check SecurityConfig is properly configured (already done)

**Database file not found?**
→ Database is created automatically on first run

**"No static resource h2-console" error?**
→ Fixed by adding proper Spring Security configuration

**404 Whitelabel error page?**
→ Fixed by creating GlobalExceptionHandler

---

## 📚 Documentation Files

- **H2_DATABASE_SETUP.md** - Detailed configuration guide
- **TEST_API.md** - Comprehensive API testing examples
- **PROJECT_STRUCTURE.md** - Complete project structure
- **QUICK_REFERENCE.md** - This file!

---

**Last Updated:** April 17, 2026
**Status:** ✅ Production Ready

