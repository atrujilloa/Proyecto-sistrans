package superandes.negocio;

public class Estante implements VOEstante{

	
	/* *********************************************************
	 * Atributos
	 ***********************************************************/
	
	/**
	 * Nivel abastecimiento estante 
	 */
	private int nivelAbastecimiento;
	
	/**
	 * 
	 */
	
	private String idCategoria;
	private String idSucursal;
	
	private String idEstante;

	public Estante() {
		this.nivelAbastecimiento = 0;
		this.idSucursal = "";
		this.idEstante ="";
	}
	
	public Estante(int nivelAbastecimiento, String idSucursal, String idEstante)
	{
		this.nivelAbastecimiento = nivelAbastecimiento;
		this.idSucursal = idSucursal;
		this.idEstante = idEstante;
	}
	
	@Override
	public int getNivelAbastecimiento() {
		// TODO Auto-generated method stub
		return nivelAbastecimiento;
	}
	
	public void setNivelAbastecimiento(int nivel)
	{
		this.nivelAbastecimiento = nivel;
	}

	@Override
	public String getIdSucursal() {
		// TODO Auto-generated method stub
		return idSucursal;
	}
	
	public void setIdSucursal(String id)
	{
		this.idSucursal = id;
	}

	@Override
	public String getIdEstante() {
		// TODO Auto-generated method stub
		return idEstante;
	}
	
	public void setIdEstante(String id)
	{
		this.idEstante = id;
	}
	
	@Override
	public String getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria( String id)
	{
		this.idCategoria = id;
	}
	
	public String toString()
	{
		return "Estante [ id =" + idEstante + "nivel abastecimiento" + nivelAbastecimiento + "id categoria" + idCategoria + "id sucursal" + idSucursal + "]";
	}
}
