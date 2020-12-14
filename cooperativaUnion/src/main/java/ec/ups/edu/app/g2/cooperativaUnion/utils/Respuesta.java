package ec.ups.edu.app.g2.cooperativaUnion.utils;

import java.util.List;

import ec.edu.ups.EN.CuentaAhorro;

public class Respuesta {
	
	private int codigo;
	private String mensaje;
	
	private List<CuentaAhorro> cuentasafectadas;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<CuentaAhorro> getCuentasafectadas() {
		return cuentasafectadas;
	}
	public void setCuentasafectadas(List<CuentaAhorro> cuentasafectadas) {
		this.cuentasafectadas = cuentasafectadas;
	}

}
