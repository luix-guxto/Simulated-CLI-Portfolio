import { lang } from './main.js';

export async function sendCommandToApi(cmd, args) {
  try {
    const url = new URL('http://localhost:5000/cli');

    const response = await fetch(url.toString(), {
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
    console.log(json);
    return json;
  } catch (error) {
    console.error('Erro na API:', error);
    return 'Erro: falha na comunicação com o servidor.';
  }
}
