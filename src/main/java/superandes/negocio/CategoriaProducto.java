package superandes.negocio;

public class CategoriaProducto implements VOCategoriaProducto{

	
	/* ******************************************
	 * Atributos
	 ********************************************/
	
	private String idCategoria;

	public  CategoriaProducto() {
		this.idCategoria = "";
	}
	
	public CategoriaProducto(String idCategoria)
	{
		this.idCategoria = idCategoria;
	}
	
	@Override
	public String getIdCategoria() {
		// TODO Auto-generated method stub
		return idCategoria;
	}
	
	public void setIdCategoria(String id)
	{
		this.idCategoria = id;
	}
	
	@Override
	public String toString() {
		return "CategoriaProducto [idCategoria =" + idCategoria	+ "]";

	}
}
