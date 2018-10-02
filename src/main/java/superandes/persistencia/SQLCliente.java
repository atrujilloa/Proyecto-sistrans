package superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import oracle.net.aso.t;

public class SQLCliente {

	private static final String SQL = PersistenciaSuperandes.SQL;
	
	private  PersistenciaSuperandes ps;
	
	public SQLCliente(PersistenciaSuperandes ps)
	{
		this.ps = ps;
	}
	
	public long registrarCliente(PersistenceManager pm, int documento, String nombre, int nit, String correo, String direccion, String tipo, String idSupermercado)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaCliente() + "(documento, nombre, nit, correo, direccion, tipo, idSupermercado) values (?,?,?,?,?,?,?)");
		q.setParameters(documento, nombre, nit, correo, direccion, tipo, idSupermercado);
		return (long) q.executeUnique();
	}
	
	public long eliminarCliente(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaCliente());
		return (long) q.executeUnique();
	}
}
