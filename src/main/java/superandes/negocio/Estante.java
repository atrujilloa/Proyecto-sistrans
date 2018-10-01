package superandes.negocio;

public class Estante implements VOEstante{

	
	/* *********************************************************
	 * Atributos
	 ***********************************************************/
	
	private String idEstante;
	/**
	 * Nivel abastecimiento estante 
	 */
	private int nivelAbastecimiento;
	
	private double volumen;
	
	private double peso;
	
	//---------------------------- Asociaciones -----------------------------//
	private String idCategoria;
	private String idSucursal;
	
	//---------------------------- Constructor -----------------------------//

	public Estante() {
		this.nivelAbastecimiento = 0;
		this.peso = 0;
		this.volumen = 0;
		this.idSucursal = "";
		this.idEstante ="";
	}
	
	public Estante(int nivelAbastecimiento, String idSucursal, String idEstante, double peso, double volumen)
	{
		this.nivelAbastecimiento = nivelAbastecimiento;
		this.peso = peso;
		this.volumen = volumen;
		this.idSucursal = idSucursal;
		this.idEstante = idEstante;
	}
	
	//--------------------------------- Métodos -------------------------------------//
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
		return "Estante [ id =" + idEstante + "nivel abastecimiento" + nivelAbastecimiento + "id categoria" + idCategoria + "id sucursal" + idSucursal + "peso" + peso + 
				" volumen" + volumen + "]";
	}

	@Override
	public double getPeso() {
		// TODO Auto-generated method stub
		return peso;
	}
	
	public void setPeso( double peso)
	{
		this.peso = peso;
	}

	@Override
	public double getVolumen() {
		// TODO Auto-generated method stub
		return volumen;
	}
	
	public void setVolumen(double volumen)
	{
		this.volumen = volumen;
	}
}
