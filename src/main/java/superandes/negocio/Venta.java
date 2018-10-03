	package superandes.negocio;

import java.util.LinkedList;

public class Venta implements VOVenta {
	
	
	//-------------------------------------------------------------------
	// Atributos 
	// -----------------------------------------------------------------
	
	private long idVenta;
	
	private double total;
	
	private LinkedList<String> idProductos;
	
	private long idCliente;
	
	private String idSucursal;
	
	
	public Venta() {
		idVenta = 0;
		total = 0;
		idProductos = new LinkedList<>();
		idCliente = 0;
		idSucursal ="";
	}
	
	public Venta(long idVenta, double total, long idCliente, String idSucursal)
	{
		this.idVenta = idVenta;
		this.total = total;
		this.idCliente = idCliente;
		this.idSucursal = idSucursal;
	}
	
	//--------------------------------------------------------------------
	// Metodos
	//--------------------------------------------------------------------
	
	@Override
	public long getIdVenta() {
		return idVenta;
	}
	
	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}
	
	@Override
	public String getIdSucursal() {
		return idSucursal;
	}
	
	public void setIdSucursal(String ids) {
		this.idSucursal = ids;
	}
	
	@Override
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double ids) {
		this.total = ids;
	}
	
	@Override
	public LinkedList<String> getIdProductos(){
		return idProductos;
	}
	
	public void setGetIdProductos(LinkedList<String> list) {
		
		idProductos = list;
	}
	
	@Override
	public long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(long idCliente) {
		
          this.idCliente = idCliente;
	}
	
	
	
	

}
