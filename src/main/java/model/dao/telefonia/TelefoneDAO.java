package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.telefonia.Telefone;

public class TelefoneDAO {

	public boolean inserir(Telefone tel1) {
		boolean deuBom = false;
		
		Connection conn = Banco.getConnection();
		String sql = "insert into "
				+ "telefone (idcliente, ddd, numero, ativo, movel)"
				+ "values (?, ?, ?, ?, ?) ";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conn, sql);
		
		try {
			query.setInt(1, tel1.getIdCliente());
			query.setString(2, tel1.getDdd());
			query.setString(3, tel1.getNumero());
			query.setBoolean(4, tel1.isAtivo());
			query.setBoolean(5, tel1.isMovel());
			query.execute();
			
			ResultSet resultado = query.getGeneratedKeys();
			
			if(resultado.next()) {
				tel1.setId(resultado.getInt(1));
			}
			
			deuBom = tel1.getId()>0;
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir telefone!"
					+ "\nCausa: " + e.getMessage());
		}
		
		
		
		
		
		return deuBom;
	}
	
	

}
