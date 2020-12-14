package ec.ups.edu.app.g2.cooperativaUnion.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import ec.ups.edu.app.g2.cooperativaUnion.DAO.CreditoPreDAO;
import ec.ups.edu.app.g2.cooperativaUnion.DAO.CuentaAhorroDAO;
import ec.ups.edu.app.g2.cooperativaUnion.DAO.PagoDAO;
import ec.ups.edu.app.g2.cooperativaUnion.EN.CreditoPres;
import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Pago;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Sesion;
import ec.ups.edu.app.g2.cooperativaUnion.utils.Decimales;
import ec.ups.edu.app.g2.cooperativaUnion.utils.Mail;
import ec.ups.edu.app.g2.cooperativaUnion.utils.PrestamoTemp;

@Stateless
public class CreditoPresON {
	@Inject
	private CuentaAhorroON cdao;

	@Inject
	private CreditoPreDAO credao;

	@Inject
	private PagoDAO pagodao;
	
	@Inject
	private CuentaAhorroDAO daoc;
	
	
	Mail mail = new Mail();

	public void Credito(PrestamoTemp t) {
		CuentaAhorro cue = cdao.verCuentaAhorro(t.getNumcuenta());
		if (cue != null) {
			CreditoPres cre = new CreditoPres();
			cre.setMonto(t.getMonto());
			cre.setSaldo(t.getMonto());
			cre.setTipo(t.getTipo());
			Double dos = cue.getSaldoCuenta()+t.getMonto();
			cue.setSaldoCuenta(dos);
			try {
				daoc.update(cue);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			cre.setFecha(formateador.format(new Date()));
			String fecha = formateador.format(new Date());
			t.setPagouno(fecha);
			int dia = Integer.parseInt(t.getPagouno().substring(0, 2));
			int mes = Integer.parseInt(t.getPagouno().substring(4, 5));
			int anio = Integer.parseInt(t.getPagouno().substring(6, 10));
			mes=mes+1;
			Decimales d = new Decimales();
			
			List<Pago> listap = new ArrayList<Pago>();
			
			Pago p2 = new Pago();
			for (int i = 1; i <= t.getCuotas(); i++) {
				Pago p = new Pago();
				p.setCuenta(t.getNumcuenta());
				p2.setFechaPago("" + dia + "/" + mes + "/" + anio);
				p.setFechaPago("" + dia + "/" + mes + "/" + anio);
				p.setNumeroPago(i);
				double cuota = t.getMonto() / t.getCuotas();
				p.setValor(d.redondearDecimales(cuota, 2));
				p.setSaldo(d.redondearDecimales(cuota, 2));
				p.setEstado("Pendiente");
				cre.agregarpago(p);
				mes++;
				if (mes >= 13) {
					anio++;
					mes = 1;
				}
				listap.add(p);
				
			}
			try {
				mail.enviarMail(cue.getUsuario().getCorreo(), "Se ha aprobado su prestamo", "DATOS PAGO>>>>>>>" + listap.toString());
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			cre.setFechaFin(p2.getFechaPago());
			cue.agregarCredito(cre);
			credao.crearCreditoPres(cre);
			cue.getUsuario().getCorreo();
			
		} else {
			System.out.println("la cuenta no existe");
		}
	}

	public CreditoPres Lista(int codigo) {
		CreditoPres cre = credao.buscarCreditoPres(codigo);
		return cre;
	}
	
	public List<CreditoPres> listarCredito(String numeroCuenta) {
		return credao.buscarCreditoPres2(numeroCuenta);	
	}
	public List<Pago> listarPagos(int codigo_pre) {
		return pagodao.listaPagos(codigo_pre);
	}
	public List<Pago> listarMovil(String cuenta) {
		return pagodao.listaPagosMovil(cuenta);
	}
	public List<Pago> listarPagosCajero(int codigo_pre) {
		return pagodao.listaPagosCajero(codigo_pre);
	}


}
