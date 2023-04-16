package vacina.model.vo;

import java.time.LocalDate;

public class Vacina {

	private int id;
	private String paisOrigem;
	private EstagioVacina estagioPesquisa;
	private LocalDate inicioPesquisa;
	private Pessoa pesquisadorResponsavel;
	
	public Vacina() {
		super();
	}
	
	public Vacina(int id, String paisOrigem, EstagioVacina estagioPesquisa, LocalDate inicioPesquisa,
			Pessoa pesquisadorResponsavel) {
		super();
		this.id = id;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.inicioPesquisa = inicioPesquisa;
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	public EstagioVacina getEstagioPesquisa() {
		return estagioPesquisa;
	}
	public void setEstagioPesquisa(EstagioVacina estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}
	public LocalDate getInicioPesquisa() {
		return inicioPesquisa;
	}
	public void setInicioPesquisa(LocalDate inicioPesquisa) {
		this.inicioPesquisa = inicioPesquisa;
	}
	public Pessoa getPesquisadorResponsavel() {
		return pesquisadorResponsavel;
	}
	public void setPesquisadorResponsavel(Pessoa pesquisadorResponsavel) {
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}
	

}