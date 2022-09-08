package dao;

import java.util.ArrayList;
import java.util.List;
import model.Candidato;

public class CandidatoDao {
	private static CandidatoDao instance;
	private List<Candidato> listaCandidatos = new ArrayList<Candidato>();
	
	public static CandidatoDao getInstance() {
		if (instance == null) {
			instance = new CandidatoDao();
		}
		return instance;
		
	}
	
	public void salvar(Candidato candidato) {
		listaCandidatos.add(candidato);
		
	}

	public void atualizar(Candidato candidato) {
		listaCandidatos.set(candidato.getId(),candidato);
		
	}
	
	public void excluir(int idCandidato) {
		listaCandidatos.remove(idCandidato);
	}
	
	public List<Candidato> listar(){
		return listaCandidatos;
	}



}
