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
	
	//---------------------------- Asociaciones -----------------------------//
	
	/**
	 * Id productos que provee el identificador
	 */
	
	private LinkedList<Long> productoProveedor;
	
	private long idSupermercado;

	//---------------------------- Constructor -----------------------------//

	public Proveedor() {
		this.NIT = 0;
		this.nombre ="";
		this.calificacionCalidad = 0;
		this.productoProveedor = new LinkedList<Long>();
		this.idSupermercado = 0;
	}
	
	public Proveedor(int nit, String nombre, double calificion, LinkedList<Long> idProductos, long idSupermercado)
	{
		this.NIT = nit;
		this.nombre = nombre;
		this.calificacionCalidad = calificion;
		this.productoProveedor = idProductos;
		this.idSupermercado = idSupermercado;
	}
	
	//--------------------------------- Métodos -------------------------------------//
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
	public LinkedList<Long> getIdProductos() {
		// TODO Auto-generated method stub
		return productoProveedor;
	}
	
	public void setIdProductos(LinkedList<Long> idP) {
		productoProveedor = idP;
	}
	
	@Override 
	
	public long getIdSupermercado() {
		return idSupermercado;
	}
	
	public void setIdSupermercado(long id) {
		idSupermercado = id;
	}
	
	@Override
	public String toString() {
		return "Proveedor [NIT=" + NIT + ", nombre=" + nombre + ", calificacionCalidad=" + calificacionCalidad + ", idProductos= idSupermercado = "+idSupermercado+"]";

	}
	
	
}
