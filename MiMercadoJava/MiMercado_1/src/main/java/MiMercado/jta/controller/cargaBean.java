package MiMercado.jta.controller;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import MiMercado.jta.dao.cargaDao;
import MiMercado.jta.model.Producto;

@ManagedBean (name="cargaBean")
@SessionScoped
public class cargaBean {
	
	int valor = 0;
	
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getUrl() {
		cargaDao carga = new cargaDao();
		return carga.getProducto().get(4);
		
	}
	
	public String getNombre() {
		cargaDao carga = new cargaDao();
		return carga.getProducto().get(1);
		
	}
	
	public String getPrecio() {
		cargaDao carga = new cargaDao();
		return carga.getProducto().get(2);
		
	}
	
	public String getCodigo() {
		cargaDao carga = new cargaDao();
		return carga.getProducto().get(0);
		
	}
	
	public String getInventario() {
		cargaDao carga = new cargaDao();
		return carga.getProducto().get(3);
		
	}
	
	
	public void sumar() {
		
		valor ++;
	
		
	}
	
    public void restar() {
    	
    	if (valor > 0) {
    		
    		valor --;
    	}
			
	}
    
    public String agregarLista() {
    	
    	FacesContext context = FacesContext.getCurrentInstance();
    	
    	if (valor == 0) {
    		
    		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "elija la cantidad de productos", "elija la cantidad de productos" ));
    		return "";
    	}
    	else {
    	cargaDao carga = new cargaDao();
    	double total = (valor * Double.parseDouble(carga.getProducto().get(2)));
    	Producto producto = new Producto(carga.getProducto().get(0),carga.getProducto().get(1),Double.parseDouble(carga.getProducto().get(2)),
    			Integer.parseInt(carga.getProducto().get(3)), carga.getProducto().get(4), carga.getProducto().get(5), valor, total );
    	carga.guardar_Producto(producto);
    	return "index_promos.xhtml";
    	}
    }
    
    public String total() {
    	cargaDao total = new cargaDao();
    	return total.getTotal();
    	
    }
    
    public String pago() {
    	
    	return "resumen.xhtml";
    }
	
	
	
}
