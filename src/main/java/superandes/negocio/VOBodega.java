package superandes.negocio;

import java.util.LinkedList;

public interface VOBodega {
	
	/* *********************************
	 * Metodos
	 ***********************************/
	
	/**
	 * @return  id de la categoria
	 */
	
	public String getCategoria();
	
	/**
	 * @return  capacidad de la bodega 
	 */
	
	public double getVolumenBodega();
	
	public double getPesoBodega();
	
	public long getIdBodega();
	
	public long getIdSucursal();
	
	@Override
	public String toString();

	public LinkedList<Long> getIdProductos();

}
