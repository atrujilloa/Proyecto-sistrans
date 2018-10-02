package superandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLSupermercado {
	
	private final static String SQL = PersistenciaSuperandes.SQL;
	
	private PersistenciaSuperandes ps;
	

	public SQLSupermercado(PersistenciaSuperandes ps)
	{
		this.ps = ps;
	}
	
	public long registrarSupermercado(PersistenceManager pm, String id)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + ps.darTablaSupermercado() + "(id) values (?)");
		q.setParameters(id);
		return (long) q.executeUnique();
	}
	
	public long eliminarSupermercado(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaSupermercado());
		return (long) q.executeUnique();
	}
}
