package superandes.negocio;

import java.util.LinkedList;

public interface VOVenta {

	public long getIdVenta();

	public LinkedList<String> getIdProductos();

	public long getIdCliente();

	public String getIdSucursal();
	
	public double getTotal();

}
