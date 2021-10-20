package MiMercado.jta.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import MiMercado.jta.dao.TablaDao;

@ManagedBean (name="TablaBean")
@SessionScoped
public class TablaBean {

	private String id ="";
	private String url="";
	private String nombre="";
	private String precio ="";
	private String cantidad ="";
	private String total = "";
	
	
	
	
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




	public String getPrecio() {
		return precio;
	}




	public void setPrecio(String precio) {
		this.precio = precio;
	}




	public String getCantidad() {
		return cantidad;
	}




	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}




	public String getTotal() {
		return total;
	}




	public void setTotal(String total) {
		this.total = total;
	}




	public ArrayList  listarTabla()
	{
		//FacesContext context = FacesContext.getCurrentInstance();
		TablaDao tabla = new TablaDao();
		
		ArrayList listaTabla = new ArrayList();
		try 
		{
			listaTabla = tabla.getProductos();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return listaTabla;
	}
	
	
	
	public String actualizar(ArrayList producto) {
		
		TablaDao table = new TablaDao();
		id = (String)producto.get(0);
		String total_1 = (String) producto.get(2);
		double precio_1 = Double.parseDouble(total_1);
		double total_2 = precio_1 * Integer.parseInt(cantidad);
		
		
		table.modificar_cantidad(id, Integer.parseInt(cantidad), total_2);
		
		
		System.out.println(id + "  " + getCantidad());
		
		return "";
		
		
	}
	
	public String borrar(ArrayList producto) {
		
		TablaDao table = new TablaDao();
		id = (String)producto.get(0);
		
		table.eliminar(id);
		
		return "";
		
	}
	
}
