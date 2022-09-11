package controller;

import java.util.List;

import dao.CandidatoXPesquisaDao;
import model.CandidatoXPesquisa;

public class CandidatoXPesquisaController {
	
	public void salvar(CandidatoXPesquisa cxp) throws Exception {
		CandidatoXPesquisaDao.getInstance().salvar(cxp);
	}
	
	public void atualizar(CandidatoXPesquisa cxp) throws Exception {
		CandidatoXPesquisaDao.getInstance().atualizar(cxp); 
	}
	
	public void excluir(CandidatoXPesquisa cxp) throws Exception {
		CandidatoXPesquisaDao.getInstance().excluir(cxp);
	}
	
	public List<CandidatoXPesquisa> listar(){
		return CandidatoXPesquisaDao.getInstance().listar();
	}

}
