package test;

import dao.CandidatoDao;
import model.Candidato;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CandidatoTest {
    Candidato candidate = new Candidato(1, "Candidate name", "Partido", true);

    @Test
    public void addCandidate_Succeed() throws Exception {
        CandidatoDao candidateDao = CandidatoDao.getInstance();
        candidateDao.salvar(candidate);

        List<Candidato> candidateListAfter = candidateDao.listar();
        Candidato lastIndexOfCandidateList = candidateListAfter.get(candidateListAfter.size() - 1);

        assertEquals(lastIndexOfCandidateList.getNome(), candidate.getNome());
        assertEquals(lastIndexOfCandidateList.getPartido(), candidate.getPartido());
        assertEquals(lastIndexOfCandidateList.getFichaLimpa(), candidate.getFichaLimpa());
    }


    @Test
    public void updateCandidate_Succeed() throws Exception {
        CandidatoDao candidateDao = CandidatoDao.getInstance();
        // Função só pode ser rodada se existir um candidato na lista
        // Primeiro rodar o salvar e depois atualizar
        Candidato updatedCandidate = new Candidato(1, "Updated name", "Partido", false);
        candidateDao.salvar(candidate);
        candidateDao.atualizar(updatedCandidate);

        Candidato objectFounded = null;

        List<Candidato> list = candidateDao.listar();
        for (Candidato c : list) {
            if (c.getId() == updatedCandidate.getId()) {
                objectFounded = c;
            }
        }

        Assert.assertNotNull(objectFounded);
        assertEquals(objectFounded.getNome(), updatedCandidate.getNome());
        assertEquals(objectFounded.getPartido(), updatedCandidate.getPartido());
        assertEquals(objectFounded.getFichaLimpa(), updatedCandidate.getFichaLimpa());
    }

    @Test
    public void updateCandidate_NotFound_Error() throws Exception {
        CandidatoDao candidateDao = CandidatoDao.getInstance();
        // Função só pode ser rodada se existir um candidato na lista
        // Primeiro rodar o salvar e depois atualizar
        Candidato updatedCandidate = new Candidato(0, "Updated name", "Partido", false);
        candidateDao.salvar(candidate);
        candidateDao.atualizar(updatedCandidate);

        Candidato objectFounded = null;

        List<Candidato> list = candidateDao.listar();
        for (Candidato c : list) {
            if (c.getId() == updatedCandidate.getId()) {
                objectFounded = c;
            }
        }

        Assert.assertNull(objectFounded);
    }

}
