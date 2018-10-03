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
	
	private long idSucursal;
	
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
	public long getIdSucursal() {
		return idSucursal;
	}
	
	public void setIdSucursal(long ids) {
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
