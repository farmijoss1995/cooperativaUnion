package ec.ups.edu.app.g2.cooperativaUnion.EN;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Credito_Prestamo")
public class CreditoPres {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String tipo;
	private double monto;
	private String fecha;
	private double Saldo;
	private String fechaFin;
	
	@OneToOne
    @JoinColumn(name = "cuenta_ahorroPres", referencedColumnName = "numeroCuenta")
    private CuentaAhorro cuenta;
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "credito_pre")
	private List<Pago>pagos;
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "credito_idcredito")
    private List<Transaccion> listaTra;
	public void agregarpago(Pago p) {
	if (pagos == null) {
		pagos = new ArrayList<Pago>();
	}
	pagos.add(p);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public List<Pago> getPagos() {
		return pagos;
	}
	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
	public CuentaAhorro getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaAhorro cuenta) {
		this.cuenta = cuenta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getSaldo() {
		return Saldo;
	}
	public void setSaldo(double saldo) {
		Saldo = saldo;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}	
	
}
