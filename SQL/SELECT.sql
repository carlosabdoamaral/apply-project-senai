-- Select 01 A
SELECT * FROM candidate_and_search 
WHERE id_candidate = 1 and id_search = 5;

-- Select 01 B
SELECT * FROM candidate_and_search
WHERE id_search = 5;

-- Select 01 C
SELECT * FROM candidate_and_search
WHERE id_candidate = 1;


-- Select 02
SELECT COUNT(*) FROM candidate_and_search


-- Select 03
SELECT SUM(vote) FROM candidate_and_search
WHERE id_candidate = 1;


-- Select 04
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