package superandes.persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import oracle.net.aso.t;
import superandes.negocio.Bodega;
import superandes.negocio.Estante;

public class SQLEstante {

	private static final String SQL = PersistenciaSuperandes.SQL;

	private PersistenciaSuperandes ps;

	public SQLEstante(PersistenciaSuperandes ps)
	{
		this.ps = ps;
	}

	

	public long adicionarEstante (PersistenceManager pm, long id, int nivelAbastecimiento, double peso, double volumen, String categoria, String idSucursal, long idProducto) 
	{
		LinkedList<Long> lista = new LinkedList<Long>();
		lista.add(idProducto);
		Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaEstante() + "(id, nivelAbastecimiento, peso, volumen, categoria, idSucursal, idProductos) values (?,?,?,?,?,?,?)");
		q.setParameters(id, nivelAbastecimiento, peso, volumen, categoria, idSucursal, lista);
		return (long) q.executeUnique();
	}


	public long eliminarEstante(PersistenceManager pm, String idEstante)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaEstante() + "WHERE idEstante = ?");
		q.setParameters(idEstante);
		return (long) q.executeUnique();
	}

	public Estante darEstantePorCategoria (PersistenceManager pm, String categoria) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaEstante() + " WHERE categoria = ?");
		q.setResultClass(Estante.class);
		q.setParameters(categoria);
		return (Estante) q.executeUnique();
	}
	
	public long agregarProductoAEstante(PersistenceManager pm, String categ, long idProducto) {

		Query n = pm.newQuery(SQL, "SELECT idProductos FROM "+ ps.darTablaEstante()+" WHERE categoria = ?");
		n.setParameters(categ);
		List<Long> lista = n.executeList();
		Query q = pm.newQuery(SQL, "UPDATE " + ps.darTablaEstante() + " SET idProductos = ? WHERE categoria = ?");
		lista.add(idProducto);
		q.setParameters(lista, categ);
		return (long) q.executeUnique(); 
	}
	
	
}
