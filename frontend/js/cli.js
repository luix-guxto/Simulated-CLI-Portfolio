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
  loadSavedTheme();
  input.focus();
  setupEventDelegation();

  window.executeCommand = async (cmdLine) => {
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
      
      if (cmd === 'get') {
        try {
          
          const getData = response.message;
          
          if (getData.type === 'redirect' && getData.url) {
            appendOutput(getData.message + '\n');
          
            window.open(getData.url, '_blank');
            return;
          } else if (getData.type === 'help') {
            appendOutput(getData.message + '\n');
            return;
          } else {
            appendOutput('❌ Erro: Tipo de resposta inesperado do comando get\n');
            return;
          }
        } catch (parseError) {
          appendOutput('❌ Erro: Não foi possível processar a resposta do comando get\n');
          return;
        }
      }
      
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

function setupEventDelegation() {
  
  document.removeEventListener('click', handleLinkClick);
  
  document.addEventListener('click', handleLinkClick);
  
}

function handleLinkClick(e) {
  
  if (e.target && e.target.classList.contains('cli-link')) {
    e.preventDefault();
    const cmdLine = e.target.getAttribute('data-command');
    
    if (cmdLine) {
      if (window.executeCommand) {
        window.executeCommand(cmdLine);
      } else {
        console.error('executeCommand não encontrado!');
      }
    } else {
      console.error('data-command não encontrado!');
    }
  }
}

if (document.readyState === 'loading') {
  document.addEventListener('DOMContentLoaded', setupEventDelegation);
} else {
  setupEventDelegation();
}

window.addEventListener('load', setupEventDelegation);
