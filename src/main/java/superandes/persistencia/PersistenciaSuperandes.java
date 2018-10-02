package superandes.persistencia;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import superandes.negocio.Sucursal;

import java.util.LinkedList;
import java.util.List;

import java.sql.Timestamp;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;


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


	private int numSucursal;
	
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

	private SQLCategoriaProducto sqlCategoriaProducto;

	
	private SQLPromocion sqlPromocion;
	
	

	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */

	public PersistenciaSuperandes( ) {
		
		numSucursal = 0;

		pmf = JDOHelper.getPersistenceManagerFactory("Superandes");
		crearClasesSQL();

		tablas = new LinkedList<String>();
		tablas.add("Superandes_sequence");
		tablas.add("BODEGA");
		tablas.add("CLIENTE");
		tablas.add("ESTANTE");
		tablas.add("PEDIDO");
		tablas.add("PRODUCTO");
		tablas.add("CATEGORIAPRODUCTO");
		tablas.add("PROVEEDOR");
		tablas.add("SUCURSAL");
		tablas.add("SUPERMERCADO");
		tablas.add("PROMOCION");
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
		sqlCategoriaProducto = new SQLCategoriaProducto(this);
		sqlCliente = new SQLCliente(this);
		sqlEstante = new SQLEstante(this);
		sqlPedido = new SQLPedido(this);
		sqlProducto = new SQLProducto(this);
		sqlProveedor = new SQLProveedor(this);
		sqlSucursal = new SQLSucursal(this);
		sqlSupermercado = new SQLSupermercado(this);
		sqlPromocion = new SQLPromocion(this);
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

	public String darTablaCategoriaProducto() {
		return tablas.get(6);
	}

	public String darTablaProveedor() {
		return tablas.get(7);
	}

	public String darTablaSucursal() {
		return tablas.get(8);
	}

	public String darTablaSupermercado() {
		return tablas.get(9);
	}

	
	public String darTablaPromocion() {
		return tablas. get(10);
	}


public long nextval()
{
	long resp = sqlUtil.nextval(pmf.getPersistenceManager());
	log.trace("Generando secuencia: " + resp);
	return resp;
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

/* ****************************************************************
 * 			Métodos para manejar la BODEGA
 *****************************************************************/
/* ****************************************************************
 * 			Métodos para manejar las CATEGORIAS PRODUCTO
 *****************************************************************/	
/* ****************************************************************
 * 			Métodos para manejar los CLIENTES
 *****************************************************************/
/* ****************************************************************
 * 			Métodos para manejar los ESTANTES
 *****************************************************************/
/* ****************************************************************
 * 			Métodos para manejar los PEDIDOS
 *****************************************************************/
/* ****************************************************************
 * 			Métodos para manejar los PRODUCTOS
 *****************************************************************/
/* ****************************************************************
 * 			Métodos para manejar los PROMOCION
 *****************************************************************/
/* ****************************************************************
 * 			Métodos para manejar los PROVEEDOR
 *****************************************************************/
/* ****************************************************************
 * 			Métodos para manejar los SUCURSAL
 *****************************************************************/

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
public Sucursal darSucursalPorId (int idSucursal) 
{
	return (Sucursal) sqlSucursal.darSucursalPorId (pmf.getPersistenceManager(), ""+idSucursal);
}
/* ****************************************************************
 * 			Métodos para manejar los SUPERMERCADO
 *****************************************************************/

}
