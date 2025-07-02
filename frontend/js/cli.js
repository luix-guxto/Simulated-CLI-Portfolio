import { sendCommandToApi } from './api.js';
import { setLanguage } from './main.js';
import { lang } from './main.js';
let firstCommandExecuted = false;
export function initTerminal() {
  const input = document.getElementById('input');
  const output = document.getElementById('output');

  input.focus();

  input.addEventListener('keydown', async (e) => {
    if (e.key === 'Enter') {
      e.preventDefault();

      const cmdLine = input.value.trim();
      const cmd = cmdLine.split(" ")[0].toLowerCase();
      const args = cmdLine.split(" ").slice(1);
      if (!cmdLine) return;
      if(!firstCommandExecuted){
        clearOutput();
        firstCommandExecuted = true;
      }
      appendOutput(`> ${cmdLine}`);
      input.value = '';

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

      input.disabled = true; // trava input
      input.value = '';
      try {
        const response = await sendCommandToApi(cmd, args);
        let msg = response.message
        msg += '\n'
        appendOutput(msg);
      } catch (err) {
        let msg = lang == 'pt' ? "[Erro]: não foi possível conectar ao servidor." : "[Error]: Could not connect to the server.";
          msg += '\n'
        appendOutput(msg);
      }finally{
        input.disabled = false;
        input.focus();
      }
    }
  });

  function appendOutput(text) {
    output.textContent += text + '\n';
    output.scrollTop = output.scrollHeight;
  }

  function clearOutput() {
    output.textContent = '';
  }
}
