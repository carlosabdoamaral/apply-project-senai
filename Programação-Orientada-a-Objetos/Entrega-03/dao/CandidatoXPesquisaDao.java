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
	
	public void salvar(CandidatoXPesquisa candidatoxPesquisa) throws Exception {
		if (candidatoxPesquisa.getVotos() >= 0 && candidatoxPesquisa.getCandidato() != null && candidatoxPesquisa.getPesquisa() != null) {
			listaCandidatosxPesquisas.add(candidatoxPesquisa);
		} else {
			throw new Exception("Object must be full filled");
		}
	}

	public void atualizar(CandidatoXPesquisa candidatoxPesquisa) throws Exception {
		if (listaCandidatosxPesquisas.isEmpty()) {
			throw new Exception("List is empty");
		} else {
			int i = 0;
			for (CandidatoXPesquisa cxp : listaCandidatosxPesquisas) {
				if (cxp.getId() == candidatoxPesquisa.getId()) {
					listaCandidatosxPesquisas.set(i, candidatoxPesquisa);
					return;
				}

				i++;
			}
		}
	}
	
	public void excluir(CandidatoXPesquisa candidatoXPesquisa) throws Exception {
		if (listaCandidatosxPesquisas.isEmpty()) {
			throw new Exception("List is empty");
		} else {
			int i = 0;

			for (CandidatoXPesquisa cxp : listaCandidatosxPesquisas) {
				if (i == candidatoXPesquisa.getId()) {
					listaCandidatosxPesquisas.remove(i);
				}
			}
		}
	}
	
	public List<CandidatoXPesquisa> listar(){
		return listaCandidatosxPesquisas;
	}



}
