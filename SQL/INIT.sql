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

-- CREATE TABLE institute (
-- 	id SERIAL PRIMARY KEY,
-- 	id_place INT REFERENCES place(id),
-- 	name VARCHAR(255) NOT NULL UNIQUE
-- );

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
	-- id_institute INT REFERENCES institute(id),
	id_place INT REFERENCES place(id),
	id_type INT REFERENCES search_type(id),
	id_format INT REFERENCES search_format(id),
	date timestamp NOT NULL,
	age_average FLOAT
);

CREATE TABLE candidate_and_search(
	id SERIAL PRIMARY KEY,
	id_candidate INT REFERENCES candidate(id),
	id_search INT REFERENCES search(id),
  vote int
);

INSERT INTO political_party(name, number) VALUES ('PT', 13);
INSERT INTO political_party(name, number) VALUES ('PDT', 12);
INSERT INTO political_party(name, number) VALUES ('MDB', 15);
INSERT INTO political_party(name, number) VALUES ('NOVO', 30);
INSERT INTO political_party(name, number) VALUES ('PL', 22);

INSERT INTO clean_sheet(id_candidate, status) VALUES (1, true);
INSERT INTO clean_sheet(id_candidate, status, description) VALUES (2, false, 'Verificar no TSE, todos os processos do candidato em questão!');
INSERT INTO clean_sheet(id_candidate, status) VALUES (3, true);
INSERT INTO clean_sheet(id_candidate, status, description) VALUES (4, false, 'Verificar no TSE, todos os processos do candidato em questão!');
INSERT INTO clean_sheet(id_candidate, status) VALUES (5, true);

INSERT INTO candidate(id_political_party, name) VALUES (1, 'Luis Inácio Lula da Silva');
INSERT INTO candidate(id_political_party, name) VALUES (2, 'Ciro Gomes');
INSERT INTO candidate(id_political_party, name) VALUES (3, 'Simone Tebet');
INSERT INTO candidate(id_political_party, name) VALUES (4, 'Luiz Felipe Davila');
INSERT INTO candidate(id_political_party, name) VALUES (5, 'Jair Bolsonaro');

INSERT INTO place (street, neighborhood, city, state, cep) VALUES ('Rua', 'Bairo', 'Floripa', 'Estado', '88066013');
INSERT INTO place (street, neighborhood, city, state, cep) VALUES ('Rua', 'Bairo', 'São Jośe', 'Estado', '88752700');
INSERT INTO place (street, neighborhood, city, state, cep) VALUES ('Rua', 'Bairo', 'Palhoça', 'Estado', '88111480');

INSERT INTO search_type (description) VALUES ('Induzida');
INSERT INTO search_type (description) VALUES ('Livre');

INSERT INTO search_format (description) VALUES ('Telefone');
INSERT INTO search_format (description) VALUES ('Presencial');

INSERT INTO search (id_place, id_type, id_format, date, age_average) VALUES (1, 2, 1, '2020-08-19', 25);
INSERT INTO search (id_place, id_type, id_format, date, age_average) VALUES (2, 1, 2, '2020-01-17', 32);
INSERT INTO search (id_place, id_type, id_format, date, age_average) VALUES (3, 1, 1, '2020-04-04', 18);
INSERT INTO search (id_place, id_type, id_format, date, age_average) VALUES (1, 2, 2, '2020-07-22', 40);
INSERT INTO search (id_place, id_type, id_format, date, age_average) VALUES (2, 1, 2, '2020-03-10', 50);

INSERT INTO candidate_and_search (id_candidate, id_search, vote) VALUES (1, 5, 100000);	
INSERT INTO candidate_and_search (id_candidate, id_search, vote) VALUES (2, 4, 15000);
INSERT INTO candidate_and_search (id_candidate, id_search, vote) VALUES (3, 3, 3000);
INSERT INTO candidate_and_search (id_candidate, id_search, vote) VALUES (4, 2, 10000);
INSERT INTO candidate_and_search (id_candidate, id_search, vote) VALUES (5, 1, 97000);

