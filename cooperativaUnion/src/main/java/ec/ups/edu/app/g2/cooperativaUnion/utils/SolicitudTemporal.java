package ec.ups.edu.app.g2.cooperativaUnion.utils;

import java.util.Arrays;

import javax.persistence.Lob;

public class SolicitudTemporal {
	
	private String nombre;
	private String apellido;
	private String cedula;
	private String numeroCuenta;
	private int id;
	private Double montoCredito;
	private int plazoCredito;
	
	
	private byte[] cedulaImagen;
	
	private byte[] planillaImagen;
	
	private byte[] rolPagosImagen;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getMontoCredito() {
		return montoCredito;
	}
	public void setMontoCredito(Double montoCredito) {
		this.montoCredito = montoCredito;
	}
	public int getPlazoCredito() {
		return plazoCredito;
	}
	public void setPlazoCredito(int plazoCredito) {
		this.plazoCredito = plazoCredito;
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
	@Override
	public String toString() {
		return "SolicitudTemporal [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", numeroCuenta=" + numeroCuenta + ", id=" + id + ", montoCredito=" + montoCredito + ", plazoCredito="
				+ plazoCredito + ", cedulaImagen=" + Arrays.toString(cedulaImagen) + ", planillaImagen="
				+ Arrays.toString(planillaImagen) + ", rolPagosImagen=" + Arrays.toString(rolPagosImagen) + "]";
	}
	
	
	
	

}
