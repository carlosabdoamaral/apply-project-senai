import java.sql.SQLException;
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
		Pesquisa pesquisa = new Pesquisa("UFSC", "20/10/2021", "Florianópolis - SC", 35, "Livre", "Presencial");
		
		CandidatoXPesquisa candidatoPesquisa = new CandidatoXPesquisa();
		candidatoPesquisa.setVotos(135000);
		candidatoPesquisa.setCandidato(candidato);
		candidatoPesquisa.setPesquisa(pesquisa);

		CandidatoXPesquisaController controllerCP = new CandidatoXPesquisaController();

		// Salvar
		try {
			controllerCP.salvar(pesquisa, candidato, candidatoPesquisa);
			System.out.println("CandidatoXPesquisa salvo com sucesso! " + candidatoPesquisa);
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}

		// Listar
		try {
			List<CandidatoXPesquisa> listaCxp = controllerCP.listar();
			System.out.println("Lista CandidatoXPesquisa: " + listaCxp);
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
		
		// Excluir
		try {
			controllerCP.excluir(1);
			System.out.println("ControlerXPesquisa removido com sucesso!");
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
	}
}
