package model.vo.vacina;

import java.time.LocalDate;


public class PessoaVO {

	private int id;
	private String nome;
	private LocalDate dataNascimento;
	private char sexo;
	private String cpf;
	private TipoPessoa tipo;
	
	public PessoaVO() {
		super();
	}

	public PessoaVO(int id, String nome, LocalDate dataNascimento, char sexo, String cpf, TipoPessoa tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.tipo = tipo;
	}
	
	public PessoaVO(String nome, LocalDate dataNascimento, char sexo, String cpf, TipoPessoa tipo) {
		super();
		this.id = 0;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	
	
	
	
}