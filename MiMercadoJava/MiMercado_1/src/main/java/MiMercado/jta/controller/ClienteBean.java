package MiMercado.jta.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import MiMercado.jta.dao.ClienteDao;
import MiMercado.jta.model.Cliente;

@ManagedBean (name="ClienteBean")
@SessionScoped

public class ClienteBean {
	
	private String cedula = "";
	private String correo = "";
	private String password = "";
	private String nombre="";
	private String apellido ="";
	private String confirmarPassword = "";
	
	
	
	
public String getCedula() {
		return cedula;
	}




	public void setCedula(String cedula) {
		this.cedula = cedula;
	}




	public String getCorreo() {
		return correo;
	}




	public void setCorreo(String correo) {
		this.correo = correo;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public String getConfirmarPassword() {
		return confirmarPassword;
	}




	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}




public String registrarCliente() {
	
	Cliente cliente = new Cliente(cedula, correo, password, nombre, apellido);
	ClienteDao clientedao = new ClienteDao();
	
	boolean guardarDatos = clientedao.guardar_Cliente(cliente);
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		boolean ingreso = true;
		
        if (nombre.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nombre obligatorio", "Nombre obligatorio" ));
			ingreso = false;
		}
        
        if (apellido.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Apellido obligatorio", "Apellido obligatorio" ));
			ingreso = false;
		}
        
        if (correo.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Correo obligatorio", "Correo obligatorio" ));
			ingreso = false;
		}
		
        if (cedula.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "cedula obligatorio", "cedula obligatorio" ));
			ingreso = false;
		}
        
        if (password.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "contraseña obligatorio", "contraseña obligatorio" ));
			ingreso = false;
		}
        
        if (confirmarPassword.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "confirma contraseña", "Confirma contraseña" ));
			ingreso = false;
		}
        
        if (ingreso) {
        	
        	if(password.equals(confirmarPassword) == false) {
        		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "las contraseñas deben coincidir", "las contraseñas deben conincidir" ));
    			ingreso = false;
        	}
        	else {
        		if(guardarDatos) {
        			String strMensaje= "Se guardaron correctamente los datos del socio "+nombre;
        			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
        					strMensaje, strMensaje));
        			return "index_promos.xhtml";
        		}else
        		{
        			String strMensaje= "NO Se guardaron correctamente los datos del socio "+nombre;
        			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
        					strMensaje, strMensaje));
        			
        		}

        		
        	}
        	
        }
		
		return "";
		
	}
	

}
