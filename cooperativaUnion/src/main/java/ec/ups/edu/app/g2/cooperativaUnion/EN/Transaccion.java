package ec.ups.edu.app.g2.cooperativaUnion.EN;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
@Entity
public class Transaccion{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date fecha;
	private Double monto;
	@JoinColumn(name = "tipo_transaccion")
	private String tipoTransaccion;
	
	@OneToOne
	@JoinColumn(name = "cuenta_numeroCuenta", referencedColumnName = "numeroCuenta")
	private CuentaAhorro cuenta;
	
	@OneToOne
	@JoinColumn(name = "credito_idcredito", referencedColumnName = "codigo")
	private CreditoPres credito;
	
	
	@XmlTransient
	private String cuent;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public CuentaAhorro getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaAhorro cuenta) {
		this.cuenta = cuenta;
	}

	public String getCuent() {
		return cuent;
	}
	public void setCuent(String cuent) {
		this.cuent = cuent;
	}

	public CreditoPres getCredito() {
		return credito;
	}
	public void setCredito(CreditoPres credito) {
		this.credito = credito;
	}
	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", fecha=" + fecha + ", monto=" + monto + ", tipoTransaccion="
				+ tipoTransaccion + ", cuenta=" + cuenta + ", credito=" + credito + ", cuent=" + cuent + "]";
	}
	

}
