package ec.ups.edu.app.g2.cooperativaUnion.Ser;

import javax.inject.Inject;
//import javax.jws.WebMethod;
//import javax.jws.WebService;

import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Transaccion;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.TransaccionON;
import ec.ups.edu.app.g2.cooperativaUnion.utils.Respuesta;
import ec.ups.edu.app.g2.cooperativaUnion.utils.Trans;

//@WebService
public class TransaccionService {
	@Inject
	TransaccionON on;
	
	//@WebMethod
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
