package superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLVentas_sucursal {
private final static String SQL = PersistenciaSuperandes.SQL;
	
	private PersistenciaSuperandes ps;
	
	public SQLVentas_sucursal(PersistenciaSuperandes ps) {
		this.ps = ps;
	}
	
	public long registrarVentasSucursal(PersistenceManager pm, long idVenta, String idSucursal)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + ps.darTablaVentaSucursal() + "(idVenta, idSucursal) values (?,?)");
		q.setParameters(idVenta, idSucursal);
		return (long) q.executeUnique();
	}
	
	public long darClientesVenta(PersistenceManager pm, long idVenta)
	{
		Query q = pm.newQuery(SQL, "SELECT idSucursal FROM" + ps.darTablaVentaSucursal() + "WHERE idVenta = ?");
		q.setParameters(idVenta);
		return (long) q.executeUnique();
	}

}
