package superandes.negocio;

public class Supermercado implements VOSupermercado {

	
	/* *************************************************************
	*  Atributos
	**************************************************************/
	
	/**
	 * id supermercado
	 */
	
	private long idSupermercado;

	//---------------------------- Constructor -----------------------------//
	
	public Supermercado() {
		this.idSupermercado = 0;
	}
	
	public Supermercado(long idSupermercado)
	{
		this.idSupermercado = idSupermercado;
	}	
	
	//--------------------------------- Métodos -------------------------------------//
	@Override
	public long getIdSupermercado() {
		// TODO Auto-generated method stub
		return idSupermercado;
	}
	
	public void setIdSupermercado(long id)
	{
		this.idSupermercado = id;
	}
	
	public String toString()
	{
		return "Supermercado [ id = " + idSupermercado + "]";
	}
	
}
