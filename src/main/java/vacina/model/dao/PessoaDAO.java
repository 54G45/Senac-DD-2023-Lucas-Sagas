package vacina.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import telefonia.model.dao.Banco;
import vacina.model.vo.Pessoa;
import vacina.model.vo.TipoPessoa;

public class PessoaDAO {

	public boolean cadastrarPessoa(Pessoa pessoa) {

		boolean deuBom = false;

		Connection conexao = Banco.getConnection();
		String sql = " insert into pessoa(nome, dataNascimento, sexo, cpf, tipo) values(?, ?, ?, ?, ?) ";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);

		try {

			query.setString(1, pessoa.getNome());
			query.setObject(2, pessoa.getDataNascimento());
			query.setString(3, String.valueOf(pessoa.getSexo()));
			query.setString(4, pessoa.getCpf());
			query.setInt(5, pessoa.getTipo().getValor());
			query.execute();

			ResultSet resultado = query.getGeneratedKeys();

			while (resultado.next()) {
				pessoa.setId(resultado.getInt(1));
			}

			deuBom = pessoa.getId() > 0;

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar pessoa!" + "\nCausa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return deuBom;

	}

	public Pessoa consultarPessoaPorId(int id) {

		Pessoa pessoa = null;

		Connection conexao = Banco.getConnection();
		String sql = " select * from pessoa where id = ? ";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);

		try {

			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();

			if (resultado.next()) {
				pessoa = converterDeResultSetParaEntidade(resultado);
			}

		} catch (SQLException erro) {
			erro.getMessage();
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return pessoa;
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

		Pessoa pessoa = new Pessoa();

		pessoa.setId(resultado.getInt("id"));
		pessoa.setNome(resultado.getString("nome"));
		pessoa.setDataNascimento(resultado.getDate("data").toLocalDate());
		pessoa.setSexo(resultado.getString(0).charAt(0));
		pessoa.setCpf(resultado.getString("cpf"));
		pessoa.setTipo(TipoPessoa.getTipoPessoaPorValor(resultado.getInt("tipo")));

		return pessoa;
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
