import { sendCommandToApi } from './api.js';
import { setLanguage } from './main.js';
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
        } catch (err) {
          appendOutput("[Error] No such language, type help --lang to see all languages")
          return
        }
      }

      input.disabled = true; // trava input
      input.value = '';
      try {
        const response = await sendCommandToApi(cmdLine);
        appendOutput(response);
      } catch (err) {
        appendOutput('Erro: não foi possível conectar ao servidor.');
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
