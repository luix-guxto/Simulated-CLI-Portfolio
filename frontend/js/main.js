import { initTerminal } from './cli.js';
import { createButtons } from './buttons.js';
import { initCategories, refreshCategories } from './categories.js';

export const url = new URL(`http://${location.hostname}:5000`)
export let availableCategories = [];

async function loadCategoriesFromBackend() {
    try {
        const response = await fetch(url.toString() + 'categories');
        const data = await response.json();
        availableCategories = data.message;
    } catch (error) {
        console.error('Erro ao carregar categorias:', error);
    }
}

export let lang = 'pt'
export function setLanguage(newLang) {
  let newLanguage = newLang.toLowerCase()
  if(newLanguage !== 'pt' && newLanguage !== 'en'){
    throw new Error('Language not exist, use en or pt');
  }
  lang = newLanguage;
  createButtons();
  updateStaticTexts();
  refreshCategories(lang);
  console.log("Language has been changed to: "+newLang);
}
window.onload = async () => {
  await loadCategoriesFromBackend();
  initTerminal();
  createButtons();
  updateStaticTexts();
  initCategories(lang);
};

export function updateStaticTexts() {
  const manual = document.getElementById('manual-text');
  const title = document.getElementById('page-title');

  if (lang === 'pt') {
    title.textContent = 'Portfólio CLI Simulado';
    manual.innerHTML = `
      <b>Manual simplificado:</b> clique nos botões abaixo para preencher o terminal com o comando correspondente. Pressione <b>Enter</b> para executá-lo.<br>
      Ou digite <code>help</code> no terminal para ver os principais comandos disponíveis.
    `;
  } else {
    title.textContent = 'Simulated CLI Portfolio';
    manual.innerHTML = `
      <b>Simplified manual:</b> click the buttons below to fill the terminal with the corresponding command. Press <b>Enter</b> to execute it.<br>
      Or type <code>help</code> in the terminal to see the available commands.
    `;
  }
}