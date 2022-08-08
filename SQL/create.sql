CREATE DATABASE pesquisa_eleicao;
USE pesquisa_eleicao;

CREATE TABLE candidato (
    id INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    partido VARCHAR(255) NOT NULL,
    ficha_limpa BOOLEAN,
    PRIMARY KEY (id)
);

CREATE TABLE pesquisa (
    id INT NOT NULL,
    instituto VARCHAR(255) NOT NULL,
    data_pesquisa INT NOT NULL,
    local_pesquisa VARCHAR(255) NOT NULL,
    media_idade INT NOT NULL,
    tipo_id INT NOT NULL,
    formato_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tipo_id)
        REFERENCES tipo_pesquisa (id),
    FOREIGN KEY (formato_id)
        REFERENCES formato_pesquisa (id)
);

CREATE TABLE tipo_presquisa (
    id INT NOT NULL,
    descricao VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE formato_pesquisa (
    id INT NOT NULL,
    descricao VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE candidato_pesquisa (
    id INT NOT NULL,
    canditado_id INT NOT NULL,
    pesquisa_id INT NOT NULL,
    voto INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (candidato_id)
        REFERENCES candidato (id),
    FOREIGN KEY (pesquisa_id)
        REFERENCES pesquisa (id)
);

-- drop database pesquisa_eleicao; 
