package superandes.persistencia;

import java.util.LinkedList;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLPromocion {

		
		private static final String SQL = PersistenciaSuperandes.SQL;
		
		private PersistenciaSuperandes ps;
		
		public SQLPromocion(PersistenciaSuperandes ps)
		{
			this.ps = ps;
		}
		
		public long registrarPromocion(PersistenceManager pm, String idPromocion, LinkedList<String> productos, String tipoPromocion)
		{
			Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaPromocion() + "(idPromocion, idProductos, tipoPromocion) values (?,?,?)");
			q.setParameters(idPromocion, productos, tipoPromocion);
			return (long) q.executeUnique();
		}
		
		
		/** VERIFICAR 
		 
		public long eliminarPromocion(PersistenceManager pm)
		{
			Query q = pm.newQuery(SQL, "DELETE FROM " + ps.darTablaPromocion());
			return (long) q.executeUnique();
		}
		**/

		
		
}
