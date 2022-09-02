package controller;

import java.util.List;

import dao.TipoPesquisaDao;
import model.TipoPesquisa;

public class TipoPesquisaController {

	public void salvar(TipoPesquisa tipo) throws Exception {
		if (tipo.getDescricao() == null || tipo.getDescricao().length() < 3){
			throw new Exception("Tipo de pesquia inválido!"); 
		}
		TipoPesquisaDao.getInstance().salvar(tipo);
	}
	
	public void atualizar(TipoPesquisa tipo) throws Exception {
		if (tipo.getDescricao() == null || tipo.getDescricao().length() < 3) {
			throw new Exception("Tipo de pesquisa inválido!");
		}
		TipoPesquisaDao.getInstance().atualizar(tipo); 
	}
	
	public void excluir(int idTipo) throws Exception {
		if (idTipo == 0) {
			throw new Exception("Nenhum tipo de pesquisa selecionado!");
		}
		TipoPesquisaDao.getInstance().excluir(idTipo);
	}
	
	public List<TipoPesquisa> listar(){
		return TipoPesquisaDao.getInstance().listar();
	}
}
