package ec.ups.edu.app.g2.cooperativaUnion.Ser;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.EN.CuentaAhorro;
import ec.edu.ups.bussiness.CuentaAhorroON;

@Path("/InfoCuenta")
public class InfoCuenta {
	
	@Inject
	private  CuentaAhorroON con;
	
	@GET
	@Produces("application/json")
	public CuentaAhorro misCuentas(@QueryParam("numeroCuenta") String numeroCuenta) {
		
		return con.misCuentas(numeroCuenta);
	}

}
