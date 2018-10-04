package superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLVentas_cliente {
	
	private final static String SQL = PersistenciaSuperandes.SQL;
	
	private PersistenciaSuperandes ps;
	
	public SQLVentas_cliente(PersistenciaSuperandes ps) {
		this.ps = ps; 
	}
	
	public long registrarVentasCliente(PersistenceManager pm, long idVenta, long idCliente)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + ps.darTablaVentasCliente() + "(idVenta, idCliente) values (?,?)");
		q.setParameters(idVenta, idCliente);
		return (long) q.executeUnique();
	}
	
	public long darClientesVenta(PersistenceManager pm, long idVenta)
	{
		Query q = pm.newQuery(SQL, "SELECT idCliente FROM" + ps.darTablaVentasCliente() + "WHERE idVenta = ?");
		q.setParameters(idVenta);
		return (long) q.executeUnique();
	}

}
