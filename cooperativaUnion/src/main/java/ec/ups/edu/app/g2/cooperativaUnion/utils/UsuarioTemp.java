package ec.ups.edu.app.g2.cooperativaUnion.utils;

import java.io.Serializable;

public class UsuarioTemp implements Serializable {
	private String email;
	private String clave;
	private String nuevaClave;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNuevaClave() {
		return nuevaClave;
	}

	public void setNuevaClave(String nuevaClave) {
		this.nuevaClave = nuevaClave;
	}
	
	
}