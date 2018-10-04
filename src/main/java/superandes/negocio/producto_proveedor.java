package superandes.negocio;

public class producto_proveedor  implements VOProducto_proveedor{
	
	
	long idProveedor, idProducto;
	
	
	public producto_proveedor() {
		idProducto = 0;
		idProveedor = 0;
	}
	
	public producto_proveedor(long idProducto, long idProveedor) {
		
	    this.idProveedor = idProveedor;
	    this.idProducto = idProducto;
	}
	
	@Override 
	public long getIdProveedor() {
		return idProveedor;
	}
	
	public void setIdProveedor(long id) {
		idProveedor = id;
	}
	
	@Override
	public long getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(long id) {
		idProducto = id;
	}
	
	

}
