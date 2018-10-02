package superandes.negocio;

public class Bodega implements VOBodega{


	/* ***************************************************************
	 * Atributos
	 *****************************************************************/
	/**
	 * id de la bodega
	 */

	private long idBodega;

	/**
	 * Capacidad de la bodega
	 */

	private double pesoBodega;
	
	private double volumenBodega;
	
	private String categoria;

	//---------------------------- Asociaciones -----------------------------//

	private long idSucursal;

	//---------------------------- Constructor -----------------------------//

	public Bodega() {
		this.pesoBodega = 0;
		this.volumenBodega = 0;
		this.categoria = "";
		this.idBodega = 0;
		this.idSucursal = 0;
	}

	public Bodega( String categoria, double peso, double volumen, long idBodega, long idSucursal)
	{
		this.categoria = categoria;
		this.pesoBodega = peso;
		this.volumenBodega = volumen;
		this.idBodega = idBodega;
		this.idSucursal = idSucursal;
	}

	//--------------------------------- Métodos -------------------------------------//
	@Override
	public String getCategoria() {
		// TODO Auto-generated method stub
		return categoria;
	}

	public void setCategoria( String id)
	{
		this.categoria = id;
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
	public long getIdBodega() {
		// TODO Auto-generated method stub
		return idBodega;
	}

	public void setIdBodega(long id)
	{
		this.idBodega = id;
	}

	@Override
	public long getIdSucursal() {
		// TODO Auto-generated method stub
		return idSucursal;
	}

	public void setIdSucursal(long id)
	{
		this.idSucursal = id;
	}

	@Override

	public String toString() {
		return "Bodega [categoria=" + categoria + ", pesoBodega=" + pesoBodega+ ", volumenBodega="+volumenBodega + ", idBodega=" + idBodega + ", idSucural=" + idSucursal + "]";

	}
}
