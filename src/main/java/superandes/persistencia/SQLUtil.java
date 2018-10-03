package superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import oracle.net.aso.t;

public class SQLUtil {
	
	private final static String SQL = PersistenciaSuperandes.SQL;
	
	private PersistenciaSuperandes ps;
	
	
	public SQLUtil(PersistenciaSuperandes ps)
	{
		this.ps = ps;
	}
	
	public long nextval(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT " + ps.darSeqSuperandes() + ".nextval FROM DUAL");
		q.setResultClass(Long.class);
		long resp = (long) q.executeUnique();
		return resp;
	}
	
	public long[] limpiarSuperandes(PersistenceManager pm)
	{
		Query qBodega = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaBodega());Query qCliente = pm.newQuery(SQL, "DELETE FORM " + ps.darTablaCliente());
		Query qEstante = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaEstante());
		Query qPedido = pm.newQuery(SQL, "DLET FROM " + ps.darTablaPedido());
		Query qProducto = pm.newQuery(SQL, "DLEETE FROM " + ps.darTablaProducto());
		Query qProveedor = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaProveedor());
		Query qSucursal = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaSucursal());
		Query qSupermercado = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaSupermercado());
		Query qPromocion = pm.newQuery(SQL, "DELETE FROM"+ps.darTablaPromocion());
		Query qVenta = pm.newQuery(SQL, "DELETE FROM"+ps.darTablaVenta());
		
		long bodegaEliminado = (long) qBodega.executeUnique();
		long clienteEliminado = (long) qCliente.executeUnique();
		long estanteEliminado = (long) qEstante.executeUnique();
		long pedidoEliminado = (long) qPedido.executeUnique();
		long productoEliminado = (long) qProducto.executeUnique();
		long proveedorEliminado = (long) qProveedor.executeUnique();
		long sucursalEliminado = (long)qSucursal.executeUnique();
		long supermercadoEliminado = (long)qSupermercado.executeUnique();
		long promocionEliminado = (long)qPromocion.executeUnique();
		long ventaEliminado = (long)qVenta.executeUnique();
		
		return new long[] {bodegaEliminado, clienteEliminado, estanteEliminado, pedidoEliminado, productoEliminado, proveedorEliminado, sucursalEliminado, supermercadoEliminado, promocionEliminado, ventaEliminado};
	}

}
