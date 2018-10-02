package superandes.negocio;

import java.util.Date;

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
	
	public long getIdSucursal();
	
	public Date getFechaVencimiento();
	
	public long getIdEstante();
	
	public long getIdBodega();
	
}
