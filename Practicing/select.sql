-- Seleciona todos os resultados do João
SELECT 
    p.*
FROM
    pesquisa AS p,
    candidato_pesquisa AS cp,
    candidato AS c
WHERE
    c.nome = 'João'
        AND cp.candidato_id = c.id
        AND cp.pesquisa_id = p.id; 

-- Total de votos da pesquisa
SELECT 
    SUM(votos) AS total_votos
FROM
    candidato_pesquisa;

-- Total de votos somente do João    
SELECT 
    cp.votos
FROM
    candidato_pesquisa AS cp,
    candidato AS c
WHERE
    c.nome = 'João'
        AND cp.candidato_id = c.id; 
        
-- Porcentagem de cada candidato


