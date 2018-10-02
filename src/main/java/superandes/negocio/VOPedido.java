package superandes.negocio;

import java.util.Date;
import java.util.LinkedList;

public interface VOPedido {
	
	public String getIdPedido();
	
	public Date getFechaPedido();
	
	public Date getFechaLlegada();
	
	public String getIdSucursal();
	
	public LinkedList<String> getIdProductos();
	
	public LinkedList<String> getIdProveedores();

}
