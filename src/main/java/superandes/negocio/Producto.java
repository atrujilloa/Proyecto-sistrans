package superandes.negocio;

import java.sql.Date;

public class Producto implements VOProducto {

	/* ***********************************************
	 * Atributos
	 *************************************************/
	
	/**
	 * Nombre del producto
	 */
	
	public static final String GRAMOS = "gramos";
	
	public static final String MILILITROS ="mililitros";
		
	private String nombre;
	
	/**
	 * Marca del producto
	 */
	
	private String marca;
	
	/**
	 *  Precio del producto 
	 */
	
	private double precioUnitario;
	
	/**
	 * Precio por unidad de medida 
	 */
	
	private double precioUnidadMedida;
	
	/**
	 *  Unidad medida producto
	 */
	
	private String unidadMed;
	
	/**
	 * volumen empaque
	 */
	
	private double volumenEmpaque;
	
	/**
	 * Peso de empaque
	 */
	
	private double pesoEmpaque;
	
	/**
	 * Codigo de barras
	 */
	
	private String codigoBarras;
	
	private Date fechaVencimiento;
	
	//---------------------------- Asociaciones -----------------------------//
	/**
	 * identificador de la sucursal en la cual se encuentra el producto
	 */
	private String idSucursal;
	
	private String idEstante;
	
	private String idBodega;

	
	//---------------------------- Constructor -----------------------------//

	public Producto()
	{ 
		this.nombre = "";
		this.marca = "";
		this.precioUnitario = 0;
		this.precioUnidadMedida = 0;
		this.unidadMed = "";
		this.volumenEmpaque = 0;
		this.pesoEmpaque = 0;
		this.codigoBarras = "";
		this.idSucursal = "";
		this.fechaVencimiento = new Date(0);
	}
	
	public Producto(String nombre, String marca, double precioUnitario, double precioUnidad, String unidad, double volumen, double peso, String codigo, String sucursal, Date fecha, String idEstante, String idBodega)
	{
		this.nombre = nombre;
		this.marca = marca;
		this.precioUnitario = precioUnitario;
		this.precioUnidadMedida = precioUnidad;
		this.unidadMed = unidad;
		this.volumenEmpaque = volumen;
		this.pesoEmpaque = peso;
		this.codigoBarras = codigo;
		this.idSucursal = sucursal;
		this.fechaVencimiento = fecha;
		this.idEstante = idEstante;
		this.idBodega = idBodega;
	}

	//--------------------------------- Métodos -------------------------------------//
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	@Override
	public String getMarca() {
		// TODO Auto-generated method stub
		return marca;
	}

	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	
	@Override
	public double getPrecioUnitario() {
		// TODO Auto-generated method stub
		return precioUnitario;
	}

	public void setPrecioUnitario(double precio)
	{
		this.precioUnitario = precio;
	}
	
	@Override
	public double getPrecioUnidadMedida() {
		// TODO Auto-generated method stub
		return precioUnidadMedida;
	}

	public void setPrecioUnidad(double precio)
	{
		this.precioUnidadMedida = precio;
	}
	
	@Override
	public double getVolumenEmpaque() {
		// TODO Auto-generated method stub
		return volumenEmpaque;
	}

	public void setVolumen(double volumen)
	{
		this.volumenEmpaque = volumen;
	}
	
	@Override
	public double getPesoEmpaque() {
		// TODO Auto-generated method stub
		return pesoEmpaque;
	}
	
	public void setPeso(double peso)
	{
		this.pesoEmpaque = peso;
	}

	@Override
	public String getCodigoBarras() {
		// TODO Auto-generated method stub
		return codigoBarras;
	}

	public void setCodigo(String codigo)
	{
		this.codigoBarras = codigo;
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
	public Date getFechaVencimiento() {
		// TODO Auto-generated method stub
		return fechaVencimiento;
	}
	
	public void setFechaVenciminto(Date fecha)
	{
		this.fechaVencimiento = fecha;
	}
	
	@Override
	public String toString()
	{
		return "Producto [ nombre =" + nombre + "marca" + "precio unitario" + precioUnitario + "precio unidad" + precioUnidadMedida + "unidad medida" + unidadMed + "volumen del empaque" + volumenEmpaque + "peso empaque" + pesoEmpaque
				+ "codigo de barras" + codigoBarras + "id sucursal" + idSucursal + "]";
	}

	@Override
	public String getIdEstante() {
		// TODO Auto-generated method stub
		return idEstante;
	}

	public void setIdEstante( String id)
	{
		this.idEstante = id;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
}

