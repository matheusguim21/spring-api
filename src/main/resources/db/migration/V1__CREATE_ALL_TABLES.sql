CREATE SCHEMA IF NOT EXISTS socinproapp;

-- Sequences
CREATE SEQUENCE socinproapp.titular_id_seq;
CREATE SEQUENCE socinproapp.fonograma_ecad_seq;
CREATE SEQUENCE socinproapp.obra_ecad_seq;
CREATE SEQUENCE socinproapp.usuario_id_seq;
CREATE SEQUENCE socinproapp.codigo_socinpro_seq; -- Nova sequence para codigo_socinpro
CREATE SEQUENCE socinproapp.codigo_ecad_seq; -- Nova sequence para codigo_ecad

-- Tabela Titular com codigo_socinpro e codigo_ecad como BIGINT
CREATE TABLE socinproapp.Titular (
                                     id BIGINT PRIMARY KEY DEFAULT nextval('socinproapp.titular_id_seq'),
                                     nome VARCHAR NOT NULL,
                                     cpf_cnpj VARCHAR UNIQUE NOT NULL,
                                     saldo NUMERIC(15,2),
                                     foto_perfil VARCHAR,
                                     pseudonimo VARCHAR UNIQUE,
                                     codigo_socinpro BIGINT UNIQUE DEFAULT nextval('socinproapp.codigo_socinpro_seq'),
                                     codigo_ecad BIGINT UNIQUE DEFAULT nextval('socinproapp.codigo_ecad_seq')
);

-- Tabela Usuario
CREATE TABLE socinproapp.Usuario (
                                     id BIGINT PRIMARY KEY DEFAULT nextval('socinproapp.usuario_id_seq'),
                                     nome_usuario VARCHAR NOT NULL UNIQUE,
                                     senha VARCHAR NOT NULL,
                                     role VARCHAR DEFAULT 'user',
                                     titular_id BIGINT UNIQUE,
                                     FOREIGN KEY (titular_id) REFERENCES socinproapp.Titular(id) ON DELETE CASCADE
);

-- Tabela Fonograma
CREATE TABLE socinproapp.Fonograma (
                                       codigo_ecad BIGINT PRIMARY KEY DEFAULT nextval('socinproapp.fonograma_ecad_seq'),
                                       isrc VARCHAR NOT NULL,
                                       titulo VARCHAR NOT NULL,
                                       titular_id BIGINT,
                                       FOREIGN KEY (titular_id) REFERENCES socinproapp.Titular(id) ON DELETE CASCADE
);

-- Tabela Obra
CREATE TABLE socinproapp.Obra (
                                  codigo_ecad BIGINT PRIMARY KEY DEFAULT nextval('socinproapp.obra_ecad_seq'),
                                  titulo VARCHAR NOT NULL,
                                  titular_id BIGINT,
                                  FOREIGN KEY (titular_id) REFERENCES socinproapp.Titular(id) ON DELETE CASCADE
);
