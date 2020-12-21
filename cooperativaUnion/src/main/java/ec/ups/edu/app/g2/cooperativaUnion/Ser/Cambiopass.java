package ec.ups.edu.app.g2.cooperativaUnion.Ser;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.ups.edu.app.g2.cooperativaUnion.modelo.UsuarioON;
import ec.ups.edu.app.g2.cooperativaUnion.utils.Respuesta;
import ec.ups.edu.app.g2.cooperativaUnion.utils.Trans;
import ec.ups.edu.app.g2.cooperativaUnion.utils.UsuarioTemp;

@Path("/cambiopass")
public class Cambiopass {
	@Inject
	private UsuarioON clienteON;

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	
	public Respuesta transacciones( UsuarioTemp sesion) {
		Respuesta r = new Respuesta();
		try {
			r = clienteON.cambioContrasenia(sesion);
		} catch (Exception e) {
		e.printStackTrace();
		r.setCodigo(88);
		r.setMensaje(e.getMessage());
		}
		return r;
	}

}
