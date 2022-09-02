package controller;

import java.util.List;
import dao.FormatoPesquisaDao;
import model.FormatoPesquisa;

public class FormatoPesquisaController {
	
	public void salvar(FormatoPesquisa formato) throws Exception {
		if (formato.getDescricao() == null || formato.getDescricao().length() < 3){
			throw new Exception("Formato de pesquia inválido!"); 
		}
		FormatoPesquisaDao.getInstance().salvar(formato);
	}
	
	public void atualizar(FormatoPesquisa formato) throws Exception {
		if (formato.getDescricao() == null || formato.getDescricao().length() < 3) {
			throw new Exception("Formato de pesquisa inválido!");
		}
		FormatoPesquisaDao.getInstance().atualizar(formato); 
	}
	
	public void excluir(int idFormato) throws Exception {
		if (idFormato == 0) {
			throw new Exception("Nenhum formato de pesquisa selecionado!");
		}
		FormatoPesquisaDao.getInstance().excluir(idFormato);
	}
	
	public List<FormatoPesquisa> listar(){
		return FormatoPesquisaDao.getInstance().listar();
	}
}
