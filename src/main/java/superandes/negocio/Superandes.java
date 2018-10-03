package superandes.negocio;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
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
	 * Metodos para manejar los clientes
	 ***************************************************/
	/**
	 * Adiciona de manera persistente un tipo de bebida 
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepción
	 */
	public Cliente registrarCliente(int documento, int nit, String nombre, String direccion, String correo, String tipo)
	{
        log.info ("Adicionando cliente: " + nombre);
        Cliente cliente = ps.registrarCliente(nombre, correo, documento, tipo, nit, direccion); 		
        log.info ("Adicionando cliente: " + cliente);
        return cliente;
	}
	
	/**
	 * Elimina un tipo de bebida por su nombre
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida a eliminar
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarClientePorNombre (String nombre)
	{
		log.info ("Eliminando cliente por nombre: " + nombre);
        long resp = ps.eliminarClientePorNombre (nombre);		
        log.info ("Eliminando cliente por nombre: " + resp + " tuplas eliminadas");
        return resp;
	}
		
	/**
	 * Encuentra todos los tipos de bebida en Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos TipoBebida con todos los tipos de bebida que conoce la aplicación, llenos con su información básica
	 */
	public List<Cliente> darClientesPorNombre(String nombre)
	{
		log.info ("Consultando clientes");
        List<Cliente> clientes = ps.darCLientesPorNombre(nombre);	
        log.info ("Consultando clientes: " + clientes.size() + " existentes");
        return clientes;
	}


	/**
	 * Encuentra el tipos de bebida en Parranderos con el nombre solicitado
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre de la bebida
	 * @return Un objeto TipoBebida con el tipos de bebida de ese nombre que conoce la aplicación, 
	 * lleno con su información básica
	 */
	public Cliente darClientePorId (long idCliente)
	{
		log.info ("Buscando cliente por id: " + idCliente);
		Cliente tb = ps.darCLientePorId(idCliente);
		return tb;
	}
	
	public List<Cliente> darClientes()
	{
		log.info("Consultando los clientes");
		List<Cliente> list = ps.darClientes();
		log.info("Consultando clientes : " + list.size());
		return list;
	}
	
	/* *************************************************
	 * Metodos para manejar los estantes
	 ***************************************************/
	
	/**
	 * Adiciona de manera persistente un tipo de bebida 
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepción
	 */
	public Estante registrarEstante(int nivel, double volumen, double peso, String categoria, long idSucursal)
	{
        log.info ("Adicionando estante: " + nivel + volumen + peso);
        Estante estante = ps.registrarEstante(nivel, volumen, peso, categoria, idSucursal);
        log.info ("Adicionando estante: " + estante);
        return estante;
	}
	
	/**
	 * Elimina un tipo de bebida por su nombre
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida a eliminar
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarEstante(long idSucursal)
	{
		log.info ("Eliminando estante de la sucursal : " + idSucursal);
        long resp = ps.eliminarEstante(idSucursal);		
        log.info ("Eliminando estante por sucursal: " + resp + " tuplas eliminadas");
        return resp;
	}
		
	
	/* *************************************************
	 * Metodos para manejar los pedidos
	 ***************************************************/
	/**
	 * Adiciona de manera persistente un tipo de bebida 
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepción
	 */
	public Pedido registrarPedido(Date fechaPedido, Date fechaLlegada, long idSucursal, LinkedList<String> idProductos, long idProveedor)
	{
        log.info ("Adicionando pedido: " + fechaPedido + fechaLlegada + idSucursal + idProductos + idProveedor);
        Pedido pedido= ps.registrarPedido(fechaPedido, fechaLlegada, idSucursal, idProductos, idProveedor);
        log.info ("Adicionando pedido: " + pedido);
        return pedido;
	}
	
	/**
	 * Elimina un tipo de bebida por su nombre
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida a eliminar
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarPedido(long idSucursal, LinkedList<String> idProductos, long idProveedor)
	{
		log.info ("Eliminando pedido de productos de una sucursal a un proveedor: " + idSucursal + idProductos + idProveedor);
        long resp = ps.eliminarPedido(idSucursal, idProductos, idProveedor);		
        log.info ("Eliminando pedido de productos por una sucursal a un proveedor: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	public long registrarLlegadaPedido(Date fechaLlegada, long idPedido)
	{
		log.info("Registrando llegada de un pedido: " + fechaLlegada + idPedido);
		long resp = ps.registrarLlegadaPedido(fechaLlegada, idPedido);
		log.info("Registrando fecha llegada pedido: " + resp);
		return resp;
	}
		
	
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
	/**
	 * Adiciona de manera persistente un tipo de bebida 
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepción
	 */
	public Supermercado registrarSupermercado()
	{
        log.info ("Adicionando supermercado ");
        Supermercado supermercado= ps.registrarSupermercado();
        log.info ("Adicionando superercado: " + supermercado);
        return supermercado;
	}
	
	/**
	 * Elimina un tipo de bebida por su nombre
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida a eliminar
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarSupermercadoId(long idSupermercado)
	{
		log.info ("Eliminando supermercado: " + idSupermercado);
        long resp = ps.eliminarSupermercadoId(idSupermercado);
        log.info ("Eliminando supermercado : " + resp + " tuplas eliminadas");
        return resp;
	}
}