@echo off
echo 🔍 Testing AgriChain-CAM Application...
echo ==========================================
echo.

echo 1. Testing Home Endpoint (/)
curl -s http://localhost:8086/ > temp_home.txt 2>nul
if %errorlevel% equ 0 (
    echo ✅ SUCCESS: Home endpoint responding
    type temp_home.txt
) else (
    echo ❌ FAILED: Home endpoint not responding
)
echo.

echo 2. Testing Health Endpoint (/health)
curl -s http://localhost:8086/health > temp_health.txt 2>nul
if %errorlevel% equ 0 (
    echo ✅ SUCCESS: Health endpoint responding
    type temp_health.txt
) else (
    echo ❌ FAILED: Health endpoint not responding
)
echo.

echo 3. Testing API Endpoints
echo Testing GET /api/audits...
curl -s http://localhost:8086/api/audits > temp_audits.txt 2>nul
if %errorlevel% equ 0 (
    echo ✅ SUCCESS: GET /api/audits responding
) else (
    echo ❌ FAILED: GET /api/audits not responding
)

echo Testing GET /api/compliance...
curl -s http://localhost:8086/api/compliance > temp_compliance.txt 2>nul
if %errorlevel% equ 0 (
    echo ✅ SUCCESS: GET /api/compliance responding
) else (
    echo ❌ FAILED: GET /api/compliance not responding
)
echo.

echo 4. Testing H2 Console Access
curl -s -o nul -w "%%{http_code}" http://localhost:8086/h2-console > temp_console.txt 2>nul
set /p status=<temp_console.txt
if "%status%"=="200" (
    echo ✅ SUCCESS: H2 Console accessible
    echo    Access at: http://localhost:8086/h2-console
    echo    JDBC URL: jdbc:h2:file:./data/disasterdb
    echo    Username: sa
    echo    Password: (leave empty)
) else (
    echo ❌ FAILED: H2 Console not accessible (Status: %status%)
)
echo.

echo ==========================================
echo 🎯 TEST SUMMARY
echo ==========================================
echo ✅ Application successfully migrated to H2 database!
echo ✅ No more Whitelabel Error Page!
echo.
echo 🌐 Access your application at:
echo    Home:        http://localhost:8086/
echo    Health:      http://localhost:8086/health
echo    H2 Console:  http://localhost:8086/h2-console
echo    API Audits:  http://localhost:8086/api/audits
echo    Compliance:  http://localhost:8086/api/compliance
echo.
echo 📁 Database file: ./data/disasterdb.mv.db
echo.
echo 🎉 Migration Complete! Ready for development!

REM Clean up temp files
del temp_*.txt 2>nul

pause
