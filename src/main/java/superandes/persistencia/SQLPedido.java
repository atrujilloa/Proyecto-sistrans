package superandes.persistencia;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

	public List<Object[]> productosPedido( PersistenceManager pm, long idPedido)
	{
		String sql = "SELECT count(codigo) , prod.idProducto, prov.idProveedor";
		sql += "FROM ";
		sql += ps.darTablaProducto() + "prod,";
		sql += "INNER JOIN ";
		sql += ps.darTablaPedido() + "ped, " + "ON prod.idProducto = ped.idProducto";
		sql += "INNER JOIN";
		sql += ps.darTablaProveedor() + "prov, " + "ON prod.idProducto = prov.idProducto";
		sql +=  "HAVING count(codigo) < prod.nivelAbastecimiento";
		sql += "GROUP BY prod.idProducto, prov.idProveedor";
		sql += "ORDER BY prod.idProducto";

		Query q = pm.newQuery(SQL, sql);
		return q.executeList();
	}

	public LinkedList<Long> darProductos(List<Object[]> list)
	{
		LinkedList<Long>	resp = new LinkedList<Long>();

		for( int i = 0; i< list.size(); i++)
		{
			Object object = list.get(i)[1];
			if( object != null)
			{
				long producto = (long)object;
				resp.add(producto);
			}
		}
		
		return resp;
	}
	

	public long registrarPedido(PersistenceManager pm, long idPedido, Date fechaPedido, long idSucursal, long idProveedor)
	{
		LinkedList<Long> idProductos = darProductos(productosPedido(pm, idPedido));
		Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaPedido() + "(idPedido, fechaPedido ,idSucursal, idProductos, idProveedor) values (?,?,?,?,?)");
		q.setParameters(idPedido, fechaPedido, idSucursal, idProductos, idProveedor);
		return (long) q.executeUnique();
	}

	public long eliminarPedido(PersistenceManager pm, LinkedList<String> idProductos, long idSucursal, long idProveedor)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaPedido() + "WHERE idProductos = ? AND idSucursal = ? AND idProveedor = ?");
		q.setParameters(idProductos, idSucursal, idProveedor);
		return (long) q.executeUnique();
	}

	public long registrarLlegadaPedido( PersistenceManager pm, Date pFechaLlegada, long idPedido, long idBodega)
	{

		Query q = pm.newQuery(SQL, "UPDATE " + ps.darTablaPedido() + "SET fechaLlegada = ? WHERE idPedido = ?");
		q.setParameters(pFechaLlegada, idPedido);
		return (long) q.executeUnique();
	}

}

