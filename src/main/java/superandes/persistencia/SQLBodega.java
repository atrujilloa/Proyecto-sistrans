package superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

import superandes.negocio.Bodega;

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
	 * @param pesoBodga - El peso maximo de capacidad en la bodega 
	 * @param volumenBodega - volumen maximo en la bodega
	 * @param idSucursal - identificador de la sucursal a la cual pertenece la bodega 
	 * @param idCategoria - categoria de los productos de la bodega 
	 * @return El número de tuplas insertadas
	 */
	
	public long adicionarBar (PersistenceManager pm, String idBar, String nombre, String ciudad, String presupuesto, int sedes) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaBodega () + "(idBodega, pesoBodega, volumenBodega, idSucursal, idCategoria) values (?, ?, ?, ?, ?)");
        q.setParameters(idBar, nombre, ciudad, presupuesto, sedes);
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
	public List<Bodega> darBodega (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBodega ());
		q.setResultClass(Bodega.class);
		return (List<Bodega>) q.executeList();
	}
	
	
}


