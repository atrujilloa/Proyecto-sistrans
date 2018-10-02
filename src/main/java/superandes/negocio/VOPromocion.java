package superandes.negocio;

import java.util.LinkedList;

public interface VOPromocion {
	
	
	public String getIdPromocion();
	
	public LinkedList<String> getIdProducto();
	
	public String getTipoPromocion();
	
	@Override
	public String toString();
	

}
