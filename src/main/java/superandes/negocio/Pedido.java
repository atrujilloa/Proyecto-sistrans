package superandes.negocio;

import java.util.Date;
import java.util.LinkedList;

public class Pedido implements VOPedido{

	/* ***************************************************************
	 * Atributos
	 *****************************************************************/
	private String idPedido;
	
	private Date fechaPedido;
	
	private Date fechaLLegada;
	//---------------------------- Asociaciones -----------------------------//
	private String idSucursal;
	
	private LinkedList<String> idProductos;
	
	private LinkedList<String> idProveedores;
	
	//---------------------------- Constructor -----------------------------//

	public Pedido() {
		this.idPedido = "";
		this.fechaPedido = new Date();
		this.fechaLLegada = new Date();
		this.idSucursal = "";
		this.idProductos = new LinkedList<String>();
		this.idProveedores = new LinkedList<String>();
	}
	
	public Pedido(String id, Date fechaPedido, Date fechaLlegada ,String idSucursal, LinkedList<String> idProductos, LinkedList<String> idProveedores)
	{
		this.idPedido = id;
		this.fechaPedido = fechaPedido;
		this.fechaLLegada = fechaLlegada;
		this.idSucursal = idSucursal;
		this.idProductos = idProductos;
		this.idProveedores = idProveedores;
	}
	
	//--------------------------------- Métodos -------------------------------------//

	@Override
	public String getIdPedido() {
		return idPedido;
	}
	
	public void setIdPedido(String id)
	{
		this.idPedido = id;
	}

	@Override
	public String getIdSucursal() {
		return idSucursal;
	}
	
	public void setIdSucursal(String id)
	{
		this.idSucursal = id;
	}

	@Override
	public LinkedList<String> getIdProductos() {
		return idProductos;
	}
	
	public void setIdProductos( LinkedList<String> id)
	{
		this.idProductos = id;
	}

	@Override
	public LinkedList<String> getIdProveedores() {
		return idProveedores;
	}
	
	public void setIdProveedores(LinkedList<String> id)
	{
		this.idProveedores = id;
	}
	
	@Override
	public Date getFechaPedido() {
		return fechaPedido;
	}
	
	public void setFechaPedido(Date fecha)
	{
		this.fechaPedido = fecha;
	}

	@Override
	public Date getFechaLlegada() {
		return fechaLLegada;
	}
	
	public void setFechaLlegada(Date fecha)
	{
		this.fechaLLegada = fecha;
	}
	
	@Override
	public String toString()
	{
		return "Pedido [idPedido = " + idPedido + "fechaPedido " + fechaPedido + "fechaLlegada" + fechaLLegada + "idSucursal " + idSucursal + "idProductos " + idProductos + "idProveedores " + idProveedores + "]";
	}


}
