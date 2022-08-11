INSERT INTO place (street, neighborhood, city, state, cep) VALUES 
('Rua', 'Bairo', 'Floripa', 'Estado', '88066013'),
('Rua', 'Bairo', 'São Jośe', 'Estado', '88752700'),
('Rua', 'Bairo', 'Palhoça', 'Estado', '88111480');

INSERT INTO search_type (description) VALUES 
('Induzida'), ('Livre');

INSERT INTO search_format (description) VALUES 
('Telefone'), ('Presencial');

INSERT INTO candidate (name) VALUES 
('Luis Inácio Lula da Silva'),
('Ciro Gomes'),
('Simone Tebet'),
('Luiz Felipe Davila'),
('Jair Bolsonaro');

INSERT INTO search (id_place, id_type, id_format, date, age_average) VALUES 
(1, 2, 1, '2020-08-19', 25),
(2, 1, 2, '2020-01-17', 32);

INSERT INTO candidate_and_search (id_candidate, id_search, vote) VALUES
(1, 2, 100000), (2, 1, 97000), (3, 1, 15000), (4, 2, 3000), (5, 2, 10000);


INSERT INTO political_party(name, number) VALUES 
('PT', 13), ('PDT', 12), ('MDB', 15), ('NOVO', 30), ('PL', 22);

INSERT INTO clean_sheet(id_candidate, status, description) VALUES 
(1, true, 'Candidato ficha limpa!'), 
(2, false, 'Verificar no TSE, todos os processos do candidato em questão!'), 
(3, true, 'Candidato ficha limpa!'),
(4, false, 'Verificar no TSE, todos os processos do candidato em questão!'), 
(5, true, 'Candidato ficha limpa!');





