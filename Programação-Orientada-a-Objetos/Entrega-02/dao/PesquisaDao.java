package dao;

import model.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class PesquisaDao {
	
	private static PesquisaDao instance;
	private List<Pesquisa> listaPesquisas = new ArrayList();
	
	public static PesquisaDao getInstance() {
		if (instance == null) {
			instance = new PesquisaDao();
		}
		return instance;
	}
	
	public void salvar(Pesquisa pesquisa) {
		listaPesquisas.add(pesquisa);
	}
	
	public void atualizar(Pesquisa pesquisa) {
		listaPesquisas.set(pesquisa.getId(), pesquisa);
	}
	
	public void excluir(int idPesquisa) {
		listaPesquisas.remove(idPesquisa);
		
	}
	
	public List<Pesquisa> listar(){
		return listaPesquisas;
	}
	

}
