package eleicao;

public class Main {
	
	public static void main(String[] args) {
		
		Candidato candidato1 = new Candidato(13, "Lula", "PT", true);
		Candidato candidato2 = new Candidato(22, "Bolsonaro", "Liberal", true);
		Candidato candidato3 = new Candidato(12, "Ciro Gomes", "PDT", true);	
		
		TipoPesquisa tipo1 = new TipoPesquisa(1, "LIVRE");
		TipoPesquisa tipo2 = new TipoPesquisa(2, "INDUZIDA");
		
		FormatoPesquisa formato1 = new FormatoPesquisa(1, "TELEFONE");
		FormatoPesquisa formato2 = new FormatoPesquisa(1, "PRESENCIAL");
		
		
		Pesquisa pesquisa1 = new Pesquisa(1, "IFSC", "24/10/2021", "Florianópolis", 32, tipo1, formato2);
		Pesquisa pesquisa2 = new Pesquisa(2, "UFSC", "16/07/2022", "Brasília", 45, tipo2, formato1);
		Pesquisa pesquisa3 = new Pesquisa(3, "UNIPAR", "08/11/2020", "Maringá", 26, tipo2, formato2);
		Pesquisa pesquisa4 = new Pesquisa(4, "PUC", "30/08/2019", "Cascavel", 18, tipo1, formato1);
		
		CandidatoPesquisa cp1 = new CandidatoPesquisa(1, 122000, candidato1, pesquisa2);
		CandidatoPesquisa cp2 = new CandidatoPesquisa(2, 105000, candidato2, pesquisa1);
		CandidatoPesquisa cp3 = new CandidatoPesquisa(3, 35000, candidato3, pesquisa3);
		CandidatoPesquisa cp4 = new CandidatoPesquisa(4, 50000, candidato3, pesquisa1);
		CandidatoPesquisa cp5 = new CandidatoPesquisa(5, 97000, candidato2, pesquisa3);
		CandidatoPesquisa cp6 = new CandidatoPesquisa(6, 102000, candidato1, pesquisa2);
		
	}

}
