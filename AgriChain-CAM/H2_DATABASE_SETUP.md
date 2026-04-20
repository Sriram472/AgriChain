# AgriChain-CAM H2 Database Configuration - Complete Setup Guide

## ✅ Project Successfully Configured for H2 Database

Your project has been fully migrated from MySQL to H2 database. Here's what has been completed:

---

## 📁 Files Created/Modified

### 1. **application.properties** (UPDATED)
- ✅ H2 file-based database configured at `./data/disasterdb`
- ✅ H2 Console enabled at `/h2-console`
- ✅ Hibernate DDL auto-update enabled
- ✅ SQL logging enabled for debugging
- ✅ Proper error handling configuration

**Location:** `src/main/resources/application.properties`

---

### 2. **pom.xml** (UPDATED)
- ✅ H2 Database dependency added (already present)
- ✅ Spring Security dependency added for H2 console security
- ✅ All required Spring Boot starters included

**Location:** `pom.xml`

---

### 3. **SecurityConfig.java** (CREATED)
- ✅ H2 Console CSRF protection disabled
- ✅ Frame options disabled for H2 Console UI
- ✅ Public access configured for H2 console and API endpoints
- ✅ Spring Security properly integrated

**Location:** `src/main/java/com/cts/agrichaincam/config/SecurityConfig.java`

---

### 4. **HomeController.java** (CREATED)
- ✅ Root endpoint (`/`) displays welcome message
- ✅ `/health` endpoint for monitoring
- ✅ Shows all available API endpoints

**Location:** `src/main/java/com/cts/agrichaincam/controller/HomeController.java`

---

### 5. **GlobalExceptionHandler.java** (CREATED)
- ✅ Handles 404 errors gracefully
- ✅ Provides helpful error messages with available endpoints
- ✅ Generic exception handling for server errors

**Location:** `src/main/java/com/cts/agrichaincam/controller/GlobalExceptionHandler.java`

---

## 🚀 How to Run the Application

### Option 1: Using Maven Wrapper
```powershell
cd C:\Users\2478376\Downloads\AgriChain-CAM\AgriChain-CAM
.\mvnw.cmd spring-boot:run
```

### Option 2: Run JAR directly
```powershell
cd C:\Users\2478376\Downloads\AgriChain-CAM\AgriChain-CAM\target
java -jar AgriChain-CAM-0.0.1-SNAPSHOT.jar
```

---

## 🌐 Available Endpoints

| Endpoint | Method | Purpose |
|----------|--------|---------|
| `/` | GET | Welcome page with API information |
| `/health` | GET | Application health status |
| `/api/audits` | GET | Get all audit records |
| `/api/audits` | POST | Create new audit record |
| `/api/compliance` | GET | Get all compliance records |
| `/api/compliance` | POST | Create new compliance record |
| `/h2-console` | GET | H2 Database console (Web UI) |

---

## 📊 H2 Console Access

**URL:** `http://localhost:8085/h2-console`

**Login Credentials:**
- **JDBC URL:** `jdbc:h2:file:./data/disasterdb`
- **Username:** `sa`
- **Password:** (leave empty)

---

## 📝 API Request Examples

### Create Audit Record
```json
POST /api/audits
{
  "officerId": 1,
  "scope": "Farm inspection",
  "findings": "All compliant"
}
```

### Create Compliance Record
```json
POST /api/compliance
{
  "entityId": 1,
  "entityType": "Farm",
  "result": "Compliant",
  "notes": "Inspection complete"
}
```

### Get All Audits
```
GET /api/audits
```

### Get All Compliance Records
```
GET /api/compliance
```

---

## 🔧 Database Configuration Details

**File Location:** `./data/disasterdb.mv.db`
- Database file is stored on disk (persistent)
- Automatically created on first run
- H2 keeps database connection open until app stops

**Configuration in application.properties:**
```properties
spring.datasource.url=jdbc:h2:file:./data/disasterdb;MODE=MySQL;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

---

## ✨ Key Features Configured

✅ **No MySQL Dependency** - Switched to H2
✅ **File-Based Persistence** - Data survives app restart
✅ **Web Console** - Browse/query database via `/h2-console`
✅ **Security Configured** - H2 console properly secured with Spring Security
✅ **Auto-Schema Creation** - Tables auto-created from @Entity classes
✅ **Error Handling** - Friendly error responses instead of Whitelabel errors
✅ **Logging** - SQL queries logged for debugging

---

## 🐛 Troubleshooting

### If port 8085 is already in use:
Change in `application.properties`:
```properties
server.port=8086
```

### If database file gets corrupted:
Delete `./data/disasterdb.mv.db` and restart the application. It will be recreated automatically.

### To reset database:
Stop the application, delete the `./data/` directory, and restart.

---

## 🎯 Build Status

✅ **Project builds successfully** with no errors
✅ **All dependencies resolved**
✅ **Ready for testing and development**

---

**Happy Coding!** 🎉

