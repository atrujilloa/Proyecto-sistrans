package superandes.negocio;

import java.util.LinkedList;

public interface VOSucursal {

	public long getIdSucursal();
	
	public double getTamañoInstalacion();
	
	public String getIdSupermercado();
	
	public double getNivelReorden();
	
	public LinkedList<String> getIdProveedor();
	
	@Override
	public String toString();
}
