package ec.ups.edu.app.g2.cooperativaUnion.Ser;
import java.util.Date;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ec.ups.edu.app.g2.cooperativaUnion.EN.Sesion;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Usuario;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.UsuarioON;
import ec.ups.edu.app.g2.cooperativaUnion.Controlador.LoginBean;
import ec.ups.edu.app.g2.cooperativaUnion.utils.RestFilter;
import ec.ups.edu.app.g2.cooperativaUnion.utils.UsuarioTemp;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@Path("/login")
public class AuthWS {
	
	@Inject
	private UsuarioON clienteON;

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response login(UsuarioTemp sesion) {
		
		try {
			Usuario cliente;
			cliente = clienteON.login(sesion);
		
		if (cliente != null) {
			String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, RestFilter.KEY).setSubject("Banca_Movil")
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() * 100)).claim("correo", sesion.getEmail())
					.claim("nmeroCuenta", cliente.getCuenta().getNumeroCuenta()).compact();
			JsonObject json = Json.createObjectBuilder().add("jwt", jwt).build();
			return Response.status(Response.Status.CREATED).entity(json).build();
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}

}
