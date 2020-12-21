package ec.ups.edu.app.g2.cooperativaUnion.utils;

import java.util.UUID;

import ec.ups.edu.app.g2.cooperativaUnion.EN.Usuario;

public class PasswordAleatoreo {
	
	Usuario u ;
	
	public void password( ) {
		String contrasena = "";
		contrasena = UUID.randomUUID().toString().toLowerCase().substring(0,11);
		u.setPassword(contrasena);
		
	}

}
