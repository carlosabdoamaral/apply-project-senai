package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
import model.CandidatoXPesquisa;
import model.Pesquisa;
import util.ConnectionUtil;

public class CandidatoXPesquisaDao {
	private static CandidatoXPesquisaDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static CandidatoXPesquisaDao getInstance() {
		if (instance == null) {
			instance = new CandidatoXPesquisaDao();
		}
		return instance;
		
	}
	
	public void salvar(Pesquisa pesquisa, Candidato candidato, CandidatoXPesquisa cxp) {
		try {
			String sqlCandidato = "insert into candidato (nome, partido, ficha_limpa) values (?, ?, ?)";
			PreparedStatement pstmtCandidato = con.prepareStatement(sqlCandidato, Statement.RETURN_GENERATED_KEYS);
			pstmtCandidato.setString(1, candidato.getNome());
			pstmtCandidato.setString(2, candidato.getPartido());
			pstmtCandidato.setBoolean(3, candidato.getFichaLimpa());

			int keyC = pstmtCandidato.executeUpdate();

			String sqlPesquisa = "insert into pesquisa (instituto, data_pesquisa, local_pesquisa, media_idade, tipo_pesquisa, formato_pesquisa) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmtPesquisa = con.prepareStatement(sqlPesquisa, Statement.RETURN_GENERATED_KEYS);
			pstmtPesquisa.setString(1, pesquisa.getInstituto());
			pstmtPesquisa.setString(2, pesquisa.getData());
			pstmtPesquisa.setString(3, pesquisa.getLocal());
			pstmtPesquisa.setInt(4, pesquisa.getIdadeMedia());
			pstmtPesquisa.setString(5, pesquisa.getTipoPesquisa());
			pstmtPesquisa.setString(6, pesquisa.getFormatoPesquisa());
			
			int keyP = pstmtPesquisa.executeUpdate();
			
			if (keyC > 0 && keyP > 0) {
				ResultSet rsC = pstmtCandidato.getGeneratedKeys();
				rsC.next();
				int idC = rsC.getInt(1);
				
				ResultSet rsP = pstmtPesquisa.getGeneratedKeys();
				rsP.next();
				int idP = rsP.getInt(1);
				
				String sql = "insert into candidato_pesquisa (votos, candidato_id, pesquisa_id) values (?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cxp.getVotos());
				pstmt.setInt(2, idC);
				pstmt.setInt(3, idP);
				pstmt.execute();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void atualizar(CandidatoXPesquisa cxp) {
		
		try {
			String sql = "update candidato_pesquisa set id = ?, votos = ?, candidato_id = ?, pesquisa_id = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cxp.getId());
			pstmt.setInt(2, cxp.getVotos());
			pstmt.setObject(3, cxp.getCandidato());
			pstmt.setObject(4, cxp.getPesquisa());
			pstmt.setInt(5, cxp.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idCxp) {
		
		try {
			String sql = "delete from candidato_pesquisa where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, idCxp);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<CandidatoXPesquisa> listar() {
		List<CandidatoXPesquisa> listaCandidatoXPesquisa = new ArrayList();

		try {
			String sql = "select * from candidato_pesquisa";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CandidatoXPesquisa cxp = new CandidatoXPesquisa();
				cxp.setId(rs.getInt("id"));
				cxp.setVotos(rs.getInt("votos"));

				String sqlCandidato = "select * from candidato where id = ?";
				PreparedStatement stmtCandidato = con.prepareStatement(sqlCandidato);
				stmtCandidato.setInt(1, rs.getInt("candidato_id"));
				ResultSet rsCandidato = stmtCandidato.executeQuery();
				rsCandidato.next();

				Candidato c = new Candidato();
				c.setId(rsCandidato.getInt("id"));
				c.setNome(rsCandidato.getString("nome"));
				c.setPartido(rsCandidato.getString("partido"));
				c.setFichaLimpa(rsCandidato.getBoolean("ficha_limpa"));

				String sqlPesquisa = "select * from pesquisa where id = ?";
				PreparedStatement stmtPesquisa = con.prepareStatement(sqlPesquisa);
				stmtPesquisa.setInt(1, rs.getInt("pesquisa_id"));
				ResultSet rsPesquisa = stmtPesquisa.executeQuery();
				rsPesquisa.next();

				Pesquisa p = new Pesquisa();
				p.setId(rsPesquisa.getInt("id"));
				p.setInstituto(rsPesquisa.getString("instituto"));
				p.setData(rsPesquisa.getString("data_pesquisa"));
				p.setLocal(rsPesquisa.getString("local_pesquisa"));
				p.setIdadeMedia(rsPesquisa.getInt("media_idade"));
				p.setTipoPesquisa(rsPesquisa.getString("tipo_pesquisa"));
				p.setFormatoPesquisa(rsPesquisa.getString("formato_pesquisa"));

				cxp.setCandidato(c);
				cxp.setPesquisa(p);

				listaCandidatoXPesquisa.add(cxp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaCandidatoXPesquisa;
	}
}
