	package superandes.negocio;

import java.util.LinkedList;

public class Venta implements VOVenta {
	
	
	//-------------------------------------------------------------------
	// Atributos 
	// -----------------------------------------------------------------
	
	private long idVenta;
	
	private LinkedList<String> idProductos;
	
	private long idCliente;
	
	
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
