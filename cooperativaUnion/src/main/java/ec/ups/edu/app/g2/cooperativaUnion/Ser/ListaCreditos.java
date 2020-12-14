package ec.ups.edu.app.g2.cooperativaUnion.Ser;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.EN.CreditoPres;
import ec.edu.ups.bussiness.CreditoPresON;

@Path("/ListaCredito")
public class ListaCreditos {
	
	@Inject
	private CreditoPresON credon;

	@GET
	@Produces("application/json")
	public List<CreditoPres> listCreditos(@QueryParam("numeroCuenta") String numeroCuenta) {
		return credon.listarCredito(numeroCuenta);
	}
}
