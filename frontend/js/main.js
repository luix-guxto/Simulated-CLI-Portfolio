import { initTerminal } from './cli.js';
import { createButtons } from './buttons.js';

export let lang = 'pt'
export function setLanguage(newLang) {
  let newLanguage = newLang.toLowerCase()
  if(newLanguage !== 'pt' && newLanguage !== 'en'){
    throw new Error('Language not exist, use en or pt');
  }
  lang = newLanguage;
  createButtons();
  updateStaticTexts();
  console.log("Language has been changed to: "+newLang);
}

window.onload = () => {
  initTerminal();
  createButtons();
  updateStaticTexts();
};

export function updateStaticTexts() {
  const manual = document.getElementById('manual-text');
  const title = document.getElementById('page-title');

  if (lang === 'pt') {
    title.textContent = 'Portfólio CLI Simulado';
    manual.innerHTML = `
      Manual simplificado: clique nos botões abaixo para executar comandos automaticamente.<br>
      Ou digite <code>help</code> no terminal para ver os principais comandos disponíveis.
    `;
  } else {
    title.textContent = 'Simulated CLI Portfolio';
    manual.innerHTML = `
      Simplified manual: click the buttons below to auto-fill commands.<br>
      Or type <code>help</code> in the terminal to see the available commands.
    `;
  }
}