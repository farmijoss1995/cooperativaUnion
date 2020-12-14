package ec.ups.edu.app.g2.cooperativaUnion.Controlador;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class VerEstadoSolicitud implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String verPagos(int codigo){
		
		return "VistaTablaPagos?faces-redirect=true&codigo="+codigo;
		
	}
	public String verPagosCajero(int codigo){
		
		return "VistaTablaPagosCajero?faces-redirect=true&codigo="+codigo;
		
	}
}
