package superandes.negocio;

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
	/**
	 * @return id de la bodega
	 */
	public long getIdBodega();
	
	public long getIdSucursal();
	
	@Override
	public String toString();

}
