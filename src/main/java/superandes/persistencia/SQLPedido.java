package superandes.persistencia;

import java.util.LinkedList;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import oracle.net.aso.t;

public class SQLPedido {

	private final static String SQL = PersistenciaSuperandes.SQL;
	
	private PersistenciaSuperandes ps;
	
	public SQLPedido(PersistenciaSuperandes ps )
	{
		this.ps = ps;
	}
	
	public long registrarPedido(PersistenceManager pm, String idPedido, String idSucursal, LinkedList<String> idProductos, LinkedList<String> idProveedores)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaPedido() + "(idPedido, idSucrsal, idProductos, idProveedores) values (?,?,?,?)");
		q.setParameters(idPedido, idSucursal, idProductos, idProveedores);
		return (long) q.executeUnique();
	}
	
	public long eliminarPedido(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaPedido());
		return (long) q.executeUnique();
	}
}

