package vacina.model.vo;

public enum EstagioVacina {
	inicial (1),
	teste (2),
	aplicEmMassa (3);
	
	private int valor;
	
	private EstagioVacina(int valor) 
	{
		this.valor = valor;
	}
	
	public int getValor()
	{
		return valor;
	}
	
	public static EstagioVacina getEstagioVacinaPorValor(int valor)
	{
		EstagioVacina estagioVacina = null;
		for(EstagioVacina elemento: EstagioVacina.values())
		{
			if(elemento.getValor() == valor)
			{
				estagioVacina = elemento;
			}
		}
		return estagioVacina;
	}
	
	
}
