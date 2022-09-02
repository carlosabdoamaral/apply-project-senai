package dao;

import java.util.ArrayList;
import java.util.List;
import model.TipoPesquisa;

public class TipoPesquisaDao {
	
	private static TipoPesquisaDao instance;
	private List<TipoPesquisa> listaTipos = new ArrayList();
	
	public static TipoPesquisaDao getInstance() {
		if (instance == null) {
			instance = new TipoPesquisaDao();
		}
		return instance;
	}
	
	public void salvar(TipoPesquisa tipoPesquisa) {
		listaTipos.add(tipoPesquisa);
	}
	
	public void atualizar(TipoPesquisa tipoPesquisa) {
		listaTipos.set(tipoPesquisa.getId(), tipoPesquisa);
	}
	
	public void excluir(int idTipoPesquisa) {
		listaTipos.remove(idTipoPesquisa);
	}
	
	public List<TipoPesquisa> listar() {
		return listaTipos;
	}

}

