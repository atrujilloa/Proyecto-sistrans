package superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import java.util.LinkedList;
import java.util.List;

import superandes.negocio.Bodega;
import superandes.negocio.Producto;

public class SQLBodega {


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
	public SQLBodega (PersistenciaSuperandes pp)
	{
		this.pp = pp;
	}

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar una BODEGA a la base de datos de SUPERANDES
	 * @param pm - El manejador de persistencia
	 * @param idBodega - El identificador de la bodega
	 * @param categoria - categoria producto 
	 * @param peso - El peso maximo de capacidad en la bodega 
	 * @param volumen - volumen maximo en la bodega
	 * @param idSucursal - identificador de la sucursal a la cual pertenece la bodega 
	 * @return El número de tuplas insertadas
	 */

	public long adicionarBodega (PersistenceManager pm, long idBodega, String categoria, double peso, double volumen, long idSucursal, long idProducto) 
	{
		LinkedList<Long> lista = new LinkedList<Long>();
		lista.add(idProducto);
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaBodega () + "(idBodega, categoria, peso, volumen, idSucursal, idProductos) values (?, ?, ?, ?, ?, ?)");
		q.setParameters(idBodega, categoria, peso, volumen, idSucursal,lista,lista);
		return (long) q.executeUnique();
	}



	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de una bodepa  
	 * base de datos de Superandes, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idBodega - El identificador de la bodega
	 * @return El objeto Bodega que tiene el identificador dado
	 */
	public Bodega darBodegaPorId (PersistenceManager pm, String idBodega) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBodega () + " WHERE idBodega = ?");
		q.setResultClass(Bodega.class);
		q.setParameters(idBodega);
		return (Bodega) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de Las bodegas de la 
	 * base de datos de Superandes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Bar
	 */
	public List<Bodega> darBodegas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBodega ());
		q.setResultClass(Bodega.class);
		return (List<Bodega>) q.executeList();
	}


	/**
	 * 
	 * @param pm - manejador de la persistencia 
	 * @param categ - categoria del producto 
	 * @param idProducto - id del producto a agregar 
	 * @return
	 */
	public long agregarProductoABodega(PersistenceManager pm, String categ, long idProducto) {

		Query n = pm.newQuery(SQL, "SELECT idProductos FROM "+ pp.darTablaBodega()+" WHERE categoria = ?");
		n.setParameters(categ);
		List<Long> lista = n.executeList();
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaBodega() + " SET idProductos = ? WHERE categoria = ?");
		lista.add(idProducto);
		q.setParameters(lista, categ);
		return (long) q.executeUnique(); 
	}
	/**
	 * 
	 * @param pm - el manejador de la persistencia
	 * @param pCodigoBarras - codigo de barras de los productos
	 * @return numero de productos con el codigo de barras en la bodega 
	 */
	public int cantProductosEnBodega(PersistenceManager pm, String pCodigoBarras) {

		int contador = 0;
		Query q = pm.newQuery(SQL,"SELECT codigoBarras FROM "+pp.darTablaBodega()+" INNER JOIN "+pp.darTablaProducto()+" ON " +pp.darTablaBodega()+".categoria = "+pp.darTablaProducto()+".categoria WHERE "+pp.darTablaBodega()+".categoria = "+pp.darTablaProducto()+".categoria");
		List<String> list = q.executeList();

		while(list.listIterator().hasNext()) {

			String next = list.listIterator().next();

			if(next.equals(pCodigoBarras)) {
				contador++;
			}
		}

		return contador;	
	}
	
	
	/**
	 * 
	 * @param pm - manejador de la persistencia 
	 * @param categ - categoria del producto 
	 * @param idProducto - id del producto a agregar 
	 * @return
	 */
	public long eliminarProductoBodega(PersistenceManager pm, String categ, long idProducto) {

		
		Query n = pm.newQuery(SQL, "SELECT idProductos FROM "+ pp.darTablaBodega()+" WHERE categoria = ?");
		 
		n.setParameters(categ);
		List<Long> lista = n.executeList();
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaBodega() + " SET idProductos = ? WHERE categoria = ?");
		lista.add(idProducto);
		q.setParameters(lista, categ);
		return (long) q.executeUnique(); 
	}
	

}


