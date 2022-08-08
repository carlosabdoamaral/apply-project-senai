INSERT INTO candidato(nome, partido, ficha_limpa) VALUES ('João', 'PT', true);
INSERT INTO candidato(nome, partido, ficha_limpa) VALUES('José', 'PSOL', false);
INSERT INTO candidato(nome, partido, ficha_limpa) VALUES('Tereza', 'Liberal', true);

INSERT INTO tipo_pesquisa(descricao) VALUES ('Induzida');
INSERT INTO tipo_pesquisa(descricao) VALUES ('Livre');

INSERT INTO formato_pesquisa(descricao) VALUES ('Telefone');
INSERT INTO formato_pesquisa(descricao) VALUES ('Presencial');


INSERT INTO pesquisa(instituto, data_pesquisa, media_idade, tipo_id, formato_id, local_pesquisa) VALUES ('IF', "2020-10-05", 35, 2, 2, 'Florianópolis');
INSERT INTO pesquisa(instituto, data_pesquisa, media_idade, tipo_id, formato_id, local_pesquisa) VALUES ('IEE', "2022-05-10", 27, 1, 2, 'São José');
INSERT INTO pesquisa(instituto, data_pesquisa, media_idade, tipo_id, formato_id, local_pesquisa) VALUES ('BTS', "2021-1-10", 50, 2, 1, 'Palhoça');

INSERT INTO candidato_pesquisa(candidato_id, pesquisa_id, votos) VALUES (1, 2, 5000);
INSERT INTO candidato_pesquisa(candidato_id, pesquisa_id, votos) VALUES (3, 1, 2000);
INSERT INTO candidato_pesquisa(candidato_id, pesquisa_id, votos) VALUES (2, 3, 8000);
