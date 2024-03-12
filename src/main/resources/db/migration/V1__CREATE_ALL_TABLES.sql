CREATE SCHEMA IF NOT EXISTS socinproapp;

CREATE SEQUENCE titular_id_seq;
CREATE SEQUENCE fonograma_ecad_seq;
CREATE SEQUENCE obra_ecad_seq;
CREATE SEQUENCE usuario_id_seq; -- Nova sequência para os IDs dos usuários

-- Modificação da tabela Titular para remover as colunas de usuário e senha
CREATE TABLE socinproapp.Titular (
                                     id BIGINT PRIMARY KEY DEFAULT nextval('titular_id_seq'),
                                     nome VARCHAR NOT NULL,
                                     cpf_cnpj VARCHAR UNIQUE NOT NULL,
                                     saldo NUMERIC(15,2),
                                     foto_perfil VARCHAR
);

-- Criação da nova tabela Usuario
CREATE TABLE socinproapp.Usuario (
                                     id BIGINT PRIMARY KEY DEFAULT nextval('usuario_id_seq'),
                                     usuario VARCHAR NOT NULL UNIQUE,
                                     senha VARCHAR NOT NULL,
                                     role VARCHAR  DEFAULT 'user',
                                     titular_id BIGINT UNIQUE,
                                     FOREIGN KEY (titular_id) REFERENCES socinproapp.Titular(id) ON DELETE CASCADE
);

-- Mantendo as definições das tabelas Fonograma e Obra como estavam
CREATE TABLE socinproapp.Fonograma (
                                       codigo_ecad BIGINT PRIMARY KEY DEFAULT nextval('fonograma_ecad_seq'),
                                       isrc VARCHAR NOT NULL,
                                       titular_id BIGINT,
                                       FOREIGN KEY (titular_id) REFERENCES socinproapp.Titular(id) ON DELETE CASCADE
);

CREATE TABLE socinproapp.Obra (
                                  codigo_ecad BIGINT PRIMARY KEY DEFAULT nextval('obra_ecad_seq'),
                                  titular_id BIGINT,
                                  FOREIGN KEY (titular_id) REFERENCES socinproapp.Titular(id) ON DELETE CASCADE
);
