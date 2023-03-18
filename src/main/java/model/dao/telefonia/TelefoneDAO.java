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
		String sql = " insert into " + " telefone (idcliente, ddd, numero, ativo, movel) " + " values (?, ?, ?, ?, ?) ";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conn, sql);

		try {
			query.setInt(1, tel1.getIdCliente());
			query.setString(2, tel1.getDdd());
			query.setString(3, tel1.getNumero());
			query.setBoolean(4, tel1.isAtivo());
			query.setBoolean(5, tel1.isMovel());
			query.execute();

			ResultSet resultado = query.getGeneratedKeys();

			if (resultado.next()) {
				tel1.setId(resultado.getInt(1));
			}

			deuBom = tel1.getId() > 0;

		} catch (SQLException e) {
			System.out.println("Erro ao inserir telefone!" + "\nCausa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);
		}

		return deuBom;
	}

	public void consultarTelefoneDAO(int id) {

		Connection conn = Banco.getConnection();
		String sql = " select * from telefone where id = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);

		try {

			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				
				Telefone telefone = new Telefone();
				telefone.setId(resultado.getInt("id"));
				telefone.setIdCliente(resultado.getInt("idcliente"));
				telefone.setDdd(resultado.getString("ddd"));
				telefone.setNumero(resultado.getString("numero"));
				telefone.setAtivo(resultado.getBoolean("ativo"));
				telefone.setMovel(resultado.getBoolean("movel"));
				
			}

		} catch (SQLException e) {
			System.out.println("Erro ao buscar telefone com id: + " + id + "\n Causa: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
