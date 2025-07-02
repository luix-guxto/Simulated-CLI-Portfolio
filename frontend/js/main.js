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
  console.log("Language has been changed to: "+newLang);
}

window.onload = () => {
  initTerminal();
  createButtons();
};
