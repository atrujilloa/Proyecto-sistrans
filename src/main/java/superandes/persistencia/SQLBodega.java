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
	 * Se renombra ac� para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperandes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicaci�n
	 */
	private PersistenciaSuperandes pp;

	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicaci�n
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
	 * @return El n�mero de tuplas insertadas
	 */

	public long adicionarBodega (PersistenceManager pm, long idBodega, double pesoBodega, double volumenBodega, String categoria, String idSucursal) 
	
	{
		
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaBodega () + "(idBodega, pesoBodega, volumenBodega, categoria, idSucursal) values (?, ?, ?, ?, ?)");
		q.setParameters(idBodega, pesoBodega, volumenBodega, categoria,idSucursal);
		return (long) q.executeUnique();
	}



	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la informaci�n de una bodepa  
	 * base de datos de Superandes, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idBodega - El identificador de la bodega
	 * @return El objeto Bodega que tiene el identificador dado
	 */
	public Bodega darBodegaPorId (PersistenceManager pm, long idBodega) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBodega () + " WHERE idBodega = ?");
		q.setResultClass(Bodega.class);
		q.setParameters(idBodega);
		return (Bodega) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la informaci�n de Las bodegas de la 
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
	 * @param pm - el manejador de la persistencia
	 * @param pCodigoBarras - codigo de barras de los productos
	 * @return numero de productos con el codigo de barras en la bodega 
	 */
	public int cantProductosEnBodega(PersistenceManager pm, long idBodega) {

	Query n = pm.newQuery(SQL, "SELECT COUNT (*) FROM "+pp.darTablaBodega()+" INNER JOIN "+pp.darTablaProducto()+" ON "+pp.darTablaBodega()+".idBodega = "+pp.darTablaProducto()+".idBodega WHERE "+ pp.darTablaBodega()+".idBodega = ?");
	n.setParameters(idBodega);
	return (int)n.executeUnique();
	}
	
	
}	


