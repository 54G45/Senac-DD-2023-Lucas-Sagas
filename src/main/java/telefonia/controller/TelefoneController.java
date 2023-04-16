package telefonia.controller;

import java.util.List;

import telefonia.model.bo.TelefoneBO;
import telefonia.model.vo.Telefone;

public class TelefoneController {

	private TelefoneBO bo = new TelefoneBO();
	
	public Telefone inserir(Telefone novoTelefone) {
		//TODO validar o preenchimento dos campos obrigatórios
		return bo.inserir(novoTelefone);
	}
	
	public boolean atualizar(Telefone telefoneAlterado) {
		//TODO validar o preenchimento dos campos obrigatórios
		return bo.atualizar(telefoneAlterado);
	}
	
	public boolean excluir(int id) {
		return bo.excluir(id);
	}
	
	public Telefone consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Telefone> consultarTodos() {
		return bo.consultarTodos();
	}
}
