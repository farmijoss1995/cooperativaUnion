package ec.ups.edu.app.g2.cooperativaUnion.Controlador;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.ups.edu.app.g2.cooperativaUnion.utils.Mail;

@ManagedBean
@SessionScoped
public class MailBean implements Serializable {

	private String destinatario;
	private String asunto;
	private String cuerpo;

	
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public void send() {
		try {
			
			Mail mail = new Mail();
			mail.enviarMail(destinatario, asunto, cuerpo);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
