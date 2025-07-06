-- Inserts para a tabela de links
-- Execute este script após criar a tabela link no banco de dados

USE CLI_PORTFOLIO;

-- Inserir link para certificados (Google Drive)
INSERT INTO link (name, url) VALUES 
('certificates', 'https://drive.google.com/drive/folders/1LTbZCsEMOe7uimBSmtMftSdys0gBeW4K?usp=drive_link');

-- Inserir outros links úteis (exemplos)
INSERT INTO link (name, url) VALUES 
('linkedin', 'https://www.linkedin.com/in/seu-perfil'),
('github', 'https://github.com/seu-usuario'),
('portfolio', 'https://seu-portfolio.com'),
('blog', 'https://seu-blog.com');

-- Verificar os dados inseridos
SELECT * FROM link; 