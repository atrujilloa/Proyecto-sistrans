package superandes.negocio;

import java.util.Date;
import java.util.LinkedList;

public class Pedido implements VOPedido{

	/* ***************************************************************
	 * Atributos
	 *****************************************************************/
	private long idPedido;
	
	private Date fechaPedido;
	
	private Date fechaLLegada;
	//---------------------------- Asociaciones -----------------------------//
	private long idSucursal;
	
	private LinkedList<String> idProductos;
	
	private long idProveedor;
	
	//---------------------------- Constructor -----------------------------//

	public Pedido() {
		this.idPedido = 0;
		this.fechaPedido = new Date();
		this.fechaLLegada = new Date();
		this.idSucursal = 0;
		this.idProductos = new LinkedList<String>();
		this.idProveedor = 0;
	}
	
	public Pedido(long id, Date fechaPedido, Date fechaLlegada ,long idSucursal,long idProveedor)
	{
		this.idPedido = id;
		this.fechaPedido = fechaPedido;
		this.fechaLLegada = fechaLlegada;
		this.idSucursal = idSucursal;
		idProductos = new LinkedList<>();
		this.idProveedor = idProveedor;
	}
	
	//--------------------------------- Métodos -------------------------------------//

	@Override
	public long getIdPedido() {
		return idPedido;
	}
	
	public void setIdPedido(long id)
	{
		this.idPedido = id;
	}

	@Override
	public long getIdSucursal() {
		return idSucursal;
	}
	
	public void setIdSucursal(long id)
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
	public long getIdProveedor() {
		return idProveedor;
	}
	
	public void setIdProveedores(long id)
	{
		this.idProveedor = id;
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
		return "Pedido [idPedido = " + idPedido + "fechaPedido " + fechaPedido + "fechaLlegada" + fechaLLegada + "idSucursal " + idSucursal + "idProductos " + idProductos + "idProveedor " + idProveedor + "]";
	}


}
