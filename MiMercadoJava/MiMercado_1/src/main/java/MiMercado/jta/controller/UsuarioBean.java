package MiMercado.jta.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import MiMercado.jta.dao.UsuarioDao;

@ManagedBean (name="UsuarioBean")
@SessionScoped
public class UsuarioBean {
	
	private String cedula = "";
	private String correo = "";
	private String password = "";
	private String nombre="";
	private String apellido ="";
	private String confirmarPassword = "";
	
	
	
	
	
	
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	
	
	
	
	
	UsuarioDao usuariodao = new UsuarioDao();
	
	
	public String validarUsuario() {
		
		//mostrar mensajes en xhtml
		FacesContext context = FacesContext.getCurrentInstance();
		boolean datos = true;
		/*context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, correo, correo));*/
		
		if (correo.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "correo obligatorio", "correo obligatorio" ));
			datos = false;
		}
		
		if (password.equals("")) {
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "contraseña obligatoria", "contraseña obligatoria" ));
			datos = false;
		}
		
		if (datos) {
			
			String nombre_usuario = usuariodao.getUsuario(correo, password);
			if (nombre_usuario.equals("")) {
				
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "datos incorrectos", "datos incorrectos" ));
				return "";
				
			}
			else {
				
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido al sistema" + nombre_usuario, "contraseña obligatoria" ));
				return "index_promos.xhtml";
			}
		}
		
		System.out.println("validar usuario");
		return "";
		
	}
	
	public String iniciarSesion() {
		return "registro.xhtml";
	}
	
	public String asignarUsuario() {
		UsuarioDao usuario = new UsuarioDao();
		return usuario.getUsuario(correo, password);
		
	}
	
	
	
	
	
	

}
