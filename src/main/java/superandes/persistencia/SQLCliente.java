package superandes.persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import oracle.net.aso.t;
import superandes.negocio.Bodega;
import superandes.negocio.Cliente;
import superandes.negocio.Venta;

public class SQLCliente {

	private static final String SQL = PersistenciaSuperandes.SQL;
	
	private  PersistenciaSuperandes ps;
	
	public SQLCliente(PersistenciaSuperandes ps)
	{
		this.ps = ps;
	}
	
	public long registrarCliente(PersistenceManager pm, long id, int documento, String nombre, int nit, String correo, String direccion, String tipo, long idSup)
	{
	
		Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaCliente() + "(id, documento, nombre, nit, correo, direccion, tipo, idSupermercado) values (?,?,?,?,?,?,?.?)");
		q.setParameters(id, documento, nombre, nit, correo, direccion, tipo, idSup);
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
		q.setResultClass(Cliente.class);
		q.setParameters(id);
		return (Cliente) q.executeUnique();
	}
	
	public long eliminarClienteNombre( PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " +ps.darTablaCliente() + "WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();
	}
	
	public List<Venta> ventaUsuarioDadoNIT(PersistenceManager pm, int nit) {

		Query q = pm.newQuery(SQL, "SELECT" +ps.darTablaVenta( )+".idVenta, "+ps.darTablaVenta( )+".total, "+ps.darTablaVenta( )+".idProductos, "+ps.darTablaVenta()+".idCliente, "+ps.darTablaVenta()+".idSucursal, FROM"+ ps.darTablaVenta( )+" INNER JOIN "+ps.darTablaCliente( )+"ON "+ps.darTablaVenta( )+".idCliente = "+ps.darTablaCliente( )+".id WHERE "+ps.darTablaCliente( )+".NIT = ?");
		q.setParameters(nit);
		q.setResultClass(Venta.class);
		return (List<Venta>) q.executeResultList();

	}

	public List<Venta> ventaUsuarioDadoDoc(PersistenceManager pm, int doc) {

		Query q = pm.newQuery(SQL, "SELECT" +ps.darTablaVenta( )+".idVenta, "+ps.darTablaVenta( )+".total, "+ps.darTablaVenta( )+".idProductos, "+ps.darTablaVenta()+".idCliente, "+ps.darTablaVenta()+".idSucursal, FROM"+ ps.darTablaVenta( )+" INNER JOIN "+ps.darTablaCliente( )+"ON "+ps.darTablaVenta( )+".idCliente = "+ps.darTablaCliente( )+".id WHERE "+ps.darTablaCliente( )+".documentoIdentificacion = ?");
		q.setParameters(doc);
		q.setResultClass(Venta.class);
		return (List<Venta>) q.executeResultList();

	}
	
	public List<Cliente> darClientesNombre( PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaCliente() + "WHERE nombre = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(nombre);
		return (List<Cliente>) q.executeList();
	}
	
	public List<Cliente> darClientes(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaCliente());
		q.setResultClass(Cliente.class);
		return (List<Cliente>) q.executeList();
	}
}
