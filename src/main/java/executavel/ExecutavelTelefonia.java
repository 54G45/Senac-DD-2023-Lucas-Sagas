package executavel;

import model.dao.telefonia.TelefoneDAO;
import model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		
		Telefone tel1 = new Telefone();
		TelefoneDAO telDAO = new TelefoneDAO();
		
		
		
		//metodo inserir telefone no DB
		if(telDAO.inserir(tel1) ){
			System.out.println("Telefone cadastrado com Sucesso!!!");
		}
		
		//metodo de consultar telefone no DB
		//o tal do metodo
		
		//metodo de atualizar Telefone no DB
		//o tal do metodo
		
		//metodo deletar telefone no DB
		//o tal do metodo
		
		
		
	}

}
