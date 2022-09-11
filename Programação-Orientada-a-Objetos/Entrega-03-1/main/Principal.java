import java.util.List;

import controller.CandidatoController;
import controller.CandidatoXPesquisaController;
import controller.PesquisaController;
import model.Candidato;
import model.CandidatoXPesquisa;
import model.Pesquisa;

public class Main {
	
	public static void main(String[] args) {
    Candidato candidato = new Candidato("Lula", "PT", true);
		
		Pesquisa pesquisa = new Pesquisa();
		pesquisa.setInstituto("UFSC");
		pesquisa.setData("20/10/2021");
		pesquisa.setLocal("Florianópolis - SC");
		pesquisa.setIdadeMedia(35);
		pesquisa.setTipoPesquisa("Livre");
		pesquisa.setFormatoPesquisa("Presencial");
		
		CandidatoXPesquisa candidatoPesquisa = new CandidatoXPesquisa();
		candidatoPesquisa.setVotos(135000);
		candidatoPesquisa.setCandidato(candidato);
		candidatoPesquisa.setPesquisa(pesquisa);
		
		CandidatoXPesquisaController controllerCP = new CandidatoXPesquisaController();
		try {
			controllerCP.salvar(pesquisa, candidato, candidatoPesquisa);
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
	}

}
