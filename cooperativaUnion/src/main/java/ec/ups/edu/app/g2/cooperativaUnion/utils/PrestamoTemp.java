package ec.ups.edu.app.g2.cooperativaUnion.utils;

public class PrestamoTemp {

	private String numcuenta;
	private double monto;
	private int cuotas;
	private String tipo;
	private String pagouno;
	

	
	public String getNumcuenta() {
		return numcuenta;
	}
	public void setNumcuenta(String numcuenta) {
		this.numcuenta = numcuenta;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	public String getPagouno() {
		return pagouno;
	}
	public void setPagouno(String pagouno) {
		this.pagouno = pagouno;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "PrestamoTemp [numcuenta=" + numcuenta + ", monto=" + monto + ", cuotas=" + cuotas + ", tipo=" + tipo
				+ ", pagouno=" + pagouno + "]";
	}

	
	
}
