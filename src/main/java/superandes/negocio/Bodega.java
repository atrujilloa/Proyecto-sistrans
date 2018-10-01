package superandes.negocio;

public class Bodega implements VOBodega{
	
	
	/* ***************************************************************
	 * Atributos
	 *****************************************************************/
	
	
	
	/**
	 * id categoria producto
	 */
	
	private String idCategoria;

	
	/**
	 * Capacidad de la bodega
	 */
	
	private double capacidadBodega;
	
	/**
	 * id de la bodega
	 */
	
	private String idBodega;
	
	
	private String idSucursal;


	public Bodega() {
		this.capacidadBodega = 0;
		this.idCategoria = "";
		this.idBodega = "";
		this.idSucursal = "";
	}
	
	public Bodega( String idCategoria, double capacidad, String idBodega, String idSucursal)
	{
		this.idCategoria = idCategoria;
		this.capacidadBodega =capacidad;
		this.idBodega = idBodega;
		this.idSucursal = idSucursal;
	}
	
	@Override
	public String getIdCategoria() {
		// TODO Auto-generated method stub
		return idCategoria;
	}

	public void setIdCategoria( String id)
	{
		this.idCategoria = id;
	}
	
	@Override
	public double getCapacidadBodega() {
		// TODO Auto-generated method stub
		return capacidadBodega;
	}

	public void setCapacidad(double capacidad)
	{
		this.capacidadBodega = capacidad;
	}

	@Override
	public String getIdBodega() {
		// TODO Auto-generated method stub
		return idBodega;
	}

	public void setIdBodega(String id)
	{
		this.idBodega = id;
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
	
	public String toString() {
		return "Bodega [idCategoria=" + idCategoria + ", capacidadBodega=" + capacidadBodega + ", idBodega=" + idBodega + ", idSucural=" + idSucursal + "]";

	}
}
