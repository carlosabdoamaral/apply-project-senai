package controller;

import java.util.List;

import dao.PesquisaDao;
import model.Pesquisa;

public class PesquisaController {
	
	public void salvar(Pesquisa pesquisa) throws Exception {
		PesquisaDao.getInstance().salvar(pesquisa);
	}
	
	public void atualizar(Pesquisa pesquisa) throws Exception {
		PesquisaDao.getInstance().atualizar(pesquisa);
	}
	
	public void excluir(Pesquisa pesquisa) throws Exception {
		PesquisaDao.getInstance().excluir(pesquisa);
	}
	
	public List<Pesquisa> listar(){
		return PesquisaDao.getInstance().listar();
	}

}
