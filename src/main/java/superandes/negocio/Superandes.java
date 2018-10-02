package superandes.negocio;

import java.util.logging.Logger;

import com.google.gson.JsonObject;

import superandes.persistencia.PersistenciaSuperandes;

public class Superandes {


	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(Superandes.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaSuperandes ps;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public Superandes ()
	{
		ps = PersistenciaSuperandes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public Superandes (JsonObject tableConfig)
	{
		ps = PersistenciaSuperandes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		ps.cerrarUnidadPersistencia ();
	}
	
	/* *************************************************
	 * Metodos para manejar las bodegas
	 ***************************************************/
	
	/**
	 * Adiciona de manera persistente una bodega
	 * Adiciona entradas al log de la aplicación
	 * @param id- El id de la bodega
	 * @return El objeto bodega adicionado. null si ocurre alguna Excepción
	 */
	
	/* *************************************************
	 * Metodos para manejar las categorias de productos
	 ***************************************************/
	
	/* *************************************************
	 * Metodos para manejar los clientes
	 ***************************************************/
	
	/* *************************************************
	 * Metodos para manejar los estantes
	 ***************************************************/
	
	/* *************************************************
	 * Metodos para manejar los pedidos
	 ***************************************************/
	
	/* *************************************************
	 * Metodos para manejar los productos
	 ***************************************************/
	
	/* *************************************************
	 * Metodos para manejar los proveedores
	 ***************************************************/
	
	/* *************************************************
	 * Metodos para manejar las sucursales
	 ***************************************************/
	
	/* *************************************************
	 * Metodos para manejar los supermercados
	 ***************************************************/

}