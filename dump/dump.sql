-- Criação das tabelas
CREATE TABLE Categoria (
    id SERIAL PRIMARY KEY,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL
);

CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE Estoque (
    id SERIAL PRIMARY KEY,
    localizacao VARCHAR(255) NOT NULL
);

CREATE TABLE Fornecedor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    contato VARCHAR(255) NOT NULL
);

CREATE TABLE Pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    rg VARCHAR(20) NOT NULL,
    login VARCHAR(50) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE Funcionario (
    id SERIAL PRIMARY KEY,
    cargo VARCHAR(255) NOT NULL,
    setor VARCHAR(255) NOT NULL,
    salario NUMERIC(10, 2) NOT NULL,
    numCarteiraTrabalho VARCHAR(50) NOT NULL,
    pessoa_id INT NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES Pessoa (id)
);

CREATE TABLE Produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    especificacaoTecnica TEXT NOT NULL,
    garantia VARCHAR(255) NOT NULL,
    imagem VARCHAR(255),
    anoFabricacao INT NOT NULL,
    precoVenda NUMERIC(10, 2) NOT NULL,
    quantidade INT NOT NULL,
    categoriaId INT NOT NULL,
    FOREIGN KEY (categoriaId) REFERENCES Categoria (id)
);

CREATE TABLE Venda (
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    formaPagamento VARCHAR(255) NOT NULL,
    valorTotal NUMERIC(10, 2) NOT NULL,
    funcionarioId INT NOT NULL,
    clienteId INT NOT NULL,
    FOREIGN KEY (funcionarioId) REFERENCES Funcionario (id),
    FOREIGN KEY (clienteId) REFERENCES Cliente (id)
);

CREATE TABLE ItemVenda (
    id SERIAL PRIMARY KEY,
    quantidade INT NOT NULL,
    precoUnitario NUMERIC(10, 2) NOT NULL,
    produtoId INT NOT NULL,
    vendaId INT NOT NULL,
    FOREIGN KEY (produtoId) REFERENCES Produto (id),
    FOREIGN KEY (vendaId) REFERENCES Venda (id)
);

-- Inserção de dados
INSERT INTO Categoria (marca, modelo) VALUES 
('Samsung', 'Galaxy S21'),
('Apple', 'iPhone 13');

INSERT INTO Cliente (email, nome, endereco, telefone) VALUES 
('cliente1@example.com', 'João Silva', 'Rua A, 123', '1111-1111'),
('cliente2@example.com', 'Maria Oliveira', 'Rua B, 456', '2222-2222');

INSERT INTO Estoque (localizacao) VALUES 
('Armazém 1'),
('Armazém 2');

INSERT INTO Fornecedor (nome, contato) VALUES 
('Fornecedor A', 'contato@fornecedorA.com'),
('Fornecedor B', 'contato@fornecedorB.com');

INSERT INTO Pessoa (nome, cpf, rg, login, senha) VALUES 
('Carlos Pereira', '111.111.111-11', 'MG-12.345.678', 'carlos', 'senha123'),
('Ana Costa', '222.222.222-22', 'SP-23.456.789', 'ana', 'senha123');

INSERT INTO Funcionario (cargo, setor, salario, numCarteiraTrabalho, pessoa_id) VALUES 
('Vendedor', 'Vendas', 3000.00, 'CT12345', 1),
('Gerente', 'Administrativo', 5000.00, 'CT67890', 2);

INSERT INTO Produto (nome, especificacaoTecnica, garantia, imagem, anoFabricacao, precoVenda, quantidade, categoriaId) VALUES 
('Smartphone Samsung Galaxy S21', '6.2-inch, 8GB RAM', '1 ano', 'imagem1.jpg', 2021, 5000.00, 10, 1),
('Smartphone Apple iPhone 13', '6.1-inch, 6GB RAM', '1 ano', 'imagem2.jpg', 2021, 7000.00, 5, 2);

INSERT INTO Venda (data, formaPagamento, valorTotal, funcionarioId, clienteId) VALUES 
('2023-01-15', 'Cartão de Crédito', 10000.00, 1, 1),
('2023-01-16', 'Boleto', 7000.00, 2, 2);

INSERT INTO ItemVenda (quantidade, precoUnitario, produtoId, vendaId) VALUES 
(2, 5000.00, 1, 1),
(1, 7000.00, 2, 2);
