import { lang } from "./main.js";
export function createButtons(){
    const container = document.getElementById('button-panel');

    container.innerHTML = '';

    const buttons = [
        {
            label: lang === 'pt' ? 'Limpar' : 'Clear',
            command: 'clear',
            description: lang === 'pt'
                ? 'Limpa a tela do terminal'
                : 'Clears the terminal screen'
        },
        {
            label: 'Idioma PT',
            command: 'lang pt',
            description: 'Altera o idioma para Português'
        },
        {
            label:'Lang EN',
            command: 'lang en',
            description: 'Change language to English'
        }
    ];

    buttons.forEach(({label, command, description}) =>{
        const wrappler = document.createElement('div');
        wrappler.style.marginBottom = '10px';

        const btn = document.createElement('button');
        btn.textContent = label;
        btn.addEventListener('click', () => {
            const input = document.getElementById('input');
            input.value = command;
            input.focus();
        });

        const desc = document.createElement('small');
        desc.textContent = description;
        desc.style.display = 'block';
        desc.style.marginTop = '4px';
        desc.style.color = '#777';

        wrappler.appendChild(btn);
        wrappler.appendChild(desc);
        container.appendChild(wrappler);
    });
}