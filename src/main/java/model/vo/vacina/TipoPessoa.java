package model.vo.vacina;

public enum TipoPessoa {
	pesquisador (1),
	voluntario (2),
	COMUN (3);
	
	private int valor;
	
	private TipoPessoa(int valor) 
	{
		this.valor = valor;
	}
	
	public int getValor()
	{
		return valor;
	}
	
	public static TipoPessoa getTipoPessoaPorValor(int valor)
	{
		TipoPessoa tipoPessoa = null;
		for(TipoPessoa elemento: TipoPessoa.values())
		{
			if(elemento.getValor() == valor)
			{
				tipoPessoa = elemento;
			}
		}
		return tipoPessoa;
	}
	
	
}
