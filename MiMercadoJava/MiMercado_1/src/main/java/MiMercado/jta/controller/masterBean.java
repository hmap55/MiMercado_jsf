package MiMercado.jta.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import MiMercado.jta.dao.ProductoDao;


@ManagedBean (name="masterBean")
@SessionScoped
public class masterBean {
	private String tipId;
	private String id;
	private String nombre;
	private String numTarjeta;
	private String codigo;
	private String fecha;
	private String correo;
	
	
	
	public String getTipId() {
		return tipId;
	}
	public void setTipId(String tipId) {
		this.tipId = tipId;
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
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String verificar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		boolean datos = true;
		/*context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, correo, correo));*/
		
		if (id.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "documento obligatorio", "documento obligatorio" ));
			datos = false;
		}
		
		if (tipId.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "tipo de documento obligatoria", "tipo de documento obligatoria" ));
			datos = false;
		}
		
        if (nombre.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "nombre obligatoria", "nombre obligatoria" ));
			datos = false;
		}
        
        if (numTarjeta.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "numero de tarjeta obligatoria", "numero de tarjeta obligatoria" ));
			datos = false;
		}
        
       if (codigo.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "codigo de seguridad obligatoria", "codigo de seguridad obligatoria" ));
			datos = false;
		}
       
       if (fecha.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "fecha de vencimiento obligatoria", "fecha de vencimiento obligatoria" ));
			datos = false;
		}
       
       if (correo.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "correo obligatorio", "correo obligatoria" ));
			datos = false;
		}
       
       if (datos) {
    	   
    	   ProductoDao limpiar = new ProductoDao();
   		   limpiar.limpiarTabla();
   		   
   		   context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "!PAGO EXITOSO", "!PAGO EXITOSO" ));
   		   
    	   return "";
       }
       
       return "";
        
        
        
	}

}
