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
DROP FUNCTION IF EXISTS candidatePercentPerSearch(int);
CREATE OR REPLACE FUNCTION candidatePercentPerSearch(INT)
RETURNS TABLE (candidate_id INT, candidate_name VARCHAR(255), percentage FLOAT) AS $$

DECLARE
	currentCandidate record;
	searchVotesCount int;
	
	totalVotes int;	
	currentCandidateVoteCount int;
BEGIN
	SELECT SUM(vote) FROM candidate_and_search WHERE id_search = $1 INTO totalVotes;

	FOR currentCandidate IN (SELECT * FROM candidate_and_search WHERE id_search=$1) LOOP
		candidate_id := currentCandidate.id_candidate;
		SELECT name FROM candidate WHERE id=currentCandidate.id_candidate INTO candidate_name;
		
		SELECT vote FROM candidate_and_search WHERE id_search = $1 AND id_candidate = currentCandidate.id_candidate INTO currentCandidateVoteCount;
		
		percentage := (currentCandidateVoteCount * 100) / totalVotes;
		
		RETURN NEXT;
	END LOOP;
	
END;$$


LANGUAGE plpgsql;
select candidatePercentPerSearch(5);

SELECT * FROM candidate_and_search WHERE id_search = 5;