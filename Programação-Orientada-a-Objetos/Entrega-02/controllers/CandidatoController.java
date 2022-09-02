package controller;

import java.util.List;

import dao.CandidatoDao;
import model.Candidato;

public class CandidatoController {
	
	public void salvar(Candidato candidato) throws Exception {
		if (candidato.getNome() == null || candidato.getNome().length() < 3 || candidato.getPartido() == null) {
			throw new Exception("Nome do candidato e/ou Partido inválidos!"); 
		}
		CandidatoDao.getInstance().salvar(candidato);
	}
	
	public void atualizar(Candidato candidato) throws Exception {
		if (candidato.getNome() == null || candidato.getNome().length() < 3 || candidato.getPartido() == null) {
			throw new Exception("Nome do candidato e/ou partido inválidos!");
		}
		CandidatoDao.getInstance().atualizar(candidato); 
	}
	
	public void excluir(int idCandidato) throws Exception {
		if (idCandidato == 0) {
			throw new Exception("Nenhum candidato selecionado!");
		}
		CandidatoDao.getInstance().excluir(idCandidato);
	}
	
	public List<Candidato> listar(){
		return CandidatoDao.getInstance().listar();
	}

}
