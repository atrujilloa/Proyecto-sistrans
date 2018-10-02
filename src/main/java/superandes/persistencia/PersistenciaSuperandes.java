package superandes.persistencia;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import java.util.LinkedList;
import java.util.List;
<<<<<<< HEAD
=======
import java.sql.Timestamp;

import javax.jdo.JDOHelper;
>>>>>>> b5ca9b1898e36dc5861ae17ef148bc434148e763
import javax.jdo.PersistenceManagerFactory;


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
	
	private SQLCategoriaProducto sqlCategoriaProducto;
	
	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	
	public PersistenciaSuperandes( ) {
		
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
	
		return null;
	}

	public static PersistenciaSuperandes getInstance(JsonObject tableConfig) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cerrarUnidadPersistencia() {
		// TODO Auto-generated method stub
		
	     cerrarUnidadPersistencia();
	}
	
	private LinkedList<String> leerNombreTablas(JsonObject tableConfig) {
		// TODO Auto-generated method stub
		return null;
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
		sqlUtil = new SQLUtil(this);
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
	
	
}
