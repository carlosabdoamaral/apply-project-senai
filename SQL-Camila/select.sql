-- ENUNCIADO: Todos os resultados de um ou todos os candidatos em uma ou todas as pesquisas 
-- OPÇÃO ESCOLHIDA: Todos os resultados de todos os candidatos em um pesquisa
SELECT * FROM candidate, search
WHERE search.id = '5';

-- Totalizar a quantidade de votos da pesquisa
SELECT SUM(vote) FROM candidate_and_search;

-- Totalizar a quantidade total de votos de um candidato em todas as pesquisas
SELECT SUM(vote) FROM candidate_and_search
WHERE id_candidate = 1;

-- Listar percentual de cada candidato em uma pesquisa
SELECT 
    id_candidate,
    (SUM(vote) / (SELECT 
            SUM(vote) AS total_votos
        FROM
            candidate_and_search AS cs
        WHERE
            cs.id_search = '2') * 100) AS f
FROM
    candidate_and_search AS cs
WHERE
    cs.id_search = '2'
GROUP BY cs.id_candidate;


