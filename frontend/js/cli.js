import { sendCommandToApi } from './api.js';
import { setLanguage } from './main.js';
import { lang } from './main.js';
import { easterEggsMenu } from './easter_eggs_menu.js';
import { catCommand, themeCommand, loadSavedTheme } from './easter_eggs_commands.js';
let firstCommandExecuted = false;

export function initTerminal() {
  const input = document.getElementById('input');
  const output = document.getElementById('output');
  const mobileExecuteBtn = document.getElementById('mobile-execute-btn');

  // Carregar tema salvo
  loadSavedTheme();

  input.focus();

  // Configurar event delegation para links clicáveis
  setupEventDelegation();

  // Expor executeCommand globalmente para os links HTML
  window.executeCommand = async (cmdLine) => {
    console.log('executeCommand chamado com:', cmdLine); // Debug
    if (!cmdLine) return;
    
    if(!firstCommandExecuted){
      clearOutput();
      firstCommandExecuted = true;
    }
    
    appendOutput(`> ${cmdLine}`);
    
    const cmd = cmdLine.split(" ")[0].toLowerCase();
    const args = cmdLine.split(" ").slice(1);

    if (cmd === 'cat') {
      let output = catCommand();
      output += '\n'
      appendOutput(output);
      return;
    }
    
    if (cmd === 'theme') {
      let output = themeCommand(args);
      output += '\n'
      appendOutput(output);
      return;
    }
    if (cmd === 'easteregg') {
      const title = lang === 'pt' ? 'Easter Eggs' : 'Easter Eggs';
      const header = '=== ' + title.padEnd(40, '=');
      const footer = '='.repeat(header.length);
      const list = easterEggsMenu.map(e => `${e.cmd.padEnd(12)}${e.desc[lang]}`).join('\n');
      let output = `${header}\n\n${list}\n\n${footer}`;
      output+='\n'
      appendOutput(output);
      return;
    }



    if (cmd === 'help') {
      let extra = lang === 'pt'
        ? '\n<b>Dica:</b> Digite <b>easteregg</b> para ver comandos secretos!'
        : '\n<b>Tip:</b> Type <b>easteregg</b> to see secret commands!';
      try {
        const response = await sendCommandToApi(cmd, args);
        let msg = response.message + extra;
        msg += '\n';
        appendOutput(msg);
      } catch (err) {
        let msg = lang == 'pt' ? "[Erro]: não foi possível conectar ao servidor." : "[Error]: Could not connect to the server.";
        msg += '\n';
        appendOutput(msg);
      }
      return;
    }

    if (cmd === 'clear') {
      clearOutput();
      return;
    }

    if (cmd === 'lang') {
      try{
        setLanguage(args[0])
        let msg = lang == 'pt' ? "Linguagem alterada para Português" : "Language changed to English";
        msg += '\n'
        appendOutput(msg)
        return
      } catch (err) {
        let msg = lang == 'pt' ? "Want to change to English? type `lang en`" : "Deseja alterar para Português? digite `lang pt`";
        msg += '\n'
        appendOutput(msg)
        return
      }
    }

    try {
      const response = await sendCommandToApi(cmd, args);
      
      // Verificar se é comando get e processar JSON
      if (cmd === 'get') {
        try {
          console.log('Resposta do comando get:', response);
          
          // O response.message já é um objeto JSON (não uma string)
          const getData = response.message;
          console.log('Dados do comando get:', getData);
          
          if (getData.type === 'redirect' && getData.url) {
            // Exibir mensagem
            appendOutput(getData.message + '\n');
            
            // Abrir o link em nova aba
            window.open(getData.url, '_blank');
            return;
          } else if (getData.type === 'help') {
            // Exibir ajuda
            appendOutput(getData.message + '\n');
            return;
          } else {
            // Caso inesperado, exibir mensagem de erro
            appendOutput('❌ Erro: Tipo de resposta inesperado do comando get\n');
            return;
          }
        } catch (parseError) {
          // Se não conseguir fazer parse, exibir erro
          console.error('Erro ao processar dados do comando get:', parseError);
          console.error('Resposta recebida:', response);
          appendOutput('❌ Erro: Não foi possível processar a resposta do comando get\n');
          return;
        }
      }
      
      // Para outros comandos, exibir normalmente
      let msg = response.message;
      msg += '\n';
      appendOutput(msg);
    } catch (err) {
      let msg = lang == 'pt' ? "[Erro]: não foi possível conectar ao servidor." : "[Error]: Could not connect to the server.";
        msg += '\n'
      appendOutput(msg);
    }
  };

  input.addEventListener('keydown', async (e) => {
    if (e.key === 'Enter') {
      e.preventDefault();

      const cmdLine = input.value.trim();
      if (!cmdLine) return;
      
      input.disabled = true; 
      input.value = '';
      
      await window.executeCommand(cmdLine);
      
      input.disabled = false;
      input.focus();
    }
  });

  function appendOutput(text) {
    // Sempre usar innerHTML para processar links HTML
    output.innerHTML += text + '<br>';
    output.scrollTop = output.scrollHeight;
  }

  function clearOutput() {
    output.innerHTML = '';
  }
  
  async function executeCommand(cmdLine) {
    await window.executeCommand(cmdLine);
  }
  
  mobileExecuteBtn.addEventListener('click', async () => {
    const cmdLine = input.value.trim();
    if (cmdLine) {
      input.disabled = true;
      input.value = '';
      
      await window.executeCommand(cmdLine);
      
      input.disabled = false;
      input.focus();
    }
  });
}

// Event delegation para links clicáveis - funciona sempre
function setupEventDelegation() {
  console.log('Configurando event delegation...');
  
  // Remover listener anterior se existir
  document.removeEventListener('click', handleLinkClick);
  
  // Adicionar novo listener
  document.addEventListener('click', handleLinkClick);
  
  console.log('Event delegation configurado com sucesso');
}

function handleLinkClick(e) {
  console.log('Click detectado em:', e.target);
  
  if (e.target && e.target.classList.contains('cli-link')) {
    console.log('Link cli-link clicado!');
    e.preventDefault();
    const cmdLine = e.target.getAttribute('data-command');
    console.log('Comando encontrado:', cmdLine);
    
    if (cmdLine) {
      console.log('Link clicado via event delegation:', cmdLine);
      if (window.executeCommand) {
        console.log('Executando comando:', cmdLine);
        window.executeCommand(cmdLine);
      } else {
        console.error('executeCommand não encontrado!');
      }
    } else {
      console.error('data-command não encontrado!');
    }
  }
}

// Configurar event delegation quando o DOM estiver pronto
if (document.readyState === 'loading') {
  document.addEventListener('DOMContentLoaded', setupEventDelegation);
} else {
  setupEventDelegation();
}

// Também configurar quando a página carregar completamente
window.addEventListener('load', setupEventDelegation);
