package MiMercado.jta.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import MiMercado.jta.dao.ProductoDao;

@ManagedBean (name="pseBean")
@SessionScoped
public class pseBean {
	
		private String tipId;
		private String id;
		private String banco;
		private String nombre;
		private String celular;
		private String direccion;
		private String correo;
		private String edad;
		
		
		
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



		public String getBanco() {
			return banco;
		}



		public void setBanco(String banco) {
			this.banco = banco;
		}



		public String getNombre() {
			return nombre;
		}



		public void setNombre(String nombre) {
			this.nombre = nombre;
		}



		public String getCelular() {
			return celular;
		}



		public void setCelular(String celular) {
			this.celular = celular;
		}



		public String getDireccion() {
			return direccion;
		}



		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}



		public String getCorreo() {
			return correo;
		}



		public void setCorreo(String correo) {
			this.correo = correo;
		}



		public String getEdad() {
			return edad;
		}



		public void setEdad(String edad) {
			this.edad = edad;
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
	        
            if (banco.equals("")) {
				
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "seleccione entidad", "seleccione entidad" ));
				datos = false;
			}
	        
	        if (celular.equals("")) {
				
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "introduzca numero celular", "introduzca numero celular" ));
				datos = false;
			}
	        
	       if (direccion.equals("")) {
				
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "direccion de entrega", "direccion de entrega" ));
				datos = false;
			}
	       
	       if (edad.equals("")) {
				
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ingrese edad", "ingrese edad" ));
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

