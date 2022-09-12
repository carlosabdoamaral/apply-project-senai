package controller;

import java.util.List;

import dao.CandidatoXPesquisaDao;
import model.Candidato;
import model.CandidatoXPesquisa;
import model.Pesquisa;

public class CandidatoXPesquisaController {

	public void salvar(Pesquisa pesquisa, Candidato candidato, CandidatoXPesquisa cxp) throws Exception {
		if (cxp.getCandidato() == null || cxp.getPesquisa() == null || cxp.getVotos() == 0) {
			throw new Exception("Um ou mais atributos faltando!");
		}
		CandidatoXPesquisaDao.getInstance().salvar(pesquisa, candidato, cxp);
	}

	public void atualizar(CandidatoXPesquisa cxp) throws Exception {
		if (cxp.getCandidato() == null || cxp.getPesquisa() == null || cxp.getVotos() == 0) {
			throw new Exception("Um ou mais atributos inválidos!");
		}
		CandidatoXPesquisaDao.getInstance().atualizar(cxp);
	}

	public void excluir(int idCxp) throws Exception {
		if (idCxp == 0) {
			throw new Exception("Nenhum item selecionado!");
		}
		CandidatoXPesquisaDao.getInstance().excluir(idCxp);
	}

	public List<CandidatoXPesquisa> listar() {
		return CandidatoXPesquisaDao.getInstance().listar();
	}
}
