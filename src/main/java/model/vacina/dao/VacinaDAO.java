package model.vacina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Banco;
import model.vacina.vo.Pessoa;
import model.vacina.vo.TipoPessoa;
import model.vacina.vo.Vacina;

public class VacinaDAO {
	
	public boolean cadastrarVacina(Vacina vacina) {
		
		boolean deuBom = false;
		
		Connection conexao = Banco.getConnection();
		String sql = " insert into vacina () values (?, ?, ?, ?) ";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			
			query.setString(1, vacina.getPaisOrigem());
			query.setInt(2, 1);
			query.setObject(3, vacina.getInicioPesquisa());
			query.setObject(4, vacina.getPesquisadorResponsavel());
			query.execute();
			
			ResultSet resultado = query.getGeneratedKeys();
			
			while(resultado.next()) {
				vacina.setId(resultado.getInt(1));
			}
			
			deuBom = vacina.getId() > 0;
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar vacina!" + "\nCausa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return deuBom;
		
	}
	
	public Pessoa consultarVacinaPorId(int id) {

		Pessoa vacina = null;

		Connection conexao = Banco.getConnection();
		String sql = " select * from vacina where id = ? ";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);

		try {

			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();

			if (resultado.next()) {
				vacina = converterDeResultSetParaEntidade(resultado);
			}

		} catch (SQLException erro) {
			erro.getMessage();
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return vacina;
	}

	public List<Pessoa> consultarPessoaTodos() {

		Pessoa pessoa = null;

		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

		Connection conexao = Banco.getConnection();
		String sql = " select * from pessoa ";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		ResultSet resultado = null;
		try {
			resultado = query.executeQuery(sql);
			while (resultado.next()) {

				pessoa = converterDeResultSetParaEntidade(resultado);
				listaPessoas.add(pessoa);

			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}

		return listaPessoas;
	}

	private Pessoa converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {

		Pessoa vacina = new Pessoa();

		vacina.setId(resultado.getInt("id"));
		vacina.setNome(resultado.getString("nome"));
		vacina.setDataNascimento(resultado.getDate("data").toLocalDate());
		vacina.setSexo(resultado.getString(0).charAt(0));
		vacina.setCpf(resultado.getString("cpf"));
		vacina.setTipo(TipoPessoa.getTipoPessoaPorValor(resultado.getInt("tipo")));

		return vacina;
	}

	public boolean atualizarPessoa(Pessoa pessoa) {
		
		boolean deuBom = false;

		Connection conexao = Banco.getConnection();
		String sql = " update pessoa set nome = ?, dataNascimento = ?, sexo = ?, cpf = ?, tipo = ? where id = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {

			query.setString(1, pessoa.getNome());
			query.setObject(2, pessoa.getDataNascimento());
			query.setString(3, String.valueOf(pessoa.getSexo()));
			query.setString(4, pessoa.getCpf());
			query.setInt(5, pessoa.getTipo().getValor());
			query.setInt(6, pessoa.getId());
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			deuBom = quantidadeLinhasAtualizadas > 0;

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar pessoa!" + "\nCausa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return deuBom;
		

	}

	public boolean escluirPessoa(int id) {

		boolean deuBom = false;
		Connection conexao = Banco.getConnection();
		String sql = "delete from pessoa where id = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			
			query.setInt(1, id);
			deuBom = query.executeUpdate() > 0;
			
		} catch (SQLException e) {
			
			System.out.println("Erro no método excluir da classe PessoaDAO");
			System.out.println(e.getMessage());
			
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return deuBom;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
