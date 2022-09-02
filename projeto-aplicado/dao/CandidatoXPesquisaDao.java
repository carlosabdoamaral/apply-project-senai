package dao;

import java.util.ArrayList;
import java.util.List;
import model.CandidatoXPesquisa;

public class CandidatoXPesquisaDao {
	private static CandidatoXPesquisaDao instance;
	private List<CandidatoXPesquisa> listaCandidatosxPesquisas = new ArrayList();
	
	public static CandidatoXPesquisaDao getInstance() {
		if (instance == null) {
			instance = new CandidatoXPesquisaDao();
		}
		return instance;
		
	}
	
	public void salvar(CandidatoXPesquisa candidatoxPesquisa) {
		listaCandidatosxPesquisas.add(candidatoxPesquisa);
		
	}

	public void atualizar(CandidatoXPesquisa candidatoxPesquisa) {
		listaCandidatosxPesquisas.set(candidatoxPesquisa.getId(),candidatoxPesquisa);
		
	}
	
	public void excluir(int idCandidatoxPesquisa) {
		listaCandidatosxPesquisas.remove(idCandidatoxPesquisa);
	}
	
	public List<CandidatoXPesquisa> listar(){
		return listaCandidatosxPesquisas;
	}



}

