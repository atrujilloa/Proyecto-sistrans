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
	private String tama�oInstalacion;
	
	private double nivelReorden;
	
	private LinkedList<String> idProveedores;
	
	/**
	 * id del supermercado al que pertenecen
	 */
	
	private String idSupermercado;

	public Sucursal() {
		this.idSucursal = "";
		this.tama�oInstalacion = "";
		this.nivelReorden = 0;
		idProveedores = new LinkedList<>();
	}
	
	public Sucursal(String idSucursal, String tamano, double nivelReorden, LinkedList<String> proveedor)
	{
		this.idSucursal = idSucursal;
		this.tama�oInstalacion = tamano;
		this.nivelReorden = nivelReorden;
		this.idProveedores = proveedor;
	}
	
	
	@Override
	public String getIdSucursal() {
		// TODO Auto-generated method stub
		return idSucursal;
	}

	public void setIdSucursal(String ids) {
		
		idSucursal = ids;
	}
	@Override
	public String getTama�oInstalacion() {
		// TODO Auto-generated method stub
		return tama�oInstalacion;
	}
	
	public void setTama�oInstalacion(String tam) {
		tama�oInstalacion = tam;
	}

	@Override
	public String getIdSupermercado() {
		// TODO Auto-generated method stub
		return idSupermercado;
	}

	public void seIdSupermercado(String idS) {
		
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
	public String toString() {
		return "Sucursal [idSucursal=" + idSucursal + ", tama�oInstalacion=" + tama�oInstalacion + ", nivelReorden=" + nivelReorden + ", idProveedores=" + idProveedores +"idSupermercado="+idSupermercado+"]";
		
	}
	
}
