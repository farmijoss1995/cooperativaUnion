package ec.ups.edu.app.g2.cooperativaUnion.Controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sound.midi.Soundbank;

import ec.edu.ups.EN.CreditoPres;
import ec.edu.ups.EN.CuentaAhorro;
import ec.edu.ups.EN.Empleado;
import ec.edu.ups.EN.Pago;
import ec.edu.ups.EN.Sesion;
import ec.edu.ups.EN.SolicitudCredito;
import ec.edu.ups.EN.Transaccion;
import ec.edu.ups.bussiness.SolicitudCreditoON;
import ec.edu.ups.bussiness.TransaccionON;

@Named
@ConversationScoped
public class TransaccionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private TransaccionON transaccOn;
	
	
	private Transaccion transaccion;
	private CuentaAhorro cuenta;
	private CreditoPres credito;
	private Pago pago;
	private String numcuenta;
	private List<Transaccion> transacciones;

	private int codigo;
	private String ncuenta;
	private int codigo2;

	@PostConstruct
	public void init() {
		transaccion = new Transaccion();
		credito = new CreditoPres();
		cuenta = new CuentaAhorro();
		pago = new Pago();
	}

	public String guardarTransaccion(String numeroCuenta) {
		cuenta = transaccOn.getCuenta(numeroCuenta);
		transaccion.setCuenta(cuenta);
		transaccOn.nuevaTransaccion(transaccion,cuenta);
		return "Transacciones?faces-redirect=true";
	}
	
	public String guardarTransaccion2(int codigo, double monto, int codpago) {
		credito = transaccOn.getCredito(codigo);
		transaccion.setMonto(monto);
		transaccion.setCredito(credito);
		pago = transaccOn.getPago(codpago);
		pago.setCreditoPres(credito);
		transaccOn.TransPagoCredito(transaccion, credito, pago);
		
		return ""+codigo;
	}

	public CuentaAhorro buscarCuenta(String numeroCuenta) {
		cuenta = transaccOn.getCuenta(numeroCuenta);
		return cuenta;
	}
	
	
	public CreditoPres getCredito() {
		return credito;
	}

	public void setCredito(CreditoPres credito) {
		this.credito = credito;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	

	public int getCodigo2() {
		return codigo2;
	}

	public void setCodigo2(int codigo2) {
		this.codigo2 = codigo2;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public List<Transaccion> loadDataTransaccion(String numcuenta) {
		transacciones = transaccOn.listaTransaciones(numcuenta);
		return transacciones;
	}

	public String pasarNumCuenta(String numcuenta) {
		
		SolicitudCreditoBean s = new SolicitudCreditoBean();
		s.setnumcuenta(numcuenta);
		
		return "vistaSolicitudCredito?faces-redirect=true&numcuenta="+ numcuenta;
		
	}
	
	public String verTransacciones(String  numcuenta) {
			this.numcuenta=numcuenta;
		 return "VistaClienteTransacciones?faces-redirect=true&numcuenta="+numcuenta;
	}
	
	//listar solicitudes
	public String verSolicitudes(String  numcuenta) {
		this.numcuenta=numcuenta;
	 return "VistaClienteSolicitudes?faces-redirect=true&numcuenta="+numcuenta;
	}
	
	public String paginaSolicitud(String  numcuenta) {
		this.numcuenta=numcuenta;
	 return "vistaSolicitudCredito?faces-redirect=true&numcuenta="+numcuenta;
}

	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	public CuentaAhorro getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaAhorro cuenta) {
		this.cuenta = cuenta;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public String getNumcuenta() {
		return numcuenta;
	}

	public void setNumcuenta(String numcuenta) {
		this.numcuenta = numcuenta;
	}

	public String getNcuenta() {
		return ncuenta;
	}

	public void setNcuenta(String ncuenta) {
		this.ncuenta = ncuenta;
	}

	public int recuperar(int codigo2) {
		this.codigo = codigo2;
		return codigo;
	}
	public int recuperar2(int codigo3) {
		codigo2 = codigo3;
		return codigo2;
	}
	

}
