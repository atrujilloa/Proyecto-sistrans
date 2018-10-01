package superandes.negocio;

public class Supermercado implements VOSupermercado {

	
	/* *************************************************************
	*  Atributos
	**************************************************************/
	
	/**
	 * id supermercado
	 */
	
	private String idSupermercado;

	
	public Supermercado() {
		this.idSupermercado = "";
	}
	
	public Supermercado(String idSupermercado)
	{
		this.idSupermercado = idSupermercado;
	}
	
	
	
	@Override
	public String getIdSupermercado() {
		// TODO Auto-generated method stub
		return idSupermercado;
	}
	
	public String toString()
	{
		return "Supermercado [ id = " + idSupermercado + "]";
	}
	
}
