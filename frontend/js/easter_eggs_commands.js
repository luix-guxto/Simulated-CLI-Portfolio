// Comandos Easter Eggs individuais
import { lang } from './main.js';

// Comando cat - Gatinho ASCII
export function catCommand() {
  const catArt =
    ' /\\_/\\\n' +
    '( o.o )\n' +
    ' > ^ <';
  const msg = lang === 'pt' ? 'Miau! Aqui está um gatinho para alegrar seu dia! 🐾' : 'Meow! Here is a cat to brighten your day! 🐾';
  return catArt + '\n' + msg;
}

// Comando theme - Mudar tema do terminal
export function themeCommand(args) {
  const themes = {
    'default': { 
      name: lang === 'pt' ? 'Padrão' : 'Default', 
      bodyBg: 'linear-gradient(135deg, #181c24 0%, #232b3a 100%), repeating-linear-gradient(0deg, rgba(0,255,0,0.04), rgba(0,255,0,0.04) 1px, transparent 1px, transparent 4px)',
      terminalBg: 'linear-gradient(145deg, #000000, #1a1a1a)',
      terminalColor: '#00ff00',
      terminalBorder: '#333',
      inputBg: '#1a1a1a',
      inputColor: '#00ff00',
      inputBorder: '#333',
      scrollbarTrack: '#2e2e2e',
      scrollbarThumb: 'linear-gradient(180deg, #019601, #005a00)',
      scrollbarThumbHover: 'linear-gradient(180deg, #005a00, #003300)',
      linkColor: '#00ff00',
      linkHover: '#ffff00',
      cliLinkColor: '#00ffff',
      cliLinkBg: 'rgba(0, 255, 255, 0.1)',
      cliLinkBorder: 'rgba(0, 255, 255, 0.3)',
      cliLinkHover: '#ffffff',
      cliLinkHoverBg: 'rgba(0, 255, 255, 0.2)',
      cliLinkHoverBorder: 'rgba(0, 255, 255, 0.6)',
      buttonPanelBg: 'linear-gradient(145deg, #ffffff, #f8f9fa)',
      buttonPanelBorder: '#e0e0e0',
      buttonPanelHoverBorder: '#019601',
      categoryPanelBg: '#f8f9fa',
      categoryPanelBorder: '#dee2e6',
      titleColor: '#fff',
      subtitleColor: '#e0e0e0',
      labelColor: '#bdbdbd',
      buttonBg: '#007acc',
      buttonText: '#fff',
      buttonBorder: '#007acc',
      buttonHoverBg: '#005a9e',
      buttonHoverText: '#fff',
      manualTextColor: '#fff'
    },
    'dark': { 
      name: lang === 'pt' ? 'Escuro' : 'Dark', 
      bodyBg: 'linear-gradient(135deg, #000000 0%, #1a1a1a 100%)',
      terminalBg: 'linear-gradient(145deg, #000000, #1a1a1a)',
      terminalColor: '#00ff00',
      terminalBorder: '#00ff00',
      inputBg: '#1a1a1a',
      inputColor: '#00ff00',
      inputBorder: '#00ff00',
      scrollbarTrack: '#2e2e2e',
      scrollbarThumb: 'linear-gradient(180deg, #00ff00, #00cc00)',
      scrollbarThumbHover: 'linear-gradient(180deg, #00cc00, #009900)',
      linkColor: '#00ff00',
      linkHover: '#ffff00',
      cliLinkColor: '#00ff00',
      cliLinkBg: 'rgba(0, 255, 0, 0.1)',
      cliLinkBorder: 'rgba(0, 255, 0, 0.3)',
      cliLinkHover: '#ffffff',
      cliLinkHoverBg: 'rgba(0, 255, 0, 0.2)',
      cliLinkHoverBorder: 'rgba(0, 255, 0, 0.6)',
      buttonPanelBg: 'linear-gradient(145deg, #2d2d2d, #1a1a1a)',
      buttonPanelBorder: '#00ff00',
      buttonPanelHoverBorder: '#ffff00',
      categoryPanelBg: '#2d2d2d',
      categoryPanelBorder: '#00ff00',
      titleColor: '#00ff00',
      subtitleColor: '#bdbdbd',
      labelColor: '#bdbdbd',
      buttonBg: '#222',
      buttonText: '#00ff00',
      buttonBorder: '#00ff00',
      buttonHoverBg: '#00ff00',
      buttonHoverText: '#222',
      manualTextColor: '#00ff00'
    },
    'light': { 
      name: lang === 'pt' ? 'Claro' : 'Light', 
      bodyBg: 'linear-gradient(135deg, #f8f9fa 0%, #e9ecef 100%)',
      terminalBg: 'linear-gradient(145deg, #f8f9fa, #e9ecef)',
      terminalColor: '#222',
      terminalBorder: '#cccccc',
      inputBg: '#f1f3f4',
      inputColor: '#222',
      inputBorder: '#cccccc',
      scrollbarTrack: '#f1f3f4',
      scrollbarThumb: 'linear-gradient(180deg, #007acc, #005a9e)',
      scrollbarThumbHover: 'linear-gradient(180deg, #005a9e, #004080)',
      linkColor: '#007acc',
      linkHover: '#005a9e',
      cliLinkColor: '#007acc',
      cliLinkBg: 'rgba(0, 122, 204, 0.1)',
      cliLinkBorder: 'rgba(0, 122, 204, 0.3)',
      cliLinkHover: '#ffffff',
      cliLinkHoverBg: 'rgba(0, 122, 204, 0.2)',
      cliLinkHoverBorder: 'rgba(0, 122, 204, 0.6)',
      buttonPanelBg: 'linear-gradient(145deg, #ffffff, #f8f9fa)',
      buttonPanelBorder: '#dee2e6',
      buttonPanelHoverBorder: '#007acc',
      categoryPanelBg: '#ffffff',
      categoryPanelBorder: '#dee2e6',
      titleColor: '#222',
      subtitleColor: '#666',
      labelColor: '#888',
      buttonBg: '#007acc',
      buttonText: '#fff',
      buttonBorder: '#007acc',
      buttonHoverBg: '#005a9e',
      buttonHoverText: '#fff',
      manualTextColor: '#222'
    },
    'matrix': { 
      name: 'Matrix', 
      bodyBg: 'linear-gradient(135deg, #000000 0%, #003300 100%)',
      terminalBg: 'linear-gradient(145deg, #000000, #001a00)',
      terminalColor: '#00ff00',
      terminalBorder: '#003300',
      inputBg: '#001a00',
      inputColor: '#00ff00',
      inputBorder: '#003300',
      scrollbarTrack: '#001a00',
      scrollbarThumb: 'linear-gradient(180deg, #00ff00, #00cc00)',
      scrollbarThumbHover: 'linear-gradient(180deg, #00cc00, #009900)',
      linkColor: '#00ff00',
      linkHover: '#ffff00',
      cliLinkColor: '#00ff00',
      cliLinkBg: 'rgba(0, 255, 0, 0.1)',
      cliLinkBorder: 'rgba(0, 255, 0, 0.3)',
      cliLinkHover: '#ffffff',
      cliLinkHoverBg: 'rgba(0, 255, 0, 0.2)',
      cliLinkHoverBorder: 'rgba(0, 255, 0, 0.6)',
      buttonPanelBg: 'linear-gradient(145deg, #001a00, #003300)',
      buttonPanelBorder: '#00ff00',
      buttonPanelHoverBorder: '#ffff00',
      categoryPanelBg: '#001a00',
      categoryPanelBorder: '#00ff00',
      titleColor: '#00ff00',
      subtitleColor: '#bdbdbd',
      labelColor: '#bdbdbd',
      buttonBg: '#003300',
      buttonText: '#00ff00',
      buttonBorder: '#00ff00',
      buttonHoverBg: '#00ff00',
      buttonHoverText: '#003300',
      manualTextColor: '#00ff00'
    },
    'retro': { 
      name: 'Retrô', 
      bodyBg: 'linear-gradient(135deg, #2b2b2b 0%, #1a1a1a 100%)',
      terminalBg: 'linear-gradient(145deg, #2b2b2b, #1a1a1a)',
      terminalColor: '#ff6b6b',
      terminalBorder: '#ff6b6b',
      inputBg: '#2b2b2b',
      inputColor: '#ff6b6b',
      inputBorder: '#ff6b6b',
      scrollbarTrack: '#1a1a1a',
      scrollbarThumb: 'linear-gradient(180deg, #ff6b6b, #ff5252)',
      scrollbarThumbHover: 'linear-gradient(180deg, #ff5252, #ff3333)',
      linkColor: '#ff6b6b',
      linkHover: '#4ecdc4',
      cliLinkColor: '#4ecdc4',
      cliLinkBg: 'rgba(78, 205, 196, 0.1)',
      cliLinkBorder: 'rgba(78, 205, 196, 0.3)',
      cliLinkHover: '#ffffff',
      cliLinkHoverBg: 'rgba(78, 205, 196, 0.2)',
      cliLinkHoverBorder: 'rgba(78, 205, 196, 0.6)',
      buttonPanelBg: 'linear-gradient(145deg, #2b2b2b, #1a1a1a)',
      buttonPanelBorder: '#ff6b6b',
      buttonPanelHoverBorder: '#4ecdc4',
      categoryPanelBg: '#2b2b2b',
      categoryPanelBorder: '#ff6b6b',
      titleColor: '#ff6b6b',
      subtitleColor: '#bdbdbd',
      labelColor: '#bdbdbd',
      buttonBg: '#ff6b6b',
      buttonText: '#fff',
      buttonBorder: '#ff6b6b',
      buttonHoverBg: '#4ecdc4',
      buttonHoverText: '#fff',
      manualTextColor: '#ff6b6b'
    },
    'ocean': { 
      name: lang === 'pt' ? 'Oceano' : 'Ocean', 
      bodyBg: 'linear-gradient(135deg, #001f3f 0%, #003366 100%)',
      terminalBg: 'linear-gradient(145deg, #001f3f, #002b5c)',
      terminalColor: '#ffffff',
      terminalBorder: '#0074d9',
      inputBg: '#001f3f',
      inputColor: '#ffffff',
      inputBorder: '#0074d9',
      scrollbarTrack: '#002b5c',
      scrollbarThumb: 'linear-gradient(180deg, #39cccc, #2bb8b8)',
      scrollbarThumbHover: 'linear-gradient(180deg, #2bb8b8, #1fa4a4)',
      linkColor: '#39cccc',
      linkHover: '#ffffff',
      cliLinkColor: '#39cccc',
      cliLinkBg: 'rgba(57, 204, 204, 0.1)',
      cliLinkBorder: 'rgba(57, 204, 204, 0.3)',
      cliLinkHover: '#ffffff',
      cliLinkHoverBg: 'rgba(57, 204, 204, 0.2)',
      cliLinkHoverBorder: 'rgba(57, 204, 204, 0.6)',
      buttonPanelBg: 'linear-gradient(145deg, #001f3f, #002b5c)',
      buttonPanelBorder: '#39cccc',
      buttonPanelHoverBorder: '#ffffff',
      categoryPanelBg: '#001f3f',
      categoryPanelBorder: '#39cccc',
      titleColor: '#39cccc',
      subtitleColor: '#bdbdbd',
      labelColor: '#bdbdbd',
      buttonBg: '#39cccc',
      buttonText: '#fff',
      buttonBorder: '#39cccc',
      buttonHoverBg: '#ffffff',
      buttonHoverText: '#39cccc',
      manualTextColor: '#39cccc'
    },
    'neon': { 
      name: 'Neon', 
      bodyBg: 'linear-gradient(135deg, #0a0a0a 0%, #1a0a1a 100%)',
      terminalBg: 'linear-gradient(145deg, #0a0a0a, #1a0a1a)',
      terminalColor: '#ff00ff',
      terminalBorder: '#ff00ff',
      inputBg: '#0a0a0a',
      inputColor: '#ff00ff',
      inputBorder: '#ff00ff',
      scrollbarTrack: '#1a0a1a',
      scrollbarThumb: 'linear-gradient(180deg, #ff00ff, #cc00cc)',
      scrollbarThumbHover: 'linear-gradient(180deg, #cc00cc, #990099)',
      linkColor: '#ff00ff',
      linkHover: '#00ffff',
      cliLinkColor: '#00ffff',
      cliLinkBg: 'rgba(0, 255, 255, 0.1)',
      cliLinkBorder: 'rgba(0, 255, 255, 0.3)',
      cliLinkHover: '#ffffff',
      cliLinkHoverBg: 'rgba(0, 255, 255, 0.2)',
      cliLinkHoverBorder: 'rgba(0, 255, 255, 0.6)',
      buttonPanelBg: 'linear-gradient(145deg, #0a0a0a, #1a0a1a)',
      buttonPanelBorder: '#ff00ff',
      buttonPanelHoverBorder: '#00ffff',
      categoryPanelBg: '#0a0a0a',
      categoryPanelBorder: '#ff00ff',
      titleColor: '#ff00ff',
      subtitleColor: '#bdbdbd',
      labelColor: '#bdbdbd',
      buttonBg: '#ff00ff',
      buttonText: '#fff',
      buttonBorder: '#ff00ff',
      buttonHoverBg: '#00ffff',
      buttonHoverText: '#0a0a0a',
      manualTextColor: '#ff00ff'
    }
  };
  
  if (!args || args.length === 0) {
    // Mostrar lista de temas
    return listThemes(themes);
  }
  
  const themeName = args[0].toLowerCase();
  if (themes[themeName]) {
    applyTheme(themes[themeName]);
    const msg = lang === 'pt' 
      ? ` Tema alterado para: ${themes[themeName].name}`
      : ` Theme changed to: ${themes[themeName].name}`;
    return msg;
  } else {
    const msg = lang === 'pt' 
      ? `❌ Tema '${themeName}' não encontrado. Digite 'theme' para ver opções.`
      : `❌ Theme '${themeName}' not found. Type 'theme' to see options.`;
    return msg;
  }
}

function listThemes(themes) {
  const header = lang === 'pt' ? '=== Temas Disponíveis ===================' : '=== Available Themes ===================';
  const footer = '='.repeat(header.length);
  
  let output = header + '\n\n';
  
  Object.entries(themes).forEach(([key, theme]) => {
    output += `${key.padEnd(12)}${theme.name}\n`;
  });
  
  output += `\n${footer}`;
  return output;
}

function setMatrixEffect(visible) {
  let matrixCanvas = document.getElementById('matrix-canvas');
  if (visible) {
    if (!matrixCanvas) {
      matrixCanvas = document.createElement('canvas');
      matrixCanvas.id = 'matrix-canvas';
      matrixCanvas.style.position = 'fixed';
      matrixCanvas.style.top = 0;
      matrixCanvas.style.left = 0;
      matrixCanvas.style.width = '100vw';
      matrixCanvas.style.height = '100vh';
      matrixCanvas.style.zIndex = -1;
      matrixCanvas.style.pointerEvents = 'none';
      matrixCanvas.style.opacity = '0.25';
      document.body.appendChild(matrixCanvas);
      startMatrixEffect(matrixCanvas, true); // true para forçar resize inicial
    }
  } else {
    if (matrixCanvas) {
      // Remover event listener de resize
      window.removeEventListener('resize', window._matrixResizeHandler);
      matrixCanvas.remove();
      if (window._matrixInterval) {
        clearInterval(window._matrixInterval);
        window._matrixInterval = null;
      }
    }
  }
}

function startMatrixEffect(canvas, forceInitialResize) {
  var ctx = canvas.getContext('2d');
  var texts = 'アァイィウヴエカキクケコサシスセソタチツテトABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'.split('');
  var fontSize = 20;
  var columns, drops;
  function resize() {
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
    columns = Math.floor(canvas.width / fontSize);
    drops = [];
    for (var x = 0; x < columns; x++) {
      drops[x] = 1;
    }
  }
  // Handler global para poder remover depois
  window._matrixResizeHandler = resize;
  window.addEventListener('resize', resize);
  if (forceInitialResize) resize();
  if (window._matrixInterval) clearInterval(window._matrixInterval);
  window._matrixInterval = setInterval(function draw() {
    ctx.fillStyle = 'rgba(0,0,0,0.05)';
    ctx.fillRect(0, 0, canvas.width, canvas.height);
    ctx.fillStyle = '#0F0';
    ctx.font = fontSize + 'px monospace';
    for (var i = 0; i < drops.length; i++) {
      var text = texts[Math.floor(Math.random() * texts.length)];
      ctx.fillText(text, i * fontSize, drops[i] * fontSize);
      if (drops[i] * fontSize > canvas.height || Math.random() > 0.95) {
        drops[i] = 0;
      }
      drops[i]++;
    }
  }, 33);
}

function applyTheme(theme) {
  // Aplicar ao body (background da página)
  document.body.style.background = theme.bodyBg;
  
  // Título principal
  const pageTitle = document.getElementById('page-title');
  if (pageTitle) {
    pageTitle.style.color = theme.titleColor;
  }
  // Subtítulo
  const subtitle = document.querySelector('.text-white-50, .subtitle, .text-muted');
  if (subtitle) {
    subtitle.style.color = theme.subtitleColor;
  }
  // Labels
  const labels = document.querySelectorAll('.form-label, #category-title');
  labels.forEach(label => {
    label.style.color = theme.labelColor;
  });
  // Botões
  const buttons = document.querySelectorAll('button, .btn');
  buttons.forEach(btn => {
    btn.style.background = theme.buttonBg;
    btn.style.color = theme.buttonText;
    btn.style.borderColor = theme.buttonBorder;
  });
  // Botão hover
  buttons.forEach(btn => {
    btn.onmouseenter = () => {
      btn.style.background = theme.buttonHoverBg;
      btn.style.color = theme.buttonHoverText;
    };
    btn.onmouseleave = () => {
      btn.style.background = theme.buttonBg;
      btn.style.color = theme.buttonText;
    };
  });
  // Texto do manual
  const manualText = document.getElementById('manual-text');
  if (manualText) {
    manualText.style.color = theme.manualTextColor;
  }
  // Terminal principal
  const terminal = document.getElementById('terminal');
  if (terminal) {
    terminal.style.background = theme.terminalBg;
    terminal.style.borderColor = theme.terminalBorder;
  }
  // Output do terminal
  const output = document.getElementById('output');
  if (output) {
    output.style.color = theme.terminalColor;
  }
  // Input do terminal
  const input = document.getElementById('input');
  if (input) {
    input.style.backgroundColor = 'transparent'; // Sempre transparente
    input.style.color = theme.inputColor;
    input.style.borderColor = 'none';
  }
  // Input line (container do input)
  const inputLine = document.getElementById('input-line');
  if (inputLine) {
    inputLine.classList.remove('bg-dark', 'text-light', 'border-0');
    inputLine.style.backgroundColor = theme.inputBg;
    inputLine.style.borderColor = theme.inputBorder;
    inputLine.style.color = theme.inputColor;
  }
  // Prompt
  const prompt = document.getElementById('prompt');
  if (prompt) {
    prompt.style.color = theme.terminalColor;
  }
  // Terminal scroll (container do output)
  const terminalScroll = document.querySelector('.terminal-scroll');
  if (terminalScroll) {
    terminalScroll.style.backgroundColor = theme.inputBg;
    terminalScroll.style.borderColor = theme.terminalBorder;
  }
  // Button panel
  const buttonPanel = document.getElementById('button-panel');
  if (buttonPanel) {
    const panelButtons = buttonPanel.querySelectorAll('div');
    panelButtons.forEach(button => {
      button.style.background = theme.buttonPanelBg;
      button.style.borderColor = theme.buttonPanelBorder;
    });
  }
  // Category panel
  const categoryPanel = document.getElementById('category-panel');
  if (categoryPanel) {
    categoryPanel.style.backgroundColor = theme.categoryPanelBg;
    categoryPanel.style.borderColor = theme.categoryPanelBorder;
  }
  // Aplicar estilos CSS customizados para scrollbar e links
  applyCustomStyles(theme);
  // Salvar no localStorage
  localStorage.setItem('cli-theme', JSON.stringify(theme));
  // Matrix effect
  if (theme.name === 'Matrix') {
    setMatrixEffect(true);
  } else {
    setMatrixEffect(false);
  }
}

function applyCustomStyles(theme) {
  // Criar ou atualizar style tag para estilos customizados
  let styleTag = document.getElementById('theme-styles');
  if (!styleTag) {
    styleTag = document.createElement('style');
    styleTag.id = 'theme-styles';
    document.head.appendChild(styleTag);
  }
  
  const css = `
    .terminal-scroll::-webkit-scrollbar-track {
      background: ${theme.scrollbarTrack} !important;
    }
    
    .terminal-scroll::-webkit-scrollbar-thumb {
      background: ${theme.scrollbarThumb} !important;
    }
    
    .terminal-scroll::-webkit-scrollbar-thumb:hover {
      background: ${theme.scrollbarThumbHover} !important;
    }
    
    #output a {
      color: ${theme.linkColor} !important;
    }
    
    #output a:hover {
      color: ${theme.linkHover} !important;
    }
    
    #output a.cli-link {
      color: ${theme.cliLinkColor} !important;
      background-color: ${theme.cliLinkBg} !important;
      border-color: ${theme.cliLinkBorder} !important;
    }
    
    #output a.cli-link:hover {
      color: ${theme.cliLinkHover} !important;
      background-color: ${theme.cliLinkHoverBg} !important;
      border-color: ${theme.cliLinkHoverBorder} !important;
    }
    
    #button-panel > div:hover {
      border-color: ${theme.buttonPanelHoverBorder} !important;
    }
  `;
  
  styleTag.textContent = css;
}

// Função para carregar tema salvo
export function loadSavedTheme() {
  const savedTheme = localStorage.getItem('cli-theme');
  if (savedTheme) {
    try {
      const theme = JSON.parse(savedTheme);
      // Aguardar um pouco para garantir que o DOM está carregado
      setTimeout(() => {
        applyTheme(theme);
      }, 100);
    } catch (error) {
      console.error('Erro ao carregar tema salvo:', error);
    }
  }
}