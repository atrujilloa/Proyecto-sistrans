package superandes.negocio;

import java.util.Date;
import java.util.LinkedList;

public class Pedido implements VOPedido{
	
	
	public final static String SOLICITADO = "Solicitado";
	public final static String ENTREGADO = "Entregado";

	/* ***************************************************************
	 * Atributos
	 *****************************************************************/
	private long idPedido;
	
	private Date fechaPedido;
	
	private Date fechaLLegada;
	
	private String estadoPedido;
	//---------------------------- Asociaciones -----------------------------//
	private long idSucursal;
	
	private LinkedList<Long> idProductos;
	
	private long idProveedor;
	
	//---------------------------- Constructor -----------------------------//

	public Pedido() {
		this.idPedido = 0;
		this.fechaPedido = new Date();
		this.fechaLLegada = new Date();
		this.idSucursal = 0;
		this.idProductos = new LinkedList<Long>();
		this.idProveedor = 0;
		this.estadoPedido = "";
	}
	
	public Pedido(long id, Date fechaPedido, Date fechaLlegada ,long idSucursal,long idProveedor, String estadoPedido)
	{
		this.idPedido = id;
		this.fechaPedido = fechaPedido;
		this.fechaLLegada = fechaLlegada;
		this.idSucursal = idSucursal;
		idProductos = new LinkedList<>();
		this.idProveedor = idProveedor;
		this.estadoPedido = estadoPedido;
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
	public LinkedList<Long> getIdProductos() {
		return idProductos;
	}
	
	public void setIdProductos( LinkedList<Long> id)
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
	public String getEstadoPedido() {
		return estadoPedido;
	}
	
	public void setEstadoPedido(String estadoPed)
	{
		this.estadoPedido = estadoPed;
	}
	
	
	@Override
	public String toString()
	{
		return "Pedido [idPedido = " + idPedido + "fechaPedido " + fechaPedido + "fechaLlegada" + fechaLLegada + "idSucursal " + idSucursal + "idProductos " + idProductos + "idProveedor " + idProveedor + "]";
	}


}
