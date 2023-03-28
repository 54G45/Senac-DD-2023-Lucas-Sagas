package executavel;

import java.time.LocalDate;

import model.dao.vacina.VacinaDAO;
import model.vo.vacina.VacinaVO;

public class ExecutavelVacina {

	public static void main(String[] args) {

		VacinaVO vacinaVO = new VacinaVO("Brasil", 1, LocalDate.of(2023, 01, 01), "Giusepi");
		VacinaDAO vacinaDAO = new VacinaDAO();
		
		if(vacinaDAO.cadastrarVacina(vacinaVO)) {
			System.out.println("vacina cadastrada com sucesso");
		}
		
		System.out.println("fim do programa!");
		
	}

}
