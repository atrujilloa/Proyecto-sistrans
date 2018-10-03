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
	
	public long registrarSupermercado(PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + ps.darTablaSupermercado() + "(id) values (?)");
		q.setParameters(id);
		return (long) q.executeUnique();
	}
	
	public long eliminarSupermercadoId(PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaSupermercado() + "WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();
	}
}
