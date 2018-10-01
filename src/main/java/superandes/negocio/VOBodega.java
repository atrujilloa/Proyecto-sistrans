package superandes.negocio;

public interface VOBodega {
	
	/* *********************************
	 * Metodos
	 ***********************************/
	
	/**
	 * @return  id de la categoria
	 */
	
	public String getIdCategoria();
	
	/**
	 * @return  capacidad de la bodega 
	 */
	
	public double getVolumenBodega();
	
	public double getPesoBodega();
	/**
	 * @return id de la bodega
	 */
	public String getIdBodega();
	
	public String getIdSucursal();
	
	@Override
	public String toString();

}
