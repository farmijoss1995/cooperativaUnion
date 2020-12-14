package ec.ups.edu.app.g2.cooperativaUnion.utils;

import java.io.Serializable;

import ec.edu.ups.EN.CuentaAhorro;

public class Trans implements Serializable {
	private String cuentaorigen;
	private String cuentadestino;
	private Double monto;
	private String tipo;


	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCuentaorigen() {
		return cuentaorigen;
	}

	public void setCuentaorigen(String cuentaorigen) {
		this.cuentaorigen = cuentaorigen;
	}

	public String getCuentadestino() {
		return cuentadestino;
	}

	public void setCuentadestino(String cuentadestino) {
		this.cuentadestino = cuentadestino;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}


	
}
