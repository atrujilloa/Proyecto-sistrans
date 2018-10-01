package superandes.negocio;

import java.sql.Date;

public interface VOProducto {
	
	/* **************************************
	 * Metodos
	 ****************************************/

	public String getNombre();
	
	public String getMarca();
	
	public double getPrecioUnitario();
	
	public double getPrecioUnidadMedida();
	
	public double getVolumenEmpaque();
	
	public double getPesoEmpaque();
	
	public String getCodigoBarras();
	
	public String getIdSucursal();
	
	public Date getFechaVencimiento();
	
	public String getIdEstante();
	
	public String getIdBodega();
	
}
