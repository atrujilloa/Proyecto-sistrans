package superandes.negocio;

import java.util.List;
public interface VOProveedor {

	
	public int getNIT();
	
	public String getNombre();
	
	public double getCalificacionCalidad();
	
	public List<String> getIdProductos();
	
	@Override
	
	public String toString();
}
