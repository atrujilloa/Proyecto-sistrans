package superandes.negocio;

public class Cliente implements VOCliente {

	public final static String PERSONA_NATURAL = "Persona natural";
	
	public final static String EMPRESA = "Empresa";
	
	
	/* ******************************************
	 * Atributos
	 ********************************************/
	/**
	 * Identicación cliente
	 */
	private long id;
	
	/**
	 * Numero documento identificacion cliente 
	 */
	private int documentoIdentificacion;
	
	/**
	 * Nit del cliente si es una empresa 
	 */
	private int NIT;
	
	/**
	 * Nombre del cliente 
	 */
	private String nombre;
	
	/**
	 * Correo del cliente 
	 */
	private String correo;
	
	/**
	 * Direccion del cliente si es una empresa 
	 */
	private String direccion;
	
	/**
	 * Tipo del clinte 
	 */
	
	private String tipoCliente;
	
	//---------------------------- Asociaciones -----------------------------//

	private String idSupermercado;
	
	//---------------------------- Constructor -----------------------------//

	public Cliente() {
		this.id = 0;
		this.documentoIdentificacion = 0;
		this.NIT = 0;
		this.nombre = "";
		this.correo = "";
		this.direccion = "";
		this.tipoCliente = "";
		this.idSupermercado = "";
	}

	public Cliente(long id, int documento, int NIT, String nombre, String direccion, String correo ,String tipo, String idSupermercado)
	{
		this.id = id;
		this.documentoIdentificacion = documento;
		this.NIT = NIT;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.tipoCliente = tipo;
		this.idSupermercado = idSupermercado;
	}
	
	//--------------------------------- Métodos -------------------------------------//
	@Override
	public int getDocumento() {
		// TODO Auto-generated method stub
		return documentoIdentificacion;
	}

	public void setDocumento(int id)
	{
		this.documentoIdentificacion = id;
	}
	
	@Override
	public int getNIT() {
		// TODO Auto-generated method stub
		return NIT;
	}

	public void setNit(int nit)
	{
		this.NIT = nit;
	}
	
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
	public String getCorreo() {
		// TODO Auto-generated method stub
		return correo;
	}

	public void setCorreo(String correo)
	{
		this.correo = correo;
	}
	
	@Override
	public String getDireccion() {
		// TODO Auto-generated method stub
		return direccion;
	}

	public void getDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	@Override
	public String tipoCliente() {
		// TODO Auto-generated method stub
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente)
	{
		this.tipoCliente = tipoCliente;
	}
	
	@Override
	public String getIdSupermercado() {
		// TODO Auto-generated method stub
		return idSupermercado;
	}
	
	public void setIdSupermercado(String id)
	{
		this.idSupermercado = id;
	}
	
	public String toString()
	{
		return "Cliente [ id=" + documentoIdentificacion + "nombre" + nombre + "correo" + correo + "dirección" + direccion + "tipo cliente" + tipoCliente + "id supermercado" + idSupermercado + "]";
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
}
