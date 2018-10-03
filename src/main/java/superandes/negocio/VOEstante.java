package superandes.negocio;

import java.util.LinkedList;

public interface VOEstante {

	public int getNivelAbastecimiento();
	
	public double getPeso();
	
	public double getVolumen();
	
	public long getIdSucursal();
	
	public long getIdEstante();
	
	public String getCategoria();
	
	public LinkedList<Long> getIdProductos();
	
}
