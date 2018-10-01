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
	 * tamaño instalacion
	 */
	private String tamañoInstalacion;
	
	private double nivelReorden;
	
	private LinkedList<String> idProveedores;
	
	/**
	 * id del supermercado al que pertenecen
	 */
	
	private String idSupermercado;

	public Sucursal() {
		this.idSucursal = "";
		this.tamañoInstalacion = "";
		this.nivelReorden = 0;
		idProveedores = new LinkedList<>();
	}
	
	public Sucursal(String idSucursal, String tamano, double nivelReorden, LinkedList<String> proveedor)
	{
		this.idSucursal = idSucursal;
		this.tamañoInstalacion = tamano;
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
	public String getTamañoInstalacion() {
		// TODO Auto-generated method stub
		return tamañoInstalacion;
	}
	
	public void setTamañoInstalacion(String tam) {
		tamañoInstalacion = tam;
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
		return "Sucursal [idSucursal=" + idSucursal + ", tamañoInstalacion=" + tamañoInstalacion + ", nivelReorden=" + nivelReorden + ", idProveedores=" + idProveedores +"idSupermercado="+idSupermercado+"]";
		
	}
	
}
