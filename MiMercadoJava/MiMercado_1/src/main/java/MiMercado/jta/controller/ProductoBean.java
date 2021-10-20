package MiMercado.jta.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import MiMercado.jta.dao.ProductoDao;

@ManagedBean (name="ProductoBean")
@SessionScoped

public class ProductoBean {
	
	private String id;
	private String url;
	private String nombre;
	private double precio;
	private int inventario;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
	public String cargarDatos() {
		
		ProductoDao producto = new ProductoDao();
		producto.getProducto(nombre);
		producto.setProducto();
		System.out.println(nombre);
		
		return "index-producto.xhtml";
		
	}
	
	public void asignar(ActionEvent e) {
		nombre = (String) e.getComponent().getAttributes().get("valor");
	}
	
	public String limpiarCompras() {
		
		ProductoDao limpiar = new ProductoDao();
		limpiar.limpiarTabla();
		return "inicio.xhtml";
	}
	
    public String limpiarTabla() {
		
		ProductoDao limpiar = new ProductoDao();
		limpiar.limpiarTabla();
		return "";
	}
	
	

}
