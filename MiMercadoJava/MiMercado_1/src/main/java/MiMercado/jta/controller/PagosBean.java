package MiMercado.jta.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name="PagosBean")
@SessionScoped
public class PagosBean {
	private String opcionPago;

	public String getOpcionPago() {
		return opcionPago;
	}

	public void setOpcionPago(String opcionPago) {
		this.opcionPago = opcionPago;
	}
	
	
	public String opcion() {
		if (opcionPago.equals("pse")) {
			return "pse.xhtml";
		}
		else {
			return "Mastercard.xhtml";
		}
	}
	
	public String cancelar() {
		return "index_promos.xhtml";
	}

}
