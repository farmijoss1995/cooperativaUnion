package ec.ups.edu.app.g2.cooperativaUnion.EN;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String cuenta;
	private int numeroPago;
	private String fechaPago;
	private String estado;
	private Double valor;
	private Double saldo;
	
	
	@OneToOne
    @JoinColumn(name = "credito_pre", referencedColumnName = "codigo")
    private CreditoPres creditoPres;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public int getNumeroPago() {
		return numeroPago;
	}
	public void setNumeroPago(int numeroPago) {
		this.numeroPago = numeroPago;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public CreditoPres getCreditoPres() {
		return creditoPres;
	}
	public void setCreditoPres(CreditoPres creditoPres) {
		this.creditoPres = creditoPres;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Pago [\ncuenta=" + cuenta + ", numeroPago=" + numeroPago + ", fechaPago="+ fechaPago + ", estado=" + estado + ", valor=" + valor + ", saldo=" + saldo + "]";
	
	}
	
	
}
