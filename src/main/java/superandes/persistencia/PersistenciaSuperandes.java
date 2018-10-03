package superandes.persistencia;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import superandes.negocio.Sucursal;
import superandes.negocio.Supermercado;
import superandes.negocio.Cliente;
import superandes.negocio.Estante;
import superandes.negocio.Pedido;
import superandes.negocio.Producto;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.jdo.annotations.Cacheable;

public class PersistenciaSuperandes {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaSuperandes.class.getName());

	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	private static PersistenciaSuperandes instance;

	private PersistenceManagerFactory pmf;

	private LinkedList<String> tablas;

	private SQLUtil sqlUtil;

	private SQLBodega sqlBodega;

	private SQLCliente sqlCliente;

	private SQLEstante sqlEstante;

	private SQLPedido sqlPedido;

	private SQLProducto sqlProducto;

	private SQLProveedor sqlProveedor;

	private SQLSucursal sqlSucursal;

	private SQLSupermercado sqlSupermercado;

	private SQLPromocion sqlPromocion;

	private SQLVenta sqlVenta;


	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */

	public PersistenciaSuperandes( ) {

		pmf = JDOHelper.getPersistenceManagerFactory("Superandes");
		crearClasesSQL();

		tablas = new LinkedList<String>();
		tablas.add("Superandes_sequence");
		tablas.add("BODEGA");
		tablas.add("CLIENTE");
		tablas.add("ESTANTE");
		tablas.add("PEDIDO");
		tablas.add("PRODUCTO");
		tablas.add("PROVEEDOR");
		tablas.add("SUCURSAL");
		tablas.add("SUPERMERCADO");
		tablas.add("PROMOCION");
		tablas.add("VENTA");
	}

	private PersistenciaSuperandes(JsonObject tableConfig)
	{
		crearClasesSQL();
		tablas = leerNombreTablas(tableConfig);


		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);

	}


	public static  PersistenciaSuperandes getInstance() {

		if( instance == null)
		{
			instance = new PersistenciaSuperandes();
		}
		return instance;
	}

	public static PersistenciaSuperandes getInstance(JsonObject tableConfig) {

		if(instance == null)
		{
			instance = new PersistenciaSuperandes(tableConfig);
		}
		return instance;
	}

	public void cerrarUnidadPersistencia() {
		pmf.close();
		instance = null;
	}

	private LinkedList<String> leerNombreTablas(JsonObject tableConfig) {

		JsonArray nombres = tableConfig.getAsJsonArray("tablas");

		LinkedList<String> resp = new LinkedList<String>();
		for(JsonElement nom : nombres)
		{
			resp.add(nom.getAsString());
		}
		return resp;
	}

	private void crearClasesSQL()
	{
		sqlBodega = new SQLBodega(this);
		sqlCliente = new SQLCliente(this);
		sqlEstante = new SQLEstante(this);
		sqlPedido = new SQLPedido(this);
		sqlProducto = new SQLProducto(this);
		sqlProveedor = new SQLProveedor(this);
		sqlSucursal = new SQLSucursal(this);
		sqlSupermercado = new SQLSupermercado(this);
		sqlPromocion = new SQLPromocion(this);
		sqlVenta = new SQLVenta(this);
		sqlUtil = new SQLUtil(this);

	}

	public String darSeqSuperandes()
	{
		return tablas.get(0);
	}

	public String darTablaBodega() {
		return tablas.get(1);
	}

	public String darTablaCliente() {
		return tablas.get(2);
	}

	public String darTablaEstante() {
		return tablas.get(3);
	}

	public String darTablaPedido(){
		return tablas.get(4);
	}

	public String darTablaProducto() {
		return tablas.get(5);
	}

	public String darTablaProveedor() {
		return tablas.get(6);
	}

	public String darTablaSucursal() {
		return tablas.get(7);
	}

	public String darTablaSupermercado() {
		return tablas.get(8);
	}


	public String darTablaPromocion() {
		return tablas. get(9);
	}


	public String darTablaVenta() {
		return tablas.get(11);
	}

	private String darDetalleException(Exception e)
	{
		String resp = "";
		if(e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions()[0].getMessage();
		}
		return resp;	
	}

	private long nextval()
	{
		long resp = sqlUtil.nextval(pmf.getPersistenceManager());
		log.trace("Generando secuencia: " + resp);
		return resp;
	}

	/* ****************************************************************
	 * 			Métodos para manejar la BODEGA
	 *****************************************************************/
	/* ****************************************************************
	 * 			Métodos para manejar los CLIENTES
	 *****************************************************************/
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla BEBEDOR
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bebedor
	 * @param ciudad - La ciudad del bebedor
	 * @param presupuesto - El presupuesto del bebedor (ALTO, MEDIO, BAJO)
	 * @return El objeto BEBEDOR adicionado. null si ocurre alguna Excepción
	 */
	public Cliente registrarCliente( String nombre, String correo, int numDocumento, String tipo, int nit, String direccion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idCliente = nextval ();
			long tuplasInsertadas = sqlCliente.registrarCliente(pmf.getPersistenceManager(), idCliente ,numDocumento, nombre, nit, correo, direccion, tipo);
			tx.commit();

			log.trace ("Inserción de cliente: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Cliente (idCliente, numDocumento, nit, nombre, correo, direccion, tipo);
		}
		catch (Exception e)
		{
			//    	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BEBEDOR, dado el nombre del bebedor
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bebedor
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarClientePorNombre(String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlCliente.eliminarClienteNombre(pm, nombre);
			tx.commit();
			return resp;
		}
		catch (Exception e)
		{
			//    	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BEBEDOR que tienen el nombre dado
	 * @param nombreBebedor - El nombre del bebedor
	 * @return La lista de objetos BEBEDOR, construidos con base en las tuplas de la tabla BEBEDOR
	 */
	public List<Cliente> darCLientesPorNombre (String nombreCLiente) 
	{
		return sqlCliente.darClientesNombre(pmf.getPersistenceManager(), nombreCLiente);
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BEBEDOR que tienen el identificador dado
	 * @param idBebedor - El identificador del bebedor
	 * @return El objeto BEBEDOR, construido con base en la tuplas de la tabla BEBEDOR, que tiene el identificador dado
	 */
	public Cliente darCLientePorId (long idCLiente) 
	{
		return (Cliente) sqlCliente.darClienteId(pmf.getPersistenceManager(), idCLiente);
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BEBEDOR
	 * @return La lista de objetos BEBEDOR, construidos con base en las tuplas de la tabla BEBEDOR
	 */
	public List<Cliente> darClientes ()
	{
		return sqlCliente.darClientes (pmf.getPersistenceManager());
	}

	/* ****************************************************************
	 * 			Métodos para manejar los ESTANTES
	 *****************************************************************/
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla BEBEDOR
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bebedor
	 * @param ciudad - La ciudad del bebedor
	 * @param presupuesto - El presupuesto del bebedor (ALTO, MEDIO, BAJO)
	 * @return El objeto BEBEDOR adicionado. null si ocurre alguna Excepción
	 */
	public Estante registrarEstante( int nivel, double volumen, double peso, String categoria ,long idSucursal)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idEstante = nextval();
			long tuplasInsertadas = sqlEstante.registrarEstante(pmf.getPersistenceManager(), idEstante, nivel, volumen, peso, categoria, idSucursal );
			tx.commit();

			log.trace ("Inserción del Estante: " + idEstante + ": " + tuplasInsertadas + " tuplas insertadas");

/* ****************************************************************
 * 			Métodos para manejar los PROMOCION
 *****************************************************************/
/* ****************************************************************
 * 			Métodos para manejar los PROVEEDOR
 *****************************************************************/
/* ****************************************************************
 * 			Métodos para manejar los SUCURSAL
**************************************************************** */

			return new Estante( idEstante, nivel, volumen, peso, categoria, idSucursal);
		}
		catch (Exception e)
		{
			//    	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla GUSTAN, dados los identificadores de bebedor y bebida
	 * @param idBebedor - El identificador del bebedor
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarEstante(long idSucursal) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlEstante.eliminarEstante(pm, idSucursal);           
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
			//    	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/* ****************************************************************
	 * 			Métodos para manejar los PEDIDOS
	 *****************************************************************/
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla BEBEDOR
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bebedor
	 * @param ciudad - La ciudad del bebedor
	 * @param presupuesto - El presupuesto del bebedor (ALTO, MEDIO, BAJO)
	 * @return El objeto BEBEDOR adicionado. null si ocurre alguna Excepción
	 */
	public Pedido registrarPedido( Date fechaPedido, Date fechaLlegada, long idSucursal, long idProveedor)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idPedido = nextval();
			long tuplasInsertadas = sqlPedido.registrarPedido(pmf.getPersistenceManager(), idPedido, fechaPedido, idSucursal, idProveedor);
			tx.commit();

			log.trace ("Inserción del Estante: " + idPedido + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Pedido( idPedido, fechaPedido, fechaLlegada, idSucursal, idProveedor);
		}
		catch (Exception e)
		{
			//    	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla GUSTAN, dados los identificadores de bebedor y bebida
	 * @param idBebedor - El identificador del bebedor
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarPedido(long idSucursal, LinkedList<String> idProductos, long idProveedor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlPedido.eliminarPedido(pm, idProductos, idSucursal, idProveedor);           
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
			//    	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	public long registrarLlegadaPedido( Date fechaLlegada, long idPedido, long idBodega)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			long resp = sqlPedido.registrarLlegadaPedido(pm, fechaLlegada, idPedido, idBodega);
			tx.commit();
			
			return resp;
		}
		catch (Exception e)
		{
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if(tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los PRODUCTOS
	 *****************************************************************/
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla BEBEDOR
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bebedor
	 * @param ciudad - La ciudad del bebedor
	 * @param presupuesto - El presupuesto del bebedor (ALTO, MEDIO, BAJO)
	 * @return El objeto BEBEDOR adicionado. null si ocurre alguna Excepción
	 */
	public Producto registrarProducto( String nombre, String marca, double precioUnitario, double precioUnidad, String unidadMed, double volumen, double peso, String codigo, Date fechaVencimiento, long idSucursal, long idEstante, long idBodega)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlProducto.registrarProducto(pmf.getPersistenceManager(), nombre, marca, precioUnitario, precioUnidad, unidadMed ,volumen, peso, codigo, fechaVencimiento);
			tx.commit();

			log.trace ("Inserción del Estante: " + codigo + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Producto(nombre, marca, precioUnitario, precioUnidad, unidadMed, volumen, peso, codigo, fechaVencimiento, idSucursal, idEstante, idBodega);
		}
		catch (Exception e)
		{
			//    	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla GUSTAN, dados los identificadores de bebedor y bebida
	 * @param idBebedor - El identificador del bebedor
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarProducto(String codigo) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlProducto.eliminarProducto(pm, codigo);           
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
			//    	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/* ****************************************************************
	 * 			Métodos para manejar los PROMOCION
	 *****************************************************************/
	/* ****************************************************************
	 * 			Métodos para manejar los PROVEEDOR
	 *****************************************************************/
	/* ****************************************************************
	 * 			Métodos para manejar los SUCURSAL
/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla SUCURSAL
	 * Adiciona entradas al log de la aplicación
	 * @param tamañoInstalacion - tamaño de la bodega 
	 * @param nivelReorden - nivel reorden de la sucursal
	 * @param idProveedores - proveedores de la sucursal
	 * @param idSupermercado - supermercado al cual pertenece la sucursal 
	 * @return El objeto BEBEDOR adicionado. null si ocurre alguna Excepción
	 */
	public Sucursal adicionarSucursal(double tamañoInstalacion, double nivelReorden, LinkedList<String> idProveedores, String idSupermercado) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			String idSucursal = ""+numSucursal++;
			long tuplasInsertadas = sqlSucursal.adicionarSucursal(pmf.getPersistenceManager(), idSucursal, tamañoInstalacion,nivelReorden, idProveedores, idSupermercado);
			tx.commit();

			log.trace ("Inserción de la sucursal: " + idSucursal + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Sucursal (""+idSucursal, tamañoInstalacion, nivelReorden, idProveedores, idSupermercado);
		}
		catch (Exception e)
		{
			//    	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}


	/**
	 * Método que consulta todas las tuplas en la tabla SUCURSAL que tienen el identificador dado
	 * @param idSucursal - El identificador del bebedor
	 * @return El objeto BEBEDOR, construido con base en la tuplas de la tabla BEBEDOR, que tiene el identificador dado
	 */
	public Sucursal darSucursalPorId (String idSucursal) 
	{
		return (Sucursal) sqlSucursal.darSucursalPorId (pmf.getPersistenceManager(), idSucursal);
	}


	/* ****************************************************************
	 * 			Métodos para manejar los SUPERMERCADO
	 *****************************************************************/
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla BEBEDOR
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bebedor
	 * @param ciudad - La ciudad del bebedor
	 * @param presupuesto - El presupuesto del bebedor (ALTO, MEDIO, BAJO)
	 * @return El objeto BEBEDOR adicionado. null si ocurre alguna Excepción
	 */
	public Supermercado registrarSupermercado()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idSupermercado = nextval();
			long tuplasInsertadas = sqlSupermercado.registrarSupermercado(pmf.getPersistenceManager(), idSupermercado);
			tx.commit();

			log.trace ("Inserción del Estante: " + idSupermercado + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Supermercado();
		}
		catch (Exception e)
		{
			//    	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla GUSTAN, dados los identificadores de bebedor y bebida
	 * @param idBebedor - El identificador del bebedor
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarSupermercadoId(long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlSupermercado.eliminarSupermercadoId(pm, id);           
			tx.commit();

			return resp;
		}
		catch (Exception e)
		{
			//    	e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return -1;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

}
