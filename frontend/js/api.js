import { lang } from './main.js';

export async function sendCommandToApi(cmd) {
  try {
    const url = new URL('http://localhost:5000/cli');
    url.searchParams.append('cmd', cmd);
    url.searchParams.append('lang', lang);

    const response = await fetch(url.toString());
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    const text = await response.text();
    return text;
  } catch (error) {
    console.error('Erro na API:', error);
    return 'Erro: falha na comunicação com o servidor.';
  }
}
