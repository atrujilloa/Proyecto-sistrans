package superandes.negocio;

import java.util.LinkedList;

public class Proveedor implements VOProveedor{
	
	
	/* *******************************************
	 * Atributos
	 *********************************************/

	
	/**
	 * NIT del proveedor
	 */
	private int NIT;
	
	/**
	 * Nombre del proveedor
	 */
	private String nombre;
	
	/**
	 * Calificación calidad del provedor
	 */
	
	private double calificacionCalidad;
	
	/**
	 * Id productos que provee el identificador
	 */
	
	private LinkedList<String> idProductos;
	
	private String idSupermercado;

	public Proveedor() {
		this.NIT = 0;
		this.nombre ="";
		this.calificacionCalidad = 0;
		this.idProductos = new LinkedList<String>();
		this.idSupermercado = "";
	}
	
	public Proveedor(int nit, String nombre, double calificion, LinkedList<String> idProductos, String idSupermercado)
	{
		this.NIT = nit;
		this.nombre = nombre;
		this.calificacionCalidad = calificion;
		this.idProductos = idProductos;
		this.idSupermercado = idSupermercado;
	}
	
	@Override
	public int getNIT() {
		// TODO Auto-generated method stub
		return NIT;
	}
	
	public void setNIT(int Nit) {
		NIT = Nit;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	public void setNombre(String nom) {
		nombre = nom;
	}

	@Override
	public double getCalificacionCalidad() {
		// TODO Auto-generated method stub
		return calificacionCalidad;
	}
	
	public void setCalificacionCalidad(double calf) {
		calificacionCalidad = calf;
	}

	@Override
	public LinkedList<String> getIdProductos() {
		// TODO Auto-generated method stub
		return idProductos;
	}
	
	public void setIdProductos(LinkedList<String> idP) {
		idProductos = idP;
	}
	
	@Override
	public String toString() {
		return "Proveedor [NIT=" + NIT + ", nombre=" + nombre + ", calificacionCalidad=" + calificacionCalidad + ", idProductos=" + idProductos + "idSupermercado = "+idSupermercado+"]";

	}
	
	
}
