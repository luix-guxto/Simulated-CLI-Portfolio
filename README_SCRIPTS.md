# 🚀 Scripts de Inicialização - Portfolio CLI Simulado

Este projeto inclui scripts automatizados para facilitar a execução tanto do backend quanto do frontend.

## 📁 Arquivos Criados

- **`start.sh`** - Script para Linux/Mac
- **`start.bat`** - Script para Windows
- **`README_SCRIPTS.md`** - Este arquivo de documentação

## 🖥️ Para Linux/Mac

### Como usar
```bash
# Tornar o script executável (apenas na primeira vez)
chmod +x start.sh

# Executar o script
./start.sh
```

### O que o script faz
1. 🚀 Abre um terminal separado e inicia o backend
2. 🌐 Abre outro terminal separado e inicia o frontend
3. 🎉 Mostra as URLs de acesso

### Para parar
Feche as janelas dos terminais que foram abertas

## 🪟 Para Windows

### Como usar
```cmd
# Executar o script
start.bat
```

### O que o script faz
1. 🚀 Abre um terminal separado e inicia o backend
2. 🌐 Abre outro terminal separado e inicia o frontend
3. 🎉 Mostra as URLs de acesso

### Para parar
Feche as janelas dos terminais que foram abertas

## 🌐 URLs de Acesso

Após a execução bem-sucedida dos scripts:

- **Frontend:** http://localhost:8000
- **Backend:** http://localhost:5000

## 🔧 Funcionalidades dos Scripts

### 🚀 Inicialização com Terminais Separados
- Cada serviço roda em sua própria janela de terminal
- Facilita o monitoramento de logs individuais
- Permite parar serviços independentemente
- Navegação automática para os diretórios corretos

### 🖥️ Suporte Multiplataforma
- **Windows:** Usa `cmd /k` para terminais persistentes
- **macOS:** Usa AppleScript para abrir Terminal
- **Linux GNOME:** Usa `gnome-terminal`
- **Linux KDE:** Usa `konsole`
- **Linux XTerm:** Usa `xterm` como fallback

## ⚠️ Solução de Problemas

### Erro: "mvnw não encontrado"
- Verifique se o arquivo `mvnw` existe no diretório `backend/`
- Este arquivo é gerado automaticamente pelo Maven

### Erro: "server.py não encontrado"
- Verifique se o arquivo `server.py` existe no diretório `frontend/`

### Erro: "Backend não está respondendo"
- Verifique se a porta 5000 está livre
- Verifique se o MySQL está rodando
- Verifique as configurações do banco de dados
- Verifique os logs no terminal do backend

### Erro: "Frontend não está respondendo"
- Verifique se a porta 8000 está livre
- Verifique se o Python está funcionando
- Verifique os logs no terminal do frontend

### Erro: "Terminal não encontrado" (Linux)
- O script tenta diferentes terminais: gnome-terminal, konsole, xterm
- Se nenhum funcionar, os serviços rodam em background

## 🎯 Comandos Manuais (Alternativa)

Se preferir executar manualmente:

### Backend
```bash
cd backend
./mvnw spring-boot:run
```

### Frontend
```bash
cd frontend
python server.py
```

## 📝 Logs e Debug

Cada serviço roda em seu próprio terminal, facilitando o debug:
- **Terminal do Backend:** Logs do Spring Boot
- **Terminal do Frontend:** Logs do servidor Python
- **Terminal Principal:** Apenas informações de inicialização

## 🎉 Benefícios

- ⚡ **Inicialização rápida** com um comando
- 🔄 **Processo automatizado** sem intervenção manual
- 📱 **Suporte multiplataforma** (Linux, Mac, Windows)
- 👀 **Monitoramento fácil** - cada serviço em janela separada
- 🛑 **Controle individual** - pode parar serviços separadamente
- 🎯 **Simplicidade** - apenas executa os programas
- 📊 **Logs organizados** - cada serviço tem seu próprio terminal 