package ec.ups.edu.app.g2.cooperativaUnion.Ser;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.EN.CuentaAhorro;
import ec.edu.ups.EN.Transaccion;
import ec.edu.ups.bussiness.TransaccionON;
import ec.edu.ups.utils.Respuesta;
import ec.edu.ups.utils.Trans;

@WebService
public class TransaccionService {
	@Inject
	TransaccionON on;
	
	@WebMethod
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
