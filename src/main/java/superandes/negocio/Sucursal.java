package superandes.negocio;

import java.util.LinkedList;

public class Sucursal implements VOSucursal{

	/* *********************************************
	 * Atributos
	 ***********************************************/
	
	/**
	 * id de la sucursal
	 */
	
	private String idSucursal;
	
	/**
	 * tama�o instalacion
	 */
	private double tama�oInstalacion;
	
	private double nivelReorden;
	
	private String clave;
	//---------------------------- Asociaciones -----------------------------//
	
	private LinkedList<String> idProveedores;
	
	/**
	 * id del supermercado al que pertenecen
	 */
	
	private long idSupermercado;

	//---------------------------- Constructor -----------------------------//
	public Sucursal() {
		this.idSucursal = "";
		this.tama�oInstalacion = 0;
		this.nivelReorden = 0;
		this.clave = "";
		this.idSupermercado = 0;
	}

	
	public Sucursal(String idSucursal, double tamano, double nivelReorden, long sup, String clave)
	{
		this.idSucursal = idSucursal;
		this.tama�oInstalacion = tamano;
		this.nivelReorden = nivelReorden;
		this.idProveedores = new LinkedList<String>();
		this.idSupermercado = sup;
		this.clave = clave;
	}
	
	//--------------------------------- M�todos -------------------------------------//
	@Override
	public String getIdSucursal() {
		// TODO Auto-generated method stub
		return idSucursal;
	}

	public void setIdSucursal(String ids) {
		
		idSucursal = ids;
	}
	@Override
	public double getTama�oInstalacion() {
		// TODO Auto-generated method stub
		return tama�oInstalacion;
	}
	
	public void setTama�oInstalacion(double tam) {
		tama�oInstalacion = tam;
	}

	@Override
	public long getIdSupermercado() {
		// TODO Auto-generated method stub
		return idSupermercado;
	}

	public void seIdSupermercado(long idS) {
		
		idSupermercado = idS;
	}
	@Override
	public double getNivelReorden() {
		// TODO Auto-generated method stub
		return nivelReorden;
	}
	
	public void setNivelReorden(double Niv) {
		nivelReorden = Niv;
	}

	@Override
	public LinkedList<String> getIdProveedor() {
		// TODO Auto-generated method stub
		return idProveedores;
	}
	
	public void setIdProveedores(LinkedList<String> list) {
		idProveedores = list;
	}
	
	@Override
	public String getClave() {
		// TODO Auto-generated method stub
		return clave;
	}
	
	public void setClave(String clave) {
	     this.clave = clave;
	}
	@Override
	public String toString() {
		return "Sucursal [idSucursal=" + idSucursal + ", tama�oInstalacion=" + tama�oInstalacion + ", nivelReorden=" + nivelReorden + ", idProveedores=" + idProveedores +"idSupermercado="+idSupermercado+"]";
		
	}
	
}
