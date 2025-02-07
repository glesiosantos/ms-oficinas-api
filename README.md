# MUMEC - API de Gestão para Oficinas Mecânicas

MUMEC (Multi-Mechanic Management) é uma API desenvolvida para gerenciar múltiplas oficinas mecânicas, abrangendo serviços para carros, motos e bicicletas. O sistema oferece funcionalidades completas para administração de pedidos, produtos, estoque, fluxo de caixa e gerenciamento de clientes e seus veículos.

## 🚀 Funcionalidades

- **Gerenciamento de Pedidos**: Cadastro, atualização e acompanhamento do status dos serviços prestados.  
- **Controle de Produtos e Estoque**: Administração de peças, acessórios e insumos utilizados nas oficinas.  
- **Gestão Financeira**: Monitoramento de receitas, despesas e fluxo de caixa.  
- **Cadastro de Clientes e Veículos**: Registro detalhado de clientes, incluindo dados de contato e informações sobre seus veículos.  
- **Suporte a Múltiplas Oficinas**: Cada oficina pode operar de forma independente dentro da mesma plataforma.  

## 🛠 Tecnologias Utilizadas

- **Backend**: [Node.js](https://nodejs.org/) com [Express](https://expressjs.com/)  
- **Banco de Dados**: [MongoDB](https://www.mongodb.com/) ou [PostgreSQL](https://www.postgresql.org/)  
- **Autenticação**: JWT para segurança dos acessos  
- **Documentação da API**: Swagger ou Postman  

## 📌 Como Executar o Projeto

### Pré-requisitos

- [Node.js](https://nodejs.org/) instalado  
- Gerenciador de pacotes ([npm](https://www.npmjs.com/) ou [yarn](https://yarnpkg.com/))  
- Banco de dados configurado (MongoDB/PostgreSQL)  

### Instalação e Configuração

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/mumec.git

# Acesse a pasta do projeto
cd mumec

# Instale as dependências
npm install  # ou yarn install

# Configure as variáveis de ambiente no arquivo .env

# Inicie a aplicação
npm start  # ou yarn start
```

## 📖 Documentação da API

A documentação da API pode ser acessada via Swagger na rota `/api-docs` após iniciar o projeto.

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## 🤝 Contribuição

Contribuições são bem-vindas! Siga as diretrizes do projeto e envie seu PR.
