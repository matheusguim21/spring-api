CREATE SCHEMA IF NOT EXISTS SaudeSempre;
-- Criação da tabela Endereco
CREATE TABLE IF NOT EXISTS SaudeSempre.Endereco (
    idEndereco VARCHAR(20) NOT NULL PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    numero INTEGER NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL,
    cep VARCHAR(10) NOT NULL
);

-- Criação da tabela PlanoSaude
CREATE TABLE IF NOT EXISTS SaudeSempre.PlanoSaude (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Criação da tabela Atendimento
CREATE TABLE IF NOT EXISTS SaudeSempre.Atendimento (
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    diagnostico VARCHAR(255) NOT NULL,
    receita VARCHAR(255) NOT NULL
);

-- Criação da tabela Consultorio
CREATE TABLE IF NOT EXISTS SaudeSempre.Consultorio (
    idConsultorio SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    Endereco_idEndereco VARCHAR(20) NOT NULL,
    FOREIGN KEY (Endereco_idEndereco) REFERENCES SaudeSempre.Endereco(idEndereco)
);

-- Criação da tabela Atendente
CREATE TABLE IF NOT EXISTS SaudeSempre.Atendente (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    consultorio INTEGER NOT NULL,
    usuario VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

-- Criação da tabela Medico
CREATE TABLE IF NOT EXISTS SaudeSempre.Medico (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    consultorioId INTEGER NOT NULL,
    atendimentoId INTEGER NOT NULL,
    FOREIGN KEY (consultorioId) REFERENCES SaudeSempre.Consultorio(idConsultorio),
    FOREIGN KEY (atendimentoId) REFERENCES SaudeSempre.Atendimento(id)
);

-- Criação da tabela Paciente
CREATE TABLE IF NOT EXISTS SaudeSempre.Paciente (
    idPaciente SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    Endereco_idEndereco VARCHAR(20),  -- Supondo que seja uma chave estrangeira para a tabela Endereco
    telefone VARCHAR(15) NOT NULL,
    dataNascimento DATE NOT NULL,
    PlanoSaude_idPlanoSaude INTEGER NOT NULL,
    Atendimento_idAtendimento INTEGER,
    FOREIGN KEY (Endereco_idEndereco) REFERENCES SaudeSempre.Endereco(idEndereco),
    FOREIGN KEY (PlanoSaude_idPlanoSaude) REFERENCES SaudeSempre.PlanoSaude(id),
    FOREIGN KEY (Atendimento_idAtendimento) REFERENCES SaudeSempre.Atendimento(id)
);

-- Criação da tabela Consulta
CREATE TABLE IF NOT EXISTS SaudeSempre.Consulta (
    id SERIAL PRIMARY KEY,
    data TIMESTAMP NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    planoSaudeId INTEGER NOT NULL,
    pacienteId INTEGER NOT NULL,
    pacienteplanoId INTEGER NOT NULL,
    atendenteId INTEGER NOT NULL,
    atendenteConsultorioId INTEGER NOT NULL,
    medicoId INTEGER NOT NULL,
    medicoConsultorioId INTEGER NOT NULL,
    FOREIGN KEY (planoSaudeId) REFERENCES SaudeSempre.PlanoSaude(id),
    FOREIGN KEY (pacienteId) REFERENCES SaudeSempre.Paciente(idPaciente),
    FOREIGN KEY (atendenteId) REFERENCES SaudeSempre.Atendente(id),
    FOREIGN KEY (medicoId) REFERENCES SaudeSempre.Medico(id)
);
