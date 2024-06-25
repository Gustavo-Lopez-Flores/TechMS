# TechMS - Sistema de Gerenciamento de Loja de Informática 🖥️

## Visão Geral do Sistema

TechMS é um software de gerenciamento para uma loja física que comercializa equipamentos de informática. Seu principal objetivo é facilitar o gerenciamento de compra, venda, estoque, entrega e registros de garantias dos produtos.

## Funcionalidades Principais

- **Registro de Vendas**: Inserção de produtos no carrinho via nome ou código de barras e finalização do pedido com forma de pagamento e entrega.
- **Gerenciamento de Estoque**: Registro e controle atualizado dos produtos disponíveis para venda.
- **Acompanhamento de Entregas**: Possibilidade de o cliente acompanhar o status da entrega e registrar ocorrências.
- **Emissão de Documentos**: Geração de notas fiscais e garantias.
- **Gestão de Clientes**: Cadastro e visualização de clientes e histórico de compras.
- **Gestão de Funcionários**: Cadastro e gerenciamento de funcionários e suas permissões.
- **Geração de Relatórios**: Relatórios de vendas e estoque.

## Classes de Usuários

- **Administrador**: Acesso total ao sistema, incluindo gerenciamento de funcionários e banco de dados.
- **Gerente**: Gerencia os funcionários de seu setor, com permissões específicas sem ultrapassar a hierarquia.
- **Funcionário**: Realiza a maioria das funcionalidades do sistema, exceto gerenciar outros funcionários.
- **Cliente**: Visualiza garantias, acompanha entregas e registra ocorrências.

## Definição de Conceitos

- **Equipamentos de Informática**: Produtos vendidos na loja, organizados por categorias como placas mãe, monitores, etc.
- **Backup**: Cópia de segurança dos dados.
- **Cliente**: Pessoa que realiza compras na loja.
- **Fornecedor**: Empresa que fornece produtos para a loja.
- **Pagamento da Venda**: Pagamento realizado pelo cliente pelos produtos adquiridos.
- **Produto**: Item vendido na loja, pertencente a uma categoria de informática.
- **Venda**: Transação de aquisição de produtos por um cliente.
- **Caixa**: Setor responsável pelos pagamentos e emissão de documentos fiscais.
- **SAC**: Serviço de Atendimento ao Cliente.
- **Credencial de Acesso**: Autenticação para login no sistema.
- **Relatório**: Documento que apresenta um resumo de atividades e resultados.
- **Recursos Humanos**: Setor responsável por recrutamento e gestão de funcionários.

## Requisitos de Software

### Requisitos Funcionais

- **Cadastro de Produtos**: Registro de novos produtos no estoque, com detalhes como marca, modelo, preço, etc.
- **Gestão de Clientes**: Cadastro e visualização de informações detalhadas de clientes e histórico de compras.
- **Gestão de Acesso**: Administração de permissões de acesso para diferentes tipos de usuários.
- **Gestão de Funcionários**: Cadastro e gerenciamento de funcionários, incluindo dados pessoais e salário.
- **Controle de Estoque**: Manutenção de um registro atualizado dos produtos disponíveis.
- **Processo de Venda**: Facilitação do registro de transações de vendas.
- **Acompanhamento Pós-venda**: Recursos para acompanhamento de satisfação do cliente.
- **Geração de Relatórios**: Capacidade de gerar relatórios de vendas e estoque.

### Requisitos Não-Funcionais

- **Desempenho**: Salvar informações no banco de dados imediatamente após a conclusão das transações.
- **Confiabilidade**: Capacidade de recuperação de dados e realização de backups.
- **Disponibilidade**: Sistema disponível 24/7.
- **Segurança**: Criptografia de senhas e controle de acesso seguro.
- **Manutenibilidade**: Implantação modular do sistema.
- **Portabilidade**: Compatibilidade com diferentes plataformas e bancos de dados.

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções ou novas funcionalidades para este projeto. Caso tenha dúvidas ou sugestões, abra uma issue para discussão.

---

**Nota:** Este projeto foi desenvolvido como parte de um trabalho acadêmico na disciplina de  Análise e Projeto de Software Orientado a Objetos. As funcionalidades foram implementadas com base nos diagramas de Processo Unificado desenvolvidos em sala de aula.
