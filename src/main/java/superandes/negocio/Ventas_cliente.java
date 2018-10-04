package superandes.negocio;

public class Ventas_cliente implements VOVentas_cliente {
	

	private long idVenta;
	private long idCliente;
	
	
	public Ventas_cliente() {
		
		idVenta = 0;
		idCliente = 0;
	}
	
	public Ventas_cliente(long idV, long idC) {
		idVenta = idC;
		idCliente = idV;
	}
	
	@Override 
	public long getIdVenta() {
		return idVenta;
	}
	
	@Override
	public long getIdCliente(){
		return idCliente;
	}
	
	public void setIdProducto(long id) {
		idVenta = id;
	}
	
	public void setPedido(long id) {
		idCliente = id;
	}

}
