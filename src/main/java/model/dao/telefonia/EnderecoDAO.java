package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.telefonia.Endereco;

public class EnderecoDAO {
	
	/**
	 * Insere um novo Endereço no Banco
	 * @param novoEndereco o endereco a ser persistido
	 * @return o endereco inserido com a chave primaria gerada
	 */
	public Endereco inserir(Endereco novoEndereco) {
		
		Connection conexao = Banco.getConnection();
		String sql = " insert into endereco (cep, numero, rua, bairro, cidade, estado) values (?,?,?,?,?,?) ";
		
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			query.setString(1, novoEndereco.getCep());
			query.setString(2, novoEndereco.getNumero());
			query.setString(3, novoEndereco.getRua());
			query.setString(4, novoEndereco.getBairro());
			query.setString(5, novoEndereco.getCidade());
			query.setString(6, novoEndereco.getEstado());
		} catch (SQLException e) {

			System.out.println("Erro ao inserir endereco."
			
					+ "\nCausa: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return novoEndereco;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
