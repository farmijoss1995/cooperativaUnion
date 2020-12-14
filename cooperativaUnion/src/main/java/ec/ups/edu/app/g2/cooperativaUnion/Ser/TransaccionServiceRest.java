package ec.ups.edu.app.g2.cooperativaUnion.Ser;
import ec.edu.ups.bussiness.TransaccionON;
import ec.edu.ups.utils.Respuesta;
import ec.edu.ups.utils.Trans;
import javax.ws.rs.Consumes;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/cuenta")
public class TransaccionServiceRest {
	
	@Inject
	TransaccionON on;
	
	@POST
	@Path("/trx")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta transacciones( Trans trx) {
		Respuesta r = new Respuesta();
		try {
			r = on.Transacciones(trx);
		} catch (Exception e) {
		e.printStackTrace();
		r.setCodigo(99);
		r.setMensaje(e.getMessage());
		}
		return r;
	}

}
