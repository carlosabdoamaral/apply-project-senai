package controller;

import java.util.List;

import dao.PesquisaDao;
import model.Pesquisa;

public class PesquisaController {
	
	public void salvar(Pesquisa pesquisa) throws Exception {
		if (pesquisa.getData() == null || pesquisa.getInstituto() == null) {
			throw new Exception("Dados da pesquisa incompletos!"); 
		}
		PesquisaDao.getInstance().save(pesquisa);
	}
	
	public void atualizar(Pesquisa pesquisa) throws Exception {
		if (pesquisa.getData() == null || pesquisa.getInstituto() == null) {
			throw new Exception("Dados da pesquisa incompletos!");
		}
		PesquisaDao.getInstance().update(pesquisa);
	}
	
	public void excluir(int idPesquisa) throws Exception {
		if (idPesquisa == 0) {
			throw new Exception("Nenhuma pesquisa selecionada!");
		}
		PesquisaDao.getInstance().delete(idPesquisa);
	}
	
	public List<Pesquisa> listar(){
		return PesquisaDao.getInstance().getList();
	}

}
