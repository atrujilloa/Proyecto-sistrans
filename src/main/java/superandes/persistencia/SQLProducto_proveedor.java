package superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import oracle.net.aso.t;
import superandes.negocio.Producto;

public class SQLProducto_proveedor {
	
	private final static String SQL = PersistenciaSuperandes.SQL;
	
	private PersistenciaSuperandes ps;
	
	public SQLProducto_proveedor(PersistenciaSuperandes ps)
	{
		this.ps = ps;
	}
	
	public long registrarProductosProveedor(PersistenceManager pm, long idProducto, long idProveedor)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaProductoProveedor() + "(idProducto, idProveedor) values(?,?)");
		q.setParameters(idProducto, idProveedor);
		return (long) q.executeUnique();		
	}

	public long darProductosProveedor(PersistenceManager pm, long idProveedor)
	{
		Query q = pm.newQuery(SQL, "SELECT idProducto FROM" + ps.darTablaProductoProveedor() + "WHERE idProveedor = ?");
		q.setParameters(idProveedor);
		return (long) q.executeUnique();
	}
}
