package superandes.negocio;

public class Bodega implements VOBodega{


	/* ***************************************************************
	 * Atributos
	 *****************************************************************/
	/**
	 * id de la bodega
	 */

	private String idBodega;

	/**
	 * Capacidad de la bodega
	 */

	private double pesoBodega;
	
	private double volumenBodega;

	//---------------------------- Asociaciones -----------------------------//

	private String idSucursal;

	/**
	 * id categoria producto
	 */

	private String idCategoria;

	//---------------------------- Constructor -----------------------------//

	public Bodega() {
		this.pesoBodega = 0;
		this.volumenBodega = 0;
		this.idCategoria = "";
		this.idBodega = "";
		this.idSucursal = "";
	}

	public Bodega( String idCategoria, double peso, double volumen, String idBodega, String idSucursal)
	{
		this.idCategoria = idCategoria;
		this.pesoBodega = peso;
		this.volumenBodega = volumen;
		this.idBodega = idBodega;
		this.idSucursal = idSucursal;
	}

	//--------------------------------- M�todos -------------------------------------//
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
		return "Bodega [idCategoria=" + idCategoria + ", pesoBodega=" + pesoBodega+ ", volumenBodega="+volumenBodega + ", idBodega=" + idBodega + ", idSucural=" + idSucursal + "]";

	}
}
