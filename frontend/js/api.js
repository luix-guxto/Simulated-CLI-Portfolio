import { lang, url } from './main.js';

export async function sendCommandToApi(cmd, args) {
  try {
    const response = await fetch(url.toString() + 'cli', {
      method: 'POST',
      headers:{
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        cmd: cmd,
        args: args,
        lang: lang
      })
    });
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    const json = await response.json();
    return json;
  } catch (error) {
    console.error('Erro na API:', error);
      throw new Error(`HTTP error! status: ${response.status}`);
  }
}
