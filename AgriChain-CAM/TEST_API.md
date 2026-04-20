# Test API Endpoints - cURL Examples for Windows PowerShell

## 1. Health Check
```powershell
Invoke-WebRequest -Uri "http://localhost:8085/health" -Method Get
```

## 2. Home Endpoint
```powershell
Invoke-WebRequest -Uri "http://localhost:8085/" -Method Get
```

## 3. Create Audit Record
```powershell
$body = @{
    officerId = 101
    scope = "Monthly farm inspection"
    findings = "All regulations compliant"
} | ConvertTo-Json

Invoke-WebRequest -Uri "http://localhost:8085/api/audits" `
  -Method Post `
  -ContentType "application/json" `
  -Body $body
```

## 4. Get All Audits
```powershell
Invoke-WebRequest -Uri "http://localhost:8085/api/audits" -Method Get
```

## 5. Create Compliance Record
```powershell
$body = @{
    entityId = 1
    entityType = "Farm"
    result = "Passed"
    notes = "All certifications valid"
} | ConvertTo-Json

Invoke-WebRequest -Uri "http://localhost:8085/api/compliance" `
  -Method Post `
  -ContentType "application/json" `
  -Body $body
```

## 6. Get All Compliance Records
```powershell
Invoke-WebRequest -Uri "http://localhost:8085/api/compliance" -Method Get
```

## 7. Access H2 Console
```
Navigate to: http://localhost:8085/h2-console
Username: sa
Password: (leave empty)
JDBC URL: jdbc:h2:file:./data/disasterdb
```

## Running All Tests at Once

```powershell
# Health check
$health = Invoke-WebRequest -Uri "http://localhost:8085/health" -Method Get
Write-Host "Health Check Response:" -ForegroundColor Green
$health.Content | ConvertFrom-Json | ConvertTo-Json

# Home page
$home = Invoke-WebRequest -Uri "http://localhost:8085/" -Method Get
Write-Host "`nHome Page Response:" -ForegroundColor Green
$home.Content | ConvertFrom-Json | ConvertTo-Json

# Create audit
$auditBody = @{
    officerId = 101
    scope = "Test Audit"
    findings = "All good"
} | ConvertTo-Json

$audit = Invoke-WebRequest -Uri "http://localhost:8085/api/audits" `
  -Method Post `
  -ContentType "application/json" `
  -Body $auditBody
Write-Host "`nCreate Audit Response:" -ForegroundColor Green
$audit.Content | ConvertFrom-Json | ConvertTo-Json

# Get all audits
$audits = Invoke-WebRequest -Uri "http://localhost:8085/api/audits" -Method Get
Write-Host "`nGet All Audits Response:" -ForegroundColor Green
$audits.Content | ConvertFrom-Json | ConvertTo-Json
```

## Notes
- Make sure the application is running before executing these commands
- Default application port is 8085
- The H2 database will be created automatically at `./data/disasterdb`
- No authentication is required for the API endpoints (public access)

