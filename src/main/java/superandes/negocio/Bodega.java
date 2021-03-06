package superandes.negocio;

import java.util.LinkedList;

public class Bodega implements VOBodega{


	/* ***************************************************************
	 * Atributos
	 *****************************************************************/

	/**
	 * Capacidad de la bodega
	 */
	private double pesoBodega;
	
	private double volumenBodega;
	
	private String categoria;
	
	private long idBodega;
	

	//---------------------------- Asociaciones -----------------------------//

	private String idSucursal;

	//---------------------------- Constructor -----------------------------//

	public Bodega() {
		this.pesoBodega = 0;
		this.volumenBodega = 0;
		this.categoria = "";
		this.idSucursal = "";
		this.idBodega = 0;
	}

	public Bodega(long idBodega, double peso, double volumen, String categoria, String idSucursal)
	{
		this.categoria = categoria;
		this.pesoBodega = peso;
		this.volumenBodega = volumen;
		this.idBodega = 0;
		this.idSucursal = idSucursal;

	}
	//--------------------------------- M�todos -------------------------------------//
	@Override
	public String getCategoria() {
		// TODO Auto-generated method stub
		return categoria;
	}

	public void setCategoria( String id)
	{
		this.categoria = id;
	}

	@Override
	public double getVolumenBodega() {
		// TODO Auto-generated method stub
		return volumenBodega;
	}

	public void setVolumenBodega(double vol)
	{
		this.volumenBodega = vol;
	}
	
	@Override 
	public double getPesoBodega() {
	return pesoBodega;	
	}

	
	public void setPesoBodega(double peso) {
		pesoBodega = peso;
	}


	@Override
	public String getIdSucursal() {
		// TODO Auto-generated method stub
		return idSucursal;
	}

	public void setIdSucursal( String id)
	{
		this.idSucursal = id;
	}

	@Override

	public String toString() {
		return "Bodega [categoria=" + categoria + ", pesoBodega=" + pesoBodega+ ", volumenBodega="+volumenBodega + ", idSucural=" + idSucursal + "]";

	}

}
