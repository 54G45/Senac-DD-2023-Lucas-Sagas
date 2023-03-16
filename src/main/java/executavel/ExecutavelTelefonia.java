package executavel;

import model.dao.telefonia.TelefoneDAO;
import model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		
		Telefone tel1 = new Telefone();
		TelefoneDAO telDAO = new TelefoneDAO();
		
		
		
		//metodo inserir telefone na tabela
		if(telDAO.inserir(tel1) ){
			System.out.println("Telefone cadastrado com Sucesso!!!");
		}
		
		//metodo
		//o tal do metodo
		
		//metodo
		//o tal do metodo
		
		//metodo
		//o tal do metodo
		
		
		
	}

}
