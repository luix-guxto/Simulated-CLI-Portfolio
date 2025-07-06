import { availableCategories } from './main.js';

let currentLang = 'pt';

export function initCategories(lang) {
    currentLang = lang;
    populateDropdown();
    setupCategoryEvents();
    updateCategoryTexts();
}

function populateDropdown() {
    const categoryDropdown = document.getElementById('category-dropdown');
    const filterBtn = document.getElementById('filter-btn');
    
    categoryDropdown.innerHTML = '<option value="">' + 
        (currentLang === 'pt' ? 'Selecione uma categoria' : 'Select a category') + 
        '</option>';
    
    availableCategories.forEach(category => {
        const option = document.createElement('option');
        option.value = category;
        option.textContent = category;
        categoryDropdown.appendChild(option);
    });
    
    filterBtn.disabled = true;
}

function setupCategoryEvents() {
    const commandDropdown = document.getElementById('command-dropdown');
    const categoryDropdown = document.getElementById('category-dropdown');
    const filterBtn = document.getElementById('filter-btn');
    const input = document.getElementById('input');
    
    commandDropdown.addEventListener('change', function() {
        updateFilterButton();
    });
    
    categoryDropdown.addEventListener('change', function() {
        updateFilterButton();
    });
    
    filterBtn.addEventListener('click', function() {
        const selectedCommand = commandDropdown.value;
        const selectedCategory = categoryDropdown.value;
        if (selectedCommand && selectedCategory) {
            const commandText = `${selectedCommand} -c ${selectedCategory}`;
            
            input.value = commandText;
            input.focus();
            
            commandDropdown.value = '';
            categoryDropdown.value = '';
            filterBtn.disabled = true;
        }
    });
    
    function updateFilterButton() {
        filterBtn.disabled = !(commandDropdown.value && categoryDropdown.value);
    }
}

export function updateCategoryTexts() {
    const categoryTitle = document.getElementById('category-title');
    const commandDropdown = document.getElementById('command-dropdown');
    const categoryDropdown = document.getElementById('category-dropdown');
    const filterBtn = document.getElementById('filter-btn');
    
    const labels = document.querySelectorAll('.form-label');
    
    if (currentLang === 'pt') {
        categoryTitle.textContent = 'Categorias';
        commandDropdown.options[0].text = 'Selecione um comando';
        commandDropdown.options[1].text = 'Projetos';
        commandDropdown.options[2].text = 'Certificados';
        commandDropdown.options[3].text = 'Experiência';
        commandDropdown.options[4].text = 'Conhecimentos';
        categoryDropdown.options[0].text = 'Selecione uma categoria';
        filterBtn.innerHTML = '<i class="fas fa-filter me-1"></i>Filtrar por Categoria';
        labels[0].textContent = 'Comando:';
        labels[1].textContent = 'Categoria:';
    } else {
        categoryTitle.textContent = 'Categories';
        commandDropdown.options[0].text = 'Select a command';
        commandDropdown.options[1].text = 'Projects';
        commandDropdown.options[2].text = 'Certificates';
        commandDropdown.options[3].text = 'Experience';
        commandDropdown.options[4].text = 'Knowledge';
        categoryDropdown.options[0].text = 'Select a category';
        filterBtn.innerHTML = '<i class="fas fa-filter me-1"></i>Filter by Category';
        labels[0].textContent = 'Command:';
        labels[1].textContent = 'Category:';
    }
    
    populateDropdown();
}

export function refreshCategories(lang) {
    currentLang = lang;
    populateDropdown();
    updateCategoryTexts();
} 