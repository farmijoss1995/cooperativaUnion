package ec.ups.edu.app.g2.cooperativaUnion.Ser;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.EN.Pago;
import ec.edu.ups.bussiness.CreditoPresON;

@Path("/ListaPagos")
public class ListaPagos {

	@Inject
	private CreditoPresON credon;

	@GET
	@Produces("application/json")
	public List<Pago>listPagos(@QueryParam("codigo_pre") String cuenta1){
		
		return credon.listarMovil(cuenta1);
	}
	
	
}
