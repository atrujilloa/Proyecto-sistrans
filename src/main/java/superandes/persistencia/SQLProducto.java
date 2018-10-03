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
	
	public long registrarProducto(PersistenceManager pm, String nombre, String marca, double precioUnitario, double precioUnidad, String unidadMed, double volumen, double peso, String codigo, Date fechaVencimiento, int nivelReorden)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaProducto() + "(nombre, marca, precioUnitario, precioUnidad, unidadMed, volumen, peso, codigo, fechaVencimiento, nivelReorden) values (?,?,?,?,?,?,?,?,?,?)");
		q.setParameters(nombre, marca, precioUnitario, precioUnidad, volumen, peso, codigo, fechaVencimiento, nivelReorden);
		return (long) q.executeUnique();
	}
	
	public long eliminarProducto(PersistenceManager pm, String codigo)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaProducto() + "WHERE codigo = ?");
		q.setParameters(codigo);
		return (long) q.executeUnique();
	}
}
