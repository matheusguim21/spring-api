CREATE SCHEMA IF NOT EXISTS SaudeSempre;
-- Criação da tabela Endereco
CREATE TABLE IF NOT EXISTS SaudeSempre.Endereco (
    id VARCHAR(20) NOT NULL PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    numero INTEGER NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    cep VARCHAR(10) NOT NULL
);

-- Criação da tabela PlanoDeSaude
CREATE TABLE IF NOT EXISTS SaudeSempre.PlanoDeSaude (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);



-- Criação da tabela Consultorio
CREATE TABLE IF NOT EXISTS SaudeSempre.Consultorio (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco_id VARCHAR(20) NOT NULL,
    FOREIGN KEY (endereco_id) REFERENCES SaudeSempre.Endereco(id)
);

-- Criação da tabela Atendente
CREATE TABLE IF NOT EXISTS SaudeSempre.Atendente (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    consultorio_id INTEGER NOT NULL,
    usuario VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);
-- Criação da tabela Atendimento
CREATE TABLE IF NOT EXISTS SaudeSempre.Atendimento (
    id UUID PRIMARY KEY,
    data DATE NOT NULL,
    atendente_id INTEGER NOT NULL,

    FOREIGN KEY (atendente_id) REFERENCES SaudeSempre.Atendente(id)

);
-- Criação da tabela Medico
CREATE TABLE IF NOT EXISTS SaudeSempre.Medico (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    consultorio_id INTEGER NOT NULL,
    atendimento_id UUID NOT NULL,
    FOREIGN KEY (consultorio_id) REFERENCES SaudeSempre.Consultorio(id),
    FOREIGN KEY (atendimento_id) REFERENCES SaudeSempre.Atendimento(id)
);

-- Criação da tabela Paciente
CREATE TABLE IF NOT EXISTS SaudeSempre.Paciente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    data_nascimento DATE NOT NULL,
    endereco_id VARCHAR(20),  -- Supondo que seja uma chave estrangeira para a tabela Endereco
    plano_de_saude_id INTEGER NOT NULL,
    FOREIGN KEY (endereco_id) REFERENCES SaudeSempre.Endereco(id),
    FOREIGN KEY (plano_de_saude_id) REFERENCES SaudeSempre.PlanoDeSaude(id)
   );

-- Criação da tabela Consulta
CREATE TABLE IF NOT EXISTS SaudeSempre.Consulta (
    id UUID PRIMARY KEY,
    data TIMESTAMP NOT NULL,
    tipo VARCHAR(10) NOT NULL,
    status VARCHAR(15) NOT NULL,
    diagnostico VARCHAR(255) NOT NULL,
    receita VARCHAR(255) NOT NULL,
    plano_de_saude_id INTEGER NOT NULL,
    paciente_id INTEGER NOT NULL,
    atendente_id INTEGER NOT NULL,
    medico_id INTEGER NOT NULL,
    FOREIGN KEY (plano_de_saude_id) REFERENCES SaudeSempre.PlanoDeSaude(id),
    FOREIGN KEY (paciente_id) REFERENCES SaudeSempre.Paciente(id),
    FOREIGN KEY (atendente_id) REFERENCES SaudeSempre.Atendente(id),
    FOREIGN KEY (medico_id) REFERENCES SaudeSempre.Medico(id)
);
