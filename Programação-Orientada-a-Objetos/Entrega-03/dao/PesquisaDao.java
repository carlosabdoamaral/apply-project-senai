package dao;


import model.Candidato;
import model.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class PesquisaDao {
    private static PesquisaDao instance;

    private List<Pesquisa> listaDePesquisas = new ArrayList<>();

    public static PesquisaDao getInstance() {
        if (instance == null) {
            instance = new PesquisaDao();
        }

        return instance;
    }

    public void salvar(Pesquisa pesquisa) throws Exception {
        if (
                !pesquisa.getInstituto().isEmpty()
                && !pesquisa.getLocal().isEmpty()
                && pesquisa.getIdadeMedia() > 16 //Idade mínima para votar
                && !pesquisa.getTipoPesquisa().isEmpty()
                && !pesquisa.getFormatoPesquisa().isEmpty()
        ) {
            listaDePesquisas.add(pesquisa);
            return;
        } else {
            throw new Exception("Object must be full filled");
        }
    }

    public void atualizar(Pesquisa pesquisa) throws Exception{
        if (listaDePesquisas.isEmpty()) {
            throw new Exception("List is empty");
        } else {
            int i = 0;

            for (Pesquisa p : listaDePesquisas) {
                if (i == pesquisa.getId()) {
                    listaDePesquisas.set(i, pesquisa);
                }
            }
        }
    }

    public void excluir(Pesquisa pesquisa) throws Exception {
        if (listaDePesquisas.isEmpty()) {
            throw new Exception("List is empty");
        } else {
            int i = 0;

            for (Pesquisa p : listaDePesquisas) {
                if (i == pesquisa.getId()) {
                    listaDePesquisas.remove(i);
                }
            }
        }
    }

    public List<Pesquisa> listar() { return listaDePesquisas; }
}
