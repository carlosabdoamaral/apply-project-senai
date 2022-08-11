CREATE DATABASE projeto_aplicado1;
USE projeto_aplicado1;

CREATE TABLE place (
    id INT NOT NULL AUTO_INCREMENT,
    street VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE search_type (
    id INT NOT NULL AUTO_INCREMENT,
    description VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE search_format (
    id INT NOT NULL AUTO_INCREMENT,
    description VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE search (
    id INT NOT NULL AUTO_INCREMENT,
    date TIMESTAMP NOT NULL,
    age_average FLOAT,
    PRIMARY KEY (id),
    id_place INT,
    id_type INT,
    id_format INT,
    FOREIGN KEY (id_place)
        REFERENCES place (id),
    FOREIGN KEY (id_type)
        REFERENCES search_type (id),
    FOREIGN KEY (id_format)
        REFERENCES search_format (id)
);

CREATE TABLE candidate (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
); 

CREATE TABLE candidate_and_search (
    id INT NOT NULL AUTO_INCREMENT,
    vote INT NOT NULL,
    PRIMARY KEY (id),
    id_search INT,
    id_candidate INT,
    FOREIGN KEY (id_candidate)
        REFERENCES candidate(id),
    FOREIGN KEY (id_search)
        REFERENCES search (id)
);

CREATE TABLE political_party (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    number INT NOT NULL UNIQUE,
    PRIMARY KEY (id),
    id_candidate INT,
    FOREIGN KEY (id_candidate)
        REFERENCES candidate(id)
);

CREATE TABLE clean_sheet (
    id INT NOT NULL AUTO_INCREMENT,
    status BOOL,
    description VARCHAR(255),
    PRIMARY KEY (id),
    id_candidate INT,
    FOREIGN KEY (id_candidate)
        REFERENCES candidate(id)
);

-- CREATE TABLE institute (
-- 	id SERIAL PRIMARY KEY,
-- 	id_place INT REFERENCES place(id),
-- 	name VARCHAR(255) NOT NULL UNIQUE
-- );




