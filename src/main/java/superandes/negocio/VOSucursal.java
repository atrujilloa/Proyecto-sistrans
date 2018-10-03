package superandes.negocio;

import java.util.LinkedList;

public interface VOSucursal {

	public String getIdSucursal();
	
	public double getTamañoInstalacion();
	
	public long getIdSupermercado();
	
	public double getNivelReorden();
	
	public LinkedList<String> getIdProveedor();
	
	@Override
	public String toString();

	public String getClave();
}
