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

## Estrutura do banco

erDiagram
    CATEGORY {
        int id PK
        varchar skill
    }
    PROJECT {
        int id PK
        varchar name_pt
        varchar name_en
        text description_pt
        text description_en
        varchar url
    }
    PROJECT_CATEGORY {
        int project_id PK, FK
        int category_id PK, FK
    }
    CERTIFICATE {
        int id PK
        varchar name_pt
        varchar name_en
        varchar organization
        date issue_date
        date expiration_date
        text description_pt
        text description_en
        varchar code
        varchar url
    }
    CERTIFICATE_CATEGORY {
        int certificate_id PK, FK
        int category_id PK, FK
    }
    ACADEMIC {
        int id PK
        varchar course_pt
        varchar course_en
        varchar organization
        date start_date
        date end_date
        enum status
    }
    WORK_EXPERIENCE {
        int id PK
        varchar company
        varchar company_url
        date start_date
        date end_date
        varchar role_pt
        varchar role_en
        varchar location
        boolean is_current
        text description_pt
        text description_en
    }
    WORK_EXPERIENCE_CATEGORY {
        int work_experience_id PK, FK
        int category_id PK, FK
    }
    LANGUAGE {
        int id PK
        varchar name_pt
        varchar name_en
        enum level_reading
        enum level_writing
        enum level_speaking
    }
    KNOWLEDGE {
        int id PK
        varchar name_pt
        varchar name_en
        enum level
        varchar url
    }
    KNOWLEDGE_CATEGORY {
        int knowledge_id PK, FK
        int category_id PK, FK
    }
    PROFILE {
        int id PK
        varchar name
        varchar title_pt
        varchar title_en
        text bio_pt
        text bio_en
        varchar email
        varchar phone
        varchar location
        varchar linkedin
        varchar github
        varchar cv_pt_url
        varchar cv_en_url
    }

    CATEGORY ||--o{ PROJECT_CATEGORY : has
    PROJECT ||--o{ PROJECT_CATEGORY : has
    CATEGORY ||--o{ CERTIFICATE_CATEGORY : has
    CERTIFICATE ||--o{ CERTIFICATE_CATEGORY : has
    CATEGORY ||--o{ WORK_EXPERIENCE_CATEGORY : has
    WORK_EXPERIENCE ||--o{ WORK_EXPERIENCE_CATEGORY : has
    CATEGORY ||--o{ KNOWLEDGE_CATEGORY : has
    KNOWLEDGE ||--o{ KNOWLEDGE_CATEGORY : has


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