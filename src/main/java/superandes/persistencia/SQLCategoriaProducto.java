package superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;
import java.util.LinkedList;

import superandes.negocio.CategoriaProducto;


public class SQLCategoriaProducto {

		
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperandes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaSuperandes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLCategoriaProducto (PersistenciaSuperandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar una Sucursal a la base de datos de SUPERANDES
	 * @param pm - El manejador de persistencia
	 * @param nit - El nit del proveedor
	 * @param nombre - El nombre del proveedor 
	 * @param calificacionCalidad - calificacion del proveedor 
	 * @param idProductos - Lista con los id de los  productos  
	 * @param idSupermercado - id del supermercado al cual pertenece la sucursal 
	 * @return El número de tuplas insertadas
	 */
	
	public long adicionarCategoriaProducto (PersistenceManager pm, int nit, String nombre, double calificacionCalidad, LinkedList<String> idProductos, String idSupermercado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaProveedor () + "(NIT, nombre, calificacionCalidad, idProductos, idSupermercado) values (?, ?, ?, ?, ?)");
        q.setParameters(nit, nombre, calificacionCalidad, idProductos, idSupermercado);
        return (long) q.executeUnique();
	}
	
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de un proveedor 
	 * base de datos de Superandes, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idCategoria - categoria producto 
	 * @return El objeto proveedor que tiene el nit dado
	 */
	public CategoriaProducto darProveedorPorNit (PersistenceManager pm, int NIT) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCategoriaProducto() + " WHERE idCategoria = ?");
		q.setResultClass(CategoriaProducto.class);
		q.setParameters(NIT);
		return (CategoriaProducto) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de Los proveedores de la 
	 * base de datos de Superandes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Categoriaproducto 
	 */
	public List<CategoriaProducto> darCategoriaProducto (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCategoriaProducto ());
		q.setResultClass(CategoriaProducto.class);
		return (List<CategoriaProducto>) q.executeList();
	}
	
}