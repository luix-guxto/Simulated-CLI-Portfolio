import { sendCommandToApi } from './api.js';
let firstCommandExecuted = false;
export function initTerminal() {
  const input = document.getElementById('input');
  const output = document.getElementById('output');

  input.focus();

  input.addEventListener('keydown', async (e) => {
    if (e.key === 'Enter') {
      e.preventDefault();

      const cmd = input.value.trim();
      if (!cmd) return;
      if(!firstCommandExecuted){
        clearOutput();
        firstCommandExecuted = true;
      }
      appendOutput(`> ${cmd}`);
      input.value = '';

      // Comando especial para limpar terminal
      if (cmd.toLowerCase() === 'clear') {
        clearOutput();
        return;
      }

      try {
        const response = await sendCommandToApi(cmd);
        appendOutput(response);
      } catch (err) {
        appendOutput('Erro: não foi possível conectar ao servidor.');
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
