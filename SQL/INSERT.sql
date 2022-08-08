-- POPULANDO A TABELA DE TIPO DE PESQUISA
INSERT INTO search_type(description) VALUES ('INDUZIDA');
INSERT INTO search_type(description) VALUES ('LIVRE');

-- POPULANDO A TABELA DE FORMATO DE PESQUISA
INSERT INTO search_format(description) VALUES ('TELEFONE');
INSERT INTO search_format(description) VALUES ('PRESENCIAL');

INSERT INTO political_party(name, number) VALUES ('Partido 01', 111);
INSERT INTO political_party(name, number) VALUES ('Partido 02', 222);
INSERT INTO political_party(name, number) VALUES ('Partido 03', 333);

INSERT INTO candidate (id_political_party, name) VALUES (1, 'Joao');
INSERT INTO candidate (id_political_party, name) VALUES (2, 'Maria');
INSERT INTO candidate (id_political_party, name) VALUES (3, 'Paulo');

INSERT INTO place (street, neighborhood, city, state, cep) VALUES ('Rua', 'Bairo', 'Floripa', 'Estado', '00000000');
INSERT INTO place (street, neighborhood, city, state, cep) VALUES ('Rua', 'Bairo', 'Sao Jose', 'Estado', '11111111');
INSERT INTO place (street, neighborhood, city, state, cep) VALUES ('Rua', 'Bairo', 'Cidade 3', 'Estado', '11111111');

INSERT INTO institute(id_place, name) VALUES (1, 'Instituto Floripa');
INSERT INTO institute(id_place, name) VALUES (2, 'Instituto Sao Jose');
INSERT INTO institute(id_place, name) VALUES (3, 'Instituto 03');

INSERT INTO search(id_institute, id_place, id_type, id_format, date, age_average) VALUES (1, 1, 1, 1, NOW(), 0);
INSERT INTO search(id_institute, id_place, id_type, id_format, date, age_average) VALUES (2, 1, 1, 1, NOW(), 0);

INSERT INTO vote (id_candidate, id_search) VALUES (1, 1);
INSERT INTO vote (id_candidate, id_search) VALUES (1, 1);
INSERT INTO vote (id_candidate, id_search) VALUES (1, 1);
INSERT INTO vote (id_candidate, id_search) VALUES (2, 1);
INSERT INTO vote (id_candidate, id_search) VALUES (2, 1);
INSERT INTO vote (id_candidate, id_search) VALUES (2, 1);
INSERT INTO vote (id_candidate, id_search) VALUES (1, 2);
INSERT INTO vote (id_candidate, id_search) VALUES (2, 2);
INSERT INTO vote (id_candidate, id_search) VALUES (2, 2);
INSERT INTO vote (id_candidate, id_search) VALUES (3, 2);
