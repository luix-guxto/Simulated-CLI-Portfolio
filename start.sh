#!/bin/bash
BLUE='\033[0;34m'
GREEN='\033[0;32m'
NC='\033[0m'

echo -e "${BLUE}================================${NC}"
echo -e "${BLUE}  Portfolio CLI Simulado${NC}"
echo -e "${BLUE}  Script de Inicialização${NC}"
echo -e "${BLUE}================================${NC}"

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

echo -e "${BLUE}📁 Iniciando o backend...${NC}"

if [[ "$OSTYPE" == "darwin"* ]]; then
    osascript -e "tell application \"Terminal\" to do script \"cd '$SCRIPT_DIR/backend' && chmod +x mvnw && ./mvnw spring-boot:run\""
elif command -v gnome-terminal &> /dev/null; then
    gnome-terminal --title="Backend - Portfolio CLI" -- bash -c "cd '$SCRIPT_DIR/backend' && chmod +x mvnw && ./mvnw spring-boot:run; exec bash"
elif command -v konsole &> /dev/null; then
    konsole --title "Backend - Portfolio CLI" -e bash -c "cd '$SCRIPT_DIR/backend' && chmod +x mvnw && ./mvnw spring-boot:run; exec bash"
elif command -v xterm &> /dev/null; then
    xterm -title "Backend - Portfolio CLI" -e bash -c "cd '$SCRIPT_DIR/backend' && chmod +x mvnw && ./mvnw spring-boot:run; exec bash" &
else
    cd "$SCRIPT_DIR/backend"
    chmod +x mvnw
    ./mvnw spring-boot:run &
    cd "$SCRIPT_DIR"
fi

echo -e "${BLUE}📁 Iniciando o frontend...${NC}"

if [[ "$OSTYPE" == "darwin"* ]]; then
    osascript -e "tell application \"Terminal\" to do script \"cd '$SCRIPT_DIR/frontend' && python3 server.py\""
elif command -v gnome-terminal &> /dev/null; then
    gnome-terminal --title="Frontend - Portfolio CLI" -- bash -c "cd '$SCRIPT_DIR/frontend' && python3 server.py; exec bash"
elif command -v konsole &> /dev/null; then
    konsole --title "Frontend - Portfolio CLI" -e bash -c "cd '$SCRIPT_DIR/frontend' && python3 server.py; exec bash"
elif command -v xterm &> /dev/null; then
    xterm -title "Frontend - Portfolio CLI" -e bash -c "cd '$SCRIPT_DIR/frontend' && python3 server.py; exec bash" &
else
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