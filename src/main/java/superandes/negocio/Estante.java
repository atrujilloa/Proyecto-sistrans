package superandes.negocio;

import java.util.LinkedList;

public class Estante implements VOEstante{

	
	/* *********************************************************
	 * Atributos
	 ***********************************************************/
	
	private long idEstante;
	/**
	 * Nivel abastecimiento estante 
	 */
	private int nivelAbastecimiento;
	
	private double volumen;
	
	private double peso;
	
	private String categoria;
	
	//---------------------------- Asociaciones -----------------------------//

	private String idSucursal;
	
	private LinkedList<String> idProductos;
	
	//---------------------------- Constructor -----------------------------//

	public Estante() {
		this.nivelAbastecimiento = 0;
		this.peso = 0;
		this.volumen = 0;
		this.categoria = "";
		this.idSucursal = "";
		this.idEstante = 0;
		idProductos = new LinkedList<>();
	}
	
	public Estante(long id,int nivelAbastecimiento , double peso, double volumen, String categoria, String idSucursal)
	{
		this.nivelAbastecimiento = nivelAbastecimiento;
		this.peso = peso;
		this.volumen = volumen;
		this.categoria = categoria;
		this.idSucursal = idSucursal;
		this.idEstante = id;
		idProductos = new LinkedList<>();
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
	public long getIdEstante() {
		// TODO Auto-generated method stub
		return idEstante;
	}
	
	public void setIdEstante(long id)
	{
		this.idEstante = id;
	}
	
	public String toString()
	{
		return "Estante [ id =" + idEstante + "nivel abastecimiento" + nivelAbastecimiento  + "id sucursal" + idSucursal + "peso" + peso + 
				" volumen" + volumen + "categoria " + categoria +  "]";
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

	@Override
	public String getCategoria() {
		// TODO Auto-generated method stub
		return categoria;
	}
	
	public void setCategoria(String categoria)
	{
		this.categoria = categoria;
	}

	@Override
	public LinkedList<String> getIdProductos() {
		// TODO Auto-generated method stub
		return idProductos;
	}
	
	public void setIdProductos(LinkedList<String> list)
	{
		this.idProductos = list;
	}
}
