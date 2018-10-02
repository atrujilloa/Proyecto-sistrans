package superandes.persistencia;

import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import oracle.net.aso.t;

public class SQLProducto {

	private static final String SQL = PersistenciaSuperandes.SQL;
	
	private PersistenciaSuperandes ps;
	
	public SQLProducto(PersistenciaSuperandes ps)
	{
		this.ps = ps;
	}
	
	public long registrarProducto(PersistenceManager pm, String nombre, String marca, double precioUnitario, double precioUnidad, String unidadMed, double volumen, double peso, String codigo, Date fechaVencimiento)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaProducto() + "(nombre, marca, precioUnitario, precioUnidad, unidadMed, volumen, peso, codigo, fechaVencimiento) values (?,?,?,?,?,?,?,?,?)");
		q.setParameters(nombre, marca, precioUnitario, precioUnidad, volumen, peso, codigo, fechaVencimiento);
		return (long) q.executeUnique();
	}
	
	public long eliminarProducto(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaProducto());
		return (long) q.executeUnique();
	}
}
