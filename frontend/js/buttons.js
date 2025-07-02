import { lang } from "./main.js";
import { buttons } from "../data/buttons_template.js"
export function createButtons(){
    const container = document.getElementById('button-panel');

    container.innerHTML = '';

    buttons.forEach(({label, command, description}) =>{
        const wrappler = document.createElement('div');
        wrappler.style.marginBottom = '10px';

        const notation = document.createElement('code');
        notation.id = 'button-notation';
        notation.className = 'bg-dark rounded'
        notation.textContent = `> ${command}`;

        const btn = document.createElement('button');
        btn.textContent = label[lang];
        btn.addEventListener('click', () => {
            const input = document.getElementById('input');
            input.value = command;
            input.focus();
        });

        const desc = document.createElement('small');
        desc.textContent = description[lang];
        desc.style.display = 'block';
        desc.style.marginTop = '4px';
        desc.style.color = '#777';

        wrappler.appendChild(notation);
        wrappler.appendChild(btn);
        wrappler.appendChild(desc);
        container.appendChild(wrappler);
    });
}