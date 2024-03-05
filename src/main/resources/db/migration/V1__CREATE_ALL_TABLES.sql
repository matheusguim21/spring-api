CREATE SCHEMA IF NOT EXISTS socinproapp;

CREATE SEQUENCE titular_id_seq;
CREATE SEQUENCE fonograma_ecad_seq;
CREATE SEQUENCE obra_ecad_seq;

CREATE TABLE socinproapp.Titular (
                         id BIGINT PRIMARY KEY DEFAULT nextval('titular_id_seq'),
                         nome VARCHAR NOT NULL,
                         cpf_cnpj VARCHAR UNIQUE NOT NULL,
                         usuario VARCHAR NULL,
                         senha VARCHAR NULL,
                         saldo NUMERIC(15,2),
                         foto_perfil VARCHAR
);

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
