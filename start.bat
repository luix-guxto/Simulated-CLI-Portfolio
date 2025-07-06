@echo off
chcp 65001 >nul

echo ================================
echo   Portfolio CLI Simulado
echo   Script de Inicialização
echo ================================

echo 📁 Iniciando o backend...
start "Backend - Portfolio CLI" cmd /k "cd /d %~dp0backend && mvnw spring-boot:run"

echo 📁 Iniciando o frontend...
start "Frontend - Portfolio CLI" cmd /k "cd /d %~dp0frontend && python server.py"

echo.
echo 🎉 Sistema iniciado com sucesso!
echo ================================
echo 🌐 Frontend: http://localhost:8000
echo 🔧 Backend: http://localhost:5000
echo ================================
echo 💡 Os terminais foram abertos em janelas separadas
echo 💡 Feche as janelas dos terminais para parar os serviços

pause 