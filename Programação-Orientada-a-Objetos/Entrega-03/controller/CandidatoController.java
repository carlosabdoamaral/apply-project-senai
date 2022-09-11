package controller;

import java.util.List;

import dao.CandidatoDao;
import model.Candidato;

public class CandidatoController {
	
	public void salvar(Candidato candidato) throws Exception {
		CandidatoDao.getInstance().salvar(candidato);
	}
	
	public void atualizar(Candidato candidato) throws Exception {
		CandidatoDao.getInstance().atualizar(candidato); 
	}
	
	public void excluir(Candidato candidato) throws Exception {
		CandidatoDao.getInstance().excluir(candidato);
	}
	
	public List<Candidato> listar(){
		return CandidatoDao.getInstance().listar();
	}
}
