package dao;

import java.util.ArrayList;
import java.util.List;
import model.FormatoPesquisa;

public class FormatoPesquisaDao {
	
	private static FormatoPesquisaDao instance;
	private List<FormatoPesquisa> listaFormatos = new ArrayList();
	
	public static FormatoPesquisaDao getInstance() {
		if (instance == null) {
			instance = new FormatoPesquisaDao();
		}
		return instance;
	}
	
	public void salvar(FormatoPesquisa formato) {
		listaFormatos.add(formato);
	}
	
	public void atualizar(FormatoPesquisa formato) {
		listaFormatos.set(formato.getId(), formato);
	}
	
	public void excluir(int idFormato) {
		listaFormatos.remove(idFormato);
	}
	
	public List<FormatoPesquisa> listar() {
		return listaFormatos;
	}

}
