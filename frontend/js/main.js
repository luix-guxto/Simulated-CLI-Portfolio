import { initTerminal } from './cli.js';
import { initCategories, refreshCategories } from './categories.js';
import { setupManualPopup } from './popup_manual.js';

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
  updateStaticTexts();
  refreshCategories(lang);
  console.log("Language has been changed to: "+newLang);
}
window.onload = async () => {
  await loadCategoriesFromBackend();
  initTerminal();
  updateStaticTexts();
  initCategories(lang);
  setupManualPopup();
};

export function updateStaticTexts() {
  const manual = document.getElementById('manual-text');
  const title = document.getElementById('page-title');

  if (lang === 'pt') {
    title.textContent = 'Portfólio CLI Simulado';
    manual.innerHTML = `
      <b>Manual simplificado:</b> clique no botão <b>Manual Simplificado</b> abaixo do filtro de categorias para acessar uma lista rápida de comandos e suas descrições. Basta clicar em um comando para executá-lo imediatamente.<br>
      Ou digite <code>help</code> no terminal para ver os principais comandos disponíveis.
    `;
  } else {
    title.textContent = 'Simulated CLI Portfolio';
    manual.innerHTML = `
      <b>Simplified manual:</b> click the <b>Simplified Manual</b> button below the category filter to access a quick list of commands and their descriptions. Just click a command to execute it immediately.<br>
      Or type <code>help</code> in the terminal to see the available commands.
    `;
  }
}