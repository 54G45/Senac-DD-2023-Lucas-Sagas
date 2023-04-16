package telefonia.model.bo;

import java.util.List;

import telefonia.model.dao.ClienteDAO;
import telefonia.model.dao.EnderecoDAO;
import telefonia.model.exception.EnderecoInvalidoException;
import telefonia.model.vo.Endereco;

public class EnderecoBO {

	private EnderecoDAO dao = new EnderecoDAO();
	
	public Endereco inserir(Endereco novoEndereco) {
		return dao.inserir(novoEndereco);
	}
	
	public boolean atualizar(Endereco enderecoAlterado){
		return dao.atualizar(enderecoAlterado);
	}
	
	public boolean excluir(int id) throws EnderecoInvalidoException {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		if(clienteDAO.contarClientesQueResidemNoEndereco(id) > 0) {
			throw new EnderecoInvalidoException("Endereço não pode ser excluído, pois possui cliente(s) associado(s)");
		}
		
		return dao.excluir(id);
	}
	
	public Endereco consultarPorCep(String cep) {
		//TODO chamar viaCep
		// https://gitlab.com/parg/ViaCEP
		return null;
	}
	
	public Endereco consultarPorId(int id) {
		return dao.consultarPorId(id);
	}
	
	public List<Endereco> consultarTodos() {
		return dao.consultarTodos();
	}
}
