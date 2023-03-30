package view;

import java.time.LocalDate;

import model.dao.vacina.PessoaDAO;
import model.vo.vacina.PessoaVO;
import model.vo.vacina.TipoPessoa;

public class ExecutavelVacina {

	public static void main(String[] args) {

//		VacinaVO vacinaVO = new VacinaVO("Brasil", 1, LocalDate.of(2023, 01, 01), "Giusepi");
//		VacinaDAO vacinaDAO = new VacinaDAO();
//		
//		if(vacinaDAO.cadastrarVacina(vacinaVO)) {
//			System.out.println("vacina cadastrada com sucesso");
//		}
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		PessoaVO pessoa = new PessoaVO("Giuseppi", LocalDate.of(2000, 01, 01), 'm', "10203040500", TipoPessoa.COMUN);
		
		
		if(pessoaDAO.cadastrarPessoa(pessoa)) {
			System.out.println("vacina cadastrada com sucesso");
		}
		
		
		
		System.out.println("fim do programa!");
	}
	
}
