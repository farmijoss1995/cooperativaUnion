package ec.ups.edu.app.g2.cooperativaUnion.EN;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class SolicitudCredito{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int plazoCredito ;
	private String propositoCredito;
	private Double montoCredito;
	private String tiempoEmpleo;
	private String estadoCivil;
	private Double avaluoVivienda;
	private String activos;
	private String tipoVivienda;
	private String tipoEmpleo;
	private String trabajorExtranjero;
	private String mensaje;
	private String estado;
	
	@Lob
	private byte[] cedulaImagen;
	@Lob
	private byte[] planillaImagen;
	@Lob
	private byte[] rolPagosImagen;
	
	
	@OneToOne
	@JoinColumn(name = "cuenta_ahorro", referencedColumnName = "numeroCuenta")
	private CuentaAhorro cuentaAhorro;
	
	@OneToOne
	@JoinColumn(name = "empleado_Soli", referencedColumnName = "cedula")
	private Empleado empleado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public int getPlazoCredito() {
		return plazoCredito;
	}
	public void setPlazoCredito(int plazoCredito) {
		this.plazoCredito = plazoCredito;
	}
	public String getPropositoCredito() {
		return propositoCredito;
	}
	public void setPropositoCredito(String propositoCredito) {
		this.propositoCredito = propositoCredito;
	}
	public Double getMontoCredito() {
		return montoCredito;
	}
	public void setMontoCredito(Double montoCredito) {
		this.montoCredito = montoCredito;
	}
	
	public String getTiempoEmpleo() {
		return tiempoEmpleo;
	}
	public void setTiempoEmpleo(String tiempoEmpleo) {
		this.tiempoEmpleo = tiempoEmpleo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Double getAvaluoVivienda() {
		return avaluoVivienda;
	}
	public void setAvaluoVivienda(Double avaluoVivienda) {
		this.avaluoVivienda = avaluoVivienda;
	}
	public String getActivos() {
		return activos;
	}
	public void setActivos(String activos) {
		this.activos = activos;
	}
	public String getTipoVivienda() {
		return tipoVivienda;
	}
	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}
	public String getTipoEmpleo() {
		return tipoEmpleo;
	}
	public void setTipoEmpleo(String tipoEmpleo) {
		this.tipoEmpleo = tipoEmpleo;
	}
	public String getTrabajorExtranjero() {
		return trabajorExtranjero;
	}
	public void setTrabajorExtranjero(String trabajorExtranjero) {
		this.trabajorExtranjero = trabajorExtranjero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public CuentaAhorro getCuentaAhorro() {
		return cuentaAhorro;
	}
	public void setCuentaAhorro(CuentaAhorro cuentaAhorro) {
		this.cuentaAhorro = cuentaAhorro;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public byte[] getCedulaImagen() {
		return cedulaImagen;
	}
	public void setCedulaImagen(byte[] cedulaImagen) {
		this.cedulaImagen = cedulaImagen;
	}
	public byte[] getPlanillaImagen() {
		return planillaImagen;
	}
	public void setPlanillaImagen(byte[] planillaImagen) {
		this.planillaImagen = planillaImagen;
	}
	public byte[] getRolPagosImagen() {
		return rolPagosImagen;
	}
	public void setRolPagosImagen(byte[] rolPagosImagen) {
		this.rolPagosImagen = rolPagosImagen;
	}
	
}
