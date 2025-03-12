-- Criar tabelas inicias para controle de usuario
CREATE TABLE papeis (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE permissoes (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE papel_permissao (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    papel_id UUID NOT NULL REFERENCES papeis(id) ON DELETE CASCADE,
    permissao_id UUID NOT NULL REFERENCES permissoes(id) ON DELETE CASCADE
);

CREATE TABLE usuarios (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    papel_id UUID NOT NULL REFERENCES papeis(id)
);