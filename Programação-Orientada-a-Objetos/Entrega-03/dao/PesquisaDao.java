package dao;


import model.Candidato;
import model.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class PesquisaDao {
    private static PesquisaDao instance;

    private List<Pesquisa> searchList = new ArrayList<>();

    public static PesquisaDao getInstance() {
        if (instance == null) {
            instance = new PesquisaDao();
        }

        return instance;
    }

    public boolean save(Pesquisa pesquisa) {
        try {
            searchList.add(pesquisa);
            return true;
        } catch (Error e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public boolean update(Pesquisa pesquisa) {
        try {
            searchList.set(pesquisa.getId(), pesquisa);
            return true;
        } catch (Error e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public boolean delete(int searchID) {
        try {
            searchList.remove(searchID);
            return true;
        } catch (Error e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public List<Pesquisa> getList() { return searchList; }
}
