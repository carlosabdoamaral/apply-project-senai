package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Candidato;
import util.ConnectionUtil;

public class CandidatoDao {
	
	private static CandidatoDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static CandidatoDao getInstance() {		
		if (instance == null) {
			instance = new CandidatoDao();
		}
		return instance;
		
	}
	
	public Long salvar(Candidato candidato) {
		
		try {
			String sql = "insert into candidato (id, nome, partido, ficha_limpa) values (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, candidato.getId());
			pstmt.setString(2, candidato.getNome());
			pstmt.setString(3, candidato.getPartido());
			pstmt.setBoolean(4, candidato.getFichaLimpa());
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void atualizar(Candidato candidato) {
		
		try {
			String sql = "update candidato set id = ?, nome = ?, partido = ?, ficha_limpa = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, candidato.getId());
			pstmt.setString(2, candidato.getNome());
			pstmt.setString(3, candidato.getPartido());
			pstmt.setBoolean(4, candidato.getFichaLimpa());
			pstmt.setInt(5, candidato.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idCandidato) {
		
		try {
			String sql = "delete from candidato where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idCandidato);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Candidato> listar(){
		
		List<Candidato> listaCandidatos = new ArrayList();
		
		try {
			String sql = "select * from candidato";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Candidato c = new Candidato();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setPartido(rs.getString("partido"));
				c.setFichaLimpa(rs.getBoolean("ficha_limpa"));
				listaCandidatos.add(c);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaCandidatos;
	}



}
