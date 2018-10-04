package superandes.negocio;

public class Ventas_sucursal implements VOVentas_sucursal {
	
private long idVenta; 
private String idSucursal;
	
	public Ventas_sucursal() {
		
		idVenta = 0;
		idSucursal= "";
	}
	
	public Ventas_sucursal(long idV, String idSuc) {
		idVenta = idV;
		idSucursal = idSuc;
	}
	
	@Override 
	public long getIdVenta() {
		return idVenta;
	}
	
	@Override
	public String getIdSucursal(){
		return idSucursal;
	}
	
	public void setIdVenta(long id) {
		idVenta = id;
	}
	
	public void setIdSucursal(String id) {
		idSucursal = id;
	}

}
