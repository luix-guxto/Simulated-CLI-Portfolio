export const buttons = [
  {
    label: {
      pt: "Limpar",
      en: "Clear"
    },
    command: "clear",
    description: {
      pt: "Limpa a tela do terminal",
      en: "Clears the terminal screen"
    }
  },
  {
    label: {
      pt: "Idioma PT",
      en: "Idioma PT"
    },
    command: "lang pt",
    description: {
      pt: "Altera o idioma para Português",
      en: "Altera o idioma para Português"
    }
  },
  {
    label: {
      pt: "Lang EN",
      en: "Lang EN"
    },
    command: "lang en",
    description: {
      pt: "Change language to English",
      en: "Change language to English"
    }
  },
  {
    label: {
      pt: "Ajuda",
      en: "Help"
    },
    command: "help",
    description: {
      pt: "Exibe a lista completa de comandos disponíveis e suas funcionalidades",
      en: "Displays the complete list of available commands and their functionalities"
    }
  },
  {
    label: {
      pt: "Perfil",
      en: "Profile"
    },
    command: "profile",
    description: {
      pt: "Mostra o perfil profissional",
      en: "Displays the professional profile"
    }
  },
  {
    label: {
      pt: "Formação",
      en: "Education"
    },
    command: "academic",
    description: {
      pt: "Exibe a formação acadêmica. Sem parâmetros, lista todos os registros com seus IDs; com um ID, exibe os detalhes do item selecionado.<br>ex. <code>academic 1</code>",
      en: "Displays academic background. Without parameters, lists all entries with their IDs; with an ID, shows the details of the selected item.<br>e.g.  <code>academic 1</code>"
    }
  },
  {
    label: {
      pt: "Fluência",
      en: "Fluency"
    },
    command: "fluency",
    description: {
      pt: "Exibe os níveis de fluência em diferentes idiomas. Sem parâmetros, lista todos os registros com seus IDs; com um ID, exibe os detalhes do item selecionado.<br>ex. <code>fluency 1</code>",
      en: "Displays fluency levels in different languages. Without parameters, lists all entries with their IDs; with an ID, shows the details of the selected item.<br>e.g. <code>fluency 1</code>"
    }
  },
  {
    label: {
      pt: "Experiência",
      en: "Experience"
    },
    command: "work",
    description: {
      pt: "Exibe as experiências profissionais. Sem parâmetros, lista todas as experiências; com um ID, exibe os detalhes da experiência; com -c, filtra por categoria.<br>ex. <code>work 1</code> ou <code>work -c Java</code>",
      en: "Displays professional experiences. Without parameters, lists all experiences; with an ID, shows experience details; with -c, filters by category.<br>e.g. <code>work 1</code> or <code>work -c Java</code>"
    }
  },
  {
    label: {
      pt: "Projetos",
      en: "Projects"
    },
    command: "project",
    description: {
      pt: "Exibe os projetos desenvolvidos. Sem parâmetros, lista todos os projetos; com um ID, exibe os detalhes do projeto; com -c, filtra por categoria.<br>ex. <code>project 1</code> ou <code>project -c Java</code>",
      en: "Displays developed projects. Without parameters, lists all projects; with an ID, shows project details; with -c, filters by category.<br>e.g. <code>project 1</code> or <code>project -c Java</code>"
    }
  },
  {
    label: {
      pt: "Certificados",
      en: "Certificates"
    },
    command: "certificate",
    description: {
      pt: "Exibe os certificados obtidos. Sem parâmetros, lista todos os certificados; com um ID, exibe os detalhes do certificado; com -c, filtra por categoria.<br>ex. <code>certificate 1</code> ou <code>certificate -c Java</code>",
      en: "Displays obtained certificates. Without parameters, lists all certificates; with an ID, shows certificate details; with -c, filters by category.<br>e.g. <code>certificate 1</code> or <code>certificate -c Java</code>"
    }
  },
  {
    label: {
      pt: "Conhecimentos",
      en: "Knowledge"
    },
    command: "knowledge",
    description: {
      pt: "Exibe os conhecimentos técnicos. Sem parâmetros, lista todos os conhecimentos; com um ID, exibe os detalhes do conhecimento; com -c, filtra por categoria.<br>ex. <code>knowledge 1</code> ou <code>knowledge -c Java</code>",
      en: "Displays technical knowledge. Without parameters, lists all knowledge; with an ID, shows knowledge details; with -c, filters by category.<br>e.g. <code>knowledge 1</code> or <code>knowledge -c Java</code>"
    }
  },
  {
    label: {
      pt: "Categorias",
      en: "Categories"
    },
    command: "categories",
    description: {
      pt: "Lista todas as categorias disponíveis para filtrar os outros comandos",
      en: "Lists all available categories to filter other commands"
    }
  },
  {
    label: {
      pt: "🔗 Links",
      en: "🔗 Links"
    },
    command: "get",
    description: {
      pt: "Acessa links úteis como certificados, currículo e links personalizados. Use 'get certificates' ou 'get cv'",
      en: "Access useful links like certificates, resume and custom links. Use 'get certificates' or 'get cv'"
    }
  }

];
