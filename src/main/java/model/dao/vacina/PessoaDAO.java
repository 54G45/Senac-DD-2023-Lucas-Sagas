package model.dao.vacina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.dao.Banco;
import model.vo.vacina.PessoaVO;

public class PessoaDAO {
	
	public boolean cadastrarPessoa(PessoaVO pessoa) {
		
		boolean deuBom = false;
		
		Connection conexao = Banco.getConnection();
		String sql = "insert into";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			
			query.setString(1, pessoa.getNome());
			query.setObject(2, pessoa.getDataNascimento());
			query.setString(3, String.valueOf(pessoa.getSexo()));
			query.setString(4, pessoa.getCpf());
			query.setString(5, pessoa.getTipo());
			
			ResultSet resultado = query.getGeneratedKeys();
			
			while(resultado.next()) {
				pessoa.setId(1);
			}
			
			deuBom = pessoa.getId() > 0;
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar vacina!" + "\nCausa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return deuBom;
		
	}
	
}
