package superandes.persistencia;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import java.util.List;
import javax.jdo.PersistenceManagerFactory;


public class PersistenciaSuperandes {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaSuperandes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	
	private static PersistenciaSuperandes instance;
	
	private PersistenceManagerFactory pmf;
	
	private List<String> tablas;
	
	private SQLUtil sqlUtil;
	
	public static  PersistenciaSuperandes getInstance() {
		return null;
	}

	public static PersistenciaSuperandes getInstance(JsonObject tableConfig) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cerrarUnidadPersistencia() {
		// TODO Auto-generated method stub
		
	}

}
