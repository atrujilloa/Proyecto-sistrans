package superandes.negocio;

import java.util.LinkedList;

public interface VOEstante {

	public int getNivelAbastecimiento();
	
	public double getPeso();
	
	public double getVolumen();
	
	public String getIdSucursal();
	
	public long getIdEstante();
	
	public String getCategoria();
	
	public LinkedList<String> getIdProductos();
	
}
