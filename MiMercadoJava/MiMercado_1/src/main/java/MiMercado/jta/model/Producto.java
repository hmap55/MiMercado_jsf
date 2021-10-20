package MiMercado.jta.model;

public class Producto {
	
	private String id, 
	nombre,
	url,
	seccion;
	
	private double precio, total;
	private int inventario, cantidad;
	
	public Producto(String id, String nombre,double precio, int inventario, String url, String seccion, int cantidad, double total) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.inventario = inventario;
		this.url = url;
		this.seccion = seccion;
		this.cantidad = cantidad;
		this.total = total;
	}
	
	

	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getInventario() {
		return inventario;
	}

	public void setInventario(int inventario) {
		this.inventario = inventario;
	}
	
	
	
	

}
