-- SELECT * FROM vote WHERE id_search=1;
-- SELECT id FROM vote ORDER BY id DESC LIMIT 1
-- SELECT * FROM vote WHERE id_search=1 and id_candidate=2


-- counter_pesquisa 			 - 100
-- votos_candidato_na_pesquisa  - x

-- Counter pesquisa
-- Total de votos em uma pesquisa
-- SELECT COUNT(*) FROM vote WHERE id_search=1;

-- Candidate votes in search
-- Total de votos do candidato em uma pesquisa
-- SELECT COUNT(id_candidate) FROM vote WHERE id_search=1 AND id_candidate=1;

-- Parametro 1: Id pesquisa
-- Parametro 2: Id candidato
DROP FUNCTION percentage(int, int);
CREATE OR REPLACE FUNCTION percentage(INT, INT)
RETURNS float AS $percent$
DECLARE
	percent float;
	counter_search int;
	candidate_votes int;
BEGIN
	SELECT COUNT(*) FROM vote WHERE id_search=$1 INTO counter_search;
	SELECT COUNT(id_candidate) FROM vote WHERE id_search=$1 AND id_candidate=$2 INTO candidate_votes;
	
	percent := (candidate_votes * 100) / counter_search;
	
	RETURN percent;
END;

$percent$ LANGUAGE plpgsql;

select percentage(1, 2)