package dao;

import java.util.ArrayList;
import java.util.List;
import model.Candidato;

public class CandidatoDao {
	private static CandidatoDao instance;
	private List<Candidato> listaDeCandidatos = new ArrayList<Candidato>();
	
	public static CandidatoDao getInstance() {
		if (instance == null) {
			instance = new CandidatoDao();
		}
		return instance;
		
	}
	
	public void salvar(Candidato candidato) throws Exception {
		if (candidato.getId() >= 0 && !candidato.getNome().isEmpty() && !candidato.getPartido().isEmpty()) {
			listaDeCandidatos.add(candidato);
		} else {
			throw new Exception("Object must be full filled");
		}
	}

	public void atualizar(Candidato candidato) throws Exception {
		if (listaDeCandidatos.isEmpty()) {
			throw new Exception("Candidate list doesn't have any object registered");
		} else {
			int i = 0;
			for (Candidato c : listaDeCandidatos) {
				if (c.getId() == candidato.getId()) {
					listaDeCandidatos.set(i, candidato);
					return;
				}

				i++;
			}
		}
	}
	
	public void excluir(Candidato candidato) throws Exception {
		if (listaDeCandidatos.size() == 0) {
			throw new Exception("List is empty");
		} else {
			int i = 0;

			for (Candidato c : listaDeCandidatos) {
				if (i == candidato.getId()) {
					listaDeCandidatos.remove(c);
					return;
				}

				i++;
			}
		}
	}
	
	public List<Candidato> listar(){
		return listaDeCandidatos;
	}



}
