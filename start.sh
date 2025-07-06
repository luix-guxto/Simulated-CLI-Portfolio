#!/bin/bash

# Cores para output
BLUE='\033[0;34m'
GREEN='\033[0;32m'
NC='\033[0m' # No Color

echo -e "${BLUE}================================${NC}"
echo -e "${BLUE}  Portfolio CLI Simulado${NC}"
echo -e "${BLUE}  Script de Inicialização${NC}"
echo -e "${BLUE}================================${NC}"

# Obter o diretório do script
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

echo -e "${BLUE}📁 Iniciando o backend...${NC}"

# Detectar o sistema operacional e abrir terminal apropriado
if [[ "$OSTYPE" == "darwin"* ]]; then
    # macOS
    osascript -e "tell application \"Terminal\" to do script \"cd '$SCRIPT_DIR/backend' && chmod +x mvnw && ./mvnw spring-boot:run\""
elif command -v gnome-terminal &> /dev/null; then
    # Linux com GNOME
    gnome-terminal --title="Backend - Portfolio CLI" -- bash -c "cd '$SCRIPT_DIR/backend' && chmod +x mvnw && ./mvnw spring-boot:run; exec bash"
elif command -v konsole &> /dev/null; then
    # Linux com KDE
    konsole --title "Backend - Portfolio CLI" -e bash -c "cd '$SCRIPT_DIR/backend' && chmod +x mvnw && ./mvnw spring-boot:run; exec bash"
elif command -v xterm &> /dev/null; then
    # Linux com XTerm
    xterm -title "Backend - Portfolio CLI" -e bash -c "cd '$SCRIPT_DIR/backend' && chmod +x mvnw && ./mvnw spring-boot:run; exec bash" &
else
    # Fallback - executar em background
    cd "$SCRIPT_DIR/backend"
    chmod +x mvnw
    ./mvnw spring-boot:run &
    cd "$SCRIPT_DIR"
fi

echo -e "${BLUE}📁 Iniciando o frontend...${NC}"

if [[ "$OSTYPE" == "darwin"* ]]; then
    # macOS
    osascript -e "tell application \"Terminal\" to do script \"cd '$SCRIPT_DIR/frontend' && python3 server.py\""
elif command -v gnome-terminal &> /dev/null; then
    # Linux com GNOME
    gnome-terminal --title="Frontend - Portfolio CLI" -- bash -c "cd '$SCRIPT_DIR/frontend' && python3 server.py; exec bash"
elif command -v konsole &> /dev/null; then
    # Linux com KDE
    konsole --title "Frontend - Portfolio CLI" -e bash -c "cd '$SCRIPT_DIR/frontend' && python3 server.py; exec bash"
elif command -v xterm &> /dev/null; then
    # Linux com XTerm
    xterm -title "Frontend - Portfolio CLI" -e bash -c "cd '$SCRIPT_DIR/frontend' && python3 server.py; exec bash" &
else
    # Fallback - executar em background
    cd "$SCRIPT_DIR/frontend"
    python3 server.py &
    cd "$SCRIPT_DIR"
fi

echo -e "\n${GREEN}🎉 Sistema iniciado com sucesso!${NC}"
echo -e "${BLUE}================================${NC}"
echo -e "${GREEN}🌐 Frontend:${NC} http://localhost:8000"
echo -e "${GREEN}🔧 Backend:${NC} http://localhost:5000"
echo -e "${BLUE}================================${NC}"
echo -e "${GREEN}💡 Os terminais foram abertos em janelas separadas${NC}"
echo -e "${GREEN}💡 Feche as janelas dos terminais para parar os serviços${NC}" 