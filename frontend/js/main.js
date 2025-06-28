import { initTerminal } from './cli.js';

export let lang = 'pt'
export function setLanguage(newLang) {
  lang = newLang;
  console.log("Language has been changed to: "+newLang);
}

window.onload = () => {
  initTerminal();
};
