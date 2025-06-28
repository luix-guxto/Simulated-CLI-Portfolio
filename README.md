# 💻 Simulated CLI Portfolio

Este projeto é um portfólio interativo em forma de terminal (CLI), onde recrutadores e visitantes podem "brincar" com comandos para descobrir mais sobre mim, meus projetos, habilidades, currículo e formas de contato.

## 🚀 Funcionalidades

- Terminal interativo que simula um CLI na web.
- Comandos como `help`, `get about`, `get skills`, `get cv`, `get projects`, etc.
- Interface multilíngue: português e inglês.
- Currículo disponível para download via comando.
- Manual de comandos abaixo do terminal para facilitar o uso.
- Comandos com resposta dinâmica via API (Spring Boot).
- Banco de dados com projetos e certificados.
- Layout responsivo e acessível.

## 📂 Estrutura do Projeto

```
📦Portifolio CLI Simulado
 ┣ 📂backend
 ┣ 📂docs
 ┃ ┣ 📜1 - Lista de Regras de Negócio.pdf
 ┃ ┣ 📜2 - Lista de Requisitos Não Funcionais.pdf
 ┃ ┣ 📜3 - Lista de Requisitos Funcionais.pdf
 ┃ ┗ 📜Plano de Projeto.pdf
 ┣ 📂frontend
 ┃ ┣ 📂css
 ┃ ┃ ┗ 📜style.css
 ┃ ┣ 📂data
 ┃ ┃ ┣ 📂translations
 ┃ ┃ ┃ ┣ 📜en.json
 ┃ ┃ ┃ ┗ 📜pt.json
 ┃ ┃ ┗ 📜favicon.ico
 ┃ ┣ 📂js
 ┃ ┃ ┣ 📜api.js
 ┃ ┃ ┣ 📜buttons.js
 ┃ ┃ ┣ 📜cli.js
 ┃ ┃ ┣ 📜lang.js
 ┃ ┃ ┗ 📜main.js
 ┃ ┗ 📜index.html
 ┣ 📜.gitignore
 ┗ 📜README.md
```

## 📦 Tecnologias Utilizadas

- Java + Spring Boot (API REST)
- Python (Local Server)
- HTML + JavaScript (Front-end estilo terminal)
- JSON para internacionalização (i18n)
- Banco de dados (MySQL)
- Git + GitHub

## 📥 Executar localmente

### Frontend (HTML + JS) 
```bash
cd %/frontend
python -m http.server 8000
```

### Backend (Spring Boot)
```bash
./mvnw spring-boot:run
# ou
mvn spring-boot:run
```

## 🧪 Em desenvolvimento
Este projeto está em constante evolução. Fique à vontade para sugerir melhorias, reportar erros ou contribuir!

## Contatos
- Email: luisaugustoway@gmail.com
- linkedin: [luix-guxto](https://www.linkedin.com/in/luix-guxto/)