package superandes.persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import oracle.net.aso.t;
import superandes.negocio.Cliente;

public class SQLCliente {

	private static final String SQL = PersistenciaSuperandes.SQL;
	
	private  PersistenciaSuperandes ps;
	
	public SQLCliente(PersistenciaSuperandes ps)
	{
		this.ps = ps;
	}
	
	public long registrarCliente(PersistenceManager pm, long id, int documento, String nombre, int nit, String correo, String direccion, String tipo, String idSupermercado)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaCliente() + "(id, documento, nombre, nit, correo, direccion, tipo, idSupermercado) values (?,?,?,?,?,?,?,?)");
		q.setParameters(id, documento, nombre, nit, correo, direccion, tipo, idSupermercado);
		return (long) q.executeUnique();
	}
	
	public long eliminarCliente(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaCliente());
		return (long) q.executeUnique();
	}
	
	public Cliente darClienteId(PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaCliente() + "WHERE id = ?");
		q.setParameters(id);
		return (Cliente) q.executeUnique();
	}
	
	public long eliminarClienteNombre( PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " +ps.darTablaCliente() + "WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();
	}
	
	public List<Cliente> darClientesNombre( PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaCliente());
		q.setResultClass(Cliente.class);
		return (List<Cliente>) q.executeUnique();
	}
	
	public List<Cliente> darClientes(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaCliente());
		q.setResultClass(Cliente.class);
		return (List<Cliente>) q.executeUnique();
	}
}
