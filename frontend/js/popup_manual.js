import { buttons } from '../data/buttons_template.js';
import { lang } from './main.js';

let lastTheme = null;

function applyPopupTheme(theme) {
  const popup = document.getElementById('manual-popup');
  const content = document.getElementById('manual-popup-content');
  if (!popup) return;
  // Fundo do pop-up
  popup.style.background = theme.buttonPanelBg || theme.terminalBg || '#fff';
  popup.style.color = theme.terminalColor || '#222';
  popup.style.borderColor = theme.buttonPanelBorder || '#01960122';
  // Botão fechar
  const closeBtn = popup.querySelector('button[aria-label="Fechar"]');
  if (closeBtn) closeBtn.style.color = theme.labelColor || '#888';
  // Título
  const title = popup.querySelector('h4');
  if (title) title.style.color = theme.titleColor || '#019601';
  // Botões de comando
  if(content) {
    content.querySelectorAll('li button').forEach(btn => {
      btn.style.background = theme.buttonBg || 'linear-gradient(145deg, #019601, #005a00)';
      btn.style.color = theme.buttonText || '#fff';
      btn.style.borderColor = theme.buttonBorder || '#019601';
      btn.onmouseenter = () => {
        btn.style.background = theme.buttonHoverBg || '#005a00';
        btn.style.color = theme.buttonHoverText || '#fff';
      };
      btn.onmouseleave = () => {
        btn.style.background = theme.buttonBg || 'linear-gradient(145deg, #019601, #005a00)';
        btn.style.color = theme.buttonText || '#fff';
      };
    });
    // Descrições: cor de fundo e texto conforme tema
    content.querySelectorAll('li span').forEach(span => {
      span.style.background = theme.inputBg || theme.buttonPanelBg || '#fff';
      span.style.color = theme.inputColor || theme.terminalColor || '#222';
      span.style.borderRadius = '6px';
      span.style.padding = '2px 6px';
      span.style.display = 'block';
    });
  }
}

function getCurrentTheme() {
  const saved = localStorage.getItem('cli-theme');
  if (saved) return JSON.parse(saved);
  return null;
}

function createPopup() {
  // Evita múltiplos pop-ups
  if (document.getElementById('manual-popup')) return;

  // Desabilitar scroll do body
  const prevOverflow = document.body.style.overflow;
  document.body.style.overflow = 'hidden';

  // Overlay
  const overlay = document.createElement('div');
  overlay.id = 'manual-popup-overlay';
  overlay.style.position = 'fixed';
  overlay.style.top = 0;
  overlay.style.left = 0;
  overlay.style.width = '100vw';
  overlay.style.height = '100vh';
  overlay.style.background = 'rgba(0,0,0,0.25)';
  overlay.style.backdropFilter = 'blur(2px)';
  overlay.style.zIndex = 9999;
  overlay.style.display = 'flex';
  overlay.style.alignItems = 'center';
  overlay.style.justifyContent = 'center';

  // Pop-up externo
  const popup = document.createElement('div');
  popup.id = 'manual-popup';
  popup.style.background = 'var(--popup-bg, #fff)';
  popup.style.color = 'var(--popup-fg, #222)';
  popup.style.borderRadius = '18px';
  popup.style.boxShadow = '0 8px 32px rgba(0,0,0,0.18)';
  popup.style.padding = '0';
  popup.style.minWidth = '260px';
  popup.style.maxWidth = '420px';
  popup.style.width = '95vw';
  popup.style.maxHeight = '80vh';
  popup.style.position = 'relative';
  popup.style.border = '2px solid #01960122';
  popup.style.transition = 'all 0.2s';
  popup.style.display = 'flex';
  popup.style.flexDirection = 'column';
  popup.style.gap = '0';

  // Botão fechar
  const closeBtn = document.createElement('button');
  closeBtn.innerHTML = '<i class="fas fa-times"></i>';
  closeBtn.style.position = 'absolute';
  closeBtn.style.top = '12px';
  closeBtn.style.right = '16px';
  closeBtn.style.background = 'none';
  closeBtn.style.border = 'none';
  closeBtn.style.fontSize = '1.3em';
  closeBtn.style.color = '#888';
  closeBtn.style.cursor = 'pointer';
  closeBtn.setAttribute('aria-label', 'Fechar');
  closeBtn.addEventListener('click', () => {
    overlay.remove();
    document.body.style.overflow = prevOverflow || '';
  });
  popup.appendChild(closeBtn);

  // Div interna para conteúdo scrollável
  const content = document.createElement('div');
  content.id = 'manual-popup-content';
  content.style.overflowY = 'auto';
  content.style.maxHeight = '80vh';
  content.style.padding = '24px 12px 16px 12px';
  content.style.display = 'flex';
  content.style.flexDirection = 'column';
  content.style.gap = '8px';

  // Título
  const title = document.createElement('h4');
  title.textContent = lang === 'pt' ? 'Comandos Rápidos' : 'Quick Commands';
  title.style.marginBottom = '10px';
  title.style.textAlign = 'center';
  title.style.color = '#019601';
  title.style.fontWeight = 'bold';
  content.appendChild(title);

  // Lista de comandos
  const list = document.createElement('ul');
  list.style.listStyle = 'none';
  list.style.padding = 0;
  list.style.margin = 0;
  list.style.display = 'flex';
  list.style.flexDirection = 'column';
  list.style.gap = '8px';

  buttons.forEach(({ label, command, description }) => {
    const item = document.createElement('li');
    item.style.display = 'flex';
    item.style.alignItems = 'flex-start';
    item.style.gap = '10px';
    item.style.marginBottom = '0';

    // Botão de comando
    const cmdBtn = document.createElement('button');
    cmdBtn.textContent = label[lang];
    cmdBtn.style.background = 'linear-gradient(145deg, #019601, #005a00)';
    cmdBtn.style.color = '#fff';
    cmdBtn.style.border = 'none';
    cmdBtn.style.borderRadius = '8px';
    cmdBtn.style.padding = '7px 16px';
    cmdBtn.style.fontWeight = '600';
    cmdBtn.style.fontSize = '1em';
    cmdBtn.style.cursor = 'pointer';
    cmdBtn.style.boxShadow = '0 2px 8px rgba(1,150,1,0.10)';
    cmdBtn.style.transition = 'background 0.2s';
    cmdBtn.style.whiteSpace = 'nowrap';
    cmdBtn.addEventListener('mouseenter', () => {
      cmdBtn.style.background = 'linear-gradient(145deg, #005a00, #003300)';
    });
    cmdBtn.addEventListener('mouseleave', () => {
      cmdBtn.style.background = 'linear-gradient(145deg, #019601, #005a00)';
    });
    cmdBtn.addEventListener('click', () => {
      if (window.executeCommand) {
        window.executeCommand(command);
        overlay.remove();
      }
    });

    // Descrição
    const desc = document.createElement('span');
    desc.innerHTML = description[lang].replace(/<br>/g, ' ')
      .replace(/<code>.*?<\/code>/g, '') // Remove exemplos de código
      .replace(/\s+/g, ' ') // Espaços extras
      .trim();
    desc.style.fontSize = '0.97em';
    desc.style.color = '#333';
    desc.style.fontWeight = '400';
    desc.style.marginLeft = '2px';
    desc.style.flex = '1';
    desc.style.wordBreak = 'break-word';
    desc.style.whiteSpace = 'pre-line';
    desc.style.lineHeight = '1.4';
    desc.style.display = 'block';

    item.appendChild(cmdBtn);
    item.appendChild(desc);
    list.appendChild(item);
  });

  content.appendChild(list);
  popup.appendChild(content);
  overlay.appendChild(popup);
  document.body.appendChild(overlay);

  // Aplicar tema ao abrir
  const theme = getCurrentTheme();
  if (theme) {
    applyPopupTheme(theme);
    lastTheme = theme;
  }

  // Responsividade extra para mobile
  function handleResize() {
    if (window.innerWidth < 600) {
      popup.style.maxWidth = '98vw';
      content.style.padding = '10px 2vw 10px 2vw';
      title.style.fontSize = '1em';
      list.style.gap = '4px';
    } else {
      popup.style.maxWidth = '420px';
      content.style.padding = '24px 12px 16px 12px';
      title.style.fontSize = '1.15em';
      list.style.gap = '8px';
    }
  }
  handleResize();
  window.addEventListener('resize', handleResize);
}

// Atualiza o pop-up se o tema mudar
function observeThemeChange() {
  setInterval(() => {
    const theme = getCurrentTheme();
    if (theme && JSON.stringify(theme) !== JSON.stringify(lastTheme)) {
      applyPopupTheme(theme);
      lastTheme = theme;
    }
  }, 500);
}

export function setupManualPopup() {
  const btn = document.getElementById('manual-popup-btn');
  if (btn) {
    btn.addEventListener('click', createPopup);
  }
  observeThemeChange();
} 