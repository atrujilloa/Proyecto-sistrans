package superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import oracle.net.aso.t;

public class SQLEstante {
	
	private static final String SQL = PersistenciaSuperandes.SQL;
	
	private PersistenciaSuperandes ps;
	
	public SQLEstante(PersistenciaSuperandes ps)
	{
		this.ps = ps;
	}
	
	public long registrarEstante(PersistenceManager pm, long id, int nivelAbastecimiento, double volumen, double peso, String categoria, String idSucursal)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaEstante() + "(id, nivelAbastecimiento, volumen, peso, categoria, idSucursal) values (?,?,?,?,?,?)");
		q.setParameters(id, nivelAbastecimiento, volumen, peso, categoria, idSucursal);
		return (long) q.executeUnique();
	}
	
	public long eliminarEstante(PersistenceManager pm, long idSucursal)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaEstante() + "WHERE idSucursal = ?");
		q.setParameters(idSucursal);
		return (long) q.executeUnique();
	}

}
