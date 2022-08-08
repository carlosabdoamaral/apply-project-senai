DROP TABLE IF EXISTS political_party, clean_sheet, candidate, vote, institute, place, search_type, search_format, search,candidate_and_search CASCADE;

CREATE TABLE political_party (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	number INT NOT NULL UNIQUE
);

CREATE TABLE clean_sheet (
	id SERIAL PRIMARY KEY,
	id_candidate INT REFERENCES political_party(id),
	status BOOL,
	description VARCHAR(255)
);

CREATE TABLE candidate (
	id SERIAL PRIMARY KEY,
	id_political_party INT REFERENCES political_party(id),
	name VARCHAR(255) NOT NULL
);

CREATE TABLE place (
	id SERIAL PRIMARY KEY,
	street VARCHAR(255) NOT NULL,
	neighborhood VARCHAR(255) NOT NULL,
	city VARCHAR(255) NOT NULL,
	state VARCHAR(255) NOT NULL,
	cep VARCHAR(10) NOT NULL
);

CREATE TABLE institute (
	id SERIAL PRIMARY KEY,
	id_place INT REFERENCES place(id),
	name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE search_type (
	id SERIAL PRIMARY KEY,
	description VARCHAR(50)
);

CREATE TABLE search_format (
	id SERIAL PRIMARY KEY,
	description VARCHAR(50)
);

CREATE TABLE search (
	id SERIAL PRIMARY KEY,
	id_institute INT REFERENCES institute(id),
	id_place INT REFERENCES place(id),
	id_type INT REFERENCES search_type(id),
	id_format INT REFERENCES search_format(id),
	date timestamp NOT NULL,
	age_average FLOAT
);

-- Rever o nome
CREATE TABLE candidate_and_search(
	id SERIAL PRIMARY KEY,
	id_candidate INT REFERENCES candidate(id),
	id_search INT REFERENCES search(id)
);

CREATE TABLE vote (
	id SERIAL PRIMARY KEY,
	id_candidate INT REFERENCES candidate(id),
	id_search INT REFERENCES search(id)
);